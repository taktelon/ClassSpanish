package com.taktelon.classspanish;

import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.taktelon.classspanish.VerbFragment.OnListFragmentInteractionListener;
import com.taktelon.classspanish.items.VerbItem;

import java.util.List;

/**
 * {@link RecyclerView.Adapter} that can display a {@link VerbItem} and makes a call to the
 * specified {@link OnListFragmentInteractionListener}.
 * TODO: Replace the implementation with code for your data type.
 */
public class VerbRecyclerViewAdapter extends RecyclerView.Adapter<VerbRecyclerViewAdapter.ViewHolder> {

    private final List<VerbItem> mValues;
    private final OnListFragmentInteractionListener mListener;

    public VerbRecyclerViewAdapter(List<VerbItem> items, OnListFragmentInteractionListener listener) {
        mValues = items;
        mListener = listener;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.fragment_verb, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final ViewHolder holder, int position) {
        holder.mItem = mValues.get(position);
        holder.mIdView.setText(mValues.get(position).id);
        holder.mVerbView.setText(mValues.get(position).verb);
        holder.mMeaningView.setText(mValues.get(position).meaning);

        holder.mView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (null != mListener) {
                    // Notify the active callbacks interface (the activity, if the
                    // fragment is attached to one) that an item has been selected.
                    mListener.onListFragmentInteraction(holder.mItem);
                }
            }
        });
    }

    @Override
    public int getItemCount() {
        return mValues.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        public final View mView;
        public final TextView mIdView;
        public final TextView mVerbView;
        public final TextView mMeaningView;
        public VerbItem mItem;

        public ViewHolder(View view) {
            super(view);
            mView = view;
            mIdView = (TextView) view.findViewById(R.id.item_number);
            mVerbView = (TextView) view.findViewById(R.id.verb);
            mMeaningView = (TextView) view.findViewById(R.id.meaning);
        }

        @Override
        public String toString() {
            return super.toString() + " '" + mVerbView.getText() + "'";
        }
    }
}
