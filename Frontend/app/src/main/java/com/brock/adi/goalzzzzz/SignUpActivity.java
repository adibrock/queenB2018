package com.brock.adi.goalzzzzz;

import android.content.Intent;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.brock.adi.goalzzzzz.entities.User;

public class SignUpActivity extends AppCompatActivity {
    private void goTONextActivity(){
        Intent intent = new Intent(SignUpActivity.this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (GoalsApp.instance.appRepo.currentUser.getValue().user_name != null){
            goTONextActivity();
        }

        setContentView(R.layout.activity_sign_up);

        final ImageView next = findViewById(R.id.nextSignUp);
        final EditText editTextUsername = findViewById(R.id.editTextUsername);

        editTextUsername.addTextChangedListener(new TextWatcher() {

            public void afterTextChanged(Editable s) {
                if (editTextUsername.getText().toString().equals("")) {
                    next.setColorFilter(ContextCompat.getColor(SignUpActivity.this, R.color.gray));
                    next.setOnClickListener(null);
                    return;
                }
                next.setColorFilter(ContextCompat.getColor(SignUpActivity.this, R.color.colorAccent));
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        User user = GoalsApp.instance.appRepo.currentUser.getValue();
                        user.user_name = editTextUsername.getText().toString();
                        GoalsApp.instance.appRepo.currentUser.postValue(user);
                        goTONextActivity();
                    }
                });
            }

            public void beforeTextChanged(CharSequence s, int start,
                                          int count, int after) {
            }

            public void onTextChanged(CharSequence s, int start,
                                      int before, int count) {
            }
        });



    }
}
