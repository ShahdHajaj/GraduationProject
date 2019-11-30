package com.example.grad;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import androidx.appcompat.app.AppCompatActivity;

public class login extends AppCompatActivity {

    public static final int SERVERPORT = 8888;

    public static final String SERVER_IP = "10.0.2.2";
    private ClientThread clientThread;
    private Thread thread;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);
        TextView textView1=findViewById(R.id.timefield);
        TextView textView2=findViewById(R.id.weatherfield);
        TextView textView3=findViewById(R.id.activefiled);
        TextView textView4=findViewById(R.id.fastenfiled);
        TextView textView5=findViewById(R.id.randomfiled);

        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        String currentDateandTime = sdf.format(new Date());
        clientThread = new ClientThread();
        thread = new Thread(clientThread);
        thread.start();
//        clientThread.sendMessage("shahd");

        textView1.setText(currentDateandTime);
        sensorDataBaseHelper dataBaseHelper = new sensorDataBaseHelper(login.this);
        Cursor cursor = dataBaseHelper.getDataByTime(currentDateandTime.split(":")[0]+":00:00:00");
        if (cursor.moveToFirst()) {
            SharedPreferences sharedPreference = getSharedPreferences("usernameInfo", Context.MODE_PRIVATE);
            String username = sharedPreference.getString("username", "");
            DataBaseHelperInfo dataBaseHelper2 = new DataBaseHelperInfo(login.this);
            Cursor cursor2 = dataBaseHelper2.getUserByName(username);
            if (!cursor2.moveToFirst()) {
                Context context = getApplicationContext();
                CharSequence text = "User not found";
                int duration = Toast.LENGTH_SHORT;
                Toast toast = Toast.makeText(context, text, duration);
                toast.show();
            } else {

            }
            textView2.setText(cursor.getString(1));
            if (cursor.getString(5).matches("0")) {
                textView3.setText("Not Active");
            }
            else {
                textView3.setText("Active");

            }
            textView4.setText(cursor.getString(3));
            textView5.setText(cursor.getString(4));
            Intent intent = new Intent(login.this,MyService.class);
            startService(intent);

        }

    }
    class ClientThread implements Runnable {

        private Socket socket;
        private BufferedReader input;

        @Override
        public void run() {

            try {
                InetAddress serverAddr = InetAddress.getByName(SERVER_IP);
                socket = new Socket(serverAddr, SERVERPORT);
                sendMessage("shahd");

                while (!Thread.currentThread().isInterrupted()) {

                    this.input = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    String message = input.readLine();
                    if (null == message || "Disconnect".contentEquals(message)) {
                        Thread.interrupted();
                        message = "Server Disconnected.";
                        break;
                    }

                }
            } catch (UnknownHostException e1) {
                e1.printStackTrace();
            } catch (IOException e1) {
                e1.printStackTrace();
            }

        }

        void sendMessage(final String message) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        if (null != socket) {
                            PrintWriter out = new PrintWriter(new BufferedWriter(
                                    new OutputStreamWriter(socket.getOutputStream())),
                                    true);
                            out.write(message);
//                            out.println(message);
                            out.flush();

                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }).start();
        }

    }
}
