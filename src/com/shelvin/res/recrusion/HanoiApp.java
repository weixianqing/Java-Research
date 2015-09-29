package com.shelvin.res.recrusion;

public class HanoiApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Hanoi(5, 's', 'm', 't');
	}
	
	public static void Hanoi(int diskNum,char source,char middle,char target)
	{
		if(diskNum==1)
		{
			System.out.println("disk 1 from "+source+" to "+target);
		}
		else
		{
			Hanoi(diskNum-1,source,target,middle);
			System.out.println("disk "+diskNum+" from "+source+" to "+target);
			Hanoi(diskNum-1, middle, source, target);
		}
	}

}
