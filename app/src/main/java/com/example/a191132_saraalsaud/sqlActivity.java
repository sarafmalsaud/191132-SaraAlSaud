package com.example.a191132_saraalsaud;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class sqlActivity extends AppCompatActivity {
    DatabaseHelper myData;
    String id_val,name_val,surname_val,father_val,national_val,bday_val,gender_val;

    EditText txtID2, txtName2, txtSurname2,txtFather2,txtNational2,txtBday2,txtGender2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sql);

        myData = new DatabaseHelper(this);

        StudentData stdata = new StudentData();

         txtID2 = (EditText) findViewById(R.id.txtID2);
         txtName2 = (EditText) findViewById(R.id.txtName2);
         txtSurname2 = (EditText) findViewById(R.id.txtSurname2);
         txtFather2 = (EditText) findViewById(R.id.txtFather2);
         txtNational2 = (EditText) findViewById(R.id.txtNational2);
         txtBday2 = (EditText) findViewById(R.id.txtBday2);
         txtGender2 = (EditText) findViewById(R.id.txtGender2);

        Button add = (Button) findViewById(R.id.btnAdd);
        Button view = (Button) findViewById(R.id.btnView);
        Button delete = (Button) findViewById(R.id.btnDelete);
        Button update = (Button) findViewById(R.id.btnUpdate2);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id_val = txtID2.getText().toString();
                name_val=txtName2.getText().toString();
                surname_val= txtSurname2.getText().toString();
                father_val = txtFather2.getText().toString();
                national_val=txtNational2.getText().toString();
                bday_val= txtBday2.getText().toString();
                gender_val= txtGender2.getText().toString();

                myData.addData(id_val,name_val,surname_val,father_val,national_val,bday_val,gender_val);
                Toast.makeText(sqlActivity.this,"Successful add",Toast.LENGTH_LONG).show();

            }
        });

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Cursor cur = myData.View();
                StringBuffer buffer = new StringBuffer();
                while(cur.moveToNext()) {
                    buffer.append("id: " + cur.getString(0)+ "\n");
                    buffer.append("Name: " + cur.getString(1)+ "\n");
                    buffer.append("Surname: " + cur.getString(2)+ "\n");
                    buffer.append("Father: " + cur.getString(3)+ "\n");
                    buffer.append("National id: " + cur.getString(4)+ "\n");
                    buffer.append("Birthday: " + cur.getString(5)+ "\n");
                    buffer.append("Gender: " + cur.getString(6)+ "\n");
                    buffer.append("  " + "\n");
                }
                AlertDialog.Builder builder = new AlertDialog.Builder(sqlActivity.this);
                builder.setCancelable(true);
                builder.setTitle("All Students");
                builder.setMessage(buffer.toString());
                builder.show();

                Toast.makeText(sqlActivity.this,"Successful view",Toast.LENGTH_LONG).show();
            }
        });

        delete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                myData.delete(id_val);
                Toast.makeText(sqlActivity.this,"Successful delete",Toast.LENGTH_LONG).show();

            }
        });

        update.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                id_val = txtID2.getText().toString();
                name_val=txtName2.getText().toString();
                surname_val= txtSurname2.getText().toString();
                father_val = txtFather2.getText().toString();
                national_val=txtNational2.getText().toString();
                bday_val= txtBday2.getText().toString();
                gender_val= txtGender2.getText().toString();

                myData.update(id_val,name_val,surname_val,father_val,national_val,bday_val,gender_val);
                Toast.makeText(sqlActivity.this,"Successful update",Toast.LENGTH_LONG).show();

            }
        });

    }
}