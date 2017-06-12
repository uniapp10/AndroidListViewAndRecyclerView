package com.example.zhudong.recycleviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private List<Msg> msgList = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initMsg();
        final RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recycle_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);
        final MsgAdapter adapter = new MsgAdapter(msgList);
        recyclerView.setAdapter(adapter);

        final EditText input_text = (EditText)findViewById(R.id.input_text);
        Button send_button = (Button)findViewById(R.id.send_button);
        send_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String content = input_text.getText().toString();
                if (!"".equals(content)) {
                    Msg msg = new Msg(content, Msg.SENT);
                    msgList.add(msg);
                    adapter.notifyItemInserted(msgList.size() + 1);
                    recyclerView.scrollToPosition(msgList.size() + 1);
                    input_text.setText("");
                }
            }
        });
    }

    private void initMsg() {
        for (int i = 0; i < 3; i++) {
            Msg msg0 = new Msg("How are you?", 0);
            Msg msg1 = new Msg("I am fine, thank you. And you?", 1);
            Msg msg2 = new Msg("I am fine, too.", 0);

            msgList.add(msg0);
            msgList.add(msg1);
            msgList.add(msg2);
        }
    }
}
