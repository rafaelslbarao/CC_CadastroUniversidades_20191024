package br.rafael.cadastrouniversidades;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private Button btCadastrarUniversidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        inicializaComponenetes();
    }

    private void inicializaComponenetes()
    {
        btCadastrarUniversidade = findViewById(R.id.btCadastrarUniversidade);
        btCadastrarUniversidade.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(
                        MainActivity.this
                        , CadastroUniversidadesActivity.class
                );
                startActivity(intent);
            }
        });
    }
}
