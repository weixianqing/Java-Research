package com.shelvin.study.datastructure.res.recrusion;

public class AnagramApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char buf[]={'a','b','c','d'};
		perm(buf, 0, buf.length-1);
	}
	
	public static void Anagram(String word)
	{
		
				
	}
	
	public void swap(String first,String last)
	{
		String temp;
		temp=first;
		first=last;
		last=temp;
	}
	
	public static void perm(char[] buf,int start,int end){
        if(start==end){
            for(int i=0;i<=end;i++){
                System.out.print(buf[i]+" ");
            }
            System.out.println();
        }
        else{
            for(int i=start;i<=end;i++){
                char temp=buf[start];
                buf[start]=buf[i];
                buf[i]=temp;
                perm(buf,start+1,end);
                temp=buf[start];
                buf[start]=buf[i];
                buf[i]=temp;
            }
        }
    }

}
