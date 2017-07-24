package com.example.bibesh.realmtodb;

import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Bibesh on 7/5/17.
 */

public class DbClass extends RealmObject {
    @PrimaryKey
    private int id;
    private String firstName;
    private String lastName;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
}
