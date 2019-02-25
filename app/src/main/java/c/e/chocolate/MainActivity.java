package c.e.chocolate;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    Button btn , plus , minus, reset  ;
    TextView quant ;
    CheckBox crm ,chk ;
    int coff = 0;
    int total = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn = findViewById(R.id.button5);
        plus = findViewById(R.id.button4);
        minus = findViewById(R.id.button2);
        reset = findViewById(R.id.button6);

        quant = findViewById(R.id.textView5);

        crm = findViewById(R.id.checkBox5);
        chk = findViewById(R.id.checkBox6);

        minus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(coff>0)
                    coff--;
                quant.setText(String.valueOf(coff));

            }
        });
        plus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            coff++;
            quant.setText(String.valueOf(coff));
            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total = coff*10;
                if(crm.isChecked() && coff>0)
                {
                    total +=5*coff;
                }
                if(chk.isChecked() && coff >0)
                {
                    total += 5*coff;
                }
                if(coff>0) {
                if(crm.isChecked() && chk.isChecked()) {
                    Toast.makeText(MainActivity.this, " you have selected " + String.valueOf(coff) + " coffee with whipped Cream and Chococale. your Bill Is " + String.valueOf(total),
                            Toast.LENGTH_SHORT).show();
                }else if(crm.isChecked()) {
                    Toast.makeText(MainActivity.this, " you have selected " + String.valueOf(coff) + " coffee with whipped Cream. your Bill Is " + String.valueOf(total),Toast.LENGTH_SHORT).show();
                }else if(chk.isChecked()) {
                    Toast.makeText(MainActivity.this, " you have selected " + String.valueOf(coff) + " coffee with whipped Chococale. your Bill Is " + String.valueOf(total), Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(MainActivity.this, " you have selected " + String.valueOf(coff) + " coffee with No Toppings. your Bill Is " + String.valueOf(total), Toast.LENGTH_SHORT).show();
                }
                }
                else
                {
                    Toast.makeText(MainActivity.this, " No Coffee selected...", Toast.LENGTH_SHORT).show();
                }
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                total=0;
                coff=0;
                quant.setText(String.valueOf(coff));
                crm.setChecked(false);
                chk.setChecked(false);
            }
        });



    }
}
