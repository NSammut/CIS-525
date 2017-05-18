package edu.umflint.extracredit;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    private int cd = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button startButton = (Button) findViewById(R.id.startButton);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                EditText input = (EditText) findViewById(R.id.numberInput);
                TextView countdown = (TextView) findViewById(R.id.countdown);
                try {
                    if (Integer.parseInt(input.getText().toString()) < 1) {
                        Toast.makeText(getApplicationContext(), R.string.ERROR, Toast.LENGTH_LONG).show();
                    } else {
                        cd = Integer.parseInt(input.getText().toString());
                        countdown.setText(input.getText().toString());
                        new CountDown().execute();
                    }
                } catch (Exception ex) {
                    ex.printStackTrace();
                    Toast.makeText(getApplicationContext(), R.string.ERROR, Toast.LENGTH_LONG).show();
                }
            }
        });
    }

    public class CountDown extends AsyncTask<Void, Integer, Void> {
        @Override
        protected void onPostExecute(Void aVoid) {
            Toast.makeText(getApplicationContext(), R.string.COMPLETE, Toast.LENGTH_LONG).show();
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            TextView countdown = (TextView) findViewById(R.id.countdown);
            countdown.setText(values[0].toString());
        }

        @Override
        protected Void doInBackground(Void... params) {
            while (cd > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                cd -= 1;
                publishProgress(cd);
            }
            return null;
        }
    }
}