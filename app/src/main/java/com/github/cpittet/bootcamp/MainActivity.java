package com.github.cpittet.bootcamp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    public static final String EXTRA_MESSAGE = "com.github.cpittet.bootcamp.MESSAGE";

    private EditText mainName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mainName = (EditText) findViewById(R.id.mainName);
    }

    public void launchGreetings(View view) {
        String name = mainName.getText().toString();

        Intent intent = new Intent(this, GreetingActivity.class);
        intent.putExtra(EXTRA_MESSAGE, name);
        startActivity(intent);
    }
}