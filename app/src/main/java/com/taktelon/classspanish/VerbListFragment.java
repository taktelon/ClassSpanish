package com.taktelon.classspanish;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.taktelon.classspanish.items.VerbContent;
import com.taktelon.classspanish.items.VerbItem;
import com.taktelon.classspanish.items.VerbRepository;

import java.util.List;

import static android.os.Build.ID;

/**
 * A fragment representing a list of Items.
 * <p/>
 * Activities containing this fragment MUST implement the {@link OnListFragmentInteractionListener}
 * interface.
 */
public class VerbListFragment extends Fragment {

    // TODO: Customize parameter argument names
    private static final String ARG_COLUMN_COUNT = "column-count";
    // TODO: Customize parameters
    private int mColumnCount = 1;
    private OnListFragmentInteractionListener mListener;

    /**
     * Mandatory empty constructor for the fragment manager to instantiate the
     * fragment (e.g. upon screen orientation changes).
     */
    public VerbListFragment() {
    }

    // TODO: Customize parameter initialization
    @SuppressWarnings("unused")
    public static VerbListFragment newInstance(int columnCount) {
        VerbListFragment fragment = new VerbListFragment();
        Bundle args = new Bundle();
        args.putInt(ARG_COLUMN_COUNT, columnCount);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getArguments() != null) {
            mColumnCount = getArguments().getInt(ARG_COLUMN_COUNT);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_verb_list, container, false);

        // Set the adapter
        if (view instanceof RecyclerView) {
            Context context = view.getContext();
            RecyclerView recyclerView = (RecyclerView) view;
            if (mColumnCount <= 1) {
                recyclerView.setLayoutManager(new LinearLayoutManager(context));
            } else {
                recyclerView.setLayoutManager(new GridLayoutManager(context, mColumnCount));
            }
            recyclerView.setAdapter(new VerbRecyclerViewAdapter(VerbContent.ITEMS, mListener));
        }

        Log.d("DEBUG", "onCreateView()");

        final VerbRepository verbRepository = new VerbRepository(getActivity().getApplicationContext());

        new Thread(new Runnable() {
            @Override
            public void run() {
                List<VerbItem> verbs = verbRepository.getVerbs();
                for (VerbItem verbItem : verbs) {
                    Log.d("DEBUG", "ID     : " + verbItem.getId());
                    Log.d("DEBUG", "Verb   : " + verbItem.getVerb());
                    Log.d("DEBUG", "Meaning: " + verbItem.getMeaning());
                }
            }
        }).start();

//        verbRepository.getVerbs().observe(getActivity(), new Observer<List<VerbItem>>() {
//
//            @Override
//            public void onChanged(List<VerbItem> verbItems) {
//                for (VerbItem verbItem : verbItems) {
//                    Log.d("DEBUG", "ID     : " + verbItem.getId());
//                    Log.d("DEBUG", "Verb   : " + verbItem.getVerb());
//                    Log.d("DEBUG", "Meaning: " + verbItem.getMeaning());
//                }
//            }
//        });
//        verbRepository.insertVerb(101, "poder", "be able to");
//        new Thread(new Runnable(){
//            @Override
//            public void run() {
//                Log.d("DEBUG", "onCreateView():Create repository");
//                verbRepository.insertVerb(100, "tener", "have");
//            }
//        }).start();

        return view;
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnListFragmentInteractionListener) {
            mListener = (OnListFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnListFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p/>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnListFragmentInteractionListener {
        // TODO: Update argument type and name
        void onListFragmentInteraction(VerbItem item);
    }
}
