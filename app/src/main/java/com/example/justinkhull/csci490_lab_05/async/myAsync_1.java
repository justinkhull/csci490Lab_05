package com.example.justinkhull.csci490_lab_05.async;

import android.os.AsyncTask;

import com.example.justinkhull.csci490_lab_05.data.LabDatabase;
import com.example.justinkhull.csci490_lab_05.entities.Person;

/**
 * Created by justinkhull on 3/15/18.
 */

public class myAsync_1 extends AsyncTask <String, Void, Void> {

    LabDatabase database;

    public myAsync_1(LabDatabase database) {
        this.database = database;
    }

    @Override
    protected Void doInBackground(String... strings) {
        Person person = new Person();
        person.setName(strings[0]);

        database.personDao().insertPerson(person);
        return null;
    }
}
