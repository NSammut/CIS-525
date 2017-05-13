package edu.umflint.multiactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class ActivityA extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_activity);

        Button AtoB = (Button) findViewById(R.id.AtoB);
        Button AtoC = (Button) findViewById(R.id.AtoC);
        TextView activityATextView = (TextView) findViewById(R.id.activityATextView);

        if(getIntent().getStringExtra("Note") == null ||getIntent().getStringExtra("Note").equals(""))
        {
            activityATextView.setText("No Parent");
        } else {
            activityATextView.setText(getIntent().getStringExtra("Note"));
        }

        AtoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityA.this, ActivityB.class);
                intent.putExtra("Note", "Opened By ActivityA");
                startActivity(intent);
            }
        });

        AtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityA.this, ActivityC.class);
                intent.putExtra("Note", "Opened By ActivityA");
                startActivity(intent);
            }
        });
    }
}
