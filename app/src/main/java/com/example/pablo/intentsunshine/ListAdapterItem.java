package com.example.pablo.intentsunshine;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListAdapterItem<Object> extends ArrayAdapter<ClimaModel> {

    TextView dia;
    TextView temperatura;
    TextView clima;
    ImageView imagen;

    public ListAdapterItem(Context context, int resource, List<ClimaModel> objects) {
        super(context, resource, objects);

    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {


        ClimaModel clima1 = getItem(position);

        String diaItem= clima1.getDia();
        String temperaturaItem=clima1.getTemperatura();
        String climitaItem=clima1.getClima();
        int imagensita=clima1.getImagen();


        if (convertView==null) {
            convertView = LayoutInflater.from(getContext()).inflate(R.layout.list_item,parent,false);
        }

        dia = (TextView) convertView.findViewById(R.id.dia_item);
        temperatura= (TextView) convertView.findViewById(R.id.temperatura);
        clima= (TextView) convertView.findViewById(R.id.clima);
        imagen= (ImageView) convertView.findViewById(R.id.imagenClima);

            dia.setText(diaItem);
            temperatura.setText(temperaturaItem);
            clima.setText(climitaItem);
            imagen.setImageResource(imagensita);

        return convertView;

    }

}
