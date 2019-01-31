package com.classes.health;

public class Body {
	Organ organs[];
	int energyLevel;


	public Body() {
		super();
		organs = new Organ[5];
		organs[0] = new Organ("leg");
		organs[1] = new Organ("heart");
		organs[2] = new Organ("arm");
		organs[3] = new Organ("brain");
		organs[4] = new Organ("eyes");
		energyLevel = 10000;
	}
	public int calculateEnergyLevel(){

		if (energyLevel <= 2000) {
			return 1;
		}else if(energyLevel > 2000 && energyLevel <=4000){
			return 2;
		}else if(energyLevel > 6000 && energyLevel <=8000){
			return 3;
		}else if(energyLevel > 8000 && energyLevel <=10000){
			return 4;
		}else if(energyLevel > 10000){
			return 5;
		}
		return 0;
	}

	public Organ[] getOrgans() {
		return organs;
	}
	public void setOrgans(Organ[] organs) {
		this.organs = organs;
	}
	public int getEnergyLevel() {
		return energyLevel;
	}
	public void setEnergyLevel(int energyLevel) {
		this.energyLevel = energyLevel;
	}
}
