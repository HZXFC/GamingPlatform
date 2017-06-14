package com.image.indicator.activity;

import com.image.indicator.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;

public class FindActivity extends Activity{
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_find);
	
		TextView guanzhu2 = (TextView) this.findViewById(R.id.m_wodeguanzhu2);
		guanzhu2.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				startActivityForResult(new Intent(FindActivity.this, OtherZoom.class),  1);
			}

	});

	}

}
