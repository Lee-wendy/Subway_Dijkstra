package subway.dijkstra;

import java.util.HashMap;
import java.util.List;
import java.util.Scanner;
import java.util.Set;


public class Main {
	public static void main(String[] args) {
		String s = DataBuilder.readTxt("../������·��Ϣ.txt");  //��������
		Set<Line> alllinesSet = DataBuilder.CreatLines(s);  //����������·����
		System.out.print("||1.��ѯ������·||2.��ѯ�������·��||3.�˳�||");
		Scanner input=new Scanner(System.in);
		String choose = input.next();
		while(true) {
			if(choose.equals("1")) {
				System.out.print("���������ѯ�ĵ�����·����");
				input=new Scanner(System.in);
				String name = input.next();
				System.out.print(Solve.searchLine(alllinesSet, name));
			}
			else if(choose.equals("2")) {
				System.out.print("��������ʼվ�����յ�վ����");
				input=new Scanner(System.in);
				Station start = DijkstraAlgorithm.findStation(alllinesSet,input.next());
				Station end = DijkstraAlgorithm.findStation(alllinesSet,input.next());
				if(start==null||end==null) {
					System.out.print("��������ʼվ���յ�վ");
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
				System.out.print("ѡ����ȷ��ѡ��");
			}
			System.out.print("\n||1.��ѯ������·||2.��ѯ�������·��||3.�˳�||");
			input=new Scanner(System.in);
			choose = input.next();
		}
		System.out.print("��ӭ�´ι��٣�");
	}	
}
