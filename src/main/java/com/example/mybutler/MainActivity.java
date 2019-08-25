package com.example.mybutler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class MainActivity extends AppCompatActivity {

    Context context = this;
    ArrayList<Mood> moodList = new ArrayList<Mood>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.start);



        EditText editText = findViewById(R.id.editText);
        Button button = findViewById(R.id.button);

        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("moods");




        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {


                for(DataSnapshot datas: dataSnapshot.getChildren()){

                    Map<String, Object> map = (HashMap<String, Object>) datas.getValue();



                    for (String key : map.keySet()) {

                        Mood nMood = new Mood(String.valueOf(key), String.valueOf(map.get(key)));
                        moodList.add(nMood);

                    }


                }

            }

            @Override
            public void onCancelled(DatabaseError error) {
                // Failed to read value
                Log.w("rr", "Failed to read value.", error.toException());
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String name = editText.getText().toString();
                Intent intent = new Intent(context,start.class);
                intent.putExtra("name", name);
                intent.putExtra("moodList", (Serializable) moodList);
                context.startActivity(intent);

            }
        });





    }
}
