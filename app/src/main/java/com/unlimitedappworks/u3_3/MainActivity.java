package com.unlimitedappworks.u3_3;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void click_main(View view) {
        if (view.getId() == R.id.btn_crear) {
            startActivity(new Intent(this, RegistroActivity.class).putExtra("tipo", 0));
        }else{
            startActivity(new Intent(this, ConsultaActivity.class));
        }
    }
}
