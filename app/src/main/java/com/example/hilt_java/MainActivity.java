package com.example.hilt_java;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.hilt_java.Models.card;
import com.example.hilt_java.Models.data;
import com.example.hilt_java.UI.RetModelView;
import com.example.hilt_java.UI.RoomModelView;

import javax.inject.Inject;

import dagger.hilt.android.AndroidEntryPoint;

@AndroidEntryPoint
public class MainActivity extends AppCompatActivity {

    public RetModelView retModelView;
    public RoomModelView roomModelView;
    public TextView text;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        text = findViewById(R.id.t1);
        retModelView = ViewModelProviders.of(this).get(RetModelView.class);
        retModelView.getData();
        retModelView.getSingleMutableLiveData().observe(this, data -> text.setText(data.getName()));
    }
}