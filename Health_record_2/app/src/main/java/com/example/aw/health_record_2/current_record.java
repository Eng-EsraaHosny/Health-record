package com.example.aw.health_record_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class current_record extends AppCompatActivity {
    EditText title;
    EditText drname;
    EditText specialization;
    EditText disease;
    EditText status;
    EditText cure;
    ArrayList<record> recordd;
    private MySharedPreference sharedPreference;
    private Gson gson;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_current_record);
        title = (EditText) findViewById(R.id.title1);
        drname = (EditText) findViewById(R.id.dr_name);
        specialization = (EditText) findViewById(R.id.specialization);
        disease = (EditText) findViewById(R.id.DISEASE);
        status = (EditText) findViewById(R.id.status1);
        cure = (EditText) findViewById(R.id.CURE);
        sharedPreference = new MySharedPreference(getApplicationContext());
        gson = new Gson();
        getHighScoreListFromSharedPreference();
    }

    private  void savee() {

            String titlee, dr_name, specializationn, diseasee, statuss, curee;
            titlee = title.getText().toString();
            dr_name = drname.getText().toString();

            specializationn = specialization.getText().toString();

            diseasee = disease.getText().toString();

            statuss = status.getText().toString();
            curee = cure.getText().toString();


            record record = new record();
            record.setCure(curee);
            record.setStatus(statuss);
            record.setDiseace(diseasee);
            record.setSpecialization(specializationn);
            record.setDr_name(dr_name);
            record.setTitle(titlee);


            recordd.add(record); //add to scores list
            saveScoreListToSharedpreference(recordd); //save to share pre
            Toast.makeText(current_record.this, "save ", Toast.LENGTH_SHORT).show();

        }


    private void saveScoreListToSharedpreference(ArrayList<record> recordd) {
        //convert ArrayList object to String by Gson
        String jsonScore = gson.toJson(recordd);

        //save to shared preference
        sharedPreference.saveHighScoreList(jsonScore);
    }


    private void getHighScoreListFromSharedPreference() {
        //retrieve data from shared preference
        String jsonScore = sharedPreference.getHighScoreList();
        Type type = new TypeToken<List<record>>(){}.getType();
        recordd = gson.fromJson(jsonScore, type);

        if (recordd == null) {
            recordd = new ArrayList<>();
        }
    }


    public void save(View view) {



        if ((title.getText().toString().isEmpty()) || (drname.getText().toString().isEmpty()) || (specialization.getText().toString().isEmpty()) || (disease.getText().toString().isEmpty()) || (status.getText().toString().isEmpty()) || (cure.getText().toString().isEmpty())) {
            Toast.makeText(current_record.this, "please enter all the data ", Toast.LENGTH_SHORT).show();
        }
        else {

                      savee();
            Intent i =new Intent(current_record.this,welcome.class);
            startActivity(i);

        }
    }

}

