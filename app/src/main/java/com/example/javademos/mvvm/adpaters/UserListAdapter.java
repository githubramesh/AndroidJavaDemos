package com.example.javademos.mvvm.adpaters;

import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.javademos.R;
import com.example.javademos.databinding.UserItemViewBinding;
import com.example.javademos.mvvm.data.model.User;

import java.util.ArrayList;
import java.util.List;

public class UserListAdapter extends RecyclerView.Adapter<UserListAdapter.UserListViewHolder> {
    private List<User> userList = new ArrayList<>();

    public void setUserList(List<User> userList) {
        this.userList = userList;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public UserListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        UserItemViewBinding binding = DataBindingUtil.inflate(LayoutInflater.from(parent.getContext()), R.layout.user_item_view, parent, false);

        return new UserListViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull UserListViewHolder holder, int position) {
        User user = userList.get(position);
        holder.binding.setUser(user);

        Glide.with(holder.binding.userImageView.getContext())
                .load(user.getImageURL())
                .placeholder(R.drawable.baseline_apartment_24)
                .error(R.drawable.ic_launcher_background)
                .into(holder.binding.userImageView);

        holder.binding.executePendingBindings();
    }

    @Override
    public int getItemCount() {
        return userList.size();
    }

    static class UserListViewHolder extends RecyclerView.ViewHolder {
        final UserItemViewBinding binding;

        public UserListViewHolder(UserItemViewBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }
}
