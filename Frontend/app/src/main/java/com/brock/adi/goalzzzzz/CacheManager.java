package com.brock.adi.goalzzzzz;

import android.arch.lifecycle.Observer;
import android.content.SharedPreferences;
import android.support.annotation.Nullable;

import com.brock.adi.goalzzzzz.entities.User;
import com.brock.adi.goalzzzzz.live.AppRepo;
import com.google.gson.Gson;

/**
 * Created by reem on 27/05/18.
 */

public class CacheManager {
    public CacheManager(final SharedPreferences sp, AppRepo repo) {
        initFirstUser(sp, repo);
        listenToUserChanges(sp, repo);
    }

    private void initFirstUser(final SharedPreferences sp, AppRepo repo) {
        String userJson = sp.getString("ConnectedUser", "{}");
        repo.currentUser.setValue(new Gson().fromJson(userJson, User.class));
    }

    private void listenToUserChanges(final SharedPreferences sp, AppRepo repo) {
        repo.currentUser.observeForever(new Observer<User>() {
            @Override
            public void onChanged(@Nullable User user) {
                sp.edit().putString("ConnectedUser", new Gson().toJson(user)).apply();
            }
        });
    }
}
