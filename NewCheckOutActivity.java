package com.example.edwin.scannerproject;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

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

    //code to connect button to scanner app (copied strait from other class might need modifications)
    public void onClick(View v){
        Intent intent = new Intent(this, MainActivity.class);

        //https://stackoverflow.com/questions/8952420/wait-for-intent-to-finish-before-continuing-with-the-activities
        startActivityForResult( new Intent(this, MainActivity.class), 0);
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

        final android.content.ClipboardManager clipboardManager = (ClipboardManager)getSystemService(CLIPBOARD_SERVICE);
        ClipData clipData = clipboardManager.getPrimaryClip();
        String ret = clipData.getItemAt(0).getText().toString();
        EditText itemNum = (EditText) findViewById(R.id.editText);
        //https://developer.android.com/reference/android/widget/TextView.BufferType
        itemNum.setText(ret);

    }


}
