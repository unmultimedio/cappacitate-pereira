package net.sikuani.preferencias;


import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;


/**
 * A simple {@link Fragment} subclass.
 */
public class FragmentUp extends Fragment {


    public FragmentUp() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_up, container, false);
    }

    public void buttonClicked(View view){
        SharedPreferences.Editor editor = (SharedPreferences.Editor) getActivity().getPreferences(Context.MODE_PRIVATE);
        EditText et;
        switch (view.getId()){
            case R.id.btn_string:
                et = (EditText) getActivity().findViewById(R.id.value_string);
                String text = et.getText().toString();
                if(!text.isEmpty()){
                    //editor.putString(llave, valor);
                    editor.putString("string",text);
                    editor.commit();
                    Toast.makeText(getActivity(), "Guardado!", Toast.LENGTH_SHORT).show();
                }else{
                    Toast.makeText(getActivity(), "Vacío, no guardado!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_int:
                et = (EditText) getActivity().findViewById(R.id.value_int);
                try {
                    int value = Integer.valueOf(et.getText().toString());
                    //editor.putString(llave, valor);
                    editor.putInt("int", value);
                    editor.commit();
                    Toast.makeText(getActivity(), "Guardado!", Toast.LENGTH_SHORT).show();
                }catch(Exception e){
                    Toast.makeText(getActivity(), "Hey ponte serio!", Toast.LENGTH_SHORT).show();
                }
                break;
            case R.id.btn_boolean:
                CheckBox cb = (CheckBox) getActivity().findViewById(R.id.value_boolean);
                editor.putBoolean("boolean",cb.isChecked());
                editor.commit();
                Toast.makeText(getActivity(), "Guardado!", Toast.LENGTH_SHORT).show();
                break;
        }
        ((MainActivity)getActivity()).refreshValues();
    }


}
