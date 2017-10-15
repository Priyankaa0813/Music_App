package com.example.ms;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class SDatabaseHub extends SQLiteOpenHelper {

	public static final String rdbname="slogin.db";
	public static final int version=1;
	public static final String username="uname";
	public static final  String password="pass";
	public static final String college="college";
	public static final String mail="mail";
	public static final String address="address";
	public static final String contact="contact";
	public static final String sdb="slogin";
	
	

	public SDatabaseHub(Context context) {
		super(context, rdbname, null, version);
		// TODO Auto-generated constructor stub
	}

	
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		String sql= " create table if not exists " + sdb + "(" +  username + " text," + password + " text," + college + " text," + mail + " text," +  address + " text," +  contact + " text)"; 
		db.execSQL(sql);
	}

	
	public void onUpgrade(SQLiteDatabase db, int oldversion, int newversion) {
		// TODO Auto-generated method stub
		if(oldversion<newversion)
		{
			String sql= " create table " + sdb + "(" +  username + " text," + password + " text," + college + " text," + mail + " text," +  address + " text," +  contact + " text)"; 
			db.execSQL(sql);
		}
	}

}
