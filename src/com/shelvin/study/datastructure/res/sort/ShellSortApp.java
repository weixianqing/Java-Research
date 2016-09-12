package com.shelvin.study.datastructure.res.sort;


public class ShellSortApp
{
    public static void main(String[] args)
    {

    }
}

class ShellSortArray
{
    private int sData;
    private int maxSize;
    private int[] sArr;

    public ShellSortArray(int size)
    {
        this.maxSize = size;
        sArr = new int[maxSize];
        ;
    }

    public void insert(int data)
    {
        int i = 0;

        sData = data;
        if (i < maxSize)
        {
            sArr[i++] = sData;
        } else
        {
            System.out.println("array out of index range!");
        }
    }

    public void printOriginal()
    {
        for (int i = 0; i < maxSize; i++)
        {
            System.out.print("original array is:");
            System.out.print(" " + sArr[i]);
            System.out.println();
        }
    }

    public void ShellSort()
    {
        int h = 1;
        int temp;

        while (h < maxSize / 3)
        {
            h = 3 * h + 1;
        }

//***********************************************************
//�����h�ڲ��������о�ֱ����1��Ӧ����ϣ�������У�h���һ���������������h=3��h+1
//��ʼ�ݼ���ֱ��h��Ϊ1���ͱ�ɲ�������
//����������a{3��1��4��0��18��25��7��2��11��4��45}�����ϱ�while�����h=4������
//h=4ʱ��a[0],a[4],a[8]��a[1],a[5],a[9]��a[2],a[6],a[10]��a[3],a[7]����4-insert����Ȼ��h�ݼ�Ϊ1������1-insert������ͨ��������
        while (h > 0)//��whileѭ������h�ݼ���֪��h�ݼ�Ϊ1
        {
            for (int outer = h; h < maxSize; h++)//��forѭ����֤���ÿ���ض�h�����е����ݶ�����h-insertѭ��
            {
                int inner = outer;
                temp = sArr[outer];

                while (inner > (h - 1) && sArr[inner - h] > temp)//��whileѭ������һ�����������㷨������ͨ����������ȣ�h�ɱ䣬�ɽ���h-insert���򣬵�h�ݼ�Ϊ1ʱ��������ͨ��������
                //inner>(h-1)����������ʵ�ǲ���������������ڲ��������У��ٶ�ĳ��������������ݶ������򣬸����ұ��������ݶ�δ�������ڰѸ������뵽�����������е��ʵ�λ��
                //���ԣ�����Ҫ�ʹӸ�����ʼ��������������������ߵ��������ݽ��бȽϣ�����Ҳ�������λ�þ�һֱ�Ƚϣ�֪���ҵ�����λ�û��ߵ�������0λ�ã���������while������Ҫ��
                //����任��ָ�벻������Խ�磨��ָ��С���㣩���������ָ����inner-h������(inner-h)>=0,Ϊ���������Ч�ʣ�(inner-h)>=0��Ϊ(inner-h)>(-1)��
                //�����ͼ�����=�ıȽϣ������˱Ƚϴ�����Ȼ��inner>(h-1)
                {
                    sArr[inner] = sArr[inner - h];
                    inner = inner - h;//ÿ��h��������ɵ��������н����������򷽷��ǲ�������
                    //����h=4ʱ������������ÿ���ĸ�����ɵ��������н��в�������Ȼ��h�ݼ�Ϊ1��Ȼ��������ÿ��һ���������������
                    //���в�������h=1�Ĳ�������Ҳ��������������ͨ��������
                }

                sArr[inner] = temp;
            }

            h = (h - 1) / 3;
        }
//**************************************************************		
    }
}
