package com.taktelon.classspanish;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.taktelon.classspanish.items.VerbItem;

public class MainActivity extends AppCompatActivity implements VerbFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    // implements VerbFragment.OnListFragmentInteractionListener
    @Override
    public void onListFragmentInteraction(VerbItem item) {
        System.out.println(item.verb + " is pressed!");
    }
}
