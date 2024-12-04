package com.example.javademos.mvvm.view;

import android.os.Bundle;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.databinding.DataBindingUtil;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.javademos.R;
import com.example.javademos.databinding.ActivityUserListBinding;
import com.example.javademos.databinding.UserItemViewBinding;
import com.example.javademos.mvvm.adpaters.UserListAdapter;
import com.example.javademos.mvvm.data.model.User;
import com.example.javademos.mvvm.viewmodel.UserListViewModel;

import java.util.List;

public class UserListActivity extends AppCompatActivity {
    private ActivityUserListBinding binding;
    private UserListViewModel userListViewModel;
    private UserListAdapter userListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        EdgeToEdge.enable(this);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_user_list);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        binding.userListRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        userListAdapter = new UserListAdapter();
        binding.userListRecyclerView.setAdapter(userListAdapter);

        userListViewModel = new ViewModelProvider(this).get(UserListViewModel.class);

        userListViewModel.getUserListLiveData().observe(this, new Observer<List<User>>() {
            @Override
            public void onChanged(List<User> users) {
                userListAdapter.setUserList(users);
            }
        });

        userListViewModel.callUserListAPI();

    }
}
