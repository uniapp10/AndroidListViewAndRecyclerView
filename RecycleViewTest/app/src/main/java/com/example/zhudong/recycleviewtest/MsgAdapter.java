package com.example.zhudong.recycleviewtest;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;
import java.util.zip.Inflater;

/**
 * Created by zhudong on 2017/6/10.
 */

public class MsgAdapter extends RecyclerView.Adapter<MsgAdapter.ViewHolder> {

    private List<Msg> msgList;
    static class ViewHolder extends RecyclerView.ViewHolder {

        LinearLayout left_layout;
        ImageView left_imageView;
        TextView left_textView;

        LinearLayout right_layout;
        ImageView right_imageView;
        TextView right_textView;
        public ViewHolder(View view) {
            super(view);
            left_layout = (LinearLayout)view.findViewById(R.id.left_layout);
            left_imageView = (ImageView)view.findViewById(R.id.left_image);
            left_textView = (TextView)view.findViewById(R.id.left_text);

            right_layout = (LinearLayout)view.findViewById(R.id.right_layout);
            right_imageView = (ImageView)view.findViewById(R.id.right_image);
            right_textView = (TextView)view.findViewById(R.id.right_text);
        }
    }

    public MsgAdapter(List<Msg> msgList) {
        this.msgList = msgList;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_msg, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Msg msg = msgList.get(position);
        if (msg.getType() == msg.TYPE_RECEIVED) {
            holder.right_layout.setVisibility(View.GONE);
            holder.left_layout.setVisibility(View.VISIBLE);
            holder.left_imageView.setImageResource(R.drawable.left);
            holder.left_textView.setText(msg.getText());
        }else {
            holder.right_layout.setVisibility(View.VISIBLE);
            holder.left_layout.setVisibility(View.GONE);
            holder.right_imageView.setImageResource(R.drawable.right);
            holder.right_textView.setText(msg.getText());
        }
    }

    @Override
    public int getItemCount() {
        return msgList.size();
    }
}
