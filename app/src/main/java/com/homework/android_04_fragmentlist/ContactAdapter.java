package com.homework.android_04_fragmentlist;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ContactAdapter extends ArrayAdapter<EmailContact> {
    private MainActivity mainActivity;
    private int resourceId;
    private List<EmailContact> emploees;
    public ContactAdapter(Context context, int resource, List<EmailContact> objects) {
        super(context, resource, objects);
        this.mainActivity = (MainActivity)context;
        emploees = objects;
        resourceId = resource;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        EmailContact emploee = emploees.get(position);
        View view = LayoutInflater.from(getContext()).inflate(resourceId, null);
        TextView firstName = (TextView) view.findViewById(R.id.tvFirstName);
        TextView lastName = (TextView) view.findViewById(R.id.tvLastName);
        TextView email = (TextView) view.findViewById(R.id.tvEmail);
        firstName.setText(emploee.firstName);
        lastName.setText(emploee.lastName);
        email.setText(emploee.email);
        return view;
    }
}
