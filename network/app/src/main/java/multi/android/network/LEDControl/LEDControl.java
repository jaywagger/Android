package multi.android.network.LEDControl;

import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;

import multi.android.network.R;
import multi.android.network.tcp.ChatClientActivity2;

import android.os.AsyncTask;
import android.widget.ArrayAdapter;
import android.widget.EditText;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

public class LEDControl extends AppCompatActivity {

    EditText msg_edit;
    String nickname;
    Socket socket;
    /* ArrayList<ChatMessage> msg;*/
    ArrayList<String> msg;
    InputStream is;
    InputStreamReader isr;
    BufferedReader br;

    OutputStream os;
    PrintWriter pw;
    Vector<String> userlist = new Vector<String>();
    StringTokenizer token;

    AsyncTaskExam asyncTaskExam;

    Handler writeHandler;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_l_e_d_control);


        msg_edit = findViewById(R.id.msg_edit);
        /* msg = new ArrayList<ChatMessage>();*/
        msg = new ArrayList<String>();
        asyncTaskExam = new AsyncTaskExam();
        nickname = "LED Test";
        asyncTaskExam.execute(10,20);
    }

    public void sendMessage(final String message) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                pw.println(message);
                pw.flush();
            }
        }).start();
    }
    public void btn_on(View view){
        sendMessage("1");
    }
    public void btn_off(View view){
        sendMessage("0");
    }






    //서버로부터 데이터 읽기 70.12.224.100
    class AsyncTaskExam extends AsyncTask<Integer,String,String> {
        @Override
        protected String doInBackground(Integer... integers) {
            Log.d("myserver","시작");
            try {
                Log.d("myserver","전");
                socket = new Socket("70.12.228.108", 12345);
                Log.d("myserver","접속완료");
                if(socket!=null){
                    ioWork();
                }
                sendMsg(nickname);
                userlist.add(nickname);

                Thread t1 = new Thread(new Runnable() {
                    @Override
                    public void run() {
                        while(true){
                            String msg;
                            try {
                                msg = br.readLine();
                                Log.d("chat","서버로 부터 수신된 메시지>>"
                                        +msg);
                                filteringMsg(msg);
                            } catch (IOException e) {
                                //1.=====서버쪽에서 연결이 끊어지는 경우
                                //먼저 사용한 자원을 반납한다.========
                                try {
                                    is.close();
                                    isr.close();
                                    br.close();
                                    os.close();
                                    pw.close();
                                    socket.close();
                                    /*AlertDialog.Builder builder = new AlertDialog.Builder(getApplicationContext());

                                    builder.setTitle("알림").setMessage("서버와 접속이 끊어졌습니다.");

                                    AlertDialog alertDialog = builder.create();

                                    alertDialog.show();*/
                                } catch (IOException e1) {
                                    // TODO Auto-generated catch block
                                    e1.printStackTrace();
                                }
                                break;
                            }

                        }
                    }
                });
                t1.start();

                //taChat.append(msg);

            } catch (UnknownHostException e) {
                Log.d("myserver",e.getMessage());
                e.printStackTrace();
            } catch (IOException e) {
                Log.d("myserver",e.getMessage());
                e.printStackTrace();
            }
            return  "";
        }
        public void ioWork(){
            try {
                is = socket.getInputStream();
                isr = new InputStreamReader(is);
                br = new BufferedReader(isr);

                os = socket.getOutputStream();
                pw = new PrintWriter(os,true);
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

        public void sendMsg(String msg){
            System.out.println("클라이언트가 서버에게 메시지 전송:"+msg);
            pw.println(msg);
        }

        private void filteringMsg(String msg){
            token = new StringTokenizer(msg,"/");
            String protocol = token.nextToken();
            String message = token.nextToken();
            System.out.println("프로토콜:"+protocol+",메시지:"+message);
            if(protocol.equals("new")){
                //새로운 사용자가 접속하면 nickname리스트를 저장하는 벡터에 추가
                userlist.add(message);
               /* publishProgress(userlist);
                lstconnect.setListData(userlist);*/
                publishProgress("new","msg","********"+message+
                        "님이 입장하셨습니다.*******\n");
            }else if(protocol.equals("old")){
                userlist.add(message);
                //lstconnect.setListData(userlist);
                publishProgress("old","msg",message);
            }else if(protocol.equals("chatting")){
                String nickname = token.nextToken();
                publishProgress("chatting",nickname,message);
            }else if(protocol.equals("out")){
                userlist.remove(message);
                // lstconnect.setListData(userlist);
                publishProgress("out",nickname,"님이 퇴장하셨습니다.");
            }

        }

        @Override
        protected void onProgressUpdate(String... values) {
            super.onProgressUpdate(values);
            String state = values[0];
            if(state.equals("new")){
                // userlist.add(values[2]);

            }else if(state.equals("old")){

            }else if(state.equals("chatting")){
               /* ChatMessage message = new ChatMessage();
                message.nickname = values[0];
                message.msg = values[1];*/
                msg.add(values[1]+">>"+values[2]);
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        try {
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
