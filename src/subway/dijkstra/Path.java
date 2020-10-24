package subway.dijkstra;

public class Path {
	 private Station start; //起点站
	 private Station end; //该站点
	 private int distance = 999999;//初始化距离为无穷大
	 private Station lastStation;  //到达该站的最短路径中的上一站
	 private String line;   //到达该站在几号线上
	 private int ischange=0;  //标记从上一站到该站是否有换乘，0为无换乘，1为需换乘
	 public Station getStart() {
		 return start;
	 }
	 public void setStart(Station start) {
		 this.start = start;
	 }
	 public Station getEnd() {
		 return end;
	 }
	 public void setEnd(Station end) {
		 this.end = end;
	 }
	 public int getDistance() {
		 return distance;
	 }
	 public void setDistance(int distance) {
		 this.distance = distance;
	 }
	 public Station getLastStation() {
		 return lastStation;
	 }
	 public void setLastStation(Station lastStation) {
		 this.lastStation = lastStation;
	 }
	 public String getLine() {
		 return line;
	 }
	 public void setLine(String line) {
		 this.line = line;
	 }
	 public int getIschange() {
		 return ischange;
	 }
	 public void setIschange(int ischange) {
		 this.ischange = ischange;
	 }
}
