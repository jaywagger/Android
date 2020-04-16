package multi.android.material_design_pro.exam;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.ListFragment;

/**
 * A simple {@link Fragment} subclass.
 */
public class ListTestFragment extends ListFragment {

    public ListTestFragment() {
        // Required empty public constructor
    }

    @Override
    public void onViewCreated(@NonNull View view,
                              @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        String[] data = {"김현정", "박누리", "황제윤", "이정윤", "곽혜란", "문준우"};
        ArrayAdapter adapter = new ArrayAdapter(getActivity(),
                                    android.R.layout.simple_list_item_1,
                                    android.R.id.text1,data);
        setListAdapter(adapter);
    }

/*    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_list, container, false);
    }*/
}
