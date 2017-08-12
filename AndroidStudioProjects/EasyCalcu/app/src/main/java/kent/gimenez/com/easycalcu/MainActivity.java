package kent.gimenez.com.easycalcu;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AlertDialog.Builder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;



public class MainActivity extends AppCompatActivity{

    private EditText FirstNumber;
    private EditText SecondNumber;
    private TextView Answer;
    private String firsttext, secondtext;
    private double n1, n2;
    private double result;

    Operation m = new Operation ();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


    }

    private void findViewById() {

        FirstNumber = (EditText) findViewById(R.id.firstnum);
        SecondNumber =  (EditText) findViewById(R.id.secondnum);
        Answer =(TextView) findViewById(R.id.result);

        firsttext = FirstNumber.getText().toString();
        secondtext = SecondNumber.getText().toString();

        n1 = Double.parseDouble(firsttext);
        n2 = Double.parseDouble(secondtext);



    }


    public void add (View v) {


        if (FirstNumber.getText().toString().isEmpty()) {


            Toast.makeText(this, "asdad", Toast.LENGTH_SHORT).show();

        }

        else if(SecondNumber.getText().toString().isEmpty()) {
            Toast.makeText(this, "asdad", Toast.LENGTH_SHORT).show();
        }


        else {
            findViewById();
            DecimalFormat formatter = new DecimalFormat("#,###.##");
            result = m.add(n1, n2);
            String formatted = formatter.format(result);
            Answer.setText(String.valueOf(result));
            Answer.setText(formatted);


        }
    }
    public void minus (View v) {

        findViewById();

        DecimalFormat formatter = new DecimalFormat("#,###.##");
        result = m.minus(n1, n2);
        String formatted  = formatter.format(result);
        Answer.setText(String.valueOf(result));
        Answer.setText(formatted);
    }

    public void multiply (View v) {
        findViewById();
        DecimalFormat formatter = new DecimalFormat("#,###.##");
        result = m.multiply(n1, n2);
        String formatted  = formatter.format(result);
        Answer.setText(String.valueOf(result));
        Answer.setText(formatted);
    }

    public void divide (View v) {

        findViewById();
        DecimalFormat formatter = new DecimalFormat("#,###.##");
        result = m.divide(n1, n2);
        String formatted  = formatter.format(result);
        Answer.setText(String.valueOf(result));
        Answer.setText(formatted);
    }

    public void clear (View v) {
        FirstNumber.setText("");
        SecondNumber.setText("");
        Answer.setText("");
    }

    public void exit (View v) {

        finish();
        System.exit(0);

    }


}
