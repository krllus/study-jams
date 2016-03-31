package gyndroids.com.studyjam.fragments;

import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import gyndroids.com.studyjam.R;

/**
 * A placeholder fragment containing a simple view.
 */
public class BirthdayCard extends Fragment {

    public BirthdayCard() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_main, container, false);
    }
}
