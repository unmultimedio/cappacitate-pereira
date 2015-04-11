package net.sikuani.preferencias;

import android.content.SharedPreferences;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity {

    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        preferences = getPreferences(MODE_PRIVATE);
        editor = preferences.edit();
        refreshValues();
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void buttonClicked(View view){
        EditText et;
        switch (view.getId()){
            case R.id.btn_string:
                et = (EditText) findViewById(R.id.value_string);
                String text = et.getText().toString();
                if(!text.isEmpty()){
                    //editor.putString(llave, valor);
                    editor.putString("string",text);
                    editor.commit();
                    Toast.makeText(this, "Guardado!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(this, "Vacío, no guardado!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_int:
                et = (EditText) findViewById(R.id.value_int);
                try {
                    int value = Integer.valueOf(et.getText().toString());
                    //editor.putString(llave, valor);
                    editor.putInt("int", value);
                    editor.commit();
                    Toast.makeText(this, "Guardado!", Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(this, "Hey ponte serio!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_boolean:
                CheckBox cb = (CheckBox) findViewById(R.id.value_boolean);
                editor.putBoolean("boolean",cb.isChecked());
                editor.commit();
                Toast.makeText(this, "Guardado!", Toast.LENGTH_SHORT).show();
                break;
            case R.id.btn_clear:
                editor.clear();
                editor.commit();
                Toast.makeText(this, "Limpio!", Toast.LENGTH_SHORT).show();
                break;
        }
        refreshValues();
    }

    public void refreshValues(){

        String valString, valInt, valBoolean;

        String noValue = getResources().getString(R.string.no_value);

        valString = preferences.getString("string", noValue);
        if(preferences.contains("int")){
            valInt = String.valueOf(preferences.getInt("int",0));
        }else{
            valInt = noValue;
        }
        if(preferences.contains("boolean")){
            valBoolean = String.valueOf(preferences.getBoolean("boolean", false));
        }else{
            valBoolean = noValue;
        }

        TextView tvString, tvInt, tvBoolean;

        tvString = (TextView) findViewById(R.id.render_string);
        tvInt = (TextView) findViewById(R.id.render_int);
        tvBoolean = (TextView) findViewById(R.id.render_boolean);

        tvString.setText(valString);
        tvInt.setText(valInt);
        tvBoolean.setText(valBoolean);
    }
}
