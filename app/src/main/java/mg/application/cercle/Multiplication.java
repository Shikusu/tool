package mg.application.cercle;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Objects;

public class Multiplication extends AppCompatActivity {
    TextView blabla;
    EditText tableSample;
    Button btnTable;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_multiplication);
        tableSample =findViewById(R.id.etTable) ;
        btnTable =findViewById(R.id.btnTable);
        blabla=findViewById(R.id.reponse);
        blabla.setVisibility(TextView.INVISIBLE);
        btnTable.setOnClickListener(v -> {
            String valueStr = tableSample.getText().toString().trim();
            if (valueStr.isEmpty()) {
                Toast.makeText(this, "Choix non fait", Toast.LENGTH_SHORT).show();
                return;
            }
            int value = Integer.parseInt(tableSample.getText().toString());
            if (value<0 || 10<value){
                Toast.makeText(this,"Non valide",Toast.LENGTH_SHORT).show();
                blabla.setVisibility(TextView.GONE);
                return;
            }
            blabla.setVisibility(TextView.VISIBLE);
            blabla.setText(tableMultiplication(value));
        });

    }
     private static String tableMultiplication(int a) {
            StringBuilder result = new StringBuilder();

            for (int i = 1; i <= 10; i++) {
                result.append(a).append(" x ").append(i).append(" = ").append(a * i).append("\n");
            }
            return result.toString();
        }
}
