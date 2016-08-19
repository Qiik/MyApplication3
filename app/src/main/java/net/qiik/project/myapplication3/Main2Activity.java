package net.qiik.project.myapplication3;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    private int value;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        value = getIntent().getIntExtra(Constants.Extras.VALUE, 0);
        value++;

        Intent intent = new Intent();
        intent.putExtra(Constants.Extras.VALUE, value);
        setResult(RESULT_OK, intent);
        TextView textView = (TextView) findViewById(R.id.textView2);
        textView.setText((String.valueOf(value)));
    }

    public void goNewView(View v) {
        Intent intent = new Intent(this, Main3Activity.class);
        intent.putExtra(Constants.Extras.VALUE, 1);
        startActivityForResult(intent, Constants.RequestCodes.REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constants.RequestCodes.REQUEST_CODE && resultCode == Activity.RESULT_OK) {
            value = data.getIntExtra(Constants.Extras.VALUE, 0);
            value++;
            Intent intent = new Intent();
            intent.putExtra(Constants.Extras.VALUE, value);
            setResult(RESULT_OK, intent);
            TextView textView = (TextView) findViewById(R.id.textView2);
            textView.setText((String.valueOf(value)));
        }
    }
}
