package com.example.rbates.functionalandroid.optionexample.functional;

import com.example.rbates.functionalandroid.optionexample.imperative.DisplayImage;

import fj.data.Option;

public class Article {
    private Option<DisplayImage> mainImage;
    private Option<Contributor> contributor;

    public Option<DisplayImage> getMainImage() {
        return mainImage;
    }

    public Option<Contributor> getContributor() {
        return contributor;
    }
}
