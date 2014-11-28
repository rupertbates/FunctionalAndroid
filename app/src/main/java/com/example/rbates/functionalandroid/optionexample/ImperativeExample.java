package com.example.rbates.functionalandroid.optionexample;

import com.example.rbates.functionalandroid.optionexample.imperative.Article;

public class ImperativeExample extends BaseExample {

    private void articleNull() {
        Article article = new Article();

        if (article.getMainImage() != null) {
            setArticleImage(article.getMainImage());
        }

        if (article.getContributor() != null &&
                article.getContributor().getImage() != null &&
                article.getContributor().getImage().getSize() != null) {

            Size size = article.getContributor().getImage().getSize();
            setContributorImageSize(size.getWidth(), size.getHeight());
        }

    }

}
