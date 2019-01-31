package com.classes.health;

public class Organ {
	String organName;
	int organEnergy;

	
	public Organ(String organName) {
		super();
		this.organName = organName;
		organEnergy = 2000;
		
	}

	public String calculateColor(){
			if (getOrganEnergy()<=400) {
				//x-100
				return "red";
			}else if (getOrganEnergy()>400 && getOrganEnergy()<=800) {
				//100-200
				return "orange";
			}else if (getOrganEnergy()>800 && getOrganEnergy()<=1200) {
				//200-300
				return "blue";
			}else if (getOrganEnergy()>1200 && getOrganEnergy()<=1600) {
				//300-400
				return "yellow";
			}else if(getOrganEnergy()>1600){
				//400-x
				return "green";
			}
			return null;
	}
	
	public void calculateEnergy(int coefficient,int durationTime){
		organEnergy = organEnergy+coefficient*durationTime;
		int a = 0;
	}
	
	public String getOrganName() {
		return organName;
	}
	public void setOrganName(String organName) {
		this.organName = organName;
	}
	public int getOrganEnergy() {
		return organEnergy;
	}
	public void setOrganEnergy(int organEnergy) {
		this.organEnergy = organEnergy;
	}

}
