package com.github.fragmentviewpager;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class Fragment extends android.support.v4.app.Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String PAGE = "PAGE";
    private static final String NAME = "NAME";

    // TODO: Rename and change types of parameters
    private int page;
    private String name;

    public Fragment() {
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param page Parameter 1.
     * @param name Parameter 2.
     * @return A new instance of fragment Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment newInstance(int page, String name) {
        Fragment fragment = new Fragment();
        Bundle args = new Bundle();
        args.putInt(PAGE, page);
        args.putString(NAME, name);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            page = getArguments().getInt(PAGE);
            name = getArguments().getString(NAME);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment, container, false);
        TextView textView = (TextView) view.findViewById(R.id.text);
        textView.setText(page + " -- " + name);
        return view;
    }


    @Override
    public void onDetach() {
        super.onDetach();
    }

}
