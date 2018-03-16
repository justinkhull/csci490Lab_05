package com.example.justinkhull.csci490_lab_05.entities;

import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by justinkhull on 3/15/18.
 */

@Entity
public class Person {
    @PrimaryKey(autoGenerate = true)
    private int id;

    private String name;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
