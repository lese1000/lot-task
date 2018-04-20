package com.tp.lottery.test;

import java.util.Arrays;
import java.util.List;

import com.tp.lottery.util.WinNumber;

public class Test {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
//		Lottery lot=new Lottery();
//		lot.lottery();
//		lot.estimate();
		String[] WinNums="05,03,01,07,10".split(",");
		String[] bettingNums="01,05,09,07,03,02".split(",");
		List<String> bettingNumArr = Arrays.asList(bettingNums);
//		int winCount=WinNumber.getWinningNumbersByOptional(bettingNumArr, WinNums, 5);
		int winCount=WinNumber.getWinningNumbersByGroup(bettingNumArr, WinNums, 3);
		System.out.println(winCount);
	}

}
