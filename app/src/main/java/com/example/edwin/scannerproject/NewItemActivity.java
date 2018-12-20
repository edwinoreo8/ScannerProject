package com.example.edwin.scannerproject;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

//import de.t_dankworth.secscanqr.R;

public class NewItemActivity extends AppCompatActivity {


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.newitem_main);
    }

    public void onClick(View v) {
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

    public void onClick2(View v) {
        // make a new Item Object
        // containing item number and name
        // add to database so when checking out name is auto inputted for use in the outgoing information sheet
    }

}
