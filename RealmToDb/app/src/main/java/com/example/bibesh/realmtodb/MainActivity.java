package com.example.bibesh.realmtodb;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import org.json.JSONArray;
import org.json.JSONObject;

import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;

public class MainActivity extends AppCompatActivity {

    Button button;
    Button get;
    Realm mReal;
    Realm mReal2;
    JSONArray array;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {
            Realm.init(this);
            RealmConfiguration conf = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
            mReal = Realm.getInstance(conf);

            mReal.beginTransaction();
            DbClass db1 = mReal.createObject(DbClass.class, 1);
            db1.setFirstName("BIBESH");
            db1.setLastName("MANANDHAR");
            mReal.commitTransaction();

            mReal.beginTransaction();
            DbClass db2 = mReal.createObject(DbClass.class, 2);
            db2.setFirstName("BIBESH");
            db2.setLastName("MANANDHAR");
            mReal.commitTransaction();

            mReal.beginTransaction();
            DbClass db3 = mReal.createObject(DbClass.class, 3);
            db3.setFirstName("BIBESH");
            db3.setLastName("MANANDHAR");
            mReal.commitTransaction();

        } catch (Exception err) {
            Log.v("ERROR", err.getMessage());
        } finally {
            mReal.close();
        }

        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Realm.init(getApplicationContext());
                    RealmConfiguration conf = new RealmConfiguration.Builder().deleteRealmIfMigrationNeeded().build();
                    mReal2 = Realm.getInstance(conf);
                    RealmResults<DbClass> realm = mReal2.where(DbClass.class).findAll();
                    array = new JSONArray();
                    for (int i = 0; i < realm.size(); i++) {
                        JSONObject object = new JSONObject();
                        object.put("firstName", realm.get(i).getFirstName());
                        object.put("lastName", realm.get(i).getLastName());
                        array.put(object);
                    }

                } catch (Exception err) {

                } finally {
                    mReal.close();
                }
            }
        });

        get = (Button) findViewById(R.id.get);
        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.v("VALUES",""+array);
            }
        });
    }


}
