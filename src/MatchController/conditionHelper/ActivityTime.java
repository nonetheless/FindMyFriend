package MatchController.conditionHelper;

import MatchController.conditionHelper.ActivityTime;

public class ActivityTime {
public static double okPercent = 0.8; //双方共同时间占各自比例达到就OK
	
	private String date;  //2015-7-7
	private String startTime; //9:40
	private String endTime;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getStartTime() {
		return startTime;
	}
	public void setStartTime(String startTime) {
		this.startTime = startTime;
	}
	public String getEndTime() {
		return endTime;
	}
	public void setEndTime(String endTime) {
		this.endTime = endTime;
	}
	private int TimeIntoMin(String time){
		
		String[] temp = time.split(":");
		int hour = Integer.parseInt(temp[0]);
		int min = Integer.parseInt(temp[1]);
		int total = -1;
		
		if(hour>=0&&hour<=24&&min>=0&&min<60){
			total = hour*60+min;
		}
		return total;
	}
	public boolean isOk(ActivityTime another){
		int total11 = this.TimeIntoMin(this.startTime);
		int total12 = this.TimeIntoMin(this.endTime);
		int total21 = this.TimeIntoMin(another.getStartTime());
		int total22 = this.TimeIntoMin(another.getEndTime());
	}
}
