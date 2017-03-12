package com.example.ina.aplikasipengajuanperjalanandinas;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

/**
 * Created by INA on 3/12/2017.
 */

public class signuppage extends AppCompatActivity {
    Intent i = null;
    EditText ed1, ed2;
    SQLiteDatabase db = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.signuppage);
        ed1 = (EditText) findViewById(R.id.id2);
        ed2 = (EditText) findViewById(R.id.password2);
        db = openOrCreateDatabase("mydb", MODE_PRIVATE, null);
        db.execSQL("create table if not exists login(id varchar, pass varchar)");
    }

    public void action(View v) {
        switch (v.getId()) {
            case R.id.signup2:
                String id2 = ed1.getText().toString();
                String pass2 = ed2.getText().toString();
                if (id2 == null || id2 == "" || id2.length() < 10) {
                    Toast toast = Toast.makeText(getApplicationContext(), "check id anda", Toast.LENGTH_LONG);
                    toast.show();
                } else if (pass2 == null || pass2 == "" || pass2.length() < 8) {
                    Toast toast = Toast.makeText(getApplicationContext(), "check password anda", Toast.LENGTH_LONG);
                    toast.show();
                } else {
                    db.execSQL("insert into login values('" + id2 + "','" + pass2 + "')");
                    Toast toast = Toast.makeText(getApplicationContext(), "id telah didaftarkan", Toast.LENGTH_LONG);
                    toast.show();
                    finish();
                    i = new Intent(this, MainActivity.class);
                    startActivity(i);
                }
                break;
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    }
}
