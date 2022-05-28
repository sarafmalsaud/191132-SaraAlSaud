package com.example.a191132_saraalsaud;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class deleteActivity extends AppCompatActivity {

    static String a;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_delete);

        EditText txtID = (EditText) findViewById(R.id.txtID);
        Button btnDelete = (Button) findViewById(R.id.btnDelete);

        StudentData stdata = new StudentData();


        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                a= txtID.getText().toString();

                stdata.delete(a).addOnSuccessListener(suc -> {

                    Toast.makeText(deleteActivity.this, "Data is deleted", Toast.LENGTH_LONG).show();

                }).addOnFailureListener(er -> {

                    Toast.makeText(deleteActivity.this, "" + er.getMessage(), Toast.LENGTH_LONG).show();

                });
            }
        });
    }
}