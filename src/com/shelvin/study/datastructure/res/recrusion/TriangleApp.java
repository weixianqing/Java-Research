package com.shelvin.study.datastructure.res.recrusion;

//static���εķ�����������������࣬�Ͷ���û�й�ϵ��
//�����еĶ��󶼹���ͬһ����̬�����������������̬��������̬��������̬����ֱ��ͨ���������з��ʣ�Ҳ��ͨ�����󣬵�����ɻ�������Ϊ�þ�̬��������̬��������̬������
//�������Ķ���û���κι�ϵ��
//��̬�������ܲ����������Բ����ھ�̬�����з���ʵ���򣬵��Ǿ�̬�������Է����������еľ�̬��

public class TriangleApp
{
    public static void main(String[] args)
    {
        TriangleApp ta = new TriangleApp();
        System.out.println(ta.triangle(5));
        //ta.triangle(5);��main��ֱ���������ñ�����Ϊmain��static�ģ�
        insert(5);//��̬�������Է����������еľ�̬�򣬾�̬�������ܲ����������Բ����ھ�̬�����з���ʵ����,��triangle�����������ͨ������ֻ��ͨ����Ķ�����е���
    }

    public int triangle(int n)
    {
        if (n == 1)
            return 1;
        else
            return (n + triangle(n - 1));
    }

    public static void insert(int key)
    {
        //triangle(int key);  //��̬�������ܲ����������Բ����ھ�̬�����з���ʵ����,��triangle�����������ͨ������ֻ��ͨ����Ķ�����е���
    }

    public void remove(int key)
    {
        triangle(key);
        this.triangle(key);
    }
}
