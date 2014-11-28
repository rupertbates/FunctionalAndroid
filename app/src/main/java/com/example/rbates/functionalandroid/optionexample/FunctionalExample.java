package com.example.rbates.functionalandroid.optionexample;

import com.example.rbates.functionalandroid.optionexample.functional.Article;
import com.example.rbates.functionalandroid.optionexample.functional.Contributor;
import com.example.rbates.functionalandroid.optionexample.imperative.DisplayImage;

public class FunctionalExample extends BaseExample {

    private void articleOption(){

        Article article = new Article();

        article.getMainImage().map(this::setArticleImage);


        article.getContributor()
                .bind(Contributor::getImage)
                .map(DisplayImage::getSize)
                .map(s -> setContributorImageSize(s.getWidth(), s.getHeight()));

    }

}
