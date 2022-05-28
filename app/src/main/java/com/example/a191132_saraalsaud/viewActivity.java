package com.example.a191132_saraalsaud;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class viewActivity extends AppCompatActivity
{
    SwipeRefreshLayout swipeRefreshLayout;
    RecyclerView recyclerView;
    RVadapter adapter;
    StudentData stdata;
    boolean isLoading=false;
    String key =null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view);
        swipeRefreshLayout = findViewById(R.id.swipe);
        recyclerView = findViewById(R.id.rv);
        recyclerView.setHasFixedSize(true);
        LinearLayoutManager manager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(manager);
        adapter= new RVadapter(this);
        recyclerView.setAdapter(adapter);
        stdata = new StudentData();
        loadData();
        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener()
        {
            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy)
            {
                LinearLayoutManager linearLayoutManager = (LinearLayoutManager) recyclerView.getLayoutManager();
                int totalItem = linearLayoutManager.getItemCount();
                int lastVisible = linearLayoutManager.findLastCompletelyVisibleItemPosition();
                if(totalItem< lastVisible+3)
                {
                    if(!isLoading)
                    {
                        isLoading=true;
                        loadData();
                    }
                }
            }
        });
    }

    private void loadData()
    {

        swipeRefreshLayout.setRefreshing(true);
        stdata.get(key).addListenerForSingleValueEvent(new ValueEventListener()
        {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot)
            {
                ArrayList<Student> students = new ArrayList<>();
                for (DataSnapshot data : snapshot.getChildren())
                {
                    Student student = data.getValue(Student.class);
                    student.setKey(data.getKey());
                    students.add(student);
                    key = data.getKey();
                }
                adapter.setItems(students);
                adapter.notifyDataSetChanged();
                isLoading =false;
                swipeRefreshLayout.setRefreshing(false);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error)
            {
                swipeRefreshLayout.setRefreshing(false);
            }
        });
    }
}