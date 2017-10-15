package com.example.ms;

import java.util.List;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ms.ContactListActivity.Contact;

public class ContactTechListArrayAdapter extends ArrayAdapter<Contact> {

	 private final List<ContactListActivity.Contact> list;
	    private final Activity context;

	    static class ViewHolder {
	        protected TextView name;
	        protected ImageView flag;
			public ImageView icon;
	    }

	    public ContactTechListArrayAdapter(Activity context, List<ContactListActivity.Contact> list) {
	        super(context, R.layout.activity_contactcode_row, list);
	        this.context = context;
	        this.list = list;
	    }



@Override
public View getView(int position, View convertView, ViewGroup parent) {
    View view = null;

    if (convertView == null) {
        LayoutInflater inflator = context.getLayoutInflater();
        view = inflator.inflate(R.layout.activity_contactcode_row, null);
        final ViewHolder viewHolder = new ViewHolder();
        viewHolder.name = (TextView) view.findViewById(R.id.name);
        viewHolder.icon = (ImageView) view.findViewById(R.id.icon);
        view.setTag(viewHolder);
    } else {
        view = convertView;
    }

    ViewHolder holder = (ViewHolder) view.getTag();
    holder.name.setText(list.get(position).getName());
    holder.icon.setImageDrawable(list.get(position).getIcon());
    return view;
}
}
