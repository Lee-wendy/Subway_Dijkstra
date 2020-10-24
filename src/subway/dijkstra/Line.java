package subway.dijkstra;

import java.util.List;

public class Line {
	private String name; //������·����
	private List<Station> stations;//��·վ�㼯��
	private int iscircle=0;  //�Ƿ�Ϊ����,������Ϊ1,�ǻ���Ϊ0
	
	public Line (String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public List<Station> getStations() {
		return stations;
	}
	public void setStations(List<Station> stations) {
		this.stations = stations;
	}
	public int getIscircle() {
		return iscircle;
	}
	public void setIscircle(int iscircle) {
		this.iscircle = iscircle;
	}
	
}
