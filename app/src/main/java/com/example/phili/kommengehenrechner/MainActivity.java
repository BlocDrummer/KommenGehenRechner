package com.example.phili.kommengehenrechner;

import android.app.DialogFragment;
import android.icu.text.SimpleDateFormat;
import android.icu.util.Calendar;
import android.icu.util.GregorianCalendar;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

//TODO TabLayout: simpleView, Custom Pausen, Custom Arbeitslänge
//TODO zu einem Git Projekt machen
//TODO simpleView: Warnung wenn Gehen über 20 Uhr
//TODO simpleView: Warnung wenn Kommen unter 6 Uhr

public class MainActivity extends AppCompatActivity {
    private EditText etKommenZeit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etKommenZeit = (EditText) findViewById(R.id.etKommenZeit);
        etKommenZeit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DialogFragment fragment = new TimePickerFragment();
                fragment.show(getFragmentManager(), "TimePicker");
            }
        });

        Button btnBerechnen = (Button) findViewById(R.id.btnBerechnen);
        btnBerechnen.setOnClickListener(
            new Button.OnClickListener() {
                public void onClick(View v) {
                    berechnen();
                }
            }
        );


    }

    /**
     * Berechnet die Gehenzeit aus der Kommenzeit und setzt die Gehenzeit
     */
    private void berechnen() {
        int kommenStunden = Integer.parseInt(etKommenZeit.getText().toString().split(":")[0]);
        int kommenMinuten = Integer.parseInt(etKommenZeit.getText().toString().split(":")[1]);

        GregorianCalendar c = new GregorianCalendar();
        c.clear();
        c.add(Calendar.HOUR_OF_DAY, kommenStunden);
        c.add(Calendar.MINUTE, ArbeitszeitUtil.abrunden(kommenMinuten));

        //Arbeitszeit hinzufügen
        c.add(Calendar.HOUR_OF_DAY, 7);
        c.add(Calendar.MINUTE, 6);

        //Pause hinzufügen
        c.add(Calendar.MINUTE, 30);

        c.add(Calendar.MINUTE, -c.get(Calendar.MINUTE) % 5); //Abrunden beim Gehen
        c.add(Calendar.MINUTE, 1);

        TextView tvGehenZeit = (TextView) findViewById(R.id.tvGehenZeit);
        SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
        tvGehenZeit.setText(sdf.format(c.getTime()));
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
}
