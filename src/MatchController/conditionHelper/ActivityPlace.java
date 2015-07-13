package MatchController.conditionHelper;

import MatchController.conditionHelper.ActivityPlace;

public class ActivityPlace {

	public static double nearDistance = 100;  // 两地相距多少时认为是相近
	
	private String name;
	private double longi;  //经度
	private double lati;   //纬度
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getLongi() {
		return longi;
	}
	public void setLongi(double longi) {
		this.longi = longi;
	}
	public double getLati() {
		return lati;
	}
	public void setLati(double lati) {
		this.lati = lati;
	}
	
	private double getDistanceFrom(ActivityPlace another){
		return Math.sqrt(Math.pow((this.getLati()-another.getLati()), 2)+Math.pow((this.getLongi()-another.getLongi()), 2));
	}
	public boolean isNear(ActivityPlace another){
		if(this.getDistanceFrom(another)<= nearDistance){
			return true;
		}else{
			return false;
		}
	}
}
