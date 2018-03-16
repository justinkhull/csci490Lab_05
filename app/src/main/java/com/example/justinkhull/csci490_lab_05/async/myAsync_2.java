package com.example.justinkhull.csci490_lab_05.async;

import android.content.Context;
import android.content.Intent;
import android.os.AsyncTask;

import com.example.justinkhull.csci490_lab_05.PersonActivity;
import com.example.justinkhull.csci490_lab_05.data.LabDatabase;
import com.example.justinkhull.csci490_lab_05.entities.Person;

import java.util.ArrayList;

/**
 * Created by justinkhull on 3/15/18.
 */

public class myAsync_2 extends AsyncTask <Void, Void, ArrayList<Person>>{
    LabDatabase personDB;
    Context context;

    public myAsync_2(LabDatabase personDB, Context context) {
        this.personDB = personDB;
        this.context = context;
    }


    @Override
    protected ArrayList<Person> doInBackground(Void... voids) {
        ArrayList<Person> persons = (ArrayList) personDB.personDao().getAllPersons();


        return persons;
    }

    @Override
    protected void onPostExecute(ArrayList<Person> persons) {
        super.onPostExecute(persons);

        ArrayList<String> personNames = new ArrayList<>();
        for(Person p: persons) {
            personNames.add(p.getName());
        }

        Intent i = new Intent(context, PersonActivity.class);
        i.putExtra("Persons", personNames);
        context.startActivity(i);
    }


}
