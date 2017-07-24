package com.example.bibesh.realmpractise;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;

import Database.Grade;
import Database.Student;
import io.realm.Realm;
import io.realm.RealmObject;
import io.realm.RealmResults;

@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {
    Realm mReal;

    public void makeInit() {
        Realm.init(this);
        mReal = Realm.getDefaultInstance();
    }

    @Click(R.id.save)
    void run() {
        makeInit();
        mReal.beginTransaction();
        Grade grade = mReal.createObject(Grade.class, "3");
        grade.setRoom(1);
        mReal.commitTransaction();
    }

    @Click(R.id.value)
    public void showEntry() {
        makeInit();
        RealmResults<Grade> result = mReal.where(Grade.class).findAll();
        for (int i = 0; i < result.size(); i++) {
            Grade gd = result.get(i);
            Log.v("Value", "" + gd.getGrade());
        }
    }


    @Click(R.id.saveEntry)
    public void saveEntry() {
        makeInit();
        mReal.beginTransaction();

        Student student = mReal.createObject(Student.class, "1");
        student.setName("Bibesh");
        student.setGrade(getGrade());

        mReal.commitTransaction();
    }

    public Grade getGrade() {
        makeInit();
        RealmResults<Grade> grade = mReal.where(Grade.class).findAll();
        Grade grader = grade.get(0);
        return grader ;
    }

    @Click(R.id.showGrade)
    public void showGrade() {
        makeInit();
        RealmResults<Student> result = mReal.where(Student.class).findAll();
        for (int i = 0; i < result.size(); i++) {
            Student gd = result.get(i);
            Log.v("Value", "" + gd.getGrade());
        }
    }

}
