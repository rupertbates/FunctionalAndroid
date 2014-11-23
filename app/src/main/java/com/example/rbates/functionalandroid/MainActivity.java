package com.example.rbates.functionalandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.Random;

import fj.Equal;
import fj.Ord;
import fj.data.Array;
import fj.data.Either;
import fj.data.List;
import fj.data.Option;

import static fj.Show.intShow;
import static fj.Show.optionShow;
import static fj.Unit.unit;
import static fj.data.Array.array;
import static fj.data.Either.left;
import static fj.data.Either.right;
import static fj.data.List.list;
import static fj.data.Option.none;
import static fj.data.Option.some;
import static fj.data.hlist.HList.HCons;
import static fj.data.hlist.HList.HNil;
import static fj.data.hlist.HList.cons;
import static fj.data.hlist.HList.nil;


public class MainActivity extends Activity {
    fj.F<Integer, fj.Unit> logInt = (i -> {
        Log.d("FunctionalAndroid", String.valueOf(i));
        return unit();
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Array<Integer> a = array(1, 2, 3, 4, 5, 6);
        a = a.filter(i -> i % 2 == 0);
        a.foreach(logInt);
        a.map(i -> String.valueOf(i++));

        List<Integer> list = list(1, 2, 1, 3, 4, 5, 3, 3, 6, 3);

        List<List<Integer>> grouped = list
                .sort(Ord.intOrd)   //need to sort the list first for group to work
                .group(Equal.intEqual);

        final Option<Integer> o1 = some(7);
        final Option<Integer> o2 = none();
        final Option<Integer> p1 = o1.map(i -> i + 42);
        final Option<Integer> p2 = o2.map(i -> i + 42);
        optionShow(intShow).println(p1); // Some(49)
        optionShow(intShow).println(p2); // None

        //Type safe Heterogenous lists
        HCons<String, HCons<Integer, HCons<Boolean, HNil>>> x = cons("One", cons(2, cons(false, nil())));
        String s = x.head();
        int i = x.tail().head();

        Either<String, List<String>> either = getDataOrErrorMessage();

        if (either.isLeft())
            Toast.makeText(this, either.left().value(), Toast.LENGTH_SHORT).show();
        else
            setAdapter(either.right().value());


        either.either(
                error -> {
                    Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
                    return unit();
                },
                data -> {
                    setAdapter(data);
                    return unit();
                }
        );

        Option<List<String>> option = tryToGetData();
        option.map(data -> {
            setAdapter(data);
            return unit();
        });


        List<String> contributors = list("Charlie Brooker", "Catherine Bennett", "Zoe Williams", "John Naughton", "Charlie Brooker", "Zoe Williams", "Zoe Williams", "Daniel Taylor");

    }

    private void setAdapter(List<String> list) {
    }

    private Option<List<String>> tryToGetData() {
        if (randomBool()) {
            return some(list("One", "Two", "Three", "Four"));
        }
        return none();
    }

//    private List<List<String>> groupContributor(List<String> contributors) {
//        ArrayList<ArrayList<String>> result = new ArrayList<ArrayList<String>>();
//    }

    /**
     * The <code>Either</code> type represents a value of one of two possible types (a disjoint union).
     * The data constructors; <code>Left</code> and <code>Right</code> represent the two possible
     * values. The <code>Either</code> type is often used as an alternative to
     * <code>scala.Option</code> where <code>Left</code> represents failure (by convention) and
     * <code>Right</code> is akin to <code>Some</code>.
     *
     * @return
     */
    private Either<String, List<String>> getDataOrErrorMessage() {
        if (randomBool()) {
            return right(list("One", "Two", "Three", "Four"));
        }
        return left("Couldn't get any data");
    }

    private boolean randomBool() {
        return new Random().nextBoolean();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
