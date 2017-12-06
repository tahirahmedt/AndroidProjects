package com.tahir.nmit.program2bartb;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

/**
 * Created by Tahir on 12/6/2017.
 */

public class FlowerAdapter extends BaseAdapter{

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
    public View getView(int i, View view, ViewGroup viewGroup) {
        if(view == null){
            view = LayoutInflater.from(mContext).inflate(R.layout.rowlayout, viewGroup, false);
        }
        TextView text = view.findViewById(R.id.flowerlist);
        text.setText(mFlowers.get(i));
        return view;
    }
}
