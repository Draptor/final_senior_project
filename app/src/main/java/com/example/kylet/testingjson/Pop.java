package com.example.kylet.testingjson;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.Toast;

public class Pop extends Activity {

    boolean woodward = false;
    boolean atkins = false;

    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);

        setContentView(R.layout.pop_window);

        DisplayMetrics dm = new DisplayMetrics();

        getWindowManager().getDefaultDisplay().getMetrics(dm);

        int width = dm.widthPixels;
        int height = dm.heightPixels;

        getWindow().setLayout((int)(width*.9),(int)(height*.8));


        Switch woodwardSwitch = (Switch)findViewById(R.id.woodButton);

        woodwardSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                woodward = isChecked;
            }
        });

        Switch atkinsSwitch = (Switch)findViewById(R.id.atkinsButton);

        atkinsSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                atkins = isChecked;
                //Toast.makeText(getApplicationContext(), "test", Toast.LENGTH_LONG).show();
            }
        });





        Intent filterControl = new Intent(this, ShowLabsActivity.class);
        filterControl.putExtra("wood", woodward);
        filterControl.putExtra("atkins", atkins);
        Button b = (Button) findViewById(R.id.filterbutton);



    }

    public void refreshResults(View view) {
        Intent intent = new Intent(this, ShowLabsActivity.class);
        startActivity(intent);
        setContentView(R.layout.activity_show_labs);
    }

}
