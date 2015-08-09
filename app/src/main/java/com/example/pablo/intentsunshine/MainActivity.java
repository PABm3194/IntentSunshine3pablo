package com.example.pablo.intentsunshine;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;


public class MainActivity extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        ListAdapterItem adapterItem;

        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);

            ListView listView = (ListView) rootView.findViewById(R.id.listview_fragment);



            ClimaModel clima1 = new ClimaModel("lunes","22º/18º","Medio nublado",R.drawable.ic_launcher);
            ClimaModel clima2 = new ClimaModel("Martes","22º/18º","Medio nublado",R.drawable.ic_launcher);
            ClimaModel clima3 = new ClimaModel("Miercoles","22º/18º","Medio nublado",R.drawable.ic_launcher);
            ClimaModel clima4 = new ClimaModel("Jueves","25º/18º","Medio nublado",R.drawable.ic_launcher);
            ClimaModel clima5 = new ClimaModel("Viernes", "27º/18º","Soleado",R.drawable.ic_launcher);
            ClimaModel clima6 = new ClimaModel("Sabado", "19º/18º","Nublado",R.drawable.ic_launcher);
            ClimaModel clima7 = new ClimaModel("Domingo","19º/18º","Nublado",R.drawable.ic_launcher);

            ArrayList<ClimaModel> objetos = new ArrayList<ClimaModel>();
            objetos.add(clima1);
            objetos.add(clima2);
            objetos.add(clima3);
            objetos.add(clima4);
            objetos.add(clima5);
            objetos.add(clima6);
            objetos.add(clima7);

            adapterItem = new ListAdapterItem<ClimaModel>(getActivity(),
                    R.layout.list_item,
                    objetos);
            listView.setAdapter(adapterItem);
            listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                @Override
                public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                    ClimaModel item = (ClimaModel) adapterItem.getItem(position);


                    String dia = item.getDia().toString();
                    String clima = item.getClima().toString();
                    String temperatura = item.getTemperatura().toString();
                    int imagen = item.getImagen();


                    Intent intent = new Intent("com.example.pablo.sunshine.IntentListItem");
                    Bundle bolsita = new Bundle();
                    bolsita.putString("dia", dia);
                    bolsita.putString("clima", clima);
                    bolsita.putString("temperatura", temperatura);
                    bolsita.putInt("imagen", imagen);
                    intent.putExtras(bolsita);

                    Bundle bolsitaSerializado = new Bundle();
                    bolsitaSerializado.putSerializable("item", item);

                    startActivity(intent);

                }
            });

            return rootView;
        }
    }
}
