package com.example.registacijiski_obrazec;

import android.os.Bundle;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        Button button=findViewById(R.id.button);
        EditText ui=findViewById(R.id.editTextText2);
        EditText pi=findViewById(R.id.editTextText3);
        EditText dr=findViewById(R.id.editTextText4);
        EditText em=findViewById(R.id.editTextTextEmailAddress);
        EditText ts=findViewById(R.id.editTextPhone);
        EditText g=findViewById(R.id.editTextTextPassword7);
        RadioButton rb1=findViewById(R.id.radioButton);
        RadioButton rb2=findViewById(R.id.radioButton2);
        CheckBox cb=findViewById(R.id.checkBox);
        button.setOnClickListener(v -> {
            String uporabniskoime=ui.getText().toString();
            String polnoime=pi.getText().toString();
            String drzava=dr.getText().toString();
            String email=em.getText().toString();
            String telefon=ts.getText().toString();
            String geslo=g.getText().toString();
            String spol="";
            if(rb1.isChecked()){
                spol="M";
            }
            else if (rb2.isChecked()) {
                spol="Ž";
            }
            else{
                Toast.makeText(MainActivity.this, "Izberi spol", Toast.LENGTH_SHORT).show();
            }
            if(cb.isChecked()&&!g.equals("")&&!ts.equals("")&&!em.equals("")&&!dr.equals("")&&!pi.equals("")&&!ui.equals("")){
                new AlertDialog.Builder(MainActivity.this).setTitle("Registracijske podrobonosti").setMessage("Uporabniško ime: "+uporabniskoime+
                                                                                                                    "\nPolno ime: "+polnoime+
                                                                                                                    "\nDržava: "+drzava+
                                                                                                                    "\nEmail: "+email+
                                                                                                                    "\nTelefon: "+telefon+
                                                                                                                    "\nGeslo: "+geslo+
                                                                                                                    "\nSpol: "+spol+
                                                                                                                    "\nSprejeti pogoji storitve: DA"
                                                                                                                    ).setPositiveButton("Ok", null).show();
            }
            else{
                Toast.makeText(MainActivity.this, "Izpolni vsa polja", Toast.LENGTH_SHORT).show();
            }
        });
    }
}