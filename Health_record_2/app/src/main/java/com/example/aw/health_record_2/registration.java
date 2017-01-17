package com.example.aw.health_record_2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class registration extends AppCompatActivity {
    EditText name ;
    EditText age;
    EditText id ;
    EditText pass;
    EditText confirm;
    EditText number ;
    EditText email ;
    SharedPreferences.Editor editor;
    SharedPreferences preferences;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);

        name=(EditText) findViewById(R.id.name);
        age=(EditText)findViewById(R.id.age);
        id=(EditText) findViewById(R.id.national);
        pass=(EditText) findViewById(R.id.pass);
        confirm=(EditText) findViewById(R.id.confirm);
        number= (EditText) findViewById(R.id.number);
        email=(EditText) findViewById(R.id.email);

         preferences = getSharedPreferences("Information", MODE_PRIVATE);


       editor = preferences.edit();

    }



    public void save(View view)
    {


        String newUser  = name.getText().toString();
        String newPassword = age.getText().toString();
        String idd = id.getText().toString();
        String pas  = pass.getText().toString();
        String confirmm = confirm.getText().toString();
        String numberr = number.getText().toString();
        String emaill = email.getText().toString();
        editor.putString("newUser", newUser);
        editor.commit();
        editor.putString("newPassword", newPassword);
        editor.commit();
        editor.putString("idd", idd);
        editor.commit();
        editor.putString("pas", pas);
        editor.commit();
        editor.putString("confirmm", confirmm);
        editor.commit();
        editor.putString("numberr", numberr);
        editor.commit();
        editor.putString("emaill", emaill);
        editor.commit();


        if((id.getText().toString().isEmpty())||(pass.getText().toString().isEmpty())||(confirm.getText().toString().isEmpty())||(number.getText().toString().isEmpty())||(email.getText().toString().isEmpty()))
        {
            Toast.makeText(registration.this, "all of the fields are required ", Toast.LENGTH_SHORT).show();
        }

        if(validateEmail(emaill)==true) {


            if ((pass.getText().toString().equals(confirm.getText().toString()))) {


                  Intent i = new Intent(this, login.class);
                startActivity(i);


            } else {
                Toast.makeText(registration.this, "the password doesn't match ", Toast.LENGTH_SHORT).show();
            }
        }
        else Toast.makeText(registration.this, "the email format is wrong ", Toast.LENGTH_SHORT).show();


    }

    public boolean validateEmail(String email) {
        String emailPattern = "^(([\\w-]+\\.)+[\\w-]+|([a-zA-Z]{1}|[\\w-]{2,}))@"
                + "((([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\."
                + "([0-1]?[0-9]{1,2}|25[0-5]|2[0-4][0-9])\\.([0-1]?"
                + "[0-9]{1,2}|25[0-5]|2[0-4][0-9])){1}|"
                + "([a-zA-Z]+[\\w-]+\\.)+[a-zA-Z]{2,4})$";


        Pattern pattern = Pattern.compile(emailPattern);
        Matcher matcher = pattern.matcher(email);


        return matcher.matches();
    }

    public boolean checked() {
        int check = 0;
        if (name.getText().toString().trim().length() == 0) {
           name.setError("the name is wrong");
            name.requestFocus();
            check++;


        }
        if (age.getText().toString().trim().length() == 0) {
            age.setError("the age is wrong");
            age.requestFocus();

            check++;


        }

        if (pass.getText().toString().trim().length() == 0) {
            pass.setError("the pass is wrong");
            pass.requestFocus();

            check++;


        }
       /* if (confirm.getText().toString().trim().length() == 0 || confirm.getText().toString().equals(pass.getText().toString()) == false) {
            confirm.setError("this confirm pass is wrong");
            confirm.requestFocus();
            check++;
          }*/
        if (number.getText().toString().trim().length() == 0) {
            number.setError("the telephone is wrong");
           number.requestFocus();

            check++;

        }
        if (email.getText().toString().trim().length() == 0) {
            email.setError("the email;  is wrong");
            email.requestFocus();
            check++;

        }
        if (check > 0) {
            return false;
        } else
            return true;
    }
}
