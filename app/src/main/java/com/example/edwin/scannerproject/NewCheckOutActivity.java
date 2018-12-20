package com.example.edwin.scannerproject;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.HashMap;

//import de.t_dankworth.secscanqr.R;

public class NewCheckOutActivity extends AppCompatActivity {

    ArrayList<HashMap<String, String>> receipt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_main);


        receipt = new ArrayList<HashMap<String, String>>();

        HashMap<String, String> location = new HashMap<>();


    }




}
