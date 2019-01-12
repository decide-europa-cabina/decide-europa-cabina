package com.working4enjoyment.decidecabina;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.graphics.Typeface;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.Calendar;
import java.util.List;

public class AdapterVoting extends BaseAdapter {
    private Activity activity;
    private Typeface tf;
    private List<Voting> votings;

    public AdapterVoting(Activity activity, List<Voting> voting) {
        this.activity = activity;
        this.votings = voting;
        //this.tf = Typeface.createFromAsset(activity.getAssets(),"font/Roboto-Regular.ttf");
    }

    @Override
    public int getCount() {
        return votings.size();
    }

    @Override
    public Object getItem(int i) {
        return votings.get(i);
    }

    @Override
    public long getItemId(int i) {
        return votings.get(i).getId();
    }

    public void addAll(List<Voting> lVotings){
        votings.addAll(lVotings);
    }

    public void clear(){
        votings.clear();
    }


    @Override
    public View getView(int position, View contentView, ViewGroup parent) {
        View vi = contentView;
        final View vi2;
        String day;
        String month;
        String year;

        if (contentView == null) {
            LayoutInflater inflater = (LayoutInflater) activity
                    .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            vi = inflater.inflate(R.layout.list_view_voting, null);
        }

        vi2= vi;


        final Voting voting = votings.get(position);



        vi2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(activity.getApplicationContext(), LoginActivity.class);
                intent.putExtra("voting", voting);
                v.getContext().startActivity(intent);
            }
        });



        TextView descripcion = (TextView) vi.findViewById(R.id.descripcion);
        descripcion.setText(voting.getDesc());

        TextView fechaFin = (TextView) vi.findViewById(R.id.fechaFin);

        TextView name = (TextView) vi.findViewById(R.id.name);

        name.setText(voting.getName());

        if (voting.getEndDate() != null) {
            day = "" + voting.getEndDate().get(Calendar.DAY_OF_MONTH);
            month = "" + (voting.getEndDate().get(Calendar.MONTH)+1);
            year = "" + voting.getEndDate().get(Calendar.YEAR);

            if (voting.getEndDate().get(Calendar.MONTH)+1 < 10) {
                month = "0" + month;
            }
            if (voting.getEndDate().get(Calendar.DAY_OF_MONTH) < 10) {
                day = "0" + day;
            }

            fechaFin.setText(day+"/"+month+"/"+year);
        } else
            fechaFin.setText("No definida");

        TextView startDate = (TextView) vi.findViewById(R.id.fechaInicio);

        if (voting.getStartDate() != null){
            day = "" + voting.getStartDate().get(Calendar.DAY_OF_MONTH);
            month = "" + (voting.getStartDate().get(Calendar.MONTH)+1);
            year = "" + voting.getStartDate().get(Calendar.YEAR);


            if (voting.getStartDate().get(Calendar.MONTH)+1 < 10) {
                month = "0" + month;
            }
            if (voting.getStartDate().get(Calendar.DAY_OF_MONTH) < 10) {
                day = "0" + day;
            }
            startDate.setText(day+"/"+month+"/"+year);
        }else
            startDate.setText("No definida");


        return vi;
    }
}
