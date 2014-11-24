package com.example.rbates.functionalandroid;

import android.test.AndroidTestCase;

import fj.data.List;

public class TestContributorCount extends AndroidTestCase {
    public void testFunctional(){
        Functional functional = new Functional();
        List<ContributorCount> contributors = functional.getContributorCounts();
        assertEquals(3, contributors.length());
    }

    public void testImperative(){
        Imperative imperative = new Imperative();
        java.util.List<ContributorCount> contributors = imperative.getContributorCounts();
        assertEquals(3, contributors.size());
    }
}
