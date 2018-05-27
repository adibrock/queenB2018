package com.brock.adi.goalzzzzz.backend;

import android.arch.lifecycle.MutableLiveData;

import com.brock.adi.goalzzzzz.entities.User;
import com.brock.adi.goalzzzzz.live.AppRepo;

/**
 * Created by reem on 27/05/18.
 */

public class BackendManager {
    private final static String BACKEND_URL = "192.168.11.3:5000";

    public BackendManager(AppRepo appRepo) {
        getUserIdFromBackendIfNeeded(appRepo.currentUser);
        sendUserChangesToBackend(appRepo.currentUser);
    }

    private void sendUserChangesToBackend(MutableLiveData<User> currentUser) {

    }

    private void getUserIdFromBackendIfNeeded(MutableLiveData<User> currentUser) {

    }
}
