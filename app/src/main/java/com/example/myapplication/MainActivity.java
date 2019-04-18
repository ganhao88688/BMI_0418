package com.example.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText ed1,ed2,ed3;
    private TextView txv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getWindow().setBackgroundDrawableResource(R.drawable.bg);
    }
    int size=15;
    public void response(View v){

        ed1= findViewById(R.id.editText);
        ed2= findViewById(R.id.editText2);
        ed3= findViewById(R.id.editText3);
        txv= findViewById(R.id.textView);

        float height = Float.parseFloat(ed2.getText().toString());
        float weight = Float.parseFloat(ed3.getText().toString());
        float BMI1 = calculateBMI(height, weight);
        String BMI2 = String.valueOf(BMI1);

        txv.setTextSize(size);
        txv.setText(ed1.getText().toString() + "您好,\n" + "您的BMI是:" + BMI2);
        Toast.makeText(this, standardBMI(BMI1), Toast.LENGTH_LONG).show();
    }
    private float calculateBMI(float ht , float wt){
        float BMI = (float) (wt / Math.pow((ht/100) , 2));
                 return BMI;
    }
    private String standardBMI(double st){
        String alert="";
        if(st>25){
            alert=String.valueOf("you're too fat!!");
            getWindow().setBackgroundDrawableResource(R.drawable.fat);
        }
        else if(st<18.5){
            alert=String.valueOf("you're too thin!!");
            getWindow().setBackgroundDrawableResource(R.drawable.thin);
        }
        else {
            alert=String.valueOf("you have a nice body!!");
            getWindow().setBackgroundDrawableResource(R.drawable.bg);
        }
        return alert;

    }

}
