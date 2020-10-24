package subway.dijkstra;

import java.util.List;

public class Line {
	private String name; //地铁线路名称
	private List<Station> stations;//线路站点集合
	private int iscircle=0;  //是否为环线,若环线为1,非环线为0
	
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
