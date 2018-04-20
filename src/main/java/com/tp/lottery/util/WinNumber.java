package com.tp.lottery.util;

import java.util.HashSet;
import java.util.List;

public class WinNumber {
	private static String[] winNum=new String[]{"01","02","03","08","09","10","04","05","06","07","11"};
	public static void main(String[] args) {
//		System.out.println(getWinNumber());
		System.out.println(randomNum(2,7));
//		System.out.println(WinNumber.getBettingNumber(6));
	}
	
	/**
	 * 随机取得5个号码
	 * @return
	 */
	public static String getWinNumber(){
		 HashSet<Integer> set = new HashSet<Integer>();  
	     randomSet(0,10,5,set);  
	     String wstr="";
         for (int j : set) {  
        	 wstr+=","+winNum[j];  
		 }  
		return wstr.replaceFirst(",", "");
		
	}
	/**
	 * 随机取得n个号码
	 * @param n
	 * @return
	 */
	public static String getBettingNumber(int n){
		 HashSet<Integer> set = new HashSet<Integer>();  
	     randomSet(0,10,n,set);  
	     String wstr="";
	     for (int j : set) {  
	    	 wstr+=","+winNum[j];  
		 }  
		
		return wstr.replaceFirst(",", "");
		
	}
	
	 public static void randomSet(int min, int max, int n, HashSet<Integer> set) {  
	       if (n > (max - min + 1) || max < min) {  
	           return;  
	       }  
	       int setSizeOrg = set.size();  
	       for (int i = 0; i < n; i++) {  
	           // 调用Math.random()方法  
	           set.add(randomNum(min,max));// 将不同的数存入HashSet中  
	       }  
	       int setSize = set.size();  
	       // 如果存入的数小于指定生成的个数，则调用递归再生成剩余个数的随机数，如此循环，直到达到指定大小  
	       if (setSize < n+setSizeOrg) {  
	    	   randomSet(min, max, n+setSizeOrg - setSize, set);// 递归  
	       }  
	   } 
	 /**
	  * 任选
	  * @param bettingNumArr
	  * @param WinNums
	  * @param len
	  * @return
	  */
	 public static int getWinningNumbersByOptional(List<String> bettingNumArr,String[] WinNums,int len){
		 Long count=0l;
		 for(String win:WinNums){
 			count += bettingNumArr.stream().filter(string -> string.equals(win)).count();
 		 }
		 if(len>5){
			 return CombinatorialUtil.getCombinatorial(count.intValue(), len);
		 }
		 return CombinatorialUtil.getCombinatorial(count.intValue(), len);
		
	 }
	 /**
	  * 组选
	  * @param bettingNumArr
	  * @param WinNums
	  * @param len
	  * @return
	  */
	 public static int getWinningNumbersByGroup(List<String> bettingNumArr,String[] WinNums,int len){
		 Long count=0l;
		 int i=1; 
		 for(String win:WinNums){
 			count += bettingNumArr.stream().filter(string -> string.equals(win)).count();
 			if(len==i){
 				break;
 			}
 			i++;
 		}
		return count.intValue()==len?1:0;
		
	 }
	 /**
	  * 直选
	  * @param bettingNumArr
	  * @param WinNums
	  * @param len
	  * @return
	  */
	 public static int getWinningNumbersByStraight(List<String> bettingNumArr,String[] WinNums,int len){
		 Long count=0l;
		 for(String win:WinNums){
 			count += bettingNumArr.stream().filter(string -> string.equals(win)).count();
 		}
		return CombinatorialUtil.getCombinatorial(count.intValue(), len);
		
	 }
	 /**
	  * 随机数
	  * @param min
	  * @param max
	  * @return
	  */
	 public static Integer randomNum(int min, int max){
		 return (int) (Math.random() * (max - min)) + min;  
	 }
}
