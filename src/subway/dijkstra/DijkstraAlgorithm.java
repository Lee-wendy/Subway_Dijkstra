package subway.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class DijkstraAlgorithm {
//	�Ͻ�˹�����㷨ʵ��(����)
	public static HashMap<Station, Path> dijkstra(Set<Line> alllinesSet,Station start) {
		List<Station> finish = new ArrayList<>();        //�Ѿ���������վ��
		HashMap<Station, Path> pathMap = new HashMap<>();  //��ʼվ�㵽ĳһվ������·��
		for(Line i:alllinesSet) {  //��ʼ��
			for(Station j:i.getStations()) {
				if(!pathMap.containsKey(j)) {
					Path path = new Path();
					path.setStart(start);
					path.setEnd(j);
					if(j.getName().equals(start.getName())) {
						path.setDistance(0);
					}
					pathMap.put(j, path);
				}
			}
		}
		for(Station LinkStations:start.getLinkStations()) {//��������ٽ��㣬�������·��
			pathMap.get(LinkStations).setDistance(1);
			pathMap.get(LinkStations).setLastStation(start);
			List<String> samelines = getCommonLine(start,LinkStations);
			pathMap.get(LinkStations).setLine(samelines.get(0));
		}
		finish.add(start);
		Station nextStation = getNextStation(finish,pathMap); 
		while(nextStation!=null) {  //ѭ������ÿһ��վ������·��
        	for(Station s:nextStation.getLinkStations()) {
        		if(pathMap.get(nextStation).getDistance()+1<pathMap.get(s).getDistance()) {  //�������·��
        			pathMap.get(s).setDistance(pathMap.get(nextStation).getDistance()+1);
        			pathMap.get(s).setLastStation(nextStation);
        			List<String> samelines=getCommonLine(nextStation,s);
        			isChange(samelines,pathMap.get(nextStation));
        			pathMap.get(s).setIschange(isChange(samelines,pathMap.get(nextStation)));
        			if(pathMap.get(s).getIschange()==1) {  //��Ҫ����
        				pathMap.get(s).setLine(samelines.get(0));
        				pathMap.get(s).setDistance(pathMap.get(s).getDistance()+3);//����ֱ�ߵ�������൱�ڶ�1վ����
        			}
        			else {
        				pathMap.get(s).setLine(pathMap.get(nextStation).getLine());
        			}
        		}
        	}
        	finish.add(nextStation); 
        	nextStation = getNextStation(finish,pathMap);
        }
		return pathMap;
	}
	//����վ����Ѱ��ĳһվ��(Station)
		public static Station findStation(Set<Line> alllinesSet,String name) {
			for(Line i:alllinesSet) {
				for(Station j:i.getStations()) {
					if(name.equals(j.getName())) {
						return j;
					}
				}
			}
			return null;
		}
//		�ҵ�����վ��Ĺ�����·
		public static List<String> getCommonLine(Station station1,Station station2) {
			List<String> commonLine=new ArrayList<String>();
			for(String i:station1.getLineNames()) {
				for(String j:station2.getLineNames()) {
					if(i.equals(j))
						commonLine.add(i);
				}
			}
			return commonLine;
		}
//		�ҵ���һ����Ҫ������վ��
//		�ڲ��������ҵ����·����վ��������Ŀǰ���·����վ��
		private static Station getNextStation(List<Station> finish,HashMap<Station, Path> pathMap) {    
	        int min=999999;
	        Station nextstation = null;
	        Set<Station> stations = pathMap.keySet();
	        for (Station station : stations) {
	            if (!finish.contains(station)) {
	            	Path path = pathMap.get(station);
	                if (path.getDistance() < min) {
	                    min = path.getDistance();
	                    nextstation = path.getEnd();
	                }
	            }
	        }
	        return nextstation;
	    }
//		�ж��Ƿ񻻳�
		private static int isChange(List<String> lines,Path path) {
			if(lines.contains(path.getLine())) {
				return 0;
			}
			else {
				return 1;
			}
		}
}
