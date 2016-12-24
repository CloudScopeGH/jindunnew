package com.cloudspace.jindun.adapter;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.cloudspace.jindun.R;

/**
 * User: Cloud(32325596@qq.com)
 * Date: 2016-12-23
 * Time: 14:51
 * project: jindunaaa
 * Describe 回报记录List适配器
 */
public class ReportListAdapter extends MyBaseAdapter<Object>{
    public ReportListAdapter(Context context) {
        super(context);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = getInflater().inflate(R.layout.item_reportlist,parent,false);
        }
        ListViewHolder viewHolder = (ListViewHolder) convertView.getTag();
        if (viewHolder == null) {
            viewHolder = new ListViewHolder(convertView);
            convertView.setTag(viewHolder);
        }

        viewHolder.bindView(getContext(),getItem(position));
        return convertView;
    }
    private static class ListViewHolder{
        private ImageView mImageView;
        private TextView mTitle,details,time01,time02;
        private ListViewHolder(View itemView){
            mImageView= (ImageView) itemView.findViewById(R.id.report_listview_item_image);
            mTitle= (TextView) itemView.findViewById(R.id.report_listview_item_tv_title);
            details= (TextView) itemView.findViewById(R.id.report_listview_item_tv_details);
            time01= (TextView) itemView.findViewById(R.id.report_listview_item_time01);
            time02= (TextView) itemView.findViewById(R.id.report_listview_item_time02);
        }
        public void bindView(final Context context, final Object item){

        }
    }
}
