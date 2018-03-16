package com.example.justinkhull.csci490_lab_05;

import android.arch.persistence.room.Room;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.justinkhull.csci490_lab_05.async.myAsync_1;
import com.example.justinkhull.csci490_lab_05.async.myAsync_2;
import com.example.justinkhull.csci490_lab_05.data.LabDatabase;

public class MainActivity extends AppCompatActivity {
    private static final String DATABASE_NAME = "person_db";
    private LabDatabase labDB;
    private Button submit_button;
    private Button list_button;
    private EditText name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        labDB = Room.databaseBuilder(this, LabDatabase.class, DATABASE_NAME)
                .build();

        submit_button = findViewById(R.id.submit_button);
        list_button = findViewById(R.id.list_button);
        name = findViewById(R.id.name);

        submit_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {                                   //change name to actual name typed in
                Toast submitToast = Toast.makeText(getApplicationContext(), name.getText().toString() + " added.", Toast.LENGTH_LONG);
                submitToast.show();
                submitToDatabase(name.getText().toString());
            }
        });

        list_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast listToast = Toast.makeText(getApplicationContext(), "Showing list.", Toast.LENGTH_SHORT);
                listToast.show();
                retreiveName();
            }
        });


    }
    private void submitToDatabase(String name) {
        myAsync_1 myAsync_1 = new myAsync_1(labDB);
        myAsync_1.execute(name);
    }

    private void retreiveName() {
        myAsync_2 async_2 = new myAsync_2(labDB, getApplicationContext());
        async_2.execute();
    }
}
