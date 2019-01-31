package com.classes.health;

public class Physical extends Activity{
	int arm;
	int leg;
	int heart;




	public Physical(String activityName,int type,int arm,int leg,int heart) {
		super( activityName, type);
		// TODO Auto-generated constructor stub
		this.leg = leg;
		this.arm = arm;
		this.heart = heart;
				


	}

	public void doPhsicalActivity(int durationTime){

		HealthMonitor.person.getBody().getOrgans()[0].calculateEnergy(leg, durationTime);
		HealthMonitor.person.getBody().getOrgans()[1].calculateEnergy(heart, durationTime);
		HealthMonitor.person.getBody().getOrgans()[2].calculateEnergy(arm, durationTime);
		HealthMonitor.person.getBody().energyLevel = HealthMonitor.person.getBody().energyLevel + ((leg+heart+arm)*durationTime);
	}


	public int getArm() {
		return arm;
	}
	public void setArm(int arm) {
		this.arm = arm;
	}

	public int getLeg() {
		return leg;
	}
	public void setLeg(int leg) {
		this.leg = leg;
	}
	public int getHeart() {
		return heart;
	}
	public void setHeart(int heart) {
		this.heart = heart;
	}
}
