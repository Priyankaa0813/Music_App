package com.example.ms;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class Master extends FirstPageActivity {

	Button login,signup;
	EditText uname,pass;
	String uname_s,pass_s;
	
    boolean set;	  
    protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.master_login);
		
		
		 signup=(Button)findViewById(R.id.btn_signup);
		 login=(Button)findViewById(R.id.btn_login);
		 
		 login.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				
				
				 
				validationSuccess();
            if (set=true) 
            {
         try
{
DatabaseHub dbh=new DatabaseHub(Master.this);
SQLiteDatabase db=dbh.getReadableDatabase();

Cursor cur=db.query(DatabaseHub.masterdb, null, null, null, null, null, null);

if(!cur.equals(""))
{
	if(cur.moveToFirst())
	{
		do
		{
		String sdbname=cur.getString(cur.getColumnIndex("uname"));
		String sdbpass=cur.getString(cur.getColumnIndex("pass"));
		if(uname_s.equals(sdbname)&&pass_s.equals(sdbpass))
		{
			uname.setText(null);
			pass.setText(null);
			Toast.makeText(Master.this,"Login Successfull",Toast.LENGTH_SHORT).show();
		    Intent in=new Intent(Master.this,MasterPage.class);
			 startActivity(in);
		}
		else
		{
			
		Toast.makeText(Master.this,"Login failed",Toast.LENGTH_SHORT).show();
		}
	}while(cur.moveToNext());
		}
	}
}catch(Exception e)
{
	System.out.println("Database error");
	Toast.makeText(Master.this,"DB failed",Toast.LENGTH_SHORT).show();
}
}
}

			private boolean validationSuccess() {
				// TODO Auto-generated method stub
				 uname=(EditText)findViewById(R.id.edt_username);
				 uname.requestFocus();
				 pass=(EditText)findViewById(R.id.edt_pass);
				 uname_s=uname.getText().toString();
				 pass_s=pass.getText().toString();
				if(uname_s.length()==0)
				{
					
                    uname.setError("User Name Required");
                    uname.requestFocus();
             }
				
			
				else if(pass_s.length()==0){
                    pass.setError("Password Required");
                    pass.requestFocus();
             }
				else
				{
				set=true;
			}
				return set;
			}
			});
		
		 
		 
		
		 signup.setOnClickListener(new OnClickListener() {
			
			
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				Intent in=new Intent(Master.this,MasterSignUp.class);
				 startActivity(in);
			}
		});
	}
	
	
	public void onBackPressed() {
	    super.onBackPressed();
	}
	

}
