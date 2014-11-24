package com.example.rbates.functionalandroid;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import fj.Unit;
import fj.data.Either;
import fj.data.List;
import fj.data.Option;

import static fj.Unit.unit;


public class MainActivity extends Activity {
    fj.F<Integer, fj.Unit> logInt = (i -> {
        Log.d("FunctionalAndroid", String.valueOf(i));
        return unit();
    });

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /**
         * Functional way of doing things:
         */
        Functional functional = new Functional();

        //Option as return type
        Option<List<String>> option = functional.getSavedPages();
        option.map(data -> showSavedPages(data));

        //Either as return type
        Either<String, List<String>> either = functional.getDataOrErrorMessage();

        if (either.isLeft())
            Toast.makeText(this, either.left().value(), Toast.LENGTH_SHORT).show();
        else
            setAdapter(either.right().value());

        either.either(
                error -> showErrorMessage(error),
                data -> setAdapter(data)
        );

        /**
         * Imperative way of doing it
         */

    }

    private Unit setAdapter(List<String> list) {
        return unit();
    }

    private Unit showErrorMessage(String error) {
        Toast.makeText(this, error, Toast.LENGTH_SHORT).show();
        return unit();
    }

    private Unit showSavedPages(List<String> list) {
        return unit();
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
