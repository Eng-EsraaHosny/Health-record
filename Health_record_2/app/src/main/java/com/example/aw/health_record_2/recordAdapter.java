package com.example.aw.health_record_2;

import android.app.Activity;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

/**
 * Created by User on 9/21/2016.
 */
public class recordAdapter extends ArrayAdapter<record>{

    private Activity activity;
    private welcome w;
    public recordAdapter(Activity activity, int resource, List<record> record) {
        super(activity, resource, record);
        this.activity = activity;

    }

    @Override
    public int getCount() {
        return super.getCount();
    }

    @Override
    public record getItem(int position) {
        return super.getItem(position);
    }

    @Override
    public long getItemId(int position) {
        return super.getItemId(position);
    }

    @Override
    public View getView(final int position, View convertView, ViewGroup parent) {

        ViewHolder holder = null;
        LayoutInflater inflater = (LayoutInflater) activity
                .getSystemService(Activity.LAYOUT_INFLATER_SERVICE);

        if (convertView == null) {
            // inflate UI from XML file
            convertView = inflater.inflate(R.layout.list_view, parent, false);
            // get all UI view
            holder = new ViewHolder(convertView);
            // set tag for holder
            convertView.setTag(holder);
        } else {
            // if holder created, get tag from view
            holder = (ViewHolder) convertView.getTag();
        }



        record currentrecord = getItem(position);

        holder.drname.setText(currentrecord.getDr_name());
        holder.title.setText(currentrecord.getTitle());
        holder.status.setText(currentrecord.getStatus());

        holder.spec.setText(currentrecord.getspecialization());

        holder.cure.setText(currentrecord.getcure());
        holder.dise.setText(currentrecord.getDiseace());

convertView.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
       // Toast.makeText(getContext(), position+"", Toast.LENGTH_SHORT).show();
                String t = getItem(position).getTitle();
                String dr_name = getItem(position).getDr_name();
                String spec =  getItem(position).getspecialization();
                String dis =  getItem(position).getDiseace();
                String status = getItem(position).getStatus();
                String cure = getItem(position).getcure();

                Intent intent = new Intent(getContext(), Edit.class);

                intent.putExtra("x", t);//key = x , t = value
                intent.putExtra("z", dr_name);
                intent.putExtra("m", spec);
                intent.putExtra("n", dis);
                intent.putExtra("o", status);
                intent.putExtra("p", cure);
              getContext().startActivity(intent);
    }
});

       /* holder.button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(getContext(), Edit.class);
                getContext().startActivity(i);
            }
        });*/






        return convertView;
    }

private static class ViewHolder {
    private TextView drname;
    private TextView title;
    private TextView status;
    private TextView spec;
    private TextView cure;
    private TextView dise;
    private Button button;


    public ViewHolder(View v) {
        drname = (TextView) v.findViewById(R.id.DR_name);
        title = (TextView) v.findViewById(R.id.TITLE);
        status = (TextView) v.findViewById(R.id.STATUS);
        spec = (TextView) v.findViewById(R.id.Sepcialization);
        cure = (TextView) v.findViewById(R.id.CURE);
        dise = (TextView) v.findViewById(R.id.DISEASE);
       // button = (Button)v.findViewById(R.id.email);
    }
}

}
