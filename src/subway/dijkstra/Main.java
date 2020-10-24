package subway.dijkstra;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Main {
	public static void main(String[] args) {
		String s = DataBuilder.readTxt("../地铁线路信息.txt");  //读入数据
		Set<Line> alllinesSet = DataBuilder.CreatLines(s);  //构造所有线路集合
		System.out.print("||1.查询地铁线路||2.查询地铁最短路径||3.退出||");
		Scanner input=new Scanner(System.in);
		String choose = input.next();
		while(true) {
			if(choose.equals("1")) {
				System.out.print("请输入需查询的地铁线路名：");
				input=new Scanner(System.in);
				String name = input.next();
				System.out.print(Solve.searchLine(alllinesSet, name));
			}
			else if(choose.equals("2")) {
				System.out.print("请输入起始站名和终点站名：");
				input=new Scanner(System.in);
				Station start = DijkstraAlgorithm.findStation(alllinesSet,input.next());
				Station end = DijkstraAlgorithm.findStation(alllinesSet,input.next());
				if(start==null||end==null) {
					System.out.print("不存在起始站或终点站");
				}
				else {
					HashMap<Station, Path> pathMap = DijkstraAlgorithm.dijkstra(alllinesSet,start);
					List<String> paths = Solve.getPath(pathMap,pathMap.get(end));
					for(String path:paths) {
						System.out.print(path+" ");
					}
				}
				
			}
			else if(choose.equals("3")){
				break;
			}
			else {
				System.out.print("选择正确的选项");
			}
			System.out.print("\n||1.查询地铁线路||2.查询地铁最短路径||3.退出||");
			input=new Scanner(System.in);
			choose = input.next();
		}
		System.out.print("欢迎下次光临！");
	}	
}
