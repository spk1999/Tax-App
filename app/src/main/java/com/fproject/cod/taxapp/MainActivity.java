package com.fproject.cod.taxapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
EditText et_input;
TextView tv_res;
Button btn;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn=findViewById(R.id.btn);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                et_input=findViewById(R.id.et_salary);
                tv_res=findViewById(R.id.tv_output);

                if(et_input.getText().toString().length()<1 )
                {
                    et_input.setError("Please make sure you input valid Amount");
                }
                else
                {
                    int number=Integer.parseInt(et_input.getText().toString());
                    tv_res.setText(getTax(number));
                }
            }
        });
    }


    public String getTax(int number)
    {
        if(number >1 && number<=200000)
        {
            return "The tax is  Rs "+(0.01*number);
        }
        else if(number > 200000 && number<=350000)
        {
            int tax=number-200000;
            double fin=(0.01*number)+(0.15*tax);
            return "The tax is  Rs "+fin;
        }
        else if(number>350000)
        {
            int tax=number-350000;
           double fin=(0.01*number)+(0.15*150000)+(0.25*tax);
            return "The tax is  Rs "+fin;
        }
        return "wrong";
    }

}
