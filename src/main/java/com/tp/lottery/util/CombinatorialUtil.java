package com.tp.lottery.util;

public class CombinatorialUtil {

	public static void main(String[] args) {
//		System.out.println(getFactorial(4));
		System.out.println(getCombinatorial(6,2));

	}
	
	public static int getCombinatorial(int max,int num){
		if(num>max){
			return 0;
		}else if(num==1){
			return max;
		}else if(num==max){
			return 1;
		}else{
			int i_a=1;
			for(int i=0;i<num;i++){
				i_a=i_a*(max-i);
			}
			return i_a/getFactorial(num);
		}
		
	} 
	
	private static int getFactorial(int  num){
		if(num==1){
			return num;
		}else{
			return num*getFactorial(num-1);
		}
	} 

}
