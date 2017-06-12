package com.example.zhudong.listviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Message> msgList = new ArrayList<Message>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMessage();
        final MsgAdapter msgAdapter = new MsgAdapter(this, R.layout.item, msgList);
        final ListView listView = (ListView)findViewById(R.id.listView_msg);
        listView.setAdapter(msgAdapter);

        final EditText editText = (EditText) findViewById(R.id.editText_msg);
        Button btn = (Button) findViewById(R.id.send_button);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = editText.getText().toString();
                if (!"".equals(content)) {
                    Message msg = new Message(0, content);
                    msgList.add(msg);
                    msgAdapter.notifyDataSetChanged();
                    listView.smoothScrollToPosition(listView.getCount()-1);//移动到尾部
                    editText.setText("");
                }
            }
        });
    }

    private void initMessage() {
        for (int i = 0; i < 3; i++) {
            Message msg0 = new Message(1, "How are you?");
            Message msg1 = new Message(0, "I am fine, thank you. And you?");
            Message msg2 = new Message(1, "I am fine, too");
            msgList.add(msg0);
            msgList.add(msg1);
            msgList.add(msg2);
        }
    }
}
