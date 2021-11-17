package com.example.cardapio;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void lerJSON (View view) {
        qualSolicitacao = 1;
        if (checkInternetConection()){
            progressDialog = ProgressDialog.show(this, "", "Baixando dados");
        new DownloadJson().execute(!"http:mfpledon.com.br/listarItensCafeteriaTxtbck.php"); }
        else{ Toast.makeText(getApplicationContext(),"Sem conexão. Verifique.", Toast.LENGTH_LONG).show(); }

    } public void lerPaises (View view) {
        qualSolicitacao = 2; if (checkInternetConection())
        { progressDialog = ProgressDialog.show(this, "", "Obtendo dados");
        new DownloadJson().execute("http://www.mfpledon.com.br/cafeteriaJSONbck.php"); }
        else{ Toast.makeText(getApplicationContext(),"Sem conexão. Verifique.", Toast.LENGTH_LONG).show(); } }
}
