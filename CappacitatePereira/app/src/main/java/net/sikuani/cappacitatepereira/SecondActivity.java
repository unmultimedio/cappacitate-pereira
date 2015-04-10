package net.sikuani.cappacitatepereira;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

/**
 * Created by julian on 4/10/15.
 */
public class SecondActivity extends MainActivity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.second_activity);

        /*
        Intent miIntent = getIntent();
        String value = miIntent.getStringExtra("value");
        TextView tv = (TextView)findViewById(R.id.textViewRender);
        tv.setText(value);
        */

        ((TextView)findViewById(R.id.textViewRender)).
                setText((getIntent().getStringExtra("value")));

    }
}
