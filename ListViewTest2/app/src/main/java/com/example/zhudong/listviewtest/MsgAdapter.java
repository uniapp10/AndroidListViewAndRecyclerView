package com.example.zhudong.listviewtest;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.util.List;

/**
 * Created by zhudong on 2017/6/10.
 */

public class MsgAdapter extends ArrayAdapter<Message> {

    private int resourceId;
    public MsgAdapter(Context context, int resouceId, List<Message> messages) {
        super(context, resouceId, messages);

        this.resourceId = resouceId;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        View view = LayoutInflater.from(parent.getContext()).inflate(resourceId, parent, false);
        LinearLayout leftLayout = (LinearLayout)view.findViewById(R.id.layout_left);
        LinearLayout rightLayout = (LinearLayout)view.findViewById(R.id.layout_right);
        Message msg = getItem(position);
        ImageView imageView;
        TextView textView;
        if (msg.getType() == Message.TYPE_RECEIVED) {
            leftLayout.setVisibility(View.VISIBLE);
            rightLayout.setVisibility(View.GONE);
            imageView = (ImageView)view.findViewById(R.id.imageView_itemLeft);
            textView = (TextView)view.findViewById(R.id.textView_itemLeft);
            imageView.setImageResource(R.drawable.left);
        }else {
            leftLayout.setVisibility(View.GONE);
            rightLayout.setVisibility(View.VISIBLE);
            imageView = (ImageView)view.findViewById(R.id.imageView_itemRight);
            textView = (TextView)view.findViewById(R.id.textView_itemRight);
            imageView.setImageResource(R.drawable.right);
        }

        textView.setText(msg.getContent());
        return view;
    }
}
