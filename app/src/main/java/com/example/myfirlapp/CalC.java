package com.example.myfirlapp;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by Руслан on 02.02.2016.
 */
public class CalC {
    static double f = 0;
    static int m=0;
    public  void zap(Date st, Date ed){ // your date
        Calendar cal = Calendar.getInstance();
        cal.setTime(st);
        int year = cal.get(Calendar.YEAR);
        year = st.getYear();
        int month = cal.get(Calendar.MONTH);
        int day = cal.get(Calendar.DAY_OF_MONTH);
        CalC road = new CalC();
        this.m = day;


    }
    public static void main(String[] args) {

    }

    public static double methodName(double a,  double r, double p) {
        // body
        double z = 1 + r / 365;
        f = a;

        System.out.printf("Nal: %s\n Amount: %s\n  Monthl: %s \n", a, f, Math.round(p));

        for (int i = 0; i < m; i++) {
            if (i == 0) {

                f = f * Math.pow(z, 38);

            } else {
                f = f * Math.pow(z, 30);

            }
            f = f - p;

        }
        if (0 > f || f > 0.005116) {

//.out.print(z);

            methodName(a, r, p + f / m);


        } else {
            p = p * 1000;
            f = Math.round(p);

        }
        return f / 1000;
    }

    public static double SumGet(double a) {
        double f = a / 12;
        return f;
    }
    public String[] list(double value){
        String[] listes = new String[m];
        for (int i=0;i<m;i++){
            listes[i]=String.valueOf(value+value*.01*i);
        }
        return listes;
    }

}
