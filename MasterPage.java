package com.example.ms;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class MasterPage extends Master {

	private Button button;

	public void onCreate(Bundle savedInstanceState) {

		super.onCreate(savedInstanceState);
		setContentView(R.layout.masterpage);

		button = (Button) findViewById(R.id.buttonCall);

		// add button listener
		button.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {

				Intent callIntent = new Intent(Intent.ACTION_CALL);
				callIntent.setData(Uri.parse("tel:0377778888"));
				startActivity(callIntent);

			}

		});

	}

}
