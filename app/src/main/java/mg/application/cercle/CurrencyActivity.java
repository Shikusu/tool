package mg.application.cercle;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONObject;

import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;

public class CurrencyActivity extends AppCompatActivity {
    private EditText etAmount;
    private Spinner spinnerFrom, spinnerTo;
    private LinearLayout resultCard;
    private TextView tvResult, tvRate;

    private final Map<String, Double> ratesFromUsd = new HashMap<>();
    private final List<String> currencies = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_currency);

        etAmount = findViewById(R.id.etAmount);
        spinnerFrom = findViewById(R.id.spinnerFrom);
        spinnerTo = findViewById(R.id.spinnerTo);
        resultCard = findViewById(R.id.resultCard);
        tvResult = findViewById(R.id.tvResult);
        tvRate = findViewById(R.id.tvRate);

        loadCurrencyData();

        ArrayAdapter<String> adapter = new ArrayAdapter<>(
                this, R.layout.curency_list, currencies);
        adapter.setDropDownViewResource(R.layout.currency_dropdown);

        spinnerFrom.setAdapter(adapter);
        spinnerTo.setAdapter(adapter);

        if (currencies.size() > 1) {
            spinnerTo.setSelection(1);
        }

        Button btnConvert = findViewById(R.id.btnConvert);
        btnConvert.setOnClickListener(v -> convert());
    }

    private void loadCurrencyData() {
        try {
            InputStream is = getAssets().open("currencies.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();

            String jsonString = new String(buffer, StandardCharsets.UTF_8);
            JSONObject jsonObject = new JSONObject(jsonString);

            Iterator<String> keys = jsonObject.keys();
            while (keys.hasNext()) {
                String key = keys.next();
                double value = jsonObject.getDouble(key);

                ratesFromUsd.put(key, value);
                currencies.add(key);
            }
        } catch (Exception e) {
            Log.e("Error",e.toString());
            Toast.makeText(this, "Error loading currency data", Toast.LENGTH_SHORT).show();
        }
    }

    private void convert() {
        String amountStr = etAmount.getText().toString().trim();
        if (amountStr.isEmpty()) {
            Toast.makeText(this, "Veuillez entrer la somme", Toast.LENGTH_SHORT).show();
            return;
        }

        double amount = Double.parseDouble(amountStr);
        String from = spinnerFrom.getSelectedItem().toString();
        String to = spinnerTo.getSelectedItem().toString();

        if (from.equals(to)) {
            tvResult.setText(String.format(Locale.getDefault(), "%.2f %s", amount, to));
            tvRate.setText(R.string.monnaie_identique);
            resultCard.setVisibility(View.VISIBLE);
            return;
        }

        Double fromRate = ratesFromUsd.get(from);
        Double toRate = ratesFromUsd.get(to);

        if (fromRate == null || toRate == null) {
            Toast.makeText(this, "Calcul impossible", Toast.LENGTH_SHORT).show();
            return;
        }

        double converted = (amount / fromRate) * toRate;
        double rate = toRate / fromRate;

        tvResult.setText(String.format(Locale.getDefault(), "%.2f %s", converted, to));
        tvRate.setText(String.format(Locale.getDefault(), "1 %s = %.4f %s", from, rate, to));
        resultCard.setVisibility(View.VISIBLE);
    }

    @Override
    public boolean onSupportNavigateUp() {
        finish();
        return true;
    }
}