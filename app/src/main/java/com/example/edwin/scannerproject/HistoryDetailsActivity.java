package com.example.edwin.scannerproject;

import android.app.Activity;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.example.edwin.scannerproject.R;

import static com.example.edwin.scannerproject.ButtonHandler.copyToClipboard;
import static com.example.edwin.scannerproject.ButtonHandler.openInWeb;
import static com.example.edwin.scannerproject.ButtonHandler.openInWeb;

/**
 * Created by Thore Dankworth
 * Last Update: 17.03.2018
 * Last Update by Thore Dankworth
 *
 * This class is the HistoryDetailsActivity shows details and further functionality for the chosen item
 */

public class HistoryDetailsActivity extends AppCompatActivity {

    private static final String TAG = "EditDataActivity";

    private TextView tvCode;
    private BottomNavigationView action_navigation;

    DataBaseHelper historyDatabaseHelper;
    final Activity activity = this;

    private String selectedCode;
    private int selectedID;

    /**
     * This method handles the main navigation
     */
    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.history_action_navigation_delete:
                    historyDatabaseHelper.deleteItem(selectedID);
                    Toast.makeText(activity, activity.getResources().getText(R.string.notice_deleted_from_database), Toast.LENGTH_LONG).show();
                    activity.finish();
                    return true;
                //Following cases using a method from ButtonHandler
                case R.id.history_action_navigation_copy:
                    copyToClipboard(tvCode, selectedCode, activity);
                    return true;
                case R.id.main_action_navigation_openInWeb:
                    openInWeb(selectedCode, activity);
                    return true;

            }
            return false;
        }

    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_history_details);
        tvCode = (TextView) findViewById(R.id.tvCodeHD);
        action_navigation = (BottomNavigationView) findViewById(R.id.history_action_navigation);
        BottomNavigationHelper.disableShiftMode(action_navigation);
        action_navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
        historyDatabaseHelper = new DataBaseHelper(this);

        //Get the extra information from the history listview. and set the text in the textview eqaul to code
        Intent receivedIntent = getIntent();
        selectedID = receivedIntent.getIntExtra("id", -1); //-1 is the default value
        selectedCode = receivedIntent.getStringExtra("code");
        tvCode.setText(selectedCode);

    }
}
