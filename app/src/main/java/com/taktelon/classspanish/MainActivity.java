package com.taktelon.classspanish;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

import com.taktelon.classspanish.items.VerbItem;

public class MainActivity extends AppCompatActivity implements VerbListFragment.OnListFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.addToBackStack(null);
            int columnCount = 1;
            transaction.replace(R.id.fragment_container, VerbListFragment.newInstance(columnCount));
            transaction.commit();
        }

    }

    // implements VerbFragment.OnListFragmentInteractionListener
    @Override
    public void onListFragmentInteraction(VerbItem item) {
        System.out.println(item.getVerb() + " is pressed!");
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction transaction = fm.beginTransaction();
        transaction.addToBackStack(null);
        transaction.replace(R.id.fragment_container, VerbFormFragment.newInstance(item.getVerb(), "world"));
        transaction.commit();
    }
}
