package com.tahir.nmit.program2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tahir on 12/3/2017.
 */

class FlowerAdapter extends BaseAdapter{
    Context mContext;
    List<String> mFlowers;
    public FlowerAdapter(Context mContext, List<String> mFlowers){
        this.mContext = mContext;
        this.mFlowers = mFlowers;
    }

    @Override
    public int getCount() {
        return mFlowers.size();
    }

    @Override
    public Object getItem(int i) {
        return mFlowers.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View convertView, ViewGroup viewGroup) {
        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.rowlayout, viewGroup, false);
        }
        TextView title = (TextView) convertView.findViewById(R.id.listflower);
        title.setText(mFlowers.get(i));
        return convertView;
    }
}
