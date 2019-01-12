package com.working4enjoyment.decidecabina;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;
import java.util.List;
import java.util.Map;

public class AdapterOptionVoting extends BaseAdapter {
    private Activity activity;
    private Typeface tf;
    private List<String> options;

    public AdapterOptionVoting(Activity activity, List<String> option) {
        this.activity = activity;
        this.options = option;
        //this.tf = Typeface.createFromAsset(activity.getAssets(),"font/Roboto-Regular.ttf");
    }

    @Override
    public int getCount() {
        return options.size();
    }

    @Override
    public Object getItem(int i) {
        return options.get(i);
    }

    public long getItemId(int i) {
        return options.get(i).hashCode();
    }

    public void addAll(List<String> lOptions){
        options.addAll(lOptions);
    }

    public void clear(){
        options.clear();
    }


    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        View vi = contentView;

        if (contentView == null) {
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.list_view_vote, null);
        }


        final String option = options.get(position);


        vi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(v.getContext(), "Usted quiere votar '"+option+"'. Aún no se ha implementado el envío de la votación", Toast.LENGTH_LONG).show();
            }
        });

        TextView opcionR = (TextView) vi.findViewById(R.id.option);
        opcionR.setText(option);




        return vi;
    }
}
