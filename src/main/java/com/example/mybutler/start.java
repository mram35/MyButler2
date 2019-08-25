package com.example.mybutler;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class start extends AppCompatActivity {

    Context context = this;
    RecyclerView mView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);


        TextView textView = (TextView) findViewById(R.id.lbl_name);

        String name = getIntent().getExtras().getString("name");
        ArrayList<Mood> moodArrayList = (ArrayList<Mood>) getIntent().getSerializableExtra("moodList");

        textView.setText("Hi "+ name);

        mView = findViewById(R.id.recyclerview);
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(context, 2);
        mView.setLayoutManager(mGridLayoutManager);

        Log.w("step2" , String.valueOf(moodArrayList));


        MyAdapter myAdapter = new MyAdapter(context, moodArrayList);

        mView.setAdapter(myAdapter);


    }
}
