package com.example.rbates.functionalandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;

import fj.Unit;
import fj.data.Array;
import fj.data.Option;

import static fj.Show.optionShow;
import static fj.Show.intShow;
import static fj.data.Array.array;
import static fj.data.Option.none;
import static fj.data.Option.some;


public class MainActivity extends Activity {
    fj.F<Integer, fj.Unit> logInt = (i -> {Log.d("FunctionalAndroid", String.valueOf(i)); return Unit.unit();});

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Array<Integer> a = array(1, 2, 3, 4, 5, 6);
        a = a.filter(i -> i % 2 == 0);
        a.foreach(logInt);
        a.map(i -> String.valueOf(i++));

        final Option<Integer> o1 = some(7);
        final Option<Integer> o2 = none();
        final Option<Integer> p1 = o1.map(i -> i + 42);
        final Option<Integer> p2 = o2.map(i -> i + 42);
        optionShow(intShow).println(p1); // Some(49)
        optionShow(intShow).println(p2); // None

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
