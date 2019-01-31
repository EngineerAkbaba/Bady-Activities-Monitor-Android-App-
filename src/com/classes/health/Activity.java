package com.classes.health;

public class Activity {
	int startingTime;
	int finishingTime;
	String activityName;
	int duration;
	int type;
	
	public Activity(String activityName,int type) {
		super();
		this.startingTime = startingTime;
		this.finishingTime = finishingTime;
		this.activityName = activityName;
		this.duration = duration;
		this.type = type;
	}
	
	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public void doActivity(int durationTime){
		//total caloriyi hesaplat
		
		for (int i = 0; i < HealthMonitor.person.getBody().getOrgans().length; i++) {
			HealthMonitor.person.getBody().getOrgans()[i].calculateColor();
		}
		
		
	}

	public int getStartingTime() {
		return startingTime;
	}
	public void setStartingTime(int startingTime) {
		this.startingTime = startingTime;
	}
	public int getFinishingTime() {
		return finishingTime;
	}
	public void setFinishingTime(int finishingTime) {
		this.finishingTime = finishingTime;
	}
	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
	public int getDuration() {
		return duration;
	}
	public void setDuration(int duration) {
		this.duration = duration;
	}

}
