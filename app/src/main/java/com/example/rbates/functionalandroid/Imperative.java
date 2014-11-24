package com.example.rbates.functionalandroid;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Imperative extends Base {

    public List<ContributorCount> getContributorCounts() {
        HashMap<String, Integer> contributorCounts = new HashMap<String, Integer>();
        for (String contributor : contributors) {
            Integer count = contributorCounts.get(contributor);
            if (count == null)
                contributorCounts.put(contributor, 1);
            else
                contributorCounts.put(contributor, count + 1);
        }

        List<ContributorCount> result = new ArrayList<ContributorCount>();
        for (String contributor : contributorCounts.keySet()) {
            int count = contributorCounts.get(contributor);
            if (count > 1)
                result.add(new ContributorCount(contributor, contributorCounts.get(contributor)));
        }

        return result;
    }
}
