package com.example.javademos;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.javademos.dagger2.view.ProductListActivity;
import com.example.javademos.databinding.DataBindingActivity;
import com.example.javademos.mvvm.view.UserListActivity;

public class MainActivity extends AppCompatActivity {
    private Button sampleButton;
    private Button fragmentExample;
    private Button dynamicFragmentExample, webViewExampleButton, recyclerViewExample;
    private Button dataBindingExample, mvvmAPICallExample, dagger2Example;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sampleButton = findViewById(R.id.sampleButton);
        fragmentExample = findViewById(R.id.fragmentExampleButton);
        dynamicFragmentExample = findViewById(R.id.dynamicFragmentExampleButton);
        webViewExampleButton = findViewById(R.id.webViewExampleButton);
        recyclerViewExample = findViewById(R.id.recyclerViewExample);
        dataBindingExample = findViewById(R.id.dataBindingExample);
        mvvmAPICallExample = findViewById(R.id.mvvmAPICallExample);
        dagger2Example = findViewById(R.id.dagger2Example);

        sampleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder dialogBuilder = new AlertDialog.Builder(MainActivity.this);
                dialogBuilder.setTitle("Demo Dialog");
                dialogBuilder.setMessage("Hello: This is first dialog");
                dialogBuilder.setCancelable(true);
                dialogBuilder.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int i) {
                        dialog.dismiss();
                        Toast.makeText(MainActivity.this, "Yes, Button Clicked", Toast.LENGTH_LONG).show();
                    }
                });

                dialogBuilder.setNegativeButton("Cancel", (dialog, i) -> {
                    dialog.dismiss();
                    Toast.makeText(MainActivity.this, "Cancel, Button Clicked", Toast.LENGTH_LONG).show();
                });

                AlertDialog alertDialog = dialogBuilder.create();
                alertDialog.show();
            }
        });

        setupFragmentExample();
        setupDynamicFragmentExample();
        setupWebViewExample();
        setupRecyclerViewExample();
        setupDataBindingExample();
        setupMVVMAPICallExample();
        setupDagger2Example();
    }

    private void setupFragmentExample() {
        fragmentExample.setOnClickListener(view -> {
            Intent fragmentActivityIntent = new Intent(this, SampleFragmentActivity.class);
            startActivity(fragmentActivityIntent);
        });
    }

    private void setupDynamicFragmentExample() {
        dynamicFragmentExample.setOnClickListener(view -> {
            Intent dynamicFragmentActivityIntent = new Intent(this, SampleDynamicFragmentActivity.class);
            startActivity(dynamicFragmentActivityIntent);
        });
    }

    private void setupWebViewExample() {
        webViewExampleButton.setOnClickListener(view -> {
            Intent webViewActivityIntent = new Intent(this, SampleWebViewActivity.class);
            startActivity(webViewActivityIntent);
        });
    }

    private void setupRecyclerViewExample() {
        recyclerViewExample.setOnClickListener(view -> {
            Intent recyclerViewActivityIntent = new Intent(this, RecyclerViewActivity.class);
            startActivity(recyclerViewActivityIntent);
        });
    }

    private void setupDataBindingExample() {
        dataBindingExample.setOnClickListener(view -> {
            Intent dataBindingActivityIntent = new Intent(this, DataBindingActivity.class);
            startActivity(dataBindingActivityIntent);
        });
    }

    private void setupMVVMAPICallExample() {
        mvvmAPICallExample.setOnClickListener(view -> {
            Intent mvvmAPICallActivityIntent = new Intent(this, UserListActivity.class);
            startActivity(mvvmAPICallActivityIntent);
        });
    }

    private void setupDagger2Example() {
        dagger2Example.setOnClickListener(view -> {
            Intent dagger2ExampleActivityIntent = new Intent(this, ProductListActivity.class);
            startActivity(dagger2ExampleActivityIntent);
        });
    }
}

