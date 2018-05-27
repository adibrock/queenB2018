package com.brock.adi.goalzzzzz;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.brock.adi.goalzzzzz.live.AppRepo;

/**
 * Created by reem on 27/05/18.
 */

public class GoalsApp extends Application {
    public static GoalsApp instance;

    public AppRepo appRepo;
    @Override
    public void onCreate() {
        instance = this;
        this.appRepo = new AppRepo();

        SharedPreferences sp = PreferenceManager.getDefaultSharedPreferences(this);
        new CacheManager(sp, this.appRepo);


        super.onCreate();

    }
}
