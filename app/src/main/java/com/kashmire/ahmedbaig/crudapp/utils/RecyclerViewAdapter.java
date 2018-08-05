package com.kashmire.ahmedbaig.crudapp.utils;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.kashmire.ahmedbaig.crudapp.R;

import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private List<NotesListItem> listItems;
    private Context mContext;

    public RecyclerViewAdapter(List<NotesListItem> listItems, Context mContext) {
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.note,parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        NotesListItem listItem = listItems.get(position);
        holder.heading.setText(listItem.getHead());
        if(listItem.getCompleted()){
            holder.completed.setText("Completed");
        }else{
            holder.completed.setText("Pending");
        }
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView heading;
        TextView completed;
        RelativeLayout parent;

        public ViewHolder(View itemView){
            super(itemView);
            heading = itemView.findViewById(R.id.heading);
            parent = itemView.findViewById(R.id.parent_layout);
            completed = itemView.findViewById(R.id.completed);
        }
    }
}
