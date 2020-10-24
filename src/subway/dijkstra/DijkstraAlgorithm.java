package subway.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;

public class DijkstraAlgorithm {
//	迪杰斯特拉算法实现(核心)
	public static HashMap<Station, Path> dijkstra(Set<Line> alllinesSet,Station start) {
		List<Station> finish = new ArrayList<>();        //已经分析过的站点
		HashMap<Station, Path> pathMap = new HashMap<>();  //初始站点到某一站点的最短路径
		for(Line i:alllinesSet) {  //初始化
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
		for(Station LinkStations:start.getLinkStations()) {//查找起点临近点，设置最短路径
			pathMap.get(LinkStations).setDistance(1);
			pathMap.get(LinkStations).setLastStation(start);
			List<String> samelines = getCommonLine(start,LinkStations);
			pathMap.get(LinkStations).setLine(samelines.get(0));
		}
		finish.add(start);
		Station nextStation = getNextStation(finish,pathMap); 
		while(nextStation!=null) {  //循环计算每一个站点的最短路径
        	for(Station s:nextStation.getLinkStations()) {
        		if(pathMap.get(nextStation).getDistance()+1<pathMap.get(s).getDistance()) {  //更新最短路径
        			pathMap.get(s).setDistance(pathMap.get(nextStation).getDistance()+1);
        			pathMap.get(s).setLastStation(nextStation);
        			List<String> samelines=getCommonLine(nextStation,s);
        			isChange(samelines,pathMap.get(nextStation));
        			pathMap.get(s).setIschange(isChange(samelines,pathMap.get(nextStation)));
        			if(pathMap.get(s).getIschange()==1) {  //需要换乘
        				pathMap.get(s).setLine(samelines.get(0));
        				pathMap.get(s).setDistance(pathMap.get(s).getDistance()+3);//优先直线到达，换乘相当于多1站距离
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
	//根据站点名寻找某一站点(Station)
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
//		找到两个站点的共有线路
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
//		找到下一个需要分析的站点
//		在不包含已找到最短路径的站点中搜索目前最短路径的站点
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
//		判断是否换乘
		private static int isChange(List<String> lines,Path path) {
			if(lines.contains(path.getLine())) {
				return 0;
			}
			else {
				return 1;
			}
		}
}
