package com.example.a191132_saraalsaud;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.PopupMenu;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RVadapter extends RecyclerView.Adapter<RecyclerView.ViewHolder>
{
    private Context context;
    ArrayList<Student> list = new ArrayList<>();
    public RVadapter(Context ctx)
    {
        this.context = ctx;
    }
    public void setItems(ArrayList<Student> student)
    {
        list.addAll(student);
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType)
    {
        View view = LayoutInflater.from(context).inflate(R.layout.layout_item,parent,false);
        return new StudentVH(view);
    }
    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position)
    {
        Student e = null;
        this.onBindViewHolder(holder,position,e);
    }

    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position, Student e)
    {
        StudentVH vh = (StudentVH) holder;
        Student student = e==null? list.get(position):e;
        vh.txt_name.setText(student.getName());
        vh.txt_id.setText(student.getID());
        vh.txt_surname.setText(student.getSurname());
        vh.txt_father.setText(student.getFather());
        vh.txt_national.setText(student.getNational());
        vh.txt_bday.setText(student.getBday());
        vh.txt_gender.setText(student.getGender());


    }

    @Override
    public int getItemCount()
    {
        return list.size();
    }
}