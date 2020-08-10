package com.example.quicktable;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public void rightList(int a)
    {
        ListView list=(ListView) findViewById(R.id.list1);
        ArrayList<String> numbers=new ArrayList<>();
        for(int i=1;i<=100;i++)
        {
            numbers.add(Integer.toString(a)+"X"+Integer.toString(i)+"="+Integer.toString(a*i));
        }
        ArrayAdapter<String> adapt=new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,numbers);
        list.setAdapter(adapt);

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rightList(10);
        SeekBar seek=(SeekBar)findViewById(R.id.seek1);

        seek.setProgress(10);
        seek.setMax(20);

        seek.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min=1;
                int x=1;
                if(i<min)
                {
                    x=min;
                    SeekBar seek=(SeekBar)findViewById(R.id.seek1);
                    seek.setProgress(x);
                }
                else
                {
                    x=i;
                }
                rightList(x);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });




}}
