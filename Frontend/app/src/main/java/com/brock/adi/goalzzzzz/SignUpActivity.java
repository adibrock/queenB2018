package com.brock.adi.goalzzzzz;

import android.support.v4.content.ContextCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

public class SignUpActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
                        // create new user
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
