package subway.dijkstra;

import java.util.List;

public class Station {
	private String name; //地铁站名称
	public int istransport = 0; //是否为换乘站，可换乘为1，不可换乘为0
	private List<String> LineNames; //站点所在的地铁线路集合
	private List<Station> linkStations; //相邻站点集合
	
	public Station (String name){
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
    public int getIstransport() {
		return istransport;
	}
	public void setIstransport(int istransport) {
		this.istransport = istransport;
	}
	public List<String> getLineNames() {
		return LineNames;
	}
	public void setLineNames(List<String> lineNames) {
		LineNames = lineNames;
	}
	public List<Station> getLinkStations() {
        return linkStations;
    }
    public void setLinkStations(List<Station> linkStations) {
        this.linkStations = linkStations;
    }
}