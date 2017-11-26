package com.malvansamudra;

import android.app.ProgressDialog;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.malvansamudra.constants.Constants;
import com.malvansamudra.database.DatabaseValues;
import com.malvansamudra.model.Feedback;
import com.malvansamudra.utility.Utility;

import java.nio.file.Files;

public class CustomerFeedbackActivity extends AppCompatActivity {


    //Declaring UI components

    private CheckBox ckFoodTasteAverage,ckFoodTasteGood,ckFoodTasteExcellent;
    private CheckBox ckServiceAverage,ckServiceGood,ckServiceExcellent;
    private CheckBox ckAmbienceAverage,ckAmbienceGood,ckAmbienceExcellent;
    private AutoCompleteTextView actvCustomerName,actvCustomerMobileNo,actvCustomerAddress,actvSuggestions;
    Button btnSubmitFeedback;
    ProgressDialog progressBarAddFeedback;
    //variables

    String sCustomerName,sCustomerMobileNo,sCustomerAddress,sCustomerSuggestions;
    String sFoodTasteRating="",sServiceRating="",sAmbienceRating="";

    String sFeedbackId,sDateToday;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_customer_feedback);

        initializeUiComponents();
        btnSubmitFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                saveCustomerFeedback();
            }
        });

    }

    private void saveCustomerFeedback() {
        getUserEnteredValues();
        if (validateUserEnterData()){
            saveCustomerFeedbackToDb();
        }
    }

    private void saveCustomerFeedbackToDb() {

        progressBarAddFeedback.setMessage("Adding feedback....");
        progressBarAddFeedback.show();
        DatabaseReference databaseReference = DatabaseValues.getFeedbackDetailReference();
        sFeedbackId = databaseReference.push().getKey();
        Feedback feedback = new Feedback(sFeedbackId,sCustomerName,sCustomerMobileNo,sCustomerAddress,sFoodTasteRating,sServiceRating,sAmbienceRating,sCustomerSuggestions,sDateToday);

        databaseReference.child(sFeedbackId).setValue(feedback).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if (task.isSuccessful()){
                    progressBarAddFeedback.dismiss();
                    Toast.makeText(getApplication(),"Thank You for your feedback!! We appreciate you taking the time to help us improve !! ",Toast.LENGTH_LONG).show();
                    //sendNotification();
                    resetUiComponents();

                }else {
                    progressBarAddFeedback.dismiss();
                    Toast.makeText(getApplication(),"Failed to update " + task.getException().getMessage(),Toast.LENGTH_LONG).show();
                }

            }
        });
        databaseReference = null;
    }

    private void resetUiComponents() {
        actvCustomerName.setText("");
        actvCustomerMobileNo.setText("");
        actvCustomerAddress.setText("");
        actvSuggestions.setText("");

        if (ckFoodTasteAverage.isChecked()) {
            ckFoodTasteAverage.setChecked(false);
        }
        if (ckFoodTasteGood.isChecked()) {
            ckFoodTasteGood.setChecked(false);
        }
        if (ckFoodTasteExcellent.isChecked()) {
            ckFoodTasteExcellent.setChecked(false);
        }

        if (ckServiceAverage.isChecked()) {
            ckServiceAverage.setChecked(false);
        }

        if (ckServiceGood.isChecked()) {
            ckServiceGood.setChecked(false);
        }

        if (ckServiceExcellent.isChecked()) {
            ckServiceExcellent.setChecked(false);
        }


        if (ckAmbienceAverage.isChecked()) {
            ckAmbienceAverage.setChecked(false);
        }

        if (ckAmbienceGood.isChecked()) {
            ckAmbienceGood.setChecked(false);
        }

        if (ckAmbienceExcellent.isChecked()) {
            ckAmbienceExcellent.setChecked(false);
        }


    }

    private void getUserEnteredValues() {
        sCustomerName = actvCustomerName.getText().toString().trim();
        sCustomerMobileNo = actvCustomerMobileNo.getText().toString().trim();
        sCustomerAddress = actvCustomerAddress.getText().toString().trim();
        sCustomerSuggestions = actvSuggestions.getText().toString().trim();

    }

    private boolean validateUserEnterData() {
        boolean isValid = true;
        View focusView = null;
        if(sCustomerName.isEmpty()){
            actvCustomerName.setError("Name is required");
            isValid = false;
            focusView = actvCustomerName;
        }
        else if(sCustomerMobileNo.isEmpty()){
            actvCustomerMobileNo.setError("Mobile No. is required");
            isValid = false;
            focusView = actvCustomerName;
        }
        if (!ckFoodTasteAverage.isChecked()){
            if (!ckFoodTasteGood.isChecked()){
                if(!ckFoodTasteExcellent.isChecked()){
                    Toast.makeText(this,"Please give rating for Food taste",Toast.LENGTH_SHORT).show();
                    isValid = false;
                }
            }
        }
        if (!ckServiceAverage.isChecked()){
            if (!ckServiceGood.isChecked()){
                if(!ckServiceExcellent.isChecked()){
                    Toast.makeText(this,"Please give rating for Service",Toast.LENGTH_SHORT).show();
                    isValid = false;
                }
            }
        }
        if(!ckAmbienceAverage.isChecked()){
            if (!ckAmbienceGood.isChecked()){
                if(!ckAmbienceExcellent.isChecked()){
                    Toast.makeText(this,"Please give rating for Ambience",Toast.LENGTH_SHORT).show();
                    isValid = false;
                }
            }
        }
        return isValid;
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
        actvCustomerMobileNo = (AutoCompleteTextView) findViewById(R.id.actvCustomerMobileNo);
        actvCustomerAddress = (AutoCompleteTextView) findViewById(R.id.actvCustomerAddress);
        actvSuggestions = (AutoCompleteTextView) findViewById(R.id.actvSuggestions);

        btnSubmitFeedback = (Button) findViewById(R.id.btnSubmitFeedback);

        progressBarAddFeedback = new ProgressDialog(this);

        sDateToday = Utility.getCurrentDateForUserDisplay();
    }

    public void onFoodTasteCheckboxClicked(View view) {

        switch(view.getId()) {

            case R.id.ckFoodTasteAverage:

                ckFoodTasteGood.setChecked(false);
                ckFoodTasteExcellent.setChecked(false);
                sFoodTasteRating = Constants.AVERAGE;
                break;

            case R.id.ckFoodTasteGood:

                ckFoodTasteExcellent.setChecked(false);
                ckFoodTasteAverage.setChecked(false);
                sFoodTasteRating = Constants.GOOD;

                break;

            case R.id.ckFoodTasteExcellent:

                ckFoodTasteAverage.setChecked(false);
                ckFoodTasteGood.setChecked(false);
                sFoodTasteRating = Constants.EXCELLENT;
                break;
        }
    }
    public void onServiceCheckboxClicked(View view) {

        switch(view.getId()) {

            case R.id.ckServiceAverage:

                ckServiceGood.setChecked(false);
                ckServiceExcellent.setChecked(false);
                sServiceRating = Constants.AVERAGE;
                break;

            case R.id.ckServiceGood:

                ckServiceExcellent.setChecked(false);
                ckServiceAverage.setChecked(false);
                sServiceRating = Constants.GOOD;
                break;

            case R.id.ckServiceExcellent:

                ckServiceAverage.setChecked(false);
                ckServiceGood.setChecked(false);
                sServiceRating = Constants.EXCELLENT;
                break;
        }
    }
    public void onAmbienceCheckboxClicked(View view) {

        switch(view.getId()) {

            case R.id.ckAmbienceAverage:

                ckAmbienceGood.setChecked(false);
                ckAmbienceExcellent.setChecked(false);
                sAmbienceRating = Constants.AVERAGE;
                break;

            case R.id.ckAmbienceGood:

                ckAmbienceExcellent.setChecked(false);
                ckAmbienceAverage.setChecked(false);
                sAmbienceRating = Constants.GOOD;
                break;

            case R.id.ckAmbienceExcellent:

                ckAmbienceAverage.setChecked(false);
                ckAmbienceGood.setChecked(false);
                sAmbienceRating = Constants.EXCELLENT;
                break;
        }
    }
}
