package subway.dijkstra;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class DataBuilder {
	
	public static String readTxt(String txtPath) {
        File file = new File(txtPath);
        if(file.isFile() && file.exists()){
            try {
                FileInputStream fileInputStream = new FileInputStream(file);
                InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream,"utf-8");
                BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                StringBuffer sb = new StringBuffer();
                String text = null;
                while((text = bufferedReader.readLine()) != null){
                    sb.append(text);
                    sb.append("\n");
                }
                bufferedReader.close();
                return sb.toString();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return null;
    }
	
	public static Set<Line> CreatLines(String txt) {
		Set<Line> alllinesSet = new HashSet<Line>();//所有线集合
		
		String[] Lines = txt.split("\n");
		for(int i=0;i<Lines.length;i++) {
			String[] stationsOfLine  = Lines[i].split(" ");
			Line line = new Line(stationsOfLine[0]);
			List<Station> stations = new ArrayList<Station>();
			
			for(int j = 1;j < stationsOfLine.length;j++) {
				
				Station station = new Station(stationsOfLine[j]);
				List<String> LineNames = new ArrayList<String>(); 
				List<Station> linkStations = new ArrayList<Station>();
				
				for(Line k:alllinesSet) { //是否已经存在station
					for(int p=0;p<k.getStations().size();p++) {
						if((k.getStations().get(p).getName()).equals(stationsOfLine[j])) {
							station = k.getStations().get(p);
							LineNames = station.getLineNames();
							linkStations = station.getLinkStations();
							LineNames.add(line.getName());
							station.setIstransport(1);;
	        				break;
	        			}
					}
				}
				if(station.getIstransport() == 0) {
					LineNames.add(line.getName());
				}
				if(j==stationsOfLine.length-1&&stationsOfLine[j].equals(stationsOfLine[1])) {  //环线
					line.setIscircle(1);
					station = stations.get(0);
					LineNames = station.getLineNames();
					linkStations = station.getLinkStations();
					linkStations.add(stations.get(1));
					linkStations.add(stations.get(j-2));
        		}
				station.setLineNames(LineNames);
				station.setLinkStations(linkStations);
				stations.add(station);
			}
			line.setStations(stations);
			for(int j=0;j<line.getStations().size();j++) {  //初始化每个车站相邻的车站
        		List<Station> newlinkStations=line.getStations().get(j).getLinkStations();
        		if(j==0) {
        			if(line.getIscircle()==0) {
        				newlinkStations.add(line.getStations().get(j+1));
        				line.getStations().get(j).setLinkStations(newlinkStations);
        			}
        		}
        		else if(j==line.getStations().size()-1) {
        			if(line.getIscircle()==0) {
        				newlinkStations.add(line.getStations().get(j-1));
        				line.getStations().get(j).setLinkStations(newlinkStations);
        			}
        		}
        		else {
        			newlinkStations.add(line.getStations().get(j+1));
        			newlinkStations.add(line.getStations().get(j-1));
        			line.getStations().get(j).setLinkStations(newlinkStations);
        		}
        	}
			alllinesSet.add(line);	
		}
		return alllinesSet;
	}
}
