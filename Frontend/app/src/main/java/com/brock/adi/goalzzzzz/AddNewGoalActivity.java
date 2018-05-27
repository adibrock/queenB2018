package com.brock.adi.goalzzzzz;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewGoalActivity extends AppCompatActivity {

    Button addNewGoal;
    EditText goalDescription;
    EditText numOfDays;

    private void updateVisibilityButton()
    {
        if (goalDescription.getText().toString().equals("") || numOfDays.getText().toString().equals("")) {
            addNewGoal.setVisibility(View.INVISIBLE);
        }
        else
            addNewGoal.setVisibility(View.VISIBLE);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_goal);
        this.addNewGoal = findViewById(R.id.addNewGoalAddButton);
        this.goalDescription = findViewById(R.id.addNewGoalDescriptionEditText);
        this.numOfDays = findViewById(R.id.addNewGoalDayCountEditText);
        updateVisibilityButton();
        this.addNewGoal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
        goalDescription.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s)
            {
                updateVisibilityButton();
            }
        });
        numOfDays.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                updateVisibilityButton();
            }
        });
    }

}
