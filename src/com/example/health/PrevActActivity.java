package com.example.health;

import java.util.ArrayList;

import com.classes.health.HealthMonitor;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.content.Intent;
import android.nfc.NfcEvent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.Chronometer.OnChronometerTickListener;
import android.os.Build;

public class PrevActActivity extends ActionBarActivity implements OnItemSelectedListener,OnClickListener,OnChronometerTickListener{

	ListView actList;
	Button addButton;
	Button delButton;
	EditText newDuration;
	TextView durationLabel;
	String record;
	Spinner addSpinner;
	Button lastAdd;
	String selectedValue;
	String duration;
	boolean isAdd=true;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_prev_act);

		Toast.makeText(getApplicationContext(), record, Toast.LENGTH_LONG).show();

		newDuration = (EditText)findViewById(R.id.durationText);
		durationLabel = (TextView)findViewById(R.id.textView1);
		addSpinner = (Spinner)findViewById(R.id.addSpinner);
		lastAdd = (Button)findViewById(R.id.add);

		ArrayAdapter<String> spinnAdaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1,getResources().getStringArray(R.array.selectList));		

		addSpinner.setAdapter(spinnAdaptor);
		addSpinner.setOnItemSelectedListener(this);





		actList = (ListView) findViewById(R.id.activityList);
		ArrayAdapter<String> veriAdaptoru=new ArrayAdapter<String>
		(this, android.R.layout.simple_list_item_1, android.R.id.text1, MainActivity.myList);
		actList.setAdapter(veriAdaptoru);






		addButton = (Button)findViewById(R.id.addButton);
		addButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				addSpinner.setVisibility(View.VISIBLE);
				durationLabel.setVisibility(View.VISIBLE);
				newDuration.setVisibility(View.VISIBLE);
				lastAdd.setVisibility(View.VISIBLE);
				if (isAdd) {
					
				}
			}
		});

		delButton = (Button)findViewById(R.id.deleteButton);
		delButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				actList.setOnItemClickListener(new OnItemClickListener() {
					public void onItemClick(AdapterView<?> myAdapter,View myView, int myItemint, long mylng){
						String selectedFromList = (String)(actList.getItemAtPosition(myItemint));//Selected item convert to String
						Toast.makeText(getApplicationContext(), selectedFromList, Toast.LENGTH_LONG).show();

						MainActivity.myList.remove(myItemint);
						actList.invalidateViews();

					}

				});
			}
		});
		
		
		lastAdd.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				MainActivity.myList.add(selectedValue+" "+duration);
				actList.invalidateViews();
				isAdd = false;
				addSpinner.setVisibility(View.INVISIBLE);
				durationLabel.setVisibility(View.INVISIBLE);
				newDuration.setVisibility(View.INVISIBLE);
				lastAdd.setVisibility(View.INVISIBLE);
			}
		});
	}


	@Override
	public void onChronometerTick(Chronometer arg0) {
		// TODO Auto-generated method stub

	}
	@Override
	public void onClick(View arg0) {
		// TODO Auto-generated method stub

	}



	@Override
	public void onItemSelected(AdapterView<?> arg0, View arg1, int position,
			long arg3) {
		// TODO Auto-generated method stub
		selectedValue = addSpinner.getItemAtPosition(position).toString();
		duration = newDuration.getText().toString();
	}


	@Override
	public void onNothingSelected(AdapterView<?> arg0) {
		// TODO Auto-generated method stub

	}
}
