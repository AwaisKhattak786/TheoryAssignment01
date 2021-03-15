package com.example.calculator;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity  implements
        AdapterView.OnItemSelectedListener{
    String[] operators = { "Add", "Subtract", "Multiply", "Divide"};
    Button calculatorBtn;
    EditText value1Et;
    EditText value2Et;
    EditText resultEt;
    double calculations=0.0;
    String value1,value2;
    String spinerItem;
    double mode;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        value1Et=(EditText)findViewById(R.id.value1);
        value2Et=(EditText)findViewById(R.id.value2);
        resultEt=(EditText)findViewById(R.id.result);
        calculatorBtn=findViewById(R.id.cal_btn);
        calculatorBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i("work","working");
                value1=value1Et.getText().toString().trim();
                value2=value2Et.getText().toString().trim();

                if(value1!=null &&  value2!=null && spinerItem!=null){

                    Log.i("working",spinerItem);
                    switch (spinerItem){
                        case  ("Add"):{
                            calculations=Double.parseDouble(value1)+Double.parseDouble(value2);
                            break;
                        }
                        case  ("Subtract"):{
                            calculations=Double.parseDouble(value1)-Double.parseDouble(value2);
                            break;
                        }
                        case  ("Multiply"):{
                            calculations=Double.parseDouble(value1)*Double.parseDouble(value2);
                            break;
                        }
                        case  ("Divide"):{
                            calculations=Double.parseDouble(value1)/Double.parseDouble(value2);
                            mode=Double.parseDouble(value1)%Double.parseDouble(value2);

                            Log.i("mod",""+mode);
                            break;
                        }
                    }
                }else{
                    Toast.makeText(MainActivity.this, "Something is missing", Toast.LENGTH_SHORT).show();
                }
                if(spinerItem=="Divide"){
                    resultEt.setText(""+(int)calculations+""+"  R:   "+(int)mode);
                }else{
                    resultEt.setText(""+(int)calculations);
                }

            }
        });
//
        Spinner myspin = (Spinner) findViewById(R.id.spinner);
        myspin.setOnItemSelectedListener(this);
        ArrayAdapter myadapter = new ArrayAdapter(this,android.R.layout.simple_spinner_item,operators);
        myadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        myspin.setAdapter(myadapter);
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        spinerItem=operators[position];
        Toast.makeText(getApplicationContext(),operators[position] , Toast.LENGTH_LONG).show();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}