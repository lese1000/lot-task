package com.tp.lottery.test;

import java.util.Scanner;

public class Lottery {
	int[]a=new int[7];  //输入的数
	int[]b=new int[7];  //随机中奖数
	int[]c=new int[7];  //判断是否和中奖同位数相同（1为相同/0为不同）
	public void lottery(){
		Scanner input=new Scanner (System.in);
		System.out.println("请输入7位数");//接受7为数字
		for(int i=0;i<a.length;i++){
			a[i]=input.nextInt();
		}
		System.out.print("您输入的数字为：\t");
		for(int i=0;i<a.length;i++){    
			System.out.print("  "+a[i]+"\t");
		}
		for(int i=0;i<a.length;i++){
			b[i]  = (int)(Math.random()*10);    
		}
		System.out.print("\n本期中奖号码为：\t");
		for(int i=0;i<a.length;i++){
	  		System.out.print("  "+b[i]+"\t");
	  	}System.out.println("\n");
	  	System.out.print("其中:\t\t");
	  	for(int i=0;i<a.length;i++){
	  		if(a[i]==b[i]){
	  			System.out.print("相同\t");
	  			c[i]=1;
	  		}else{
	  			System.out.print("不同\t");
	  		}    
	  	}
	  	System.out.println("\n");
	  	
	  	
	}
	//判断中奖与否方法
	public void estimate(){
		if((c[0]==1&&c[1]==1)||
			  	   (c[1]==1&&c[2]==1)||
			  	   (c[2]==1&&c[3]==1)||
			  	   (c[3]==1&&c[4]==1)||
			  	   (c[4]==1&&c[5]==1)||
			  	   (c[5]==1&&c[6]==1)){
			  		System.out.println("恭喜您中得六等奖！奖金：5元");
			  	}else if((c[0]==1&&c[1]==1&&c[2]==1)||
			  			(c[1]==1&&c[2]==1&&c[3]==1)||
			  			(c[2]==1&&c[3]==1&&c[4]==1)||
			  			(c[3]==1&&c[4]==1&&c[5]==1)||
			  			(c[4]==1&&c[5]==1&&c[6]==1)){
			  		System.out.println("恭喜您中得五等奖！奖金：20元");
			  	}else if((c[0]==1&&c[1]==1&&c[2]==1&&c[3]==1)||
			  			(c[1]==1&&c[2]==1&&c[3]==1&&c[4]==1)||
			  			(c[2]==1&&c[3]==1&&c[4]==1&&c[5]==1)||
			  			(c[3]==1&&c[4]==1&&c[5]==1&&c[6]==1)){
			  		System.out.println("恭喜您中得四等奖！奖金：300元");
			  	}else if((c[0]==1&&c[1]==1&&c[2]==1&&c[3]==1&&c[4]==1)||
			  			(c[1]==1&&c[2]==1&&c[3]==1&&c[4]==1&&c[5]==1)||
			  			(c[2]==1&&c[3]==1&&c[4]==1&&c[5]==1&&c[6]==1)){
			  		System.out.println("恭喜您中得三等奖！奖金：1800元");
			  	}else if((c[0]==1&&c[1]==1&&c[2]==1&&c[3]==1&&c[4]==1&&c[5]==1)||
			  			(c[1]==1&&c[2]==1&&c[3]==1&&c[4]==1&&c[5]==1&&c[6]==1)){
			  		System.out.println("恭喜您中得二等奖！奖金：50万元");
			  	}else if((c[0]==1&&c[1]==1&&c[2]==1&&c[3]==1&&c[4]==1&&c[5]==1&&c[6]==1)){
			  		System.out.println("恭喜您中得一等奖！奖金：500万元");
			  	}else{
			  		System.out.println("很遗憾，您没有中奖，请继续努力！");
			  	}
	}
}
