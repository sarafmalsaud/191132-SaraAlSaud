package com.example.a191132_saraalsaud;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    static String a;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        EditText txtID = (EditText) findViewById(R.id.txtID);
        EditText txtName = (EditText) findViewById(R.id.txtName);
        EditText txtSurname = (EditText) findViewById(R.id.txtSurname);
        EditText txtFather = (EditText) findViewById(R.id.txtFather);
        EditText txtNational = (EditText) findViewById(R.id.txtNational);
        EditText txtBday = (EditText) findViewById(R.id.txtBday);
        EditText txtGender = (EditText) findViewById(R.id.txtGender);
        Button btnSubmit = (Button) findViewById(R.id.btnSubmit);
        Button btngoupdate = (Button) findViewById(R.id.btngoupdate);
        Button btngodelete = (Button) findViewById(R.id.btngodelete);
        Button btngoview = (Button) findViewById(R.id.btngoview);
        Button btngoweather = (Button) findViewById(R.id.btngoweather);
        Button btngosql = (Button) findViewById(R.id.btngosql);

        StudentData stdata = new StudentData();


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                a= txtID.getText().toString();

                Student student = new Student(txtID.getText().toString(), txtName.getText().toString(),
                        txtSurname.getText().toString(), txtFather.getText().toString(), txtNational.getText().toString(),
                        txtBday.getText().toString(), txtGender.getText().toString());



                stdata.add(student).addOnSuccessListener(suc -> {

                    Toast.makeText(MainActivity.this, "Data is inserted", Toast.LENGTH_LONG).show();

                }).addOnFailureListener(er -> {

                    Toast.makeText(MainActivity.this, "" + er.getMessage(), Toast.LENGTH_LONG).show();

                });

            }
        });

        btngoupdate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,updateActivity.class));
            }
        });

        btngodelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,deleteActivity.class));
            }
        });

        btngoview.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,viewActivity.class));
            }
        });

        btngoweather.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,weatherActivity.class));
            }
        });

        btngosql.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity.this,sqlActivity.class));
            }
        });


    }
}


