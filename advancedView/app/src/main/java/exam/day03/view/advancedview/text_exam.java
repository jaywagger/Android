package exam.day03.view.advancedview;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class text_exam extends AppCompatActivity {

    EditText chatinput;
    TextView mychat;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_exam);

        chatinput = findViewById(R.id.chatinput);
        mychat = findViewById(R.id.mychat);

        Button send = findViewById(R.id.btnsend);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String msg = chatinput.getText()+"";
                mychat.append("\n"+msg);
                chatinput.setText("");            }
        });



    }
}
