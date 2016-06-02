package com.example.myfirlapp;
import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ListView;
import java.util.Date;

/**
 * Created by Руслан on 26.01.2016.
 */
public class MainActivity extends Activity {
    Button bt;
    int year_x=1994;
    int month_x = 7;
    int day_x =29;

    static final int idB=0;

    protected void ShowDialogButton(){
        bt =(Button)findViewById(R.id.button);
        bt.setText(year_x+"/"+month_x+"/"+day_x+"start");
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(idB);
            }
        });
    };

    @Override
    protected Dialog onCreateDialog(int id) {
        if (id==idB)
       return new DatePickerDialog(this,dtPickerList,year_x,month_x,day_x);
        return null;
    }

    private DatePickerDialog.OnDateSetListener dtPickerList = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x=year;
            month_x = monthOfYear;
            day_x= dayOfMonth;
            String st = year_x+"/"+month_x+"/"+day_x+" result";
           bt.setText(st);
        }
    };

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
        setContentView(R.layout.enter_layout);
        //setContentView(R.layout.table_layout);

        CalC road = new CalC();
        road.zap(new Date(2016,01,25),new Date(2017,01,25));
        String[] some =  road.list(road.methodName(990,  0.29, 990 / 12));
        ShowDialogButton();


       /*ListView listViem = (ListView) findViewById(R.id.listViem);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, some);
        listViem.setAdapter(adapter);
        listViem.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);*/


    }

}
