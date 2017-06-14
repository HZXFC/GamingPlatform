package com.image.indicator.activity;

import com.image.indicator.R;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class OtherZoom extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_other_zoom);
		final Context self = this;
		final TextView fensi_total = (TextView) this.findViewById(R.id.hotspot);
		TextView guanzhu = (TextView) this.findViewById(R.id.plusfocus);
		guanzhu.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				new AlertDialog.Builder(self)
				.setTitle("关注")
				.setMessage("关注成功！")
				.setPositiveButton("确定",null).show();
				// startActivityForResult(new Intent(UserZoom.this,
				// OtherZoom.class), 1);
				fensi_total.setText("4");
			}

		});

	}
}
