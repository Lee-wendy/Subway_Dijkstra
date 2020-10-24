package subway.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import subway.dijkstra.DijkstraAlgorithm;
public class Solve {
//	����ĳһ���ߵ�����վ��
	public static String searchLine(Set<Line> alllinesSet,String name){
		int flag=0;
		String lineinfo = "";
		for(Line k:alllinesSet) {
			if(name.equals(k.getName())){
				flag=1;
				for(Station stm:k.getStations()) {
					lineinfo+=stm.getName()+" ";
				}
			}
		}
		if(flag==0) {
			lineinfo="�����ڸ�����·��";
		}
		return lineinfo+"\n";
	}
//	��ȡ����·��
	public static List<String> getPath(HashMap<Station, Path> pathMap,Path path){
		List<String> allpath=new ArrayList<String>();
		Stack<Station> stations=new Stack<Station>();
		Station station=path.getLastStation();
		while(!station.equals(path.getStart())) {
			stations.push(station);
			station=pathMap.get(station).getLastStation();
		}
		allpath.add("->����"+DijkstraAlgorithm.getCommonLine(path.getStart(),stations.peek()).get(0)+"<-\n");
		allpath.add(path.getStart().getName());
		while(!stations.empty()) {
			if(pathMap.get(stations.peek()).getIschange()==1) {
				allpath.add("\n->����"+pathMap.get(stations.peek()).getLine()+"<-\n");
			}
			allpath.add(stations.pop().getName());
		}
		if(path.getIschange()==1) {
			allpath.add("\n->����"+path.getLine()+"<-\n");
		}
		allpath.add(path.getEnd().getName());
		return allpath;
	}
}
