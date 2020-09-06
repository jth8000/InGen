package android.bignerdranch.ingen;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.TextView;
import android.widget.Toast;

public class settingsActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        final Activity context = this;

        final TextView currentRunTime = findViewById(R.id.current_run_time);
        final TextView estimatedProduction = findViewById(R.id.amount_estimated);
        final NumberPicker hourSelection = findViewById(R.id.hours);
        Button commitButton = findViewById(R.id.commit_change);

        hourSelection.setMaxValue(6);
        hourSelection.setMinValue(1);

        final SharedPreferences preferences = this.getPreferences(Context.MODE_PRIVATE);

        hourSelection.setOnValueChangedListener(new NumberPicker.OnValueChangeListener() {
            @Override
            public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
                updateEstimate(newVal, estimatedProduction);
                String currentRunTimeDisplay = "Current Runtime: " + newVal + " hours";
                currentRunTime.setText(currentRunTimeDisplay);
            }
        });

        commitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int timeSeconds = convertToSeconds(hourSelection.getValue());
                SharedPreferences.Editor editor = preferences.edit();
                editor.putInt(getString(R.string.preference_string), timeSeconds);
                editor.apply();
                //Toast.makeText(context, "Committed run time value to " + timeSeconds, Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == android.R.id.home) {
            Intent intent = new Intent(this, MainActivity.class);
            intent.setFlags(Intent.FLAG_ACTIVITY_SINGLE_TOP | Intent.FLAG_ACTIVITY_CLEAR_TOP);
            startActivity(intent);
        }
        return true;
    }

    public void updateEstimate(int newTime, TextView showEstimate) {
        int units = 100 * newTime;
        String displayString = "Set time will produce about " + units + " units of insulin";
        showEstimate.setText(displayString);
    }

    public int convertToSeconds(int hours) {
        return hours * 60 * 60;
    }
}
