package com.guan.aaprojects.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

import com.guan.aaprojects.R;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Guan
 * @file com.example.guan.adapter
 * @date 2015/8/14
 * @Version 1.0
 */
public class GridAdapter extends BasesAdapter {

    private Context mContext;
    private Integer[] mImageInteger = {
            R.mipmap.grid_payout,
            R.mipmap.grid_bill,
            R.mipmap.grid_report,
            R.mipmap.grid_account_book,
            R.mipmap.grid_category,
            R.mipmap.grid_user,
    };

    public GridAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = getLayoutInflater().inflate(R.layout.main_body_item, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        holder.tvName.setText(getList().get(position).toString());
        holder.ivIcon.setImageResource(mImageInteger[position]);
        holder.ivIcon.setLayoutParams(new LinearLayout.LayoutParams(154, 154));
        holder.ivIcon.setScaleType(ImageView.ScaleType.FIT_XY);

        return convertView;
    }
    
    static class ViewHolder {
        @Bind(R.id.iv_icon)
        ImageView ivIcon;
        @Bind(R.id.tv_name)
        TextView tvName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
