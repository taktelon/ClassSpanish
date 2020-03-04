package com.taktelon.classspanish;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A simple {@link Fragment} subclass.
 * Use the {@link VerbFormFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class VerbFormFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_VERB = "verb";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mVerb;
    private String mParam2;

    public VerbFormFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param verb Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment VerbFormFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static VerbFormFragment newInstance(String verb, String param2) {
        VerbFormFragment fragment = new VerbFormFragment();
        Bundle args = new Bundle();
        args.putString(ARG_VERB, verb);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mVerb = getArguments().getString(ARG_VERB);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_verb_form, container, false);
        TextView verb_yo = (TextView)view.findViewById(R.id.verb_yo);
        verb_yo.setText(mVerb);
        return view;
    }
}
