package com.example.javademos;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class SampleDynamicFragmentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_sample_dynamic_fragment);

        // Create the Instance
        SampleDynamicFragment1 dynamicFragment1 = new SampleDynamicFragment1();
        SampleDynamicFragment2 dynamicFragment2 = new SampleDynamicFragment2();

        // Get FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();

        //Add fragment1 dynamically
        FragmentTransaction transaction1 = fragmentManager.beginTransaction();
        transaction1.add(R.id.dynamicFragment1, dynamicFragment1);
        transaction1.commit();

        //Add fragment2 dynamically
        FragmentTransaction transaction2 = fragmentManager.beginTransaction();
        transaction2.add(R.id.dynamicFragment2, dynamicFragment2);
        transaction2.commit();
    }


}
