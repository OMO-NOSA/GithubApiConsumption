package com.example.android.gitapplication;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by NOSSY on 9/7/2017.
 */

public class DeveloperAdapter extends ArrayAdapter<DeveloperClass>{

    ArrayList<DeveloperClass> DeveloperClass;
    Context context;
    int resource;

    public DeveloperAdapter(Context context, int resource, ArrayList<DeveloperClass> DeveloperClass) {
        super(context, resource, DeveloperClass);
        this.DeveloperClass = DeveloperClass;
        this.context=context;
        this.resource=resource;
    }

    // Call xml file inside Adapter for each listView row(Use of layoutInflater inside Adapter)
    @Override
    public View getView(int position, View convertView, ViewGroup parent){

        if (convertView==null){

            LayoutInflater layoutInflater=(LayoutInflater) getContext().getSystemService(Activity.LAYOUT_INFLATER_SERVICE);
            convertView=layoutInflater.inflate(R.layout.generic_list,null,true);
        }
        DeveloperClass users=getItem(position);

        ImageView imageView=(ImageView) convertView.findViewById(R.id.avatarId);
        Picasso.with(context).load(users.getAvatarUrl()).placeholder(R.drawable.avatar).resize(80,80).into(imageView);

        TextView textView=(TextView) convertView.findViewById(R.id.user_textView);
        textView.setText(users.getUserName());
        return convertView;
    }
}
