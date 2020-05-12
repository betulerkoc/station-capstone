package com.example.stationproject;

import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActvity extends AppCompatActivity {

    SQLiteOpenHelper openHelper;
    SQLiteDatabase db;
    Button registerButton, goLoginButton;
    EditText userName, userSurname, useremail, userPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.register_page);
        openHelper = new SQLiteHelper(this);


        registerButton = findViewById(R.id.registerButton);
        goLoginButton = findViewById(R.id.goLoginButton);

        userName = findViewById(R.id.userName);
        userSurname = findViewById(R.id.userSurname);
        userPassword = findViewById(R.id.userPassword);
        useremail = findViewById(R.id.userEmail);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                db = openHelper.getWritableDatabase();
                String username = userName.getText().toString();
                String usersurname = userSurname.getText().toString();
                String password = userPassword.getText().toString();
                String email = useremail.getText().toString();
                SQLiteHelper.insertUser(db, username, usersurname, password, email);
                Toast.makeText(getApplicationContext(), "yess", Toast.LENGTH_LONG).show();
            }
        });
    }
}