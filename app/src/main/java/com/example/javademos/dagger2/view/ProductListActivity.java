package com.example.javademos.dagger2.view;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;

import com.example.javademos.R;
import com.example.javademos.dagger2.MyApplication;
import com.example.javademos.dagger2.model.Product;
import com.example.javademos.dagger2.network.ProductListApiService;
import com.example.javademos.databinding.ActivityProductListBinding;

import java.util.List;

import javax.inject.Inject;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ProductListActivity extends AppCompatActivity {
    private ActivityProductListBinding binding;

    @Inject
    ProductListApiService apiService;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_product_list);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Inject Dependencies
        ((MyApplication) getApplication()).getAppComponent().inject(this);

        //make an api call
        apiService.getProductList().enqueue(new Callback<List<Product>>() {
            @Override
            public void onResponse(Call<List<Product>> call, Response<List<Product>> response) {
                List<Product> listOfProduct = response.body();
                String[] products = new String[listOfProduct.size()];
                for(int i = 0;  i < products.length; i++) {
                    products[i] = listOfProduct.get(i).getName();
                }

                //display string array into listview
                binding.productListView.setAdapter(new ArrayAdapter<>(getApplication(), android.R.layout.simple_list_item_1, products));
            }

            @Override
            public void onFailure(Call<List<Product>> call, Throwable t) {
                Toast.makeText(getApplication(), t.getMessage(), Toast.LENGTH_LONG).show();
            }
        });
    }
}
