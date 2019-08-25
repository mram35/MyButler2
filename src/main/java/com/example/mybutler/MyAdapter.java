package com.example.mybutler;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter <MoodViewHolder>{


    private Context context;
    private List<Mood> moodList;


    MyAdapter(Context context, List<Mood> moodList){
        this.context = context;
        this.moodList = moodList;
    }

    @NonNull
    @Override
    public MoodViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        Log.w("step2" , String.valueOf(moodList));

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_card, parent, false);

        return new MoodViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MoodViewHolder holder, int position) {



        Glide.with(context)
                .load(moodList.get(position).getMoodUrl())
                .into(holder.imageView);

        Log.w("step22" , moodList.get(position).getMoodName());

        holder.textView.setText(moodList.get(position).getMoodName());



    }

    @Override
    public int getItemCount() {
        return moodList.size();
    }
}


class MoodViewHolder extends RecyclerView.ViewHolder {

    TextView textView;
    CardView cardView;
    ImageView imageView;

    MoodViewHolder(View itemView) {
        super(itemView);

        imageView = itemView.findViewById(R.id.imageView);
        textView = itemView.findViewById(R.id.textView);
        cardView = itemView.findViewById(R.id.cardview);
    }

}