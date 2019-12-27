package mytextviewapp.add.com.convertapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {
    EditText texttemp;
    Button c_button;
    Button f_button;
    TextView show_temp;
    DecimalFormat random=new DecimalFormat("0.0");
    private static final String TAG="Main Activity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        texttemp=findViewById(R.id.temp_v);
        c_button=findViewById(R.id.c_id);
        f_button=findViewById(R.id.f_id);
        show_temp=findViewById(R.id.show_id);
        c_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String temp=texttemp.getText().toString();
                if(temp.isEmpty()){
                    Toast.makeText(getApplicationContext(),"please enter value",Toast.LENGTH_LONG).show();
                    Log.v(TAG,"hello from here");
                }
                else {
                    double value=Double.parseDouble(temp);
                    double conv=converttocelicuis(value);
                    show_temp.setText(String.valueOf(random.format(conv))+"C");
                    texttemp.setText("");
                }





            }
        });
        f_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String value=texttemp.getText().toString();
                if(value.isEmpty()){
                    Toast.makeText(getApplicationContext(),"please Enter value",Toast.LENGTH_LONG).show();
                }
                else{
                    double temp=Double.parseDouble(value);
                    double conv=converttofahr(temp);
                    show_temp.setText(String.valueOf(random.format(conv))+"F");
                    texttemp.setText("");

                }

            }
        });

    }
    public double converttocelicuis(double temp){
        double c;
        c=(temp-32)*5/9;
        return c;
    }
    public double converttofahr(double temp){
        double f;
        f=temp * 5/9 + 32;
        return f;
    }
}
