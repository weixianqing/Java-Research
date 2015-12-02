package com.shelvin.java.serializable;

import java.io.*;
import java.util.Date;

/**
 * Created by shelvin on 2015/12/1 19:11.
 */
public class SerializableBasicSample
{
    public static void main(String[] args) throws Exception
    {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("D:/objectFile.obj"));
        Customer customer = new Customer();
        customer.setName("shelvin");
        customer.setAge(22);
        String yj = "li yanjiao";
        oos.writeObject(yj);
        oos.writeObject(customer);
        oos.writeObject(new Date());
        oos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:/objectFile.obj"));
        String yji = (String) ois.readObject();
        System.out.println("obj1:"+yji);
        Customer customeri = (Customer) ois.readObject();
        System.out.println("obj2:name = "+customeri.getName()+",age = "+customeri.getAge());
        Date datei = (Date) ois.readObject();
        System.out.println("obj3:"+datei);
        ois.close();
    }
}

class Customer implements Serializable
{
    private String name;
    private int age;

    public String getName()
    {
        return name;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }
}
