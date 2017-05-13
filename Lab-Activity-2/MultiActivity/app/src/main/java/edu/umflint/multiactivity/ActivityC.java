package edu.umflint.multiactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityC extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);

        Button CtoA = (Button) findViewById(R.id.CtoA);
        Button CtoB = (Button) findViewById(R.id.CtoB);
        TextView activityCTextView = (TextView) findViewById(R.id.activityCTextView);

        if(getIntent().getStringExtra("Note") == null ||getIntent().getStringExtra("Note").equals(""))
        {
            activityCTextView.setText("No Parent");
        } else {
            activityCTextView.setText(getIntent().getStringExtra("Note"));
        }

        CtoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityC.this, ActivityA.class);
                intent.putExtra("Note", "Opened By ActivityC");
                startActivity(intent);
            }
        });

        CtoB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityC.this, ActivityB.class);
                intent.putExtra("Note", "Opened By ActivityC");
                startActivity(intent);
            }
        });

    }
}
