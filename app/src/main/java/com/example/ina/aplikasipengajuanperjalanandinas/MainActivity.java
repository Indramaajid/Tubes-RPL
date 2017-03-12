package com.example.ina.aplikasipengajuanperjalanandinas;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.database.Cursor;

public class MainActivity extends AppCompatActivity {
    Intent i = null;
    Button b1;
    EditText ed1, ed2;
    TextView tx1;
    int counter = 3;
    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b1 = (Button) findViewById(R.id.login1);
        ed1 = (EditText) findViewById(R.id.username1);
        ed2 = (EditText) findViewById(R.id.password1);
        tx1 = (TextView) findViewById(R.id.counter);
        tx1.setVisibility(View.GONE);
        db = openOrCreateDatabase("mydb", MODE_PRIVATE, null);
    }

    public void action(View v) {
        switch (v.getId()) {
            case R.id.login1:
                String id1 = ed1.getText().toString();
                String pass1 = ed2.getText().toString();
                if (id1 == null || id1 == "" || id1.length() < 10) {
                    Toast toast = Toast.makeText(getApplicationContext(), "periksa id anda", Toast.LENGTH_LONG);
                    toast.show();
                } else if (pass1 == null || pass1 == "" || pass1.length() < 8) {
                    Toast toast = Toast.makeText(getApplicationContext(), "periksa password anda", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    Cursor c = db.rawQuery("select * from login where id='" + id1 + "' and pass='" + pass1 + "'", null);
                    c.moveToFirst();
                    if (c.getCount() > 0) {
                        i = new Intent(this, homepage.class);
                        startActivityForResult(i, 500);
                        db.close();
                        finish();
                    } else {
                        Toast toast1 = Toast.makeText(getApplicationContext(), "periksa password anda", Toast.LENGTH_LONG);
                        toast1.show();
                    }

                }
                break;
            case R.id.signup1:
                i = new Intent(this, signuppage.class);
                startActivityForResult(i, 500);
                finish();
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }


}
