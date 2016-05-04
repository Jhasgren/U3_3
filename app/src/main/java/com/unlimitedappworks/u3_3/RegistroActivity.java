package com.unlimitedappworks.u3_3;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegistroActivity extends AppCompatActivity {

    private EnlaceBD enlaceBD;
    private EditText ife, nombre, dir, num;
    private Button btn_crear, btn_moficar, btn_borrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
        ife = (EditText) findViewById(R.id.edt_ife);
        nombre = (EditText) findViewById(R.id.edt_nombre);
        dir = (EditText) findViewById(R.id.edt_dir);
        num = (EditText) findViewById(R.id.edt_numc);
        btn_crear = (Button) findViewById(R.id.btn_crear);
        btn_moficar = (Button) findViewById(R.id.btn_modificar);
        btn_borrar = (Button) findViewById(R.id.btn_borrar);
        enlaceBD = new EnlaceBD(this);
        if (getIntent().getIntExtra("tipo", 0) == 0) {
            btn_moficar.setVisibility(View.GONE);
            btn_borrar.setVisibility(View.GONE);
            btn_crear.setVisibility(View.VISIBLE);
        } else {
            btn_moficar.setVisibility(View.VISIBLE);
            btn_borrar.setVisibility(View.VISIBLE);
            btn_crear.setVisibility(View.GONE);
            ife.setText(getIntent().getStringExtra("ife"));
            nombre.setText(getIntent().getStringExtra("nombre"));
            dir.setText(getIntent().getStringExtra("dir"));
            num.setText(String.valueOf(getIntent().getIntExtra("num", 0)));
        }
    }

    public void accion(View view) {
        switch (view.getId()) {
            case R.id.btn_crear:
                enlaceBD.execSQL("insert into votantes values('" + ife.getText().toString() + "', '" + nombre.getText().toString() +
                        "', '" + dir.getText().toString() + "', " + num.getText().toString() + ");");
                Toast.makeText(RegistroActivity.this, "Registro creado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_modificar:
                enlaceBD.execSQL("update votantes set ife='" + ife.getText().toString() +
                        "', nombre_votante='" + nombre.getText() + "', direccion='" + dir.getText().toString() +
                        "', num_casilla=" + num.getText().toString() + " where ife='" + getIntent().getStringExtra("ife") + "'");
                Toast.makeText(RegistroActivity.this, "Registro modificado", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_borrar:
                enlaceBD.execSQL("delete from votantes where ife='" + getIntent().getStringExtra("ife") + "'");
                Toast.makeText(RegistroActivity.this, "Registro borrado", Toast.LENGTH_SHORT).show();
                break;
        }
        finish();
    }
}
