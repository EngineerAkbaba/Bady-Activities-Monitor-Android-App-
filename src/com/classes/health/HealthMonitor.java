package com.classes.health;

import android.R.string;
import android.widget.Button;

public class HealthMonitor {

	public static Person person = new Person("");
	private Activity [] defineActivity;
	String activityName;

	public HealthMonitor(String activityName) {
		super();
		this.activityName = activityName;
		//type ver
		defineActivity = new Activity[8];
		
		defineActivity[0] = new Physical("Jogging",0,-30,-20,-30);//name , tum vucud , arm , leg , heart
		defineActivity[1] = new Physical("Cycling", 0, -45, -60, -30);
		defineActivity[2] = new Physical("Football",0, -16, -24,-16);
		defineActivity[3] = new NonPhysical("Lesson",1, -30, -40);//name , tum vucud , brain , eyes
		defineActivity[4] = new NonPhysical("Cinema",1,-16,-32);
		defineActivity[5] = new NonPhysical("Music",1, -10,-15);
		defineActivity[6] = new RegularActivitiy("Eating",2, 45, 45, 45, 45, 45);
		defineActivity[7] = new RegularActivitiy("Sleeping",2, 60, 60, 60, 60, 60);
	}

	public void decideActivity(int durationTime){

		for (int i = 0; i < defineActivity.length; i++) {
			if (defineActivity[i].getActivityName().equalsIgnoreCase(activityName)) {
				if (defineActivity[i].getType()==0) {
					((Physical)defineActivity[i]).doPhsicalActivity(durationTime);
					break;
				}
				else if (defineActivity[i].getType()==1) 
				{
					((NonPhysical)defineActivity[i]).doNonPhsicalActivity(durationTime);
					break;
				}
				else if (defineActivity[i].getType()==2) 
				{
					((RegularActivitiy)defineActivity[i]).doRegularActivity(durationTime);
					break;
				}
			}
		}



	}

	public String [] returnActivityName(){
		String []array =new String[defineActivity.length]; 

		for (int i = 0; i < array.length; i++) 
			array [i] = defineActivity[i].getActivityName(); 


		return array;
	}

	public Activity[] getDefineActivity() {
		return defineActivity;
	}




	public void setDefineActivity(Activity[] defineActivity) {
		this.defineActivity = defineActivity;
	}


	public String getActivityName() {
		return activityName;
	}
	public void setActivityName(String activityName) {
		this.activityName = activityName;
	}
}
