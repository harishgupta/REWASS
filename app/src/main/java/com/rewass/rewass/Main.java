package com.rewass.rewass;

import android.os.*;
import android.os.AsyncTask;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.couchbase.lite.*;
import com.couchbase.lite.android.AndroidContext;
import com.couchbase.lite.util.Log;
import java.util.*;

import java.io.IOException;

import appcache.AppData;
import databrokers.BrokerUser;

public class Main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_Main);

        String TAG="Harish";
        // create a manager
        Manager manager;
        try {
            manager = new Manager(new AndroidContext(this), Manager.DEFAULT_OPTIONS);
            Log.d (TAG , "Manager created");
        } catch (IOException e) {
            Log.e(TAG, "Cannot create manager object");
            return;
        }

        /* Get a list of databases, if the database 'mainDB' doesn't exist, create one */
        Database mainDB;
        String strDbName = "maindb";
        boolean flgDbFound=false;

        List<String> lstDB = manager.getAllDatabaseNames();
        for (String item : lstDB ) {
            if (strDbName.equals(item)) {
                flgDbFound=true;
                break;
            }
        }

        if (flgDbFound) {
            try {
                mainDB = manager.getExistingDatabase(strDbName);
                Log.d(TAG, "Main DB opened");
            } catch (CouchbaseLiteException e) {
                Log.e(TAG, "Cannot open database");
                return;
            }
        } else {
            try {
                mainDB = manager.getDatabase(strDbName);
                Log.d(TAG, "Main DB created");
            } catch (CouchbaseLiteException e) {
                Log.e(TAG, "Cannot get database");
                return;
            }
        }
        AppData.getInstance().setCblMainDB(mainDB);


        /* Bind List View with RWA list*/
        ListView listView1 = (ListView) findViewById(R.id.listView1);
        /*
        String[] items = { "Milk", "Butter", "Yogurt", "Toothpaste", "Ice Cream" };

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1,  items);

        listView1.setAdapter(adapter); */

        ControlRWAList1 obj=new ControlRWAList1();
        obj.execute(listView1, this);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_test, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }


    /*RWA List Controller*/

    private class ControlRWAList1 extends AsyncTask<Object,Void,ArrayList<String>> {

        private ListView resu;
        private Main context;
        protected ArrayList<String> doInBackground(Object... lstRWA) {
            resu=(ListView)lstRWA[0];
            context=(Main) lstRWA[1];
            return BrokerUser.getRwaList();
        }

        protected void onPostExecute(ArrayList<String> result) {
            String [] strArray= result.toArray(new String[0]);
            ArrayAdapter<String> adapter = new ArrayAdapter<>(context,
                    android.R.layout.simple_list_item_1,  strArray);
            resu.setAdapter(adapter);
        }


    }
}
