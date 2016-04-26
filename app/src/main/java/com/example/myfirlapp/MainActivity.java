package com.example.myfirlapp;

import android.app.Activity;
import android.app.AlertDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.app.Dialog;

import java.lang.reflect.Array;

/**
 * Created by Руслан on 26.01.2016.
 */
public class MainActivity extends Activity {
    @Override
    protected void onDestroy() {
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView(R.layout.activity_layout);
        setContentView(R.layout.table_layout);
        String[] paynebt = new String[2];
        CalC road = new CalC();
        String t = String.valueOf(road.methodName(990, 12, 0.29, 990 / 12));


        paynebt[0] = t;
        paynebt[1] = String.valueOf(road.SumGet(990));
        ListView listViem = (ListView) findViewById(R.id.listViem);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, paynebt);


        listViem.setAdapter(adapter);
        listViem.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);


    }


}
