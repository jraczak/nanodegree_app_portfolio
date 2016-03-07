package com.justinraczak.android.androidappportfolio;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends Activity
implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Get a reference to the RelativeLayout container view
        ViewGroup containerGroup = (ViewGroup)findViewById(R.id.container);
        // Make sure all the buttons respond to clicks
        setButtonListeners(containerGroup);

    }


    private void setButtonListeners(ViewGroup v) {
        // Set up the loop
        for (int i = 0; i < v.getChildCount(); i++) {
            // Get a reference to the child at the current index of i
            View child = v.getChildAt(i);
            // Check if the child is a Button
            if (child instanceof Button) {
                // Set the listener on the button
                child.setOnClickListener(this);
                Log.d("Button setup", "Successfully set " + ((Button) child).getText().toString() + " button listener.");
            }
        }
    }

    public void onClick(View v) {
        // Cast the view to a Button instance
        Button b = (Button)v;
        // Display the project name to be launched
        Toast.makeText(MainActivity.this,
                "This will launch " + b.getText().toString(),
                Toast.LENGTH_SHORT)
                .show();
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
