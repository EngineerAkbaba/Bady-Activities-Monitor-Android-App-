package com.example.health;


import java.util.ArrayList;

import javax.xml.datatype.Duration;

import com.classes.health.HealthMonitor;
import com.classes.health.Person;

import android.R.integer;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Chronometer.OnChronometerTickListener;
import android.os.Build;
import android.view.View.OnClickListener;


public class MainActivity extends ActionBarActivity implements OnItemClickListener,OnClickListener,OnChronometerTickListener{

	ImageView btnNewActivity;
	ImageView btnPrevActivity;
	ImageView btnTimer;
	ImageView leg;
	ImageView arm;
	ImageView heart;
	ImageView eyes;
	ImageView brain;
	ImageView level;
	long minutes;
	long seconds;
	long fulltime;
	int counter;
	Chronometer chronometer;
	String color;
	Button buttonStart;
	Button buttonStop;
	ListView actList;
	EditText inputTime;
	Intent newintent;
	//long time = 0;
	String activityName;
	HealthMonitor health = new HealthMonitor("");
	static ArrayList<String> myList = new ArrayList<String>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		btnNewActivity = (ImageView) findViewById(R.id.btnAct);
		btnPrevActivity =(ImageView) findViewById(R.id.btnActPrev);
		leg= (ImageView)findViewById(R.id.greenleg);
		heart = (ImageView)findViewById(R.id.greenheart);
		eyes = (ImageView)findViewById(R.id.greeneyes);
		brain = (ImageView)findViewById(R.id.greenbrain);
		arm = (ImageView)findViewById(R.id.greenarm);
		level = (ImageView)findViewById(R.id.level5);

		chronometer = (Chronometer)findViewById(R.id.chronometer1);
		color = HealthMonitor.person.getBody().getOrgans()[3].calculateColor();
		//Toast.makeText(getApplicationContext(), color, Toast.LENGTH_LONG).show();
		String a = "R.drawable."+color+HealthMonitor.person.getBody().getOrgans()[3].getOrganName();//dogru
		Toast.makeText(getApplicationContext(), a, Toast.LENGTH_LONG).show();



		inputTime = (EditText)findViewById(R.id.durationText);
		buttonStart=(Button)findViewById(R.id.buttonStart);
		buttonStop=(Button)findViewById(R.id.buttonStop);
		chronometer=(Chronometer)findViewById(R.id.chronometer1);
		chronometer.setOnChronometerTickListener(this);

		buttonStart.setOnClickListener(this);
		buttonStop.setOnClickListener(this);
		btnPrevActivity.setOnClickListener(this);

		String [] activity = languageControl();//String Arrayimi güncelliyorum.
		actList = (ListView) findViewById(R.id.selectList);
		actList.setVisibility(View.INVISIBLE);
		ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
		(this, android.R.layout.simple_list_item_1, android.R.id.text1, activity);
		actList.setAdapter(veriAdaptoru);

