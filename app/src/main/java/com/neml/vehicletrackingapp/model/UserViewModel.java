package com.neml.vehicletrackingapp.model;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import com.neml.vehicletrackingapp.data.UserAccountDatabase;
import com.neml.vehicletrackingapp.util.UserRepository;

public class UserViewModel extends ViewModel {
    private UserRepository userRepository;

    public UserViewModel(Context context) {

        userRepository = UserRepository.getInstance(UserAccountDatabase.getAppDatabase(context).userAccountDao());
    }

    public void createUser(String username, String password)
    {
        userRepository.insertUser(username, password);
    }

    public boolean checkValidLogin(String username, String password)
    {
        return userRepository.isValidAccount(username, password);
    }

    public static class Factory implements ViewModelProvider.Factory {
        private final Context ctxt;

        public Factory(Context ctxt) {
            this.ctxt=ctxt.getApplicationContext();
        }

        @NonNull
        @Override
        public <T extends ViewModel> T create(@NonNull Class<T> modelClass) {
            return((T)new UserViewModel(ctxt));
        }
    }
}
