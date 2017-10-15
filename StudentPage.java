
package com.example.ms;

import com.example.ms.ContactListActivity;
import com.example.ms.R;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ImageView;
import android.widget.Toast;

public class StudentPage extends FirstPageActivity{
    ImageView contact;
	ImageView feedback;
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.studentpage);
		
		
		feedback=(ImageView)findViewById(R.id.iv_feedback);
		feedback.setOnClickListener(new OnClickListener() {
			
		
			public void onClick(View v)
			{
				// TODO Auto-generated method stub
		         Intent in=new Intent(StudentPage.this,StudentFeedBack.class);
				 startActivity(in);
			}
		});
	
	
		 contact=(ImageView)findViewById(R.id.iv_pcall);	  
         contact.setOnClickListener(new OnClickListener() {
		 public void onClick(View v)
			{
            	Intent in=new Intent(StudentPage.this,ContactListActivity.class);
				startActivityForResult(in, 1);
			}
		});
  }


protected void onActivityResult(int requestCode, int resultCode, Intent data)
{
	// TODO Auto-generated method stub
super.onActivityResult(requestCode, resultCode, data);
	
if(requestCode==1 && resultCode==Activity.RESULT_OK)
	
{
		
	
		Toast.makeText(this,"", Toast.LENGTH_SHORT).show();
    }
    }    
        
public void onBackPressed()
        {
	    super.onBackPressed();
	    startActivity(new Intent(StudentPage.this, FirstPageActivity.class));
	    finish();
	    }
 }
