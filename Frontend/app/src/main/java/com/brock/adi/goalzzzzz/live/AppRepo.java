package com.brock.adi.goalzzzzz.live;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;

import com.brock.adi.goalzzzzz.entities.User;

/**
 * Created by reem on 27/05/18.
 */

public class AppRepo {
    public MutableLiveData<User> currentUser = new MutableLiveData<>();
}
