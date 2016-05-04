package com.unlimitedappworks.u3_3;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class ConsultaActivity extends AppCompatActivity {

    private EditText edt_busqueda;
    private ListView lst_res;
    private EnlaceBD enlaceBD;
    private ArrayList<Votante> votantes;
    private ArrayList<String> nombres;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consulta);
        edt_busqueda = (EditText) findViewById(R.id.edt_busqueda);
        lst_res = (ListView) findViewById(R.id.lsv_resultados);
        enlaceBD = new EnlaceBD(this);
        lst_res.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(ConsultaActivity.this, RegistroActivity.class);
                intent.putExtra("ife", votantes.get(position).getIfe());
                intent.putExtra("nombre", votantes.get(position).getNombre());
                intent.putExtra("dir", votantes.get(position).getDireccion_de_voto());
                intent.putExtra("num", votantes.get(position).getNum_casilla());
                intent.putExtra("tipo", 1);
                startActivityForResult(intent, 1);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        busc();
    }

    public void buscar(View view) {
        busc();
    }

    private void busc() {
        votantes = new ArrayList<>();
        nombres = new ArrayList<>();
        Cursor cursor = enlaceBD.consulta("select *  from votantes where ife like'%" +
                edt_busqueda.getText().toString() + "%';");
        while (cursor.moveToNext()) {
            votantes.add(new Votante(cursor.getString(cursor.getColumnIndex("ife")),
                    cursor.getString(cursor.getColumnIndex("nombre_votante")),
                    cursor.getString(cursor.getColumnIndex("direccion")),
                    cursor.getInt(cursor.getColumnIndex("num_casilla"))));
            nombres.add(cursor.getString(cursor.getColumnIndex("nombre_votante")));
        }
        ArrayAdapter<String> adapter =
                new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, nombres);
        lst_res.setAdapter(adapter);
    }
}
