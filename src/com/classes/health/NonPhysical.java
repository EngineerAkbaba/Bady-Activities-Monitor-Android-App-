package com.classes.health;

public class NonPhysical extends Activity{
	int brain;
	int eyes;
	

	public NonPhysical(String activityName,int type,int brain,int eyes) {
		super( activityName,type);
		// TODO Auto-generated constructor stub
		this.brain = brain;
		this.eyes = eyes;
	}
	
	public void doNonPhsicalActivity(int durationTime){

		HealthMonitor.person.getBody().getOrgans()[3].calculateEnergy(brain, durationTime);
		HealthMonitor.person.getBody().getOrgans()[4].calculateEnergy(eyes, durationTime);
		HealthMonitor.person.getBody().energyLevel = HealthMonitor.person.getBody().energyLevel + ((brain+eyes)*durationTime);
	}
	
	public int getBrain() {
		return brain;
	}
	public void setBrain(int brain) {
		this.brain = brain;
	}
	public int getEyes() {
		return eyes;
	}
	public void setEyes(int eyes) {
		this.eyes = eyes;
	}
}
