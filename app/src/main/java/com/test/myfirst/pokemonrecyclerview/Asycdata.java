package com.test.myfirst.pokemonrecyclerview;

import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class Asycdata extends AsyncTask<String, Integer, String> {


    @Override
    protected String doInBackground(String... strings) {
        String jsonurl = strings[0];
        String json="";



        Httphandler sh = new Httphandler();

        json = sh.makeServiceCall(jsonurl);
        System.out.println("This is Json :"+json);


        try {
            JSONObject mainobj = new JSONObject(json);

            JSONArray mainarray = mainobj.getJSONArray("Pokemon");
            int size = mainarray.length();

            publishProgress(size);

        } catch (JSONException e) {
            e.printStackTrace();
        }


        return json;
    }

    @Override
    protected void onPreExecute() {



        super.onPreExecute();
    }


    @Override
    protected void onPostExecute(String s) {

      //
        //  progs.setVisibility(View.INVISIBLE);

       // progressDialog.dismiss();
    }

}
