package com.example.stationproject;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button loginButton, goRegisterButton;
    EditText useremail, userPassword;
    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_page);

        openHelper = new SQLiteHelper(this);
        db = openHelper.getReadableDatabase();

        loginButton = findViewById(R.id.loginButton);
        goRegisterButton = findViewById(R.id.goRegisterButton);
        useremail = findViewById(R.id.userEmail);
        userPassword = findViewById(R.id.userPassword);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String email = useremail.getText().toString();
                String password = userPassword.getText().toString();

                cursor = db.rawQuery("SELECT * FROM USER WHERE Email=? AND Password=?", new String[]{email, password});
                if(cursor!=null) {
                    if(cursor.getCount()>0) {
                        cursor.moveToNext();
                        Toast.makeText(getApplicationContext(), "login successfully", Toast.LENGTH_LONG).show();
                    }
                    else {
                        Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });



    }

}
