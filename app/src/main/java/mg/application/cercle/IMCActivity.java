package mg.application.cercle;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class IMCActivity extends AppCompatActivity {
    TextView blabla;
    EditText poid, taille;
    Button calculer;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imcactivity);
        taille=findViewById(R.id.etTaille);
        poid=findViewById(R.id.etPoids);
        blabla=findViewById(R.id.reponse);
        blabla.setVisibility(TextView.INVISIBLE);
        calculer=findViewById(R.id.btnIMC);

        calculer.setOnClickListener(v -> {

            String tailleStr = taille.getText().toString().trim();
            if (tailleStr.isEmpty()) {
                Toast.makeText(this, "Veuillez entrer votre taille", Toast.LENGTH_SHORT).show();
                return;
            }
            String poidStr = poid.getText().toString().trim();
            if (poidStr.isEmpty()) {
                Toast.makeText(this, "Veuillez entrer votre poids", Toast.LENGTH_SHORT).show();
                return;
            }
            double tailleEnD, poidEnD,result;
            poidEnD=Double.parseDouble(poid.getText().toString());

            tailleEnD=Double.parseDouble(taille.getText().toString());
            result = poidEnD/(tailleEnD*tailleEnD);
            blabla.setVisibility(TextView.VISIBLE);
            blabla.setText(String.format("Votre IMC est %.1f. Vous êtes en %s",result,status(result)));
        });

    }
        private static String status(double imc) {
            if (imc < 16.5) {
                return "Dénutrition ou famine";
            } else if (imc >= 16.5 && imc < 18.5) {
                return "Maigreur";
            } else if (imc >= 18.5 && imc < 25) {
                return "Corpulence normale";
            } else if (imc >= 25 && imc < 30) {
                return "Surpoids";
            } else if (imc >= 30 && imc < 35) {
                return "Obésité modérée";
            } else if (imc >= 35 && imc < 40) {
                return "Obésité sévère";
            } else {
                return "Obésité morbide";
            }
        }

}