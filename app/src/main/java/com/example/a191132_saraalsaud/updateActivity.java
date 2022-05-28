package com.example.a191132_saraalsaud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.HashMap;

public class updateActivity extends AppCompatActivity {

    static String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_update);


        EditText txtID = (EditText) findViewById(R.id.txtID);
        EditText txtName = (EditText) findViewById(R.id.txtName);
        EditText txtSurname = (EditText) findViewById(R.id.txtSurname);
        EditText txtFather = (EditText) findViewById(R.id.txtFather);
        EditText txtNational = (EditText) findViewById(R.id.txtNational);
        EditText txtBday = (EditText) findViewById(R.id.txtBday);
        EditText txtGender = (EditText) findViewById(R.id.txtGender);
        Button btnUpdate = (Button) findViewById(R.id.btnUpdate);


        StudentData stdata = new StudentData();


        btnUpdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a= txtID.getText().toString();
                HashMap<String, Object> hashMap = new HashMap<>();
                hashMap.put("ID", txtID.getText().toString());
                hashMap.put("name", txtName.getText().toString());
                hashMap.put("surname", txtSurname.getText().toString());
                hashMap.put("father", txtFather.getText().toString());
                hashMap.put("national", txtNational.getText().toString());
                hashMap.put("bday", txtBday.getText().toString());
                hashMap.put("gender", txtGender.getText().toString());

                stdata.update(a , hashMap).addOnSuccessListener(suc -> {

                    Toast.makeText(updateActivity.this, "Data is updated", Toast.LENGTH_LONG).show();

                }).addOnFailureListener(er -> {

                    Toast.makeText(updateActivity.this, "" + er.getMessage(), Toast.LENGTH_LONG).show();

                });
            }
        });


    }
}