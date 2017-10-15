package com.example.ms;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.Layout;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.TextView;

public class FirstPageActivity extends Activity 
{
	ImageView imaster,istudent;
	TextView tmaster,tstudent;
    Layout   mlayout,slayout;

   

protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

ActionBar bar = getActionBar();
bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#009688")));

        imaster=(ImageView)findViewById(R.id.iv_master);
      imaster.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View arg0) 
		{
			// TODO Auto-generated method stub
		Intent in=new Intent(FirstPageActivity.this,Master.class);
		startActivity(in);
		}
	});
      
      istudent=(ImageView)findViewById(R.id.iv_student);
      istudent.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View arg0) 
		{
			// TODO Auto-generated method stub
		Intent in=new Intent(FirstPageActivity.this,Student.class);
		startActivity(in);
		}
	});
     
      
}
}
