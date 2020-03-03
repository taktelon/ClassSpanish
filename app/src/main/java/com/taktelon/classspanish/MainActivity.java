package com.taktelon.classspanish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.taktelon.classspanish.items.VerbItem;

public class MainActivity extends AppCompatActivity implements VerbFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.addToBackStack(null);
            int columnCount = 1;
            fragmentTransaction.replace(R.id.fragment_container, VerbFragment.newInstance(columnCount));
            fragmentTransaction.commit();
        }

    }

    // implements VerbFragment.OnListFragmentInteractionListener
    @Override
    public void onListFragmentInteraction(VerbItem item) {
        System.out.println(item.verb + " is pressed!");
    }
}
