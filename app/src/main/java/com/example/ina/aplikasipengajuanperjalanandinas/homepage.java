package com.example.ina.aplikasipengajuanperjalanandinas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by INA on 3/12/2017.
 */

public class homepage extends AppCompatActivity {
    Button b1;
    Intent i;
    String get_user;
    TextView tUser;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.homepage);

        b1 = (Button) findViewById(R.id.logout3);
        tUser = (TextView) findViewById(R.id.textview1);
        Bundle b = getIntent().getExtras();
        get_user = b.getString("name");
        tUser.setText("Welcome," + get_user);
    }

    public void action(View v) {
        switch (v.getId()) {
            case R.id.logout3: {
                i = new Intent(this, MainActivity.class);
                i.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(i);

            }
        }
    }
}