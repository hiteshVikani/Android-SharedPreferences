package parallel.sharedpreferences;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

/**
 * Created by acer on 12-Aug-16.
 */
public class NextActivity extends AppCompatActivity {

    TextView txtResult;
    SharedPreferences shp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.nextactivity);
        txtResult = (TextView) findViewById(R.id.txtResult);
        shp = this.getSharedPreferences("myPreferences", MODE_PRIVATE);

        String name = shp.getString("name", "0.00");
        String num = String.valueOf(shp.getInt("num", 0));
        Boolean b = shp.getBoolean("bool", false);

        txtResult.setText("Hi " + name + ", your favourite number is " + num + ". And you gave answer as " + String.valueOf(b));

    }
}
