package com.sujeet.chatappdesign;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.media.midi.MidiOutputPort;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    List<MessageChatModel> messageChatModelList =  new ArrayList<>();
    List<MessageChatModel> messageChatModelList2 =  new ArrayList<>();
    RecyclerView recyclerView ,recyclerView2;
    MessageChatAdapter adapter ,adapter1 ;

    EditText messageET ,messageET2;
    ImageView sendBtn ,sendBtn2;
    TextView messagetv ,messagetv2;
    LinearLayout linearLayout ,linearLayout2 ,messageLayout2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final String currentTime = new SimpleDateFormat("HH:mm:ss", Locale.getDefault()).format(new Date());
        messageET = (EditText)findViewById(R.id.messageET);
        sendBtn = (ImageView) findViewById(R.id.sendBtn);
        messagetv = (TextView)  findViewById(R.id.message);
        linearLayout= (LinearLayout) findViewById(R.id.linearlayout);
        messageLayout2 =(LinearLayout) findViewById(R.id.messageLayout2);


        messageET2 = (EditText)findViewById(R.id.messageET2);
        sendBtn2 = (ImageView) findViewById(R.id.sendBtn2);
        messagetv2 = (TextView)  findViewById(R.id.message2);
        linearLayout2= (LinearLayout) findViewById(R.id.linearlayout2);




        messagetv.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        linearLayout.setVisibility(View.VISIBLE);

    }
});


        messagetv2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                linearLayout2.setVisibility(View.VISIBLE);

            }
        });
        recyclerView = (RecyclerView)findViewById(R.id.recycler_view);
        LinearLayoutManager manager = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        recyclerView.setLayoutManager(manager);


        recyclerView.smoothScrollToPosition(messageChatModelList.size());
        adapter = new MessageChatAdapter(messageChatModelList, MainActivity.this );
        recyclerView.setAdapter(adapter);

        recyclerView2 = (RecyclerView)findViewById(R.id.recycler_view2);
        LinearLayoutManager manager1 = new LinearLayoutManager(MainActivity.this, RecyclerView.VERTICAL, false);
        recyclerView2.setLayoutManager(manager1);

        recyclerView2.smoothScrollToPosition(messageChatModelList2.size());
       adapter1 = new MessageChatAdapter(messageChatModelList2, MainActivity.this );

        recyclerView2.setAdapter(adapter1);



        sendBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = messageET.getText().toString();

                MessageChatModel model = new MessageChatModel(
                        msg,
                        currentTime,
                        0
                );
                messageChatModelList.add(model);
                recyclerView.smoothScrollToPosition(messageChatModelList.size());
                adapter.notifyDataSetChanged();
                messageET.setText("");
                linearLayout.setVisibility(View.INVISIBLE);
                messageLayout2.setVisibility(View.VISIBLE);

            }

        });
        sendBtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg1 = messageET2.getText().toString();

                MessageChatModel model2 = new MessageChatModel(
                        msg1,
                        currentTime,
                        0
                );
                messageChatModelList2.add(model2);
                recyclerView2.smoothScrollToPosition(messageChatModelList2.size());
                adapter1.notifyDataSetChanged();
                messageET2.setText("");
                linearLayout2.setVisibility(View.INVISIBLE);
            //    messageLayout2.setVisibility(View.VISIBLE);

            }
        });

    }
}
