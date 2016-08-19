package net.qiik.project.myapplication3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        int value = getIntent().getIntExtra(Constants.Extras.VALUE, 0);
        value++;

        Intent intent = new Intent();
        intent.putExtra(Constants.Extras.VALUE, value);
        setResult(RESULT_OK, intent);
        TextView textView = (TextView) findViewById(R.id.textView3);
        textView.setText((String.valueOf(value)));

    }


}
