package com.example.layoutstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.LinearLayout;

public class MenuActivity extends AppCompatActivity {

    LinearLayout container; // container view 추가.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        container = findViewById(R.id.container);
        Button button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                LayoutInflater inflater = (LayoutInflater) getSystemService(Context.LAYOUT_INFLATER_SERVICE);
                //getSystemService 를 이용해 Layout Inflator 사용.

                inflater.inflate(R.layout.sub1, container, true); // (붙일 리소스, 붙여질 컨테이너(부분 레이아웃),붙일건지 말건지 boolean)
                CheckBox checkBox = container.findViewById(R.id.checkBox); // container 객체에 연결된 레이아웃에 붙어야되므로 이렇게 사용한다.
                checkBox.setText("Loading Complete.");

            }
        });

    }
}