package parallel.sharedpreferences;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Created by acer on 12-Aug-16.
 */
public class UserInput extends AppCompatActivity {

    Button btnNext, btnClear;
    EditText edtName, edtNum, edtboolean;
    SharedPreferences shp;
    SharedPreferences.Editor shpeditor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.userinput);
        btnNext = (Button) findViewById(R.id.btnNext);
        btnClear = (Button) findViewById(R.id.btnClear);
        edtName = (EditText) findViewById(R.id.edtname);
        edtNum = (EditText) findViewById(R.id.edtnum);
        edtboolean = (EditText) findViewById(R.id.edtboolean);

        shp = this.getSharedPreferences("myPreferences", MODE_PRIVATE);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shpeditor = shp.edit();
                shpeditor.putString("name", edtName.getText().toString());
                int num = Integer.parseInt(edtNum.getText().toString());
                shpeditor.putInt("num", num);
                Boolean b = Boolean.parseBoolean(edtboolean.getText().toString());
                shpeditor.putBoolean("bool", b);
                shpeditor.commit();
                Intent i = new Intent(UserInput.this,NextActivity.class);
                startActivity(i);
            }
        });
    }
}
