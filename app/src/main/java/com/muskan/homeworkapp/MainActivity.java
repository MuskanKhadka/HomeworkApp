package com.muskan.homeworkapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import com.muskan.homeworkapp.adapter.AdapterView;
import com.muskan.homeworkapp.model.DetailsClass;


public class MainActivity extends AppCompatActivity {
    EditText txname,txage;
    RadioButton rbf,rbm;
    RadioGroup radioGroup;
    Spinner spinnerimg;
    RecyclerView viewR;
    Button btnsave;
    String gender;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        txname=findViewById(R.id.txtname);
        txage=findViewById(R.id.txtage);
        rbf=findViewById(R.id.rbf);
        rbm=findViewById(R.id.rbm);
        spinnerimg=findViewById(R.id.spinimg);
        viewR=findViewById(R.id.recycleV);
        btnsave=findViewById(R.id.btnsave);
        radioGroup=findViewById(R.id.genderG);
        final List<DetailsClass> detailsClass= new ArrayList<>();
        final int[] title = {
                (R.drawable.bird),
                (R.drawable.cat),
                (R.drawable.fish),
                (R.drawable.pig),
                (R.drawable.rabbit),

        };
        final String[] titlenaME = {
                "bird",
                "cat",
                "fish",
                "pig",
                "rabbit",

        };
      final ArrayAdapter<String> imgtitle= new ArrayAdapter<>(MainActivity.this, android.R.layout.simple_list_item_1, titlenaME);
        spinnerimg.setAdapter(imgtitle);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int selectid = radioGroup.getCheckedRadioButtonId();
                RadioButton radioButton = findViewById(selectid);
                gender = radioButton.getText().toString();
                String name = txname.getText().toString();
                String age = (txage.getText().toString());
                int position = (spinnerimg.getSelectedItemPosition());
                int imageposition = title[position];
                detailsClass.add(new DetailsClass(name, age, gender, imageposition));
                AdapterView adapterView = new AdapterView(MainActivity.this,detailsClass);
                  viewR.setAdapter(adapterView);
                viewR.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                Toast.makeText(MainActivity.this, ""+name+age, Toast.LENGTH_SHORT).show();





            }
        });


    }


}


