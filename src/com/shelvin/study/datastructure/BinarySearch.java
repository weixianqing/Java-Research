package com.shelvin.study.datastructure;

/**
 * ���ֲ����ֳ��۰���ң�����һ��Ч�ʽϸߵĲ��ҷ����� 
���������ֲ���Ҫ�󡿣�1.�������˳��洢�ṹ 2.���밴�ؼ��ִ�С�������С�
 * @author Shelvin Zhou
 *
 */
public class BinarySearch { 
	public static void main(String[] args) {
		int[] src = new int[] {1, 3, 5, 7, 8, 9}; 
		System.out.println(binarySearch(src, 3));
		System.out.println(binarySearch(src,3,0,src.length-1));
	}

	/**
	 * * ���ֲ����㷨 * *
	 * 
	 * @param srcArray
	 *            �������� *
	 * @param des
	 *            ����Ԫ�� *
	 * @return des�������±꣬û�ҵ�����-1
	 */ 
   public static int binarySearch(int[] srcArray, int des){ 
	
		int low = 0; 
		int high = srcArray.length-1; 
		while(low <= high) { 
			int middle = (low + high)/2; 
			if(des == srcArray[middle]) { 
			    return middle; 
			}else if(des <srcArray[middle]) { 
			    high = middle - 1; 
			}else { 
			    low = middle + 1; 
			}
		}
		return -1;
   }
      
	  /**  
	 *���ֲ����ض����������������е�λ��(�ݹ�)  
	 */
	public static int binarySearch(int[] dataset,int data,int beginIndex,int endIndex){  
	   int midIndex = (beginIndex+endIndex)/2;  
	   if(data <dataset[beginIndex]||data>dataset[endIndex]||beginIndex>endIndex){
		   return -1;  
	   }
	   if(data <dataset[midIndex]){  
		   return binarySearch(dataset,data,beginIndex,midIndex-1);  
	   }else if(data>dataset[midIndex]){  
	       return binarySearch(dataset,data,midIndex+1,endIndex);  
	   }else {  
		   return midIndex;  
	   }  
   } 

}