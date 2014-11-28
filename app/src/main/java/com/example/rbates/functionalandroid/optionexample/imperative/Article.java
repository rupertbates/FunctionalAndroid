package com.example.rbates.functionalandroid.optionexample.imperative;

public class Article {

    Contributor contributor;


    DisplayImage mainImage;


    //Rest of the class declaration

    public DisplayImage getMainImage(){
        //What happens if there is no main image on this article?
        return mainImage;
    }

    public Contributor getContributor() {
        return contributor;
    }

    public void setContributor(Contributor contributor) {
        this.contributor = contributor;
    }






}
