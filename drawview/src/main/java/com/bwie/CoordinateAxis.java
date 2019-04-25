package com.bwie;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CoordinateAxis extends AppCompatActivity {

    private EditText editX;
    private EditText editY;
    private Button add;
    private MediumDraw mediumDraw;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coordinate_axis);

        editX = findViewById(R.id.editX);
        editY = findViewById(R.id.editY);
        add = findViewById(R.id.add);
        mediumDraw = findViewById(R.id.mediumDraw);
        // mediumDraw = new MediumDraw(this);

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int X = Integer.parseInt(editX.getText().toString().trim());
                int Y = Integer.parseInt(editY.getText().toString().trim());
                if (TextUtils.isEmpty(editX.getText().toString().trim()) && TextUtils.isEmpty(editY.getText().toString().trim())) {
                    Toast.makeText(CoordinateAxis.this, "输入的值不能为空！", Toast.LENGTH_SHORT).show();
                } else {
                    mediumDraw.add(X, Y);
                }
            }
        });
    }
}
