package com.example.ms;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class StudentFeedBack extends Activity {

	Button buttonSend;
	String textTo="priyankaa0813@gmail.com";
	EditText textSubject;
	EditText textMessage;

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_feedback);

		buttonSend = (Button) findViewById(R.id.buttonSend);
	    
		textSubject = (EditText) findViewById(R.id.editTextSubject);
		textMessage = (EditText) findViewById(R.id.editTextMessage);
		 
		buttonSend.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
             
			 // String to = textTo.getText().toString();
			  String subject = textSubject.getText().toString();
			  String message = textMessage.getText().toString();

			  Intent email = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
			            "mailto","abc@gmail.com", null));
			 
			  email.putExtra(Intent.EXTRA_EMAIL, new String[]{ textTo});
			  //email.putExtra(Intent.EXTRA_CC, new String[]{ to});
			  //email.putExtra(Intent.EXTRA_BCC, new String[]{to});
			  email.putExtra(Intent.EXTRA_SUBJECT, subject);
			  email.putExtra(Intent.EXTRA_TEXT, message);

			  //need this to prompts email client only
			 
			  startActivity(Intent.createChooser(email, "Choose an Email client :"));

			}
		});
	}
}