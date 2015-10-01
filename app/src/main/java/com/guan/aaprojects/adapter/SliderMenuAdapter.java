package com.guan.aaprojects.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.guan.aaprojects.R;
import com.guan.aaprojects.model.SliderMenuItem;

import java.util.List;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * @author Guan
 * @file com.example.guan.adapter
 * @date 2015/8/14
 * @Version 1.0
 */
public class SliderMenuAdapter extends BasesAdapter {

    private Context mContext;

    public SliderMenuAdapter(Context context, List list) {
        super(context, list);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        ViewHolder holder;

        if (convertView != null) {
            holder = (ViewHolder) convertView.getTag();
        } else {
            convertView = getLayoutInflater().inflate(R.layout.slide_menu_list, null);
            holder = new ViewHolder(convertView);
            convertView.setTag(holder);
        }

        SliderMenuItem _item = (SliderMenuItem) getList().get(position);
        holder.tvMenuName.setText(_item.getTitle());

        return convertView;
    }

    static class ViewHolder {
        @Bind(R.id.tv_menu_name)
        TextView tvMenuName;

        ViewHolder(View view) {
            ButterKnife.bind(this, view);
        }
    }
}
