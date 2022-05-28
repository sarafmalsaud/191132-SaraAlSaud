package com.example.a191132_saraalsaud;

import static android.content.ContentValues.TAG;

import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

import java.util.HashMap;
import java.util.Iterator;

public class StudentData {

    private DatabaseReference databaseReference;

     public StudentData() {

         FirebaseDatabase db = FirebaseDatabase.getInstance();

        databaseReference = db.getReference(Student.class.getSimpleName());

     }


         public Task<Void> add(Student student){


         return databaseReference.child(MainActivity.a).setValue(student);

         }

         public Task<Void> update(String key, HashMap<String ,Object> hashMap){

          return databaseReference.child(key).updateChildren(hashMap);

         }


    public Task<Void> delete(String key){

        return databaseReference.child(key).removeValue();

    }





    public Query get(String key)
    {
        if(key == null)
        {
            return databaseReference.orderByKey().limitToFirst(8);
        }
        return databaseReference.orderByKey().startAfter(key).limitToFirst(8);
    }

    public Query get()
    {
        return databaseReference;
    }
     }


