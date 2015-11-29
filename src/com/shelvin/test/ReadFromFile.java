package com.shelvin.test;

import java.io.*;

/**
 * Created by shelvin on 11/17/15 18:53.
 */

public class ReadFromFile
{
    public static void readFileByBytes(String fileName)
    {
        File file = new File(fileName);
        InputStream ips = null;

        try
        {
            System.out.println("以字节为单位读取文件内容，一次读一个字节：");
            ips = new FileInputStream(file);

            int tempByte;
            while ((tempByte = ips.read()) != -1)
            {
                System.out.write(tempByte);
            }
        } catch (IOException e)
        {
            e.printStackTrace();
            return;
        }

        try
        {
            System.out.println("以字节为单位读取文件内容，一次读多个字节：");
            byte[] tempBytes= new byte[100];
            ips = new FileInputStream(fileName);
            int byteRead = 0;
            while ((byteRead = ips.read(tempBytes)) != -1)
            {
                System.out.write(tempBytes,0,byteRead);
            }
        }
        catch (Exception e2)
        {
            e2.printStackTrace();
        }finally
        {
            try
            {
                ips.close();
            } catch (IOException e)
            {
                e.printStackTrace();
            }
        }
    }

    public static void readFileByChars(String fileName)
    {
        File file = new File(fileName);
        Reader reader = null;

        try
        {
            System.out.println("以字符为单位读取文件内容，一次读一个字节：");
            reader= new InputStreamReader(new FileInputStream(fileName));
            int tempChar = 0;

            while ((tempChar = reader.read()) != -1)
            {
                if ((char)tempChar != '\r')
                {
                    System.out.print((char)tempChar);
                }
            }

        }catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
