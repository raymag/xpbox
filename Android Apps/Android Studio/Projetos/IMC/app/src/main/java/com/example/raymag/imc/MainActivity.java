package com.example.raymag.imc;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.EditText;

import org.w3c.dom.Text;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    public double imc;
    public NumberFormat formater = NumberFormat.getInstance();
    public String gravidade = "teste";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setImcGravity(){
        if(imc>=40){
            gravidade = "Obesidade Mórbida";
        }
        else if(imc>=35 && imc<40){
            gravidade = "Obesidade Servera";
        }
        else if(imc>=30 && imc<35){
            gravidade = "Obesidade Grau I";
        }
        else if(imc>=25 && imc<30){
            gravidade = "Sobrepeso";
        }
        else if(imc>=18.5 && imc<25){
            gravidade = "Saudável";
        }
        else if(imc>=17 && imc<18.5){
            gravidade = "Magreza Leve";
        }
        else if(imc>=16 && imc<17){
            gravidade = "Magreza Moderada";
        }
        else if(imc<16){
            gravidade = "Magreza Grave";
        }
    }

    private void showImc(){
        setImcGravity();
        TextView lbImcResult = (TextView) findViewById(R.id.textView3);
        TextView lbImcGravity = (TextView) findViewById(R.id.textView4);
        lbImcResult.setText(formater.format(imc));
        lbImcGravity.setText(gravidade);
    }

    public void solveImc(View view){
        EditText heightField = (EditText) findViewById(R.id.editText);
        EditText weightField = (EditText) findViewById(R.id.editText2);
        float height = Float.parseFloat(String.valueOf(heightField.getText()));
        float weight = Float.parseFloat(String.valueOf(weightField.getText()));
        imc = weight/Math.pow(height, 2);
        showImc();

    }
}
