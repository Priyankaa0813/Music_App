package com.example.ms;

import java.util.ArrayList;
import java.util.List;

import android.app.ListActivity;
import android.content.Intent;
import android.content.res.TypedArray;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.gsm.SmsMessage;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Toast;

public class ContactListActivity extends ListActivity {
	 public static String RESULT_CONTACTCODE = "contactcode";
	    public String[] contacttech,contactcodes;
	    private TypedArray imgs;
	    private List<Contact> contacttechList;
	    public static int opvalue;
	    
	 
	 
	  protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);
	        populateContactTechList();
	 ArrayAdapter<Contact> adapter=new ContactTechListArrayAdapter(this,contacttechList);
	 setListAdapter(adapter);
	 getListView().setOnItemClickListener(new AdapterView.OnItemClickListener() {

		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) 
		{
			// TODO Auto-generated method stub
			
			Contact c=contacttechList.get(position);
			
			if(position==0)
			{
				
				
	Intent in=new Intent(Intent.ACTION_VIEW,Uri.fromParts("sms", "7338917192", null));
	

	
	startActivity(in);
    imgs.recycle(); //recycle images
    finish();
			}
			
			
			if(position==1)
			{
				Intent ph=new Intent(Intent.ACTION_CALL);
				ph.setData(Uri.parse("tel: 7338917192"));
				startActivity(ph);
				
	              imgs.recycle(); //recycle images
	              finish();

			}
			
			if(position==3)
			{
				
				Intent in=new Intent(Intent.ACTION_CALL);
				setResult(RESULT_OK,in);
			}
		}
	   
     }); 
	 }
	
	 
	 private void populateContactTechList() {
		// TODO Auto-generated method stub
		  contacttechList = new ArrayList<Contact>();
		  contacttech = getResources().getStringArray(R.array.contact_names);
		  contactcodes = getResources().getStringArray(R.array.contact_codes);
		  imgs = getResources().obtainTypedArray(R.array.contact_icons);
		  

	        for(int i = 0; i < contactcodes.length; i++){
	       
	             	 contacttechList.add(new Contact(contacttech[i], contactcodes[i], imgs.getDrawable(i)));
	     
	 }
	}

	 
	 public class Contact {       
		    private String name;
	        private String code;
	        private Drawable icon;
	        public Contact(String name, String code, Drawable icon){
	            this.name = name;
	            this.code = code;
	            this.icon = icon;
	        }
	        public String getName() {
	            return name;
	        }
	        public Drawable getIcon() {
	            return icon;
	        }
	        public String getCode() {
	            return code;
	        }
	    }
	}