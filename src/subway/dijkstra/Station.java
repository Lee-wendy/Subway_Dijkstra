package subway.dijkstra;

import java.util.List;

public class Station {
	private String name; //����վ����
	public int istransport = 0; //�Ƿ�Ϊ����վ���ɻ���Ϊ1�����ɻ���Ϊ0
	private List<String> LineNames; //վ�����ڵĵ�����·����
	private List<Station> linkStations; //����վ�㼯��
	
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