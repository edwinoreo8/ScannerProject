package com.example.edwin.scannerproject;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

//import com.example.edwin.scannerproject.R;

public class OurMainActivity extends AppCompatActivity {


    String test = null;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.ouractivity_main);
        //setContentView(R.layout.newitem_main);


//        if(test != null) {
//            // Gets the Intent that started this activity
//            Intent intent = getIntent();
//            String ret = intent.getStringExtra("BARCODE");
//            Log.d("DEBUG", "***********" + ret);
//            TextView code = (TextView) findViewById(R.id.textView2);
//            code.setText(ret);
//        }
//        test = new String();

        //final android.content.ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        // ClipData clipData = clipboardManager.getPrimaryClip();


        // String ret = clipData.getItemAt(0).getText().toString();
        // TextView code = (TextView) findViewById(R.id.textView2);
        // code.setText(ret);





    }

    public void onClick(View v) {
        Intent intent = new Intent(this, NewCheckOutActivity.class);
        startActivity(intent);

    }

    public void onClick2(View v) {
        Intent intent2 = new Intent(this, NewItemActivity.class);
        startActivity(intent2);
    }




}
