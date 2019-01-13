package com.working4enjoyment.decidecabina;

import android.util.Log;

import com.google.gson.Gson;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class Utility {

    public static List<Voting> serializeVoting(String response){
        List<Voting> result;
        JSONArray ja;
        Voting voting;
        Calendar startDate;
        Calendar endDate;
        JSONObject questionJSON;
        Question question;

        result= new ArrayList<Voting>();

        try{
            ja= new JSONArray(response);
            for(int i=0; i<ja.length(); i++) {

                startDate = Calendar.getInstance();
                if (ja.getJSONObject(i).getString("start_date").trim().equals("null") || ja.getJSONObject(i).getString("start_date").trim() == "null") {
                    startDate = null;
                } else {
                    startDate.set(new Integer(ja.getJSONObject(i).getString("start_date").split("-")[0]), new Integer(ja.getJSONObject(i).getString("start_date").split("-")[1]) - 1, new Integer(ja.getJSONObject(i).getString("start_date").split("-")[2].substring(0, 2)));

                }

                endDate = Calendar.getInstance();
                if (ja.getJSONObject(i).getString("end_date").trim().equals("null") || ja.getJSONObject(i).getString("end_date").trim() == "null") {
                    endDate = null;
                } else {
                    endDate.set(new Integer(ja.getJSONObject(i).getString("end_date").split("-")[0]), new Integer(ja.getJSONObject(i).getString("end_date").split("-")[1]) - 1, new Integer(ja.getJSONObject(i).getString("end_date").split("-")[2].substring(0, 2)));
                }
                questionJSON = ja.getJSONObject(i).getJSONObject("question");

                Gson gson = new Gson();
                question = gson.fromJson(questionJSON.toString(), Question.class);


                voting = new Voting(new Integer(ja.getJSONObject(i).getInt("id")), new String(ja.getJSONObject(i).getString("name")), new String(ja.getJSONObject(i).getString("desc")), question, startDate, endDate);

                result.add(voting);
            }
        }catch (JSONException e){
            // e.printStackTrace();
           result= null;
        }

        return result;

    }
}
