package com.example.lenovo.myapplication;

/**
 * Created by lenovo on 22-04-2018.
 */
import java.util.Random;

public class RandomN {

    public RandomN(){}


        public int Generate()
        {
            int t;
            String n;
            Random r = new Random();
            t = r.nextInt(9999);
            if(t < 10)
            {
                n = "000" + Integer.toString(t);
                t = Integer.parseInt(n);
            }
            else if(t < 100)
            {
                n = "00" + Integer.toString(t);
                t = Integer.parseInt(n);             }
            else if(t < 1000)
            {
                n = "0" + Integer.toString(t);
                t = Integer.parseInt(n);
            }
            return t;
        }

}
