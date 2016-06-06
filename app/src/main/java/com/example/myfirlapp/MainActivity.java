package com.example.myfirlapp;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.os.Bundle;
import android.renderscript.Sampler;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Date;

/**
 * Created by Руслан on 26.01.2016.
 */
public class MainActivity extends Activity {
    static final int idB = 0;
    static final int idBg = 1;
    Button bt;
    Button btg;
    int year_x = 2015;
    int month_x = 7;
    int day_x = 29;
    int amount = 1000;
    int percent = 29;
    int per = 12;
    Date Start = new Date(year_x, month_x, day_x);
    NumberPicker np;
    TextView tvam;
    TextView tvpc;
    TextView tvper;
    EditText edA;
    EditText edP;
    private DatePickerDialog.OnDateSetListener dtPickerList = new DatePickerDialog.OnDateSetListener() {
        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
            year_x = year;
            month_x = monthOfYear;
            day_x = dayOfMonth;
            String st = year_x + "/" + month_x + "/" + day_x;
            bt.setText(st);
        }
    };

    ;

    protected void ShowDialogButton() {
        bt = (Button) findViewById(R.id.button);
        bt.setText(year_x + "/" + month_x + "/" + day_x);
        bt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialog(idB);
            }
        });

    }

    protected void ButtonGo() {
        btg = (Button) findViewById(R.id.button2);
        btg.setText("Calc");
        btg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LayoutShower();
            }
        });
    }
    private void Amountlist(){
        edA = (EditText) findViewById(R.id.editText);
        edA.setText(""+amount);
        edA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                amount= Integer.parseInt(edA.getText().toString());
            }
        });};
    private void Percentlist(){
        edP = (EditText) findViewById(R.id.editText1);
        edP.setText(""+percent);
        edP.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {

                    percent= Integer.parseInt(edP.getText().toString());

            }
        } );};


    @Override
    protected Dialog onCreateDialog(int id) {
        if (id == idB)
            return new DatePickerDialog(this, dtPickerList, year_x, month_x, day_x);

        return null;
    }

    private int LayoutShower() {
        setContentView(R.layout.table_layout);
        CalC road = new CalC();
        per = np.getValue();
        month_x = month_x + per;
        year_x = year_x + month_x / 12;
        month_x = month_x % 12;
        road.zap(Start, new Date(year_x, month_x, day_x));

        String[] some = road.list(road.methodName(Integer.parseInt(edA.getText().toString()), Integer.parseInt(edP.getText().toString())/100, Integer.parseInt(edA.getText().toString()) / per));
        ListView listViem = (ListView) findViewById(R.id.listViem);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, some);
        listViem.setAdapter(adapter);
        listViem.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        return 2;
    }

    ;

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "destroed", Toast.LENGTH_LONG);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.enter_layout);

        ShowDialogButton();
        ButtonGo();

        Percentlist();
        Amountlist();
        np = (NumberPicker) findViewById(R.id.numberPicker);
        tvam = (TextView) findViewById(R.id.text);
        tvpc = (TextView) findViewById(R.id.text1);
        tvper = (TextView) findViewById(R.id.text2);
        tvam.setText("Enter amount");
        tvpc.setText("Enter percent");
        tvper.setText("Enter Start  & period");
        np.setMaxValue(106);
        np.setMinValue(0);
        np.setValue(7);


    }

}
