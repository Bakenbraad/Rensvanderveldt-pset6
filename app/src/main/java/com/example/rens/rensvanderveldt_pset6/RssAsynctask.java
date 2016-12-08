package com.example.rens.rensvanderveldt_pset6;

import android.content.Context;
import android.os.AsyncTask;
import android.widget.Toast;

/**
 * Created by Rens on 8-12-2016.
 */

public class RssAsynctask extends AsyncTask {

    Context appContext;

    public RssAsynctask(Context c){
        appContext = c;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        Toast toast = Toast.makeText(appContext, "Zoeken naar meldingen", Toast.LENGTH_SHORT);
        toast.show();
    }

    @Override
    protected Object doInBackground(Object[] params) {
        return null;
    }

    @Override
    protected void onPostExecute(Object o) {
        super.onPostExecute(o);
    }
}
