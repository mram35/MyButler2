package com.example.mybutler;

import java.io.Serializable;

public class Mood implements Serializable {

    public String moodName;
    public String moodUrl;



    public Mood(String moodName, String moodUrl)
    {
        this.moodName = moodName;
        this.moodUrl = moodUrl;
    }



    public String getMoodName(){
        return moodName;
    }

    public String getMoodUrl() {
        return moodUrl;
    }


    public void setMoodName(String moodName) {
        this.moodName = moodName;
    }

    public void setMoodUrl(String moodUrl) {
        this.moodUrl = moodUrl;
    }
}
