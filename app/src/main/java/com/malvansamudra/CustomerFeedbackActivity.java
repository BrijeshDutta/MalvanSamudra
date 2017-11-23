package com.malvansamudra;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.CheckBox;

public class CustomerFeedbackActivity extends AppCompatActivity {


    //Declaring UI components

    private CheckBox ckFoodTasteAverage,ckFoodTasteGood,ckFoodTasteExcellent;
    private CheckBox ckServiceAverage,ckServiceGood,ckServiceExcellent;
    private CheckBox ckAmbienceAverage,ckAmbienceGood,ckAmbienceExcellent;
    private AutoCompleteTextView actvCustomerName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_feedback);

        initializeUiComponents();


    }

    private void initializeUiComponents() {

        ckFoodTasteAverage = (CheckBox) findViewById(R.id.ckFoodTasteAverage);
        ckFoodTasteGood = (CheckBox) findViewById(R.id.ckFoodTasteGood);
        ckFoodTasteExcellent = (CheckBox) findViewById(R.id.ckFoodTasteExcellent);


        ckServiceAverage = (CheckBox) findViewById(R.id.ckServiceAverage);
        ckServiceGood = (CheckBox) findViewById(R.id.ckServiceGood);
        ckServiceExcellent = (CheckBox) findViewById(R.id.ckServiceExcellent);

        ckAmbienceAverage = (CheckBox) findViewById(R.id.ckAmbienceAverage);
        ckAmbienceGood = (CheckBox) findViewById(R.id.ckAmbienceGood);
        ckAmbienceExcellent = (CheckBox) findViewById(R.id.ckAmbienceExcellent);

        actvCustomerName = (AutoCompleteTextView) findViewById(R.id.actvCustomerName);
    }

    public void onFoodTasteCheckboxClicked(View view) {

        switch(view.getId()) {

            case R.id.ckFoodTasteAverage:

                ckFoodTasteGood.setChecked(false);
                ckFoodTasteExcellent.setChecked(false);

                break;

            case R.id.ckFoodTasteGood:

                ckFoodTasteExcellent.setChecked(false);
                ckFoodTasteAverage.setChecked(false);

                break;

            case R.id.ckFoodTasteExcellent:

                ckFoodTasteAverage.setChecked(false);
                ckFoodTasteGood.setChecked(false);

                break;
        }
    }
    public void onServiceCheckboxClicked(View view) {

        switch(view.getId()) {

            case R.id.ckServiceAverage:

                ckServiceGood.setChecked(false);
                ckServiceExcellent.setChecked(false);

                break;

            case R.id.ckServiceGood:

                ckServiceExcellent.setChecked(false);
                ckServiceAverage.setChecked(false);

                break;

            case R.id.ckServiceExcellent:

                ckServiceAverage.setChecked(false);
                ckServiceGood.setChecked(false);

                break;
        }
    }
    public void onAmbienceCheckboxClicked(View view) {

        switch(view.getId()) {

            case R.id.ckAmbienceAverage:

                ckAmbienceGood.setChecked(false);
                ckAmbienceExcellent.setChecked(false);

                break;

            case R.id.ckAmbienceGood:

                ckAmbienceExcellent.setChecked(false);
                ckAmbienceAverage.setChecked(false);

                break;

            case R.id.ckAmbienceExcellent:

                ckAmbienceAverage.setChecked(false);
                ckAmbienceGood.setChecked(false);

                break;
        }
    }
}
