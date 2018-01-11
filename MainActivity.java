package com.example.fadla.project;


import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    RadioGroup radioGroup;
    RadioButton radioButton;
    TextView textView;
    RadioGroup radioGroup1;
    RadioButton radioButton1;
    Spinner sp;
    String  Spin;
    String names[] = {"1ST","2ND","3RD","CREW"};
    ArrayAdapter<String> adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        radioGroup = findViewById(R.id.radioGroup);
        radioGroup1 = findViewById(R.id.radioGroup1);


        Button buttonApply = findViewById(R.id.recherche);
        sp=(Spinner)findViewById(R.id.spinner);
        adapter= new ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,names);
        sp.setAdapter(adapter);
        sp.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i){
                    case 0:
                        Spin="1ST";
                        break;
                    case 1:
                        Spin="2ND";
                        break;
                    case 2:
                        Spin="3RD";
                        break;
                    case 3:
                        Spin="CREW";
                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

                Spin="Rien selectionner";
            }
        });


    }
    public void butt(View view){
        Intent myintent= new Intent(this,Main2Activity.class);
        int radioId = radioGroup.getCheckedRadioButtonId();

        radioButton = findViewById(radioId);
        int radioId1 = radioGroup1.getCheckedRadioButtonId();

        radioButton1 = findViewById(radioId1);
        Bundle b=new Bundle();
        b.putString("classe",Spin);
        b.putString("age",radioButton1.getText().toString());
        b.putString("sexe",radioButton.getText().toString());
        myintent.putExtras(b);
        startActivity(myintent);
    }

}
