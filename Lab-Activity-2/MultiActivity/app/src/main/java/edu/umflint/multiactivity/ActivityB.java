package edu.umflint.multiactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ActivityB extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        Button BtoA = (Button) findViewById(R.id.BtoA);
        Button BtoC = (Button) findViewById(R.id.BtoC);
        TextView activityBTextView = (TextView) findViewById(R.id.activityBTextView);

        if(getIntent().getStringExtra("Note") == null ||getIntent().getStringExtra("Note").equals(""))
        {
            activityBTextView.setText("No Parent");
        } else {
            activityBTextView.setText(getIntent().getStringExtra("Note"));
        }

        BtoA.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityB.this, ActivityA.class);
                intent.putExtra("Note", "Opened By ActivityB");
                startActivity(intent);
            }
        });

        BtoC.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActivityB.this, ActivityC.class);
                intent.putExtra("Note", "Opened By ActivityB");
                startActivity(intent);
            }
        });
    }
}
