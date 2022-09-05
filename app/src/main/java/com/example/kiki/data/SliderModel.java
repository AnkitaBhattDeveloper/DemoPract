package com.example.kiki.data;

import com.google.android.material.slider.Slider;

public class SliderModel {

    String sliderImageUrl;
     public SliderModel(String sliderImageUrl)
     {
         this.sliderImageUrl = sliderImageUrl;
     }

    public String getsliderImageUrl() {
        return sliderImageUrl;
    }

    public void setsliderImageUrl(String sliderImageUrl) {
        this.sliderImageUrl = sliderImageUrl;
    }
}
