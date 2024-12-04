package com.example.javademos;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.javademos.adapters.RecyclerViewAdapter;
import com.example.javademos.model.ItemModel;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {
    private RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_recycler_view);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        initializedRecyclerView();
    }

    private void initializedRecyclerView() {
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getListOfData());

        recyclerView.setAdapter(recyclerViewAdapter);
    }

    private List<ItemModel> getListOfData() {
        List<ItemModel> listOfData = new ArrayList<>();
        listOfData.add(new ItemModel("E-Book", R.drawable.baseline_apartment_24));
        listOfData.add(new ItemModel("Test Preparation", R.drawable.baseline_apartment_24));
        listOfData.add(new ItemModel("Apartment", R.drawable.baseline_apartment_24));
        listOfData.add(new ItemModel("Video", R.drawable.baseline_apartment_24));
        listOfData.add(new ItemModel("Mock Test", R.drawable.baseline_apartment_24));
        listOfData.add(new ItemModel("Learning", R.drawable.baseline_apartment_24));
        listOfData.add(new ItemModel("Reading", R.drawable.baseline_apartment_24));
        listOfData.add(new ItemModel("Info", R.drawable.baseline_apartment_24));
        listOfData.add(new ItemModel("Readable", R.drawable.baseline_apartment_24));
        listOfData.add(new ItemModel("Apartment", R.drawable.baseline_apartment_24));
        listOfData.add(new ItemModel("School", R.drawable.baseline_apartment_24));
        listOfData.add(new ItemModel("College", R.drawable.baseline_apartment_24));
        listOfData.add(new ItemModel("University", R.drawable.baseline_apartment_24));
        listOfData.add(new ItemModel("Company", R.drawable.baseline_apartment_24));

        return listOfData;
    }
}
