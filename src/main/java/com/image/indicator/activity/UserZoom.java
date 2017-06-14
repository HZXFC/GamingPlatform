package com.image.indicator.activity;





import com.image.indicator.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class UserZoom extends Activity {


	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_zoom);
		
		TextView guanzhu = (TextView) this.findViewById(R.id.m_wodeguanzhu);
		guanzhu.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				startActivityForResult(new Intent(UserZoom.this, OtherZoom.class),  1);
			}

	});
		TextView fensi = (TextView) this.findViewById(R.id.m_wodefensi);
		fensi.setOnClickListener(new View.OnClickListener(){
			public void onClick(View v){
				startActivityForResult(new Intent(UserZoom.this, FansActivity.class),  1);
			}

	});

	}
}
