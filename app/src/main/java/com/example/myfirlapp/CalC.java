package com.example.myfirlapp;

import java.util.Calendar;
import java.util.Date;

/**
 * Created by Руслан on 02.02.2016.
 */
public class CalC {
    static double f = 0;
    static int m = 0;

    public static void main(String[] args) {

    }

    public static double methodName(double a, double r, double p) {
        // body
        double z = 1 + r / 365;
        f = a;


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

    public void zap(Date st, Date ed) {
        Calendar calst = Calendar.getInstance();
        Calendar caled = Calendar.getInstance();
        calst.setTime(st);
        caled.setTime(ed);
        int days = (ed.getYear() - st.getYear()) * 360 + (calst.get(Calendar.MONTH) - calst.get(Calendar.MONTH)) * 30
                + Math.min(calst.get(Calendar.DAY_OF_MONTH), 30) - Math.min(caled.get(Calendar.DAY_OF_MONTH), 30);

        this.m = days / 30;


    }

    public String[] list(double value) {
        String[] listam = new String[m];
        for (int i = 0; i < m; i++) {
            listam[i] = String.valueOf(value + value * .01 * i);
        }
        listam[m - 1] = String.valueOf(m);
        return listam;
    }

}
