package com.classes.health;

public class RegularActivitiy extends Activity{
	int brain;
	int eyes;
	int heart;
	int leg;
	int arm;
	
	
	
	
	
	public RegularActivitiy(String activityName,int type,int arm,int leg,int heart,int brain,int eyes) {
		super( activityName,type);
		// TODO Auto-generated constructor stub
		this.arm = arm;
		this.leg = leg;
		this.heart = heart;
		this.brain = brain;
		this.eyes = eyes;
		
		
		
		
	}
	public void doRegularActivity(int durationTime){

		HealthMonitor.person.getBody().getOrgans()[0].calculateEnergy(leg, durationTime);
		HealthMonitor.person.getBody().getOrgans()[1].calculateEnergy(heart, durationTime);
		HealthMonitor.person.getBody().getOrgans()[2].calculateEnergy(arm, durationTime);
		HealthMonitor.person.getBody().getOrgans()[3].calculateEnergy(brain, durationTime);
		HealthMonitor.person.getBody().getOrgans()[4].calculateEnergy(eyes, durationTime);
		HealthMonitor.person.getBody().energyLevel = HealthMonitor.person.getBody().energyLevel + ((leg+heart+arm+brain+eyes)*durationTime);
	}
	public int getEyes() {
		return eyes;
	}

	public void setEyes(int eyes) {
		this.eyes = eyes;
	}

	public int getHeart() {
		return heart;
	}

	public void setHeart(int heart) {
		this.heart = heart;
	}

	public int getLeg() {
		return leg;
	}

	public void setLeg(int leg) {
		this.leg = leg;
	}

	public int getArm() {
		return arm;
	}

	public void setArm(int arm) {
		this.arm = arm;
	}

	public int getBrain() {
		return brain;
	}

	public void setBrain(int brain) {
		this.brain = brain;
	}
}
