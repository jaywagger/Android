package multi.android.support_lib.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import multi.android.support_lib.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class SecondFragment extends Fragment {

    public SecondFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
<<<<<<< HEAD
        return inflater.inflate(R.layout.fragment_second2, container, false);
=======
        return inflater.inflate(R.layout.fragment_second, container, false);
>>>>>>> 6e2e37a2396b3f6fbf78b16efa3188b2eb622216
    }
}
