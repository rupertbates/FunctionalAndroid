package com.example.rbates.functionalandroid;

import java.util.Random;

import fj.Equal;
import fj.F;
import fj.Ord;
import fj.data.Either;
import fj.data.List;
import fj.data.Option;
import fj.data.hlist.HList;

import static fj.data.Either.left;
import static fj.data.Either.right;
import static fj.data.List.list;
import static fj.data.Option.none;
import static fj.data.Option.some;
import static fj.data.hlist.HList.cons;
import static fj.data.hlist.HList.nil;

public class Functional extends Base {

    public List<ContributorCount> getContributorCounts(){
        return contributors
                .sort(Ord.stringOrd)
                .group(Equal.stringEqual)
                .filter(l -> l.length() > 1)
                .map(l -> new ContributorCount(l.head(), l.length()));
    }

    public Option<List<String>> getSavedPages() {
        if (randomBool()) {
            return some(list("One", "Two", "Three", "Four"));
        }
        return none();
    }

    /**
     * The <code>Either</code> type represents a value of one of two possible types (a disjoint union).
     * The data constructors; <code>Left</code> and <code>Right</code> represent the two possible
     * values. The <code>Either</code> type is often used as an alternative to
     * <code>scala.Option</code> where <code>Left</code> represents failure (by convention) and
     * <code>Right</code> is akin to <code>Some</code>.
     *
     * @return
     */
    public Either<String, List<String>> getDataOrErrorMessage() {
        if (randomBool()) {
            return right(list("One", "Two", "Three", "Four"));
        }
        return left("Couldn't get any data");
    }

    private boolean randomBool() {
        return new Random().nextBoolean();
    }

    private void heterogenousLists(){
        //Type safe Heterogenous lists
        HList.HCons<String, HList.HCons<Integer, HList.HCons<Boolean, HList.HNil>>> x = cons("One", cons(2, cons(false, nil())));
        String s = x.head();
        int i = x.tail().head();
    }
}
