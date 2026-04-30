package com.example.parcial_1_am_acn4av_onorato_tiago;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editVaccine;
    private Button btnAddVaccine;
    private LinearLayout containerVaccines;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editVaccine = findViewById(R.id.editVaccine);
        btnAddVaccine = findViewById(R.id.btnAddVaccine);
        containerVaccines = findViewById(R.id.containerVaccines);

        btnAddVaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vaccineName = editVaccine.getText().toString().trim();

                if (!vaccineName.isEmpty()) {
                    registrarVacunaDinamica(vaccineName);
                    // Limpiamos el campo de texto
                    editVaccine.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, escribe el nombre de la vacuna", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }


    private void registrarVacunaDinamica(String nombreVacuna) {
        // Creamos un nuevo TextView mediante código
        TextView nuevaVacunaEntry = new TextView(this);

        // Configuramos sus propiedades
        nuevaVacunaEntry.setText("Vacuna aplicada: " + nombreVacuna);
        nuevaVacunaEntry.setTextSize(16);
        nuevaVacunaEntry.setPadding(0, 8, 0, 8);

        // Usamos los colores definidos en res/values/colors.xml
        nuevaVacunaEntry.setTextColor(getResources().getColor(R.color.text_main));

        containerVaccines.addView(nuevaVacunaEntry, 0); // El 0 lo agrega al principio de la lista
    }
}