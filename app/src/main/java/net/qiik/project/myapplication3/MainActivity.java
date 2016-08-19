package net.qiik.project.myapplication3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView) findViewById(R.id.textView);
        textView.setText((String.valueOf(value)));


    }

    public void goNewView(View v) {
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra(Constants.Extras.VALUE, 0);
        // ctrl+alt+c - создание
        startActivityForResult(intent, Constants.RequestCodes.REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.RequestCodes.REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            value = data.getIntExtra(Constants.Extras.VALUE, 0);
            value++;
            TextView textView = (TextView) findViewById(R.id.textView);
            textView.setText((String.valueOf(value)));
        }
    }
}
