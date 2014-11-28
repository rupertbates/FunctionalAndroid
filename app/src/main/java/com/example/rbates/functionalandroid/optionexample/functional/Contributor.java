package com.example.rbates.functionalandroid.optionexample.functional;

import com.example.rbates.functionalandroid.optionexample.imperative.DisplayImage;

import fj.data.Option;

public class Contributor {
    private Option<DisplayImage> image;

    public Option<DisplayImage> getImage() {
        return image;
    }

    public void setImage(Option<DisplayImage> image) {
        this.image = image;
    }
}
