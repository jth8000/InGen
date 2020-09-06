package android.bignerdranch.ingen;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager manager = this.getSupportFragmentManager();

        FragmentTransaction transaction = manager.beginTransaction();

        Fragment startFragment = (StartFragment) manager.findFragmentById(R.id.fragment_container);

        if (startFragment == null) {
            startFragment = new StartFragment();
            transaction.add(R.id.fragment_container, startFragment);
            transaction.commit();
        }
    }
}
