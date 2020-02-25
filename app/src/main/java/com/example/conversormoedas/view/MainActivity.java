package com.example.conversormoedas.view;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.example.conversormoedas.R;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemSelectedListener {

    private BottomNavigationView bottomNavigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getSupportActionBar().hide();
        setContentView(R.layout.activity_main);

        iniciando_componentes();

        fragmentPrincpal();

    }

    public void iniciando_componentes() {
        bottomNavigationView = findViewById(R.id.bottom_navigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(this);

    }

    //Acao botoes navigation
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.home:
                fragmentPrincpal();
                break;

            case R.id.cotas:
                getSupportFragmentManager().beginTransaction().add(R.id.container_Fragment, new CotasFragment()).commit();
                break;

            case R.id.ajuda:

                break;

        }
        return true;
    }

    public void fragmentPrincpal() {
        getSupportFragmentManager().beginTransaction().add(R.id.container_Fragment, new MainFragment()).commit();
    }


    //metodo para ação do botao voltar (<) do dispositivo
    @Override
    public void onBackPressed() {
        new AlertDialog.Builder(this)
                .setIcon(android.R.drawable.ic_dialog_alert)
                .setTitle("Sair")
                .setMessage("Deseja sair do Aplicativo ?")
                .setPositiveButton("Sim", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        finish();
                    }

                })
                .setNegativeButton("Não", null)
                .show();
    }
}
