package com.example.justinkhull.csci490_lab_05.data;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import com.example.justinkhull.csci490_lab_05.entities.Person;

import java.util.List;

/**
 * Created by justinkhull on 3/15/18.
 */

@Dao
public interface PersonDao {

    @Insert
    void insertPerson(Person person);

    @Query("SELECT * FROM Person")
    List<Person> getAllPersons();


}
