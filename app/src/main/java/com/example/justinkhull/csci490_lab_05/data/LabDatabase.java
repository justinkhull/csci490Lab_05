package com.example.justinkhull.csci490_lab_05.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

import com.example.justinkhull.csci490_lab_05.entities.Person;

/**
 * Created by justinkhull on 3/15/18.
 */

@Database(entities = {Person.class}, version = 1)
public abstract class LabDatabase extends RoomDatabase {

    public abstract PersonDao personDao();
}
