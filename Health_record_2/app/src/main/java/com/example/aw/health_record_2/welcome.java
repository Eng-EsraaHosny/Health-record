package com.example.aw.health_record_2;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;


public class welcome extends AppCompatActivity {
    private MySharedPreference sharedPreference;
    private Gson gson;
    public ArrayList<record> record;
    ListView listView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        listView = (ListView)findViewById(R.id.list);

        sharedPreference = new MySharedPreference(getApplicationContext());
        gson = new Gson();
        getHighScoreListFromSharedPreference();
        adapter();

        /// error of declaration of list view



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

    private void adapter() {



                if (record.size() == 0) {
                    Toast.makeText(welcome.this, "No data in sharedPreferences", Toast.LENGTH_SHORT).show();
                } else {
                    getHighScoreListFromSharedPreference(); //get data
                    //set adapter for listview and visible it
                    recordAdapter adapter = new recordAdapter(welcome.this, R.layout.list_view, record);
                    listView.setAdapter(adapter);



                }


    }

    public void transfer_data()
    {
//        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
//            @Override
//            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
//                String t = record.get(position).getTitle();
//                String dr_name =record.get(position).getDr_name();
//                String spec = record.get(position).getspecialization();
//                String dis = record.get(position).getDiseace();
//                String status =record.get(position).getStatus();
//                String cure =record.get(position).getcure();
//
//                Intent intent = new Intent(welcome.this, Edit.class);
//
//                intent.putExtra("x", t);//key = x , t = value
//                intent.putExtra("z", dr_name);
//                intent.putExtra("m", spec);
//                intent.putExtra("n", dis);
//                intent.putExtra("o", status);
//                intent.putExtra("p", cure);
//                startActivity(intent);
//            }
//
//        });
    }

    public void new_record (View view)
    {
        Intent i =new Intent(this,current_record.class);
        startActivity(i);
    }

}
