package net.sikuani.cappacitatepereira;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Toast aviso;
        //aviso = Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT);
        //aviso.show();

        Toast.makeText(this, "onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "onStart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        Toast.makeText(this, "onPause()", Toast.LENGTH_SHORT).show();
        super.onPause();
    }

    @Override
    protected void onStop() {
        Toast.makeText(this, "onStop()", Toast.LENGTH_SHORT).show();
        super.onStop();
    }

    @Override
    protected void onDestroy() {
        Toast.makeText(this, "onDestroy()", Toast.LENGTH_SHORT).show();
        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "onRestart()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

       switch (item.getItemId()){
           case R.id.new_item:
               String texto = getResources().getString(R.string.toast_new);
               Toast.makeText(this,texto,Toast.LENGTH_SHORT).show();
               break;
           case R.id.search_item:
               Intent intent = new Intent(this, ResponseActivity.class);
               startActivity(intent);
               break;
           case R.id.action_settings:
               EditText et = (EditText)findViewById(R.id.editText);
               et.setText("");
               break;
       }

        return true;

    }

    public void sendData(View view) {

        EditText et = (EditText)findViewById(R.id.editText);

        String texto = et.getText().toString();

        Toast.makeText(this, texto, Toast.LENGTH_SHORT).show();

        Intent call2second = new Intent(this, SecondActivity.class);

        call2second.putExtra("value", texto);

        //Ejecutar o lanzar la segunda actividad
        startActivity(call2second);

    }
}
