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
    private EditText editAppointment;
    private Button btnSchedule;
    private LinearLayout containerAppointments;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editVaccine = findViewById(R.id.editVaccine);
        btnAddVaccine = findViewById(R.id.btnAddVaccine);
        containerVaccines = findViewById(R.id.containerVaccines);
        editAppointment = findViewById(R.id.editAppointment);
        btnSchedule = findViewById(R.id.btnSchedule);
        containerAppointments = findViewById(R.id.containerAppointments);

        btnSchedule.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String info = editAppointment.getText().toString().trim();
                if (!info.isEmpty()) {
                    agregarConsultaDinamica(info);
                    editAppointment.setText("");
                }
            }
        });

        btnAddVaccine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String vaccineName = editVaccine.getText().toString().trim();

                if (!vaccineName.isEmpty()) {
                    registrarVacunaDinamica(vaccineName);
                    editVaccine.setText("");
                } else {
                    Toast.makeText(MainActivity.this, "Por favor, escribe el nombre de la vacuna", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void registrarVacunaDinamica(String nombreVacuna) {
        TextView nuevaVacunaEntry = new TextView(this);
        nuevaVacunaEntry.setText("💉 Vacuna aplicada: " + nombreVacuna);
        nuevaVacunaEntry.setTextSize(16);
        nuevaVacunaEntry.setPadding(0, 8, 0, 8);
        nuevaVacunaEntry.setTextColor(getResources().getColor(R.color.text_main));
        containerVaccines.addView(nuevaVacunaEntry, 0);
    }

    private void agregarConsultaDinamica(String datos) {
        TextView tv = new TextView(this);
        tv.setText("🗓️ Turno: " + datos);
        tv.setTextColor(getResources().getColor(R.color.white));
        tv.setTextSize(16);
        tv.setPadding(0, 8, 0, 8);
        containerAppointments.addView(tv, 0);
    }
}