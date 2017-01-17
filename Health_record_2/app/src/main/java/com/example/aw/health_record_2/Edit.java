package com.example.aw.health_record_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

public class Edit extends AppCompatActivity {
    TextView title;
    TextView drname;
    TextView specialization;
    TextView disease;
    TextView status;
    TextView cure;
    Button edit;
    private MySharedPreference sharedPreference;
    private Gson gson;
    private ArrayList<record> record;
    String x,z,m,n,o,p;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit);
        sharedPreference = new MySharedPreference(getApplicationContext());
        gson = new Gson();

        title = (TextView)findViewById(R.id.ed_title1);
        drname = (TextView)findViewById(R.id.ed_dr_name);
        specialization = (TextView) findViewById(R.id.ed_specialization);
        disease = (TextView) findViewById(R.id.ed_DISEASE);
        status = (TextView) findViewById(R.id.ed_status1);
        cure = (TextView) findViewById(R.id.ed_CURE);
        edit = (Button)findViewById(R.id.ed_edit);
        getHighScoreListFromSharedPreference();

       Bundle bundle = getIntent().getExtras();
         x = bundle.getString("x");
        title.setText(x);
         z = bundle.getString("z");
        title.setText(z);
         m = bundle.getString("m");
        title.setText(m);
         n = bundle.getString("n");
        title.setText(n);
         o = bundle.getString("o");
        title.setText(o);
         p = bundle.getString("p");
        title.setText(p);

    }


    public void edit(View view)
    {
        Intent intent = new Intent(Edit.this,current_record.class);

        startActivity(intent);
    }
    private void getHighScoreListFromSharedPreference() {
        //retrieve data from shared preference
        String jsonScore = sharedPreference.getHighScoreList();
        Type type = new TypeToken<List<record>>(){}.getType();
        record = gson.fromJson(jsonScore, type);

        if (record == null) {
            record = new ArrayList<>();
        }
    }

}
