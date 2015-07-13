package MatchController.conditionBL;

import java.util.ArrayList;

import MatchController.conditionHelper.ActivityPlace;
import MatchController.conditionHelper.ActivityTime;
import MatchController.conditionHelper.User;


public class Condition {
	
	private Activity activity;
	private ActivityTime time;
	private ActivityPlace place;
	private User creater;
	private ArrayList<User> userList;
	
	public Activity getActivity() {
		return activity;
	}
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	public ActivityTime getTime() {
		return time;
	}
	public void setTime(ActivityTime time) {
		this.time = time;
	}
	public ActivityPlace getPlace() {
		return place;
	}
	public void setPlace(ActivityPlace place) {
		this.place = place;
	}
	public ArrayList<User> getUserList() {
		return userList;
	}
	public void setUserList(ArrayList<User> userList) {
		this.userList = userList;
	}
	public User getCreater() {
		return creater;
	}
	public void setCreater(User creater) {
		this.creater = creater;
	}
	
	public void addToList(User newUser){
		this.userList.add(newUser);
	}
	public void subInList(User newUser){
		for(int i = 0;i<this.userList.size();i++){
			User temp = userList.get(i);
			if(temp.equals(newUser)){
				this.userList.remove(i);
				break;
			}
		}
	}
	public boolean equals(Condition another){
		if(this.activity.equals(another.getActivity())){
			return true;
		}
	}
}