		//Toast.makeText(getApplicationContext(), health.returnActivityName()[1], Toast.LENGTH_LONG).show();
		actList.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> myAdapter,View myView, int myItemint, long mylng){
				String selectedFromList = (String)(actList.getItemAtPosition(myItemint));//Selected item convert to String
				Toast.makeText(getApplicationContext(), selectedFromList, Toast.LENGTH_LONG).show();

				activityName = selectedFromList;
				health.setActivityName(activityName);

				actList.setVisibility(View.INVISIBLE);

			}

		});






		btnNewActivity.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				actList.setVisibility(View.VISIBLE);

			}
		});



	}
	@Override
	public void onChronometerTick(Chronometer cronometer){

		long currentTime = SystemClock.elapsedRealtime();
		minutes = ((currentTime-cronometer.getBase())/1000)/60;
		seconds = ((currentTime-cronometer.getBase())/1000)%60;
		fulltime = minutes*60+seconds;
		if (fulltime != 0 && fulltime % Integer.parseInt((inputTime.getText().toString())) == 0) {
			health.decideActivity(10);//bodyPartlarýn enerjisini düsürüyorum
			changeColor();//düþmüþ enerjiye göre yeni resimleri basýyorum
			if (fulltime == 10) {
				Toast.makeText(getApplicationContext(), "", Toast.LENGTH_LONG).show();
			}
			changeLevel();//energy level i ayarlar
		}

	}
	public void changeLevel(){

		int bodyLevel = health.person.getBody().calculateEnergyLevel();
		switch (bodyLevel){
		case 1:
			level.setImageResource(R.drawable.level1);
			break;
		case 2:
			level.setImageResource(R.drawable.level2);
			break;
		case 3:
			level.setImageResource(R.drawable.level3);
			break;
		case 4:
			level.setImageResource(R.drawable.level4);
			break;
		case 5:
			level.setImageResource(R.drawable.level5);
			break;
		}

	}
	public String [] languageControl(){

		String [] array = getResources().getStringArray(R.array.selectList);
		for (int i = 0; i < health.getDefineActivity().length; i++) {
			health.getDefineActivity()[i].setActivityName(array[i]);
		}
		return array;
	}
	private void changeColor() {
		for (int i = 0; i < health.person.getBody().getOrgans().length; i++) {
			String col = health.person.getBody().getOrgans()[i].calculateColor();
			String org = health.person.getBody().getOrgans()[i].getOrganName();
			//Toast.makeText(getApplicationContext(), col+org, Toast.LENGTH_LONG).show();
			String decideValue=col+org;
			changeBody(i, col);

		}
	}
	private void changeBody(int i, String col) {
		if (i == 0) {
			if (col == "red") {
				leg.setImageResource(R.drawable.redleg);
			}else if(col == "yellow"){
				leg.setImageResource(R.drawable.yellowleg);
			}else if(col == "blue"){
				leg.setImageResource(R.drawable.blueleg);
			}else if(col == "orange"){
				leg.setImageResource(R.drawable.orangeleg);
			}else if(col == "green"){
				leg.setImageResource(R.drawable.greenleg);
			}
		}
		if (i == 1) {//Heart
			if (col == "red") {
				heart.setImageResource(R.drawable.redheart);
			}else if(col == "yellow"){
				heart.setImageResource(R.drawable.yellowheart);
			}else if(col == "blue"){
				heart.setImageResource(R.drawable.blueheart);
			}else if(col == "orange"){
				heart.setImageResource(R.drawable.orangeheart);
			}else if(col == "green"){
				heart.setImageResource(R.drawable.greenheart);
			}
		}
		if (i == 2) {//Arm
			if (col == "red") {
				arm.setImageResource(R.drawable.redarm);
			}else if(col == "yellow"){
				arm.setImageResource(R.drawable.yellowarm);
			}else if(col == "blue"){
				arm.setImageResource(R.drawable.bluearm);
			}else if(col == "orange"){
				arm.setImageResource(R.drawable.orangearm);
			}else if(col == "green"){
				arm.setImageResource(R.drawable.greenarm);
			}
		}
		if (i == 3) {//Brain
			if (col == "red") {
				brain.setImageResource(R.drawable.redbrain);
			}else if(col == "yellow"){
				brain.setImageResource(R.drawable.yellowbrain);
			}else if(col == "blue"){
				brain.setImageResource(R.drawable.bluebrain);
			}else if(col == "orange"){
				brain.setImageResource(R.drawable.orangebrain);
			}else if(col == "green"){
				brain.setImageResource(R.drawable.greenbrain);
			}
		}
		if (i == 4) {//Eyes
			if (col == "red") {
				eyes.setImageResource(R.drawable.redeyes);
			}else if(col == "yellow"){
				eyes.setImageResource(R.drawable.yelloweyes);
			}else if(col == "blue"){
				eyes.setImageResource(R.drawable.blueeyes);
			}else if(col == "orange"){
				eyes.setImageResource(R.drawable.orangeeyes);
			}else if(col == "green"){
				eyes.setImageResource(R.drawable.greeneyes);
			}
		}
	}

	public void onClick(View v)
	{
		switch(v.getId()){

		case R.id.buttonStart:
			chronometer.setBase(SystemClock.elapsedRealtime());//+time
			chronometer.start();




			break;

		case R.id.buttonStop:
			//time = chronometer.getBase()-SystemClock.elapsedRealtime();
			chronometer.stop();
			newintent = new Intent(MainActivity.this,PrevActActivity.class);
			newintent.putExtra("actal", activityName);
			myList.add(activityName+" "+Integer.toString((int)fulltime));
			break;
			
		case R.id.btnActPrev:
			//startActivity(new Intent(MainActivity.this,PrevActActivity.class));
			startActivity(newintent);
			//Toast.makeText(getApplicationContext(), "asdasdasd", Toast.LENGTH_LONG).show();
			break;
		}
	}
	@Override
	public void onItemClick(AdapterView<?> arg0, View arg1, int arg2, long arg3) {
		// TODO Auto-generated method stub

	}


}
