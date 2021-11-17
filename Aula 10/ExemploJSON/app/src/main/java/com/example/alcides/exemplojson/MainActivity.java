package com.example.alcides.exemplojson;

import android.content.Context;
import android.content.res.AssetManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView output = (TextView) findViewById(R.id.dados);
        String data = "Professores cadastrados \n\n";
        try {
            // loadJSON() retorna uma String com os dados em res/raw/dados.json:
           JSONObject objRaiz = new JSONObject(loadJSON());
           JSONArray jsonArray = objRaiz.optJSONArray("funcionarios");
           for(int i=0; i < jsonArray.length(); i++){
                JSONObject jsonObject = jsonArray.getJSONObject(i);
                String nome = jsonObject.optString("nome");
                data += "Nome: " + nome;
                JSONArray jsonDiscVet = jsonObject.getJSONArray("disciplinas");
                int cod;
                String disc="";
                for (int j=0;j<jsonDiscVet.length();j++){
                    JSONObject jsonDisc = jsonDiscVet.getJSONObject(j);
                    cod = jsonDisc.optInt("cod",0);
                    disc = jsonDisc.optString("nome");
                    data += "\nCod: "+cod+", Disc: " + disc;
                }
               data += "\n\n";
            }
            output.setText(data);
        } catch (JSONException e) {}
    }

    public String loadJSON() {
        String json = null;
        try {
            //fluxo de entrada que se encontra em res/raw/dados.json:
            InputStream is = this.getResources().openRawResource(R.raw.dados);
            int size = is.available();//retorna o n de bytes do arquivo
            byte[] buffer = new byte[size];
            final int res = is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json; //retorna uma String com os dados do vetor JSON
    }
}
