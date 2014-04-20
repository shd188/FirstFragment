package com.aimer.firstfragment;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

public class DetailActivity extends Activity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_detail);
		TextView detail = (TextView) findViewById(R.id.textView_detail);
		detail.setText(getIntent().getStringExtra("detail"));
	}

}
