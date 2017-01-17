package com.example.aw.health_record_2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class login extends AppCompatActivity {
    EditText name;
    EditText pass;
    SharedPreferences preferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        preferences = getSharedPreferences("Information", MODE_PRIVATE);

    }

    public void register(View view) {
        Intent i = new Intent(this, registration.class);
        startActivity(i);
    }

    public void login(View view) {


        name = (EditText) findViewById(R.id.name);
        pass = (EditText) findViewById(R.id.pass);
        if (name.getText().toString().isEmpty() || pass.getText().toString().isEmpty()) {
            Toast.makeText(login.this, "all of the fields are required ", Toast.LENGTH_SHORT).show();

        } else {

            String savedPassword = preferences.getString("newPassword", "");
            String savedUserName = preferences.getString("newUser", "");
            if (name.getText().toString().equals(savedUserName) && pass.getText().toString().equals(savedPassword)) {

                Toast.makeText(login.this, "welcome", Toast.LENGTH_SHORT).show();
                Intent i = new Intent(this, welcome.class);
                startActivity(i);

            }
            else
                Toast.makeText(login.this, "wrong", Toast.LENGTH_SHORT).show();

        }

    }
}
