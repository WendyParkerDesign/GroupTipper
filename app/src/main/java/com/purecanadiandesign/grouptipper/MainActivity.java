package com.purecanadiandesign.grouptipper;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.drawable.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
    }

    public void calculate(View view){
        // Hide Numpad onClick - when the button is pressed
        InputMethodManager inputManager = (InputMethodManager)
                getSystemService(Context.INPUT_METHOD_SERVICE);
        inputManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(),
                InputMethodManager.HIDE_NOT_ALWAYS);
        // get all the user input from the EditText fields
        EditText total   = (EditText)findViewById(R.id.editText2);
        EditText people   = (EditText)findViewById(R.id.editText);
        EditText tip   = (EditText)findViewById(R.id.editText3);
        EditText each   = (EditText)findViewById(R.id.editText4);
        // Convert all user input to Float
        float totalVar = Float.parseFloat(total.getText().toString());
        float peopleVar = Float.parseFloat(people.getText().toString());
        float tipVar = Float.parseFloat(tip.getText().toString());
        // Calculate total * tip + total / people
        float calc = (totalVar * tipVar / peopleVar);
        // Round it up to 2 decimal points
        String EachPay = String.format("%.2f", calc);

        // Show what everyone pays in the EditText field
        each.setText(EachPay);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.about:
                Toast.makeText(this, "Group Tipper v1.11 Meal Tip Splitting app/apps/purecanadiandesign.com",
                        Toast.LENGTH_LONG).show();
                return (true);
            case R.id.help:
                String url = "http://purecanadiandesign.com"; /*formdata.php?Help=There%20will%20be%20help%20documents%20here."; */
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse(url)));
                return (true);
        }
        return super.onOptionsItemSelected(item);
    }
}
