package subway.dijkstra;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.Stack;

import subway.dijkstra.DijkstraAlgorithm;
public class Solve {
//	搜索某一条线的所有站点
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
			lineinfo="不存在该条线路！";
		}
		return lineinfo+"\n";
	}
//	获取地铁路径
	public static List<String> getPath(HashMap<Station, Path> pathMap,Path path){
		List<String> allpath=new ArrayList<String>();
		Stack<Station> stations=new Stack<Station>();
		Station station=path.getLastStation();
		while(!station.equals(path.getStart())) {
			stations.push(station);
			station=pathMap.get(station).getLastStation();
		}
		allpath.add("->乘坐"+DijkstraAlgorithm.getCommonLine(path.getStart(),stations.peek()).get(0)+"<-\n");
		allpath.add(path.getStart().getName());
		while(!stations.empty()) {
			if(pathMap.get(stations.peek()).getIschange()==1) {
				allpath.add("\n->换乘"+pathMap.get(stations.peek()).getLine()+"<-\n");
			}
			allpath.add(stations.pop().getName());
		}
		if(path.getIschange()==1) {
			allpath.add("\n->换乘"+path.getLine()+"<-\n");
		}
		allpath.add(path.getEnd().getName());
		return allpath;
	}
}
