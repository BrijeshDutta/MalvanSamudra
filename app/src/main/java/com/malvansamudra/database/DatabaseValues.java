package com.malvansamudra.database;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

/**
 * Created by Rini Banerjee on 25-11-2017.
 */

public class DatabaseValues {

    public static DatabaseReference getFeedbackDetailReference(){
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference("Feedback");
        return databaseReference;
    }
}
