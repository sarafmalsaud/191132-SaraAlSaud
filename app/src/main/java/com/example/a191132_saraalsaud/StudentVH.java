package com.example.a191132_saraalsaud;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class StudentVH extends RecyclerView.ViewHolder
{
    public TextView txt_name,txt_id,txt_surname,txt_father,txt_national,txt_bday,txt_gender;
    public StudentVH(@NonNull View itemView)
    {
        super(itemView);
        txt_name = itemView.findViewById(R.id.txt_name);
        txt_id = itemView.findViewById(R.id.txt_id);
        txt_surname = itemView.findViewById(R.id.txt_surname);
        txt_father = itemView.findViewById(R.id.txt_father);
        txt_national = itemView.findViewById(R.id.txt_national);
        txt_bday = itemView.findViewById(R.id.txt_bday);
        txt_gender = itemView.findViewById(R.id.txt_gender);


    }
}