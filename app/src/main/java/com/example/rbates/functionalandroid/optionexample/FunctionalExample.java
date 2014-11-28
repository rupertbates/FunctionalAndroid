package com.example.rbates.functionalandroid.optionexample;

import com.example.rbates.functionalandroid.optionexample.functional.Article;
import com.example.rbates.functionalandroid.optionexample.functional.Contributor;
import com.example.rbates.functionalandroid.optionexample.imperative.DisplayImage;

import fj.data.Option;

public class FunctionalExample extends BaseExample {

    private void articleOption(){

        Article article = new Article();

        //More imperative style of dealing with an Option type
        if(article.getMainImage().isSome())
            setArticleImage(article.getMainImage().some());

        //Functional approach to dealing with an Option
        article.getMainImage().map(this::setArticleImage);


        //Chaining multiple optional values
        article.getContributor()
                .bind(Contributor::getImage)
                .map(DisplayImage::getSize)
                .map(size -> setContributorImageSize(size.getWidth(), size.getHeight()));

    }

}
