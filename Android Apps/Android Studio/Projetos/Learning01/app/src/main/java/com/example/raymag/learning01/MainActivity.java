package com.example.raymag.learning01;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int exibir_segredo = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void revela(View view){
        TextView txt = (TextView) findViewById(R.id.textView);
        Button btShow = (Button) findViewById(R.id.btFirst);
        if(exibir_segredo==0){
                txt.setText(R.string.segredo);
                exibir_segredo = 1;
                btShow.setText(R.string.btAfter);

        }else{
            txt.setText("");
            exibir_segredo = 0;
            btShow.setText(R.string.btBefore);
        }
    }
}
