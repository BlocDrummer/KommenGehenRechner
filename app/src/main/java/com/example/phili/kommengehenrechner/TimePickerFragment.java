package com.example.phili.kommengehenrechner;


import android.app.TimePickerDialog;
import android.icu.text.SimpleDateFormat;
import android.os.Bundle;
import android.app.DialogFragment;
import android.app.Dialog;

import java.text.ParseException;

import android.widget.Button;
import android.widget.TextView;
import android.widget.TimePicker;

/**
 * Created by phili on 30.06.2017.
 */
public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {
        TextView tvKommenZeit = (TextView) getActivity().findViewById(R.id.etKommenZeit);
        int hour = Integer.parseInt(tvKommenZeit.getText().toString().split(":")[0]);
        int minute = Integer.parseInt(tvKommenZeit.getText().toString().split(":")[1]);
        return new TimePickerDialog(getActivity(), this, hour, minute, true);
    }

    @Override
    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
        TextView tvKommenZeit = (TextView) getActivity().findViewById(R.id.etKommenZeit);
        SimpleDateFormat sdf = new SimpleDateFormat("H:mm");
        try {
            tvKommenZeit.setText(sdf.format(sdf.parse(hourOfDay + ":" + minute)));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        Button btnBerechnen = (Button) getActivity().findViewById(R.id.btnBerechnen);
        btnBerechnen.performClick();
    }
}
