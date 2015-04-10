package net.sikuani.menucontextual;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

import java.util.List;
import java.util.Objects;

/**
 * Created by julian on 4/10/15.
 */
public class CustomAdapter extends ArrayAdapter<String> {

    Context myContext;
    int myResource;
    List<String> myObjects;

    public CustomAdapter(Context context, int resource, List<String> objects) {
        super(context, resource, objects);

        myContext = context;
        myResource = resource;
        myObjects= objects;

    }

    /*
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        String val = myObjects.get(position);

        LayoutInflater inflater =
        (LayoutInflater) myContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //inflater.inflate();

    }
    */
}
