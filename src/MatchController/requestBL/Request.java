package MatchController.requestBL;

import MatchController.requestHelper.ActivityPlace;
import MatchController.requestHelper.ActivityTime;
import MatchController.requestHelper.User;


public class Request {
	
	private Activity activity;
	private ActivityTime time;
	private ActivityPlace place;
	private User creater;
	
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
	public User getCreater() {
		return creater;
	}
	public void setCreater(User creater) {
		this.creater = creater;
	}
	
	public boolean equals(Request another){
		if(this.activity.equals(another.getActivity())&&this.place.isNear(another.getPlace())&&this.time.isOk(another.getTime())){
			return true;
		}else{
			return false;
		}
	}
}

