package Dao;



public class Request {
	
	private Activity activity;
	private ActivityTime time;
	private ActivityPlace place;
	private User creater;
	
	public Request(String activity,String start,String end,String date,User user,String location){
		this.activity = Activity.valueOf(activity);
		this.time = new ActivityTime(start,end,date);
		this.creater = user;
		this.place = new ActivityPlace(location);
	}
	public Request(String activity,String start,String end,String date,String location){
		this.activity = Activity.valueOf(activity);
		this.time = new ActivityTime(start,end,date);
		//this.creater = new NewUser(user);
		this.place = new ActivityPlace(location);
	}
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

