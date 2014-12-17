package com.rewass.rewass;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import com.couchbase.lite.*;
import com.couchbase.lite.android.AndroidContext;
import com.couchbase.lite.util.Log;
import java.util.*;
import java.text.*;

import java.io.IOException;

import appcache.AppData;

public class Test extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);

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
        String strDbName = "mainDB";
        boolean flgDbFound=false;

        List<String> lstDB = manager.getAllDatabaseNames();
        for (Iterator<String> itr=lstDB.iterator(); itr.hasNext();) {
            if (strDbName==itr.next()) {
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
}
