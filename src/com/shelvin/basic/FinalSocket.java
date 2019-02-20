package com.shelvin.basic;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author shelvin
 * @date 2016/2/25 15:47
 */
public class FinalSocket
{
    /*
    Book -- Java Concurrent in Practise
    6.1.2 Final Socket connection example
    When the final object connection points to other Socket connection, I want to
    know if the connection object in the handleRequest(connection) is affected.
     */

    public static final int PORT = 8080;

    public static void main(String[] args) throws IOException
    {
        System.out.println("server starting...");
        System.out.println("bug02 branch test");
        FinalSocket finalSocket = new FinalSocket();
        finalSocket.init();
    }

    public void init()
    {
        try
        {
            ServerSocket serverSocket = new ServerSocket(PORT);

            while (true)
            {
                final Socket connection = serverSocket.accept();
                Runnable task = new Runnable()
                {
                    @Override
                    public void run()
                    {
                        new ThreadHandler(connection);
                    }
                };

                new Thread(task).start();
            }
        } catch (IOException e)
        {
            e.printStackTrace();
        }
    }


    private class ThreadHandler implements Runnable
    {
        private Socket socket;
        public ThreadHandler(Socket socket)
        {
            this.socket = socket;
            new Thread(this).start();
        }

        @Override
        public void run()
        {
            Thread current = Thread.currentThread();
            System.out.println("current thread is "+current.getId()+" "+current.getName());
            try
            {
                DataInputStream dataInputStream = new DataInputStream(socket.getInputStream());
                String clientOutputStr = dataInputStream.readUTF();
                System.out.println("client sends message:"+clientOutputStr);

                DataOutputStream dataOutputStream = new DataOutputStream(socket.getOutputStream());
                System.out.println("please input response:");
                String msg = new BufferedReader(new InputStreamReader(System.in)).readLine();
                dataOutputStream.writeUTF(msg);

                dataOutputStream.close();
                dataInputStream.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }finally
            {
                if (socket != null)
                {
                    try
                    {
                        socket.close();
                    } catch (IOException e)
                    {
                        socket = null;
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}

