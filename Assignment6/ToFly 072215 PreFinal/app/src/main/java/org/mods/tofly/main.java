package org.mods.tofly;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;


public class main extends ActionBarActivity {

    private static final String TAG = "ToFly";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setLogo(R.mipmap.ic_launcher);
        getSupportActionBar().setDisplayUseLogoEnabled(true);
        setContentView(R.layout.main);

        View simButton = findViewById(R.id.simulators_button);
        simButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.d(TAG, "clicked on");
                Intent intent = new Intent(main.this, simulators.class);
                startActivity(intent);
            }
        });

        View funfactsButton = findViewById(R.id.fun_facts_button);
        funfactsButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.d(TAG, "clicked on");
                Intent intent = new Intent(main.this, FunFacts.class);
                startActivity(intent);
            }
        });

        View gamesButton = findViewById(R.id.games_button);
        gamesButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.d(TAG, "clicked on");
                final Dialog dialog = new Dialog(main.this);
                dialog.setContentView(R.layout.custom_dialog);
                dialog.setTitle("Select A Game");

                Button triviaButton = (Button) dialog.findViewById(R.id.trivia_button);
                triviaButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d(TAG, "clicked on dialog");
                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("com.example.triviality");
                        startActivity(launchIntent);
                    }
                });

                Button huntButton = (Button) dialog.findViewById(R.id.hunt_button);
                huntButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Log.d(TAG, "clicked on dialog");
                        Intent launchIntent = getPackageManager().getLaunchIntentForPackage("package name");
                    }
                });
                dialog.show();
            }
        });

        View pcButton = findViewById(R.id.plane_components_button);
        pcButton.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                Log.d(TAG, "clicked on");
                Intent intent = new Intent(main.this, PlaneComponents.class);
                startActivity(intent);
            }
        });
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

    // Ask the user what difficulty level they want
    private void openNewGameDialog() {

    }

    // Start a new game with the given difficulty level
    private void startGame(int i) {
        Log.d(TAG, "clicked on " + i);
        
        // Start game here...
    }

}
