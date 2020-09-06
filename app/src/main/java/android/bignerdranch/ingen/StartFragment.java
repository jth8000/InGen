package android.bignerdranch.ingen;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

public class StartFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater layoutInflater, ViewGroup container, Bundle savedInstanceState) {
        super.onCreateView(layoutInflater, container, savedInstanceState);
        View theView = layoutInflater.inflate(R.layout.fragment_start, container, false);

        Button startCycleButton = theView.findViewById(R.id.start_button);

        setHasOptionsMenu(true);

        startCycleButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //connect to C socket on PI
            }
        });

        return theView;
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater menuInflater) {
        super.onCreateOptionsMenu(menu, menuInflater);

        menuInflater.inflate(R.menu.fragment_start_menu, menu);

        /*iconMaker = new makeIcons();

        menuInflater.inflate(R.menu.fragment_map, menu);

        MenuItem searchItem = menu.findItem(R.id.search_icon);
        MenuItem settingsItem = menu.findItem(R.id.settings_icon);

        searchItem.setIcon(iconMaker.createSearchIcon(getActivity()));
        settingsItem.setIcon(iconMaker.createSettingsIcon(getActivity()));*/
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.settings_option:
                Intent startSettingsActivity = new Intent(getActivity(), settingsActivity.class);
                startActivity(startSettingsActivity);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
        /*switch (item.getItemId()) {
            case R.id.search_icon:
                Intent startSearchActivity = new Intent(getActivity(), searchActivity.class);
                startActivity(startSearchActivity);
                return true;
            case R.id.settings_icon:
                Intent startSettingsActivity = new Intent(getActivity(), settingsActivity.class);
                startActivityForResult(startSettingsActivity, 1);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }*/
    }
}
