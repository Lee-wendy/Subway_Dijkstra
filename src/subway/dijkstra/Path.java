package subway.dijkstra;

public class Path {
	 private Station start; //���վ
	 private Station end; //��վ��
	 private int distance = 999999;//��ʼ������Ϊ�����
	 private Station lastStation;  //�����վ�����·���е���һվ
	 private String line;   //�����վ�ڼ�������
	 private int ischange=0;  //��Ǵ���һվ����վ�Ƿ��л��ˣ�0Ϊ�޻��ˣ�1Ϊ�軻��
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
