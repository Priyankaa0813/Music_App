package com.example.ms;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class StudentSignUp extends Student {
    String name,pass,college,mail,add,contact;
	Button submit,reset;
	EditText suname,spass,colname,mid,address,cno;
	boolean set;
	
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.student_signup);

		 suname=(EditText)findViewById(R.id.edt_signup_username);
		 spass=(EditText)findViewById(R.id.edt_signup_pass);
		 suname.requestFocus();
		 colname=(EditText)findViewById(R.id.edt_collegename);
		 mid=(EditText)findViewById(R.id.edt_mailid);
		 address=(EditText)findViewById(R.id.edt_address);
		 cno=(EditText)findViewById(R.id.edt_contactno);
	
	
		 
		 submit=(Button)findViewById(R.id.btn_submit);
	     submit.setOnClickListener(new OnClickListener() {
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			
			 name=suname.getText().toString().trim();
			 pass=spass.getText().toString().trim();
			 college=colname.getText().toString().trim();
			 mail=mid.getText().toString().trim();
			 add=address.getText().toString().trim();
			 contact=cno.getText().toString().trim();
			 
			
			 
			validate();
			if(set==true)
			{
			 
				
			try
			{
			 SDatabaseHub dbh=new SDatabaseHub(StudentSignUp.this);
			 SQLiteDatabase db=dbh.getWritableDatabase();
			 ContentValues cv=new ContentValues();
			 cv.put(SDatabaseHub.username,name);
			 cv.put(SDatabaseHub.password,pass);
			 cv.put(SDatabaseHub.college, college);
			 cv.put(SDatabaseHub.mail,mail);
			 cv.put(SDatabaseHub.address,add);
			 cv.put(SDatabaseHub.contact,contact);
			 
			 db.insert(SDatabaseHub.sdb, null, cv);
			 Toast.makeText(StudentSignUp.this,"Register Successfull",Toast.LENGTH_SHORT).show();

			 Intent in=new Intent(StudentSignUp.this,Student.class);
			 startActivity(in);
			
			
			}catch(Exception e)
			{
				System.out.println("Database error");
			}
			 
			Intent in=new Intent(StudentSignUp.this,Student.class);
			 startActivity(in);
			
			 
			 
			
			
          
		}
		}
		
		
		private boolean validate()
		{
			
			
			
			 
			
				if(name.length()== 0)
				{
					
	                suname.setError("User Name Required");
	                suname.requestFocus();
	         }
				else if(name.length()>=12)
				{
					 suname.setError("User Name Too Long");
	                    suname.requestFocus();	
				}
				else if(name.length()<=3)
				{
					 suname.setError("User Name Too Short");
	                    suname.requestFocus();	
				}
				 
				else if(pass.length()==0){
	                spass.setError("Password Required");
	                spass.requestFocus();
	         }
				else if(pass.length()<=4){
	                spass.setError("Password too short");
	                spass.requestFocus();
	         }
				
				else if(colname.length()==0)  
				{
					
	                colname.setError("College Name is Required");
	                colname.requestFocus();
				}
				else if(colname.length()<=4)  
				{
					
	                colname.setError("College Name is Invalid");
	                colname.requestFocus();
				}
				
	
	else if(mid.length()==0)
	{
	                mid.setError("Enter Mail Id In ***@servername.com ");
	                mid.requestFocus();
	                
	         }
	else if(mid.length()<=5)
	{
	                mid.setError("Enter Mail Id In ***@servername.com ");
	                mid.requestFocus();
	                
	         }
				
			 
			
				
				else if(add.length()==0) 
				{
					 address.setError("Address Required");
	                    address.requestFocus();	
				}
				else if(add.length()>=30) 
				{
					 address.setError("Address Too Long");
	                    address.requestFocus();	
				}
				
			

				else if(contact.length()==0) 
				{
					 cno.setError("Enter a Valid Phone Number");
	                    cno.requestFocus();	
				}
				else if(contact.length()>10) 
				{
					 cno.setError("Enter a Valid Phone Number");
	                    cno.requestFocus();	
				}
				 
				
				else
				{
			set=true;}
				
				return set;
				
				
		}
		
		
		
		
	});
	
	
	reset=(Button)findViewById(R.id.btn_reset);
	reset.setOnClickListener(new OnClickListener() {
		
		
		public void onClick(View arg0) {
			// TODO Auto-generated method stub
			suname.setText(null);
			spass.setText(null);
			colname.setText(null);
			mid.setText(null);
			address.setText(null);
			cno.setText(null);
		
		}
		});
	}
	
	
}
