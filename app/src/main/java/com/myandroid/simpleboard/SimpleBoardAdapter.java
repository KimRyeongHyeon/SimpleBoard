package com.myandroid.simpleboard;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class SimpleBoardAdapter extends BaseAdapter {
    private Context context;
    private List<SimpleBoard> simpleBoardList;

    public SimpleBoardAdapter(Context context, List<SimpleBoard> simpleBoardList) {
        this.context = context;
        this.simpleBoardList = simpleBoardList;
    }

    @Override
    public int getCount() {
        return simpleBoardList.size();
    }

    @Override
    public Object getItem(int position) {
        return simpleBoardList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        convertView = View.inflate(context, R.layout.list, null);
        TextView nameTextView = (TextView)convertView.findViewById(R.id.nameTextView);
        TextView contentTextView = (TextView)convertView.findViewById(R.id.contentTextView);
        TextView dateTextView = (TextView)convertView.findViewById(R.id.dateTextView);

        nameTextView.setText(simpleBoardList.get(position).getName());
        contentTextView.setText(simpleBoardList.get(position).getContent());
        dateTextView.setText(simpleBoardList.get(position).getTs());

        return convertView;
    }
}
