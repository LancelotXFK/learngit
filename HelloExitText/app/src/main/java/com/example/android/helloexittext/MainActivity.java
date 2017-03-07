package com.example.android.helloexittext;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private static final String TAG = "MainActivity";
    int edges=0;
    public void drawMap(View view) {
        EditText etOne = (EditText) findViewById(R.id.edit_text);
        CustomClass drawTwo = (CustomClass) findViewById(R.id.myView);
        Log.i(TAG, "drawMap: ");

        String str1 = etOne.getText().toString();
        edges = Integer.parseInt(str1);
        drawTwo.setMap(edges);
        //drawTwo.postInvalidate();
    }
    }


