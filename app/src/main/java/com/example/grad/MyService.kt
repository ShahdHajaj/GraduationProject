package com.example.grad

import android.app.Service
import android.content.Context
import android.content.Intent
import android.os.Handler
import android.os.IBinder
import android.os.SystemClock
import android.widget.Toast
import java.io.*
import java.net.InetAddress
import java.net.Socket
import java.net.UnknownHostException

import java.util.concurrent.Executors
import java.util.concurrent.ScheduledExecutorService

class MyService : Service() {
    internal var scheduler = Executors.newSingleThreadScheduledExecutor()
    internal var handler = Handler()
    val SERVERPORT = 8888

    val SERVER_IP = "10.0.2.2"

    private val periodicUpdate = object : Runnable {
        override fun run() {
            handler.postDelayed(this, 10 * 1000 - SystemClock.elapsedRealtime() % 1000)
            // onTaskRemoved(intent);
            var clientThread =  ClientThread()
            Thread(clientThread).start()

            val sdf = java.text.SimpleDateFormat("HH:mm:ss")
            val currentDateandTime = sdf.format(java.util.Date())
            val dataBaseHelper = sensorDataBaseHelper(this@MyService)
            val cursor =
                dataBaseHelper.getDataByTime(currentDateandTime.split(":".toRegex()).dropLastWhile({ it.isEmpty() }).toTypedArray()[0] + ":00:00:00")
            if (cursor.moveToFirst()) {
                val sharedPreference = getSharedPreferences("usernameInfo", Context.MODE_PRIVATE)
                val username = sharedPreference.getString("username", "")
                val dataBaseHelper2 = DataBaseHelperInfo(this@MyService)
                val cursor2 = dataBaseHelper2.getUserByName(username)
                if (!cursor2.moveToFirst()) {
                    // val context = applicationContext
                    val text = "User not found"
                    Toast.makeText(
                        applicationContext, text,
                        Toast.LENGTH_SHORT
                    ).show()
                } else{
                }
                Toast.makeText(
                    applicationContext,cursor.getString(1),
                    Toast.LENGTH_SHORT
                ).show()
//                if (cursor.getString(5).matches("0".toRegex())) {
//                    Toast.makeText(
//                        applicationContext,"Not Active",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    //textView3.setText("Not Active")
//                } else {
//                    Toast.makeText(
//                        applicationContext,"Active",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    //textView3.setText("Active")
//
//                }
//                Toast.makeText(
//                    applicationContext,cursor.getString(3),
//                    Toast.LENGTH_SHORT
//                ).show()
//                Toast.makeText(
//                    applicationContext,cursor.getString(4),
//                    Toast.LENGTH_SHORT
//                ).show()
                //textView4.setText(cursor.getString(3))
                //textView5.setText(cursor.getString(4))
            }
        }
    }

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {

        handler.post(periodicUpdate)
        return Service.START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        // TODO: Return the communication channel to the service.
        throw UnsupportedOperationException("Not yet implemented")
    }

    override fun onTaskRemoved(rootIntent: Intent) {
        val restartServiceIntent = Intent(applicationContext, this.javaClass)
        restartServiceIntent.setPackage(packageName)
        startService(restartServiceIntent)
        super.onTaskRemoved(rootIntent)
    }


    internal inner class ClientThread : Runnable {

        private var socket: Socket? = null
        private var input: BufferedReader? = null

        override fun run() {

            try {
                val serverAddr = InetAddress.getByName(SERVER_IP)
                socket = Socket(serverAddr, SERVERPORT)
                sendMessage("shahd")

                while (!Thread.currentThread().isInterrupted) {

                    this.input = BufferedReader(InputStreamReader(socket!!.getInputStream()))
                    var message: String? = input!!.readLine()
                    if (null == message || "Disconnect".contentEquals(message)) {
                        Thread.interrupted()
                        message = "Server Disconnected."
                        break
                    }

                }
            } catch (e1: UnknownHostException) {
                e1.printStackTrace()
            } catch (e1: IOException) {
                e1.printStackTrace()
            }

        }

        fun sendMessage(message: String) {
            Thread(Runnable {
                try {
                    if (null != socket) {
                        val out = PrintWriter(
                            BufferedWriter(
                                OutputStreamWriter(socket!!.getOutputStream())
                            ),
                            true
                        )
                        out.write(message)
                        //                            out.println(message);
                        out.flush()

                    }
                } catch (e: Exception) {
                    e.printStackTrace()
                }
            }).start()
        }

    }
}