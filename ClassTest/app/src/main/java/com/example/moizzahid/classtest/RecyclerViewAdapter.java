package com.example.moizzahid.classtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.moizzahid.classtest.ListItem;
import com.example.moizzahid.classtest.R;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewAdapter extends RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final String TAG = "RecyclerViewAdapter";

    private List<ListItem> listItems;
    private Context mContext;

    public RecyclerViewAdapter(List<ListItem> listItems, Context mContext) {
        this.listItems = listItems;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder( ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.layout_listitem,parent, false);
        ViewHolder holder = new ViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder( ViewHolder holder, int position) {
        Log.d(TAG, "onBindViewHolder: called");
        ListItem listItem = listItems.get(position);

        holder.heading.setText(listItem.getNum());
        holder.message.setText(listItem.getPhone());
    }

    @Override
    public int getItemCount() {
        return listItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        TextView heading;
        TextView message;
        RelativeLayout parent;

        public ViewHolder(View itemView){
            super(itemView);
            heading = itemView.findViewById(R.id.heading);
            parent = itemView.findViewById(R.id.parent_layout);
            message = itemView.findViewById(R.id.message);
        }
    }
}
