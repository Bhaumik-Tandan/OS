package com.example.os;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class gv extends AppCompatActivity {
    public static final String e1="ed",e2="ew",e3="ty";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gv);
    }
    public void su(View v)
    {
        EditText y= findViewById(R.id.t1);
        String a1 = y.getText().toString();
        EditText z= findViewById(R.id.t3);
        String a2 = z.getText().toString();
        EditText x= findViewById(R.id.t2);
        String a3 = x.getText().toString();
        Intent i=new Intent(this,bank.class);
        i.putExtra(e1, a1);
        i.putExtra(e2, a2);
        i.putExtra(e3, a3);
        startActivity(i);
    }
}