﻿package com.qa.javaAssessment;

import java.util.ArrayList;

public class Assessment {

	// Given a string, return a string where
	// for every char in the original string,
	// there are three chars.

	// multChar("The") ==> "TTThhheee"
	// multChar("AAbb") ==> "AAAAAAbbbbbb"
	// multChar("Hi-There") ==> "HHHiii---TTThhheeerrreee"

	public String multChar(String input) {
		String word = "";
		for (int i = 0; i < input.length(); i++) {
			word += input.substring(i, i + 1);
			word += input.substring(i, i + 1);
			word += input.substring(i, i + 1);
		}
		return word;
	}

	// Return the string (backwards) that is between the first and last appearance
	// of "bert"
	// in the given string, or return the empty string "" if there is not 2
	// occurances of "bert" - Ignore Case

	// getBert("bertclivebert") ==> "evilc"
	// getBert("xxbertfridgebertyy") ==> "egdirf"
	// getBert("xxBertfridgebERtyy") ==> "egdirf"
	// getBert("xxbertyy") ==> ""
	// getBert("xxbeRTyy") ==> ""

	public String getBert(String input) {
		input = input.toLowerCase();
		String output = "";
		String words = "";

		for (int i = 0; i < (input.length() - 3); i++) {
			if (input.substring(i, i + 4).equals("bert")) {

				for (int j = i + 4; j < input.length() - 3; j++) {
					if (input.substring(j, j + 4).equals("bert")) {
						words = input.substring(i + 4, j);
					}

				}
			}

		}
		for (int w = 0; w < words.length(); w++) {
			output = words.substring(w, w + 1) + output;

		}
		return output;
	}

	// Given three ints, a b c, one of them is small, one is medium and one is
	// large. Return true if the three values are evenly spaced, so the
	// difference between small and medium is the same as the difference between
	// medium and large. Do not assume the ints will come to you in a reasonable
	// order.

	// evenlySpaced(2, 4, 6) ==> true
	// evenlySpaced(4, 6, 2) ==> true
	// evenlySpaced(4, 6, 3) ==> false
	// evenlySpaced(4, 60, 9) ==> false

	public boolean evenlySpaced(int a, int b, int c) {
		if (a > b && a > c) {
			if (a - b == b - c || a - c == c - b) {
				return true;
			} else {
				return false;
			}
		} else if (b > a && b > c) {
			if (b - a == a - c || b - c == c - a) {
				return true;
			} else {
				return false;
			}
		} else if (c > a && c > b) {
			if (c - a == a - b || c - b == b - a) {
				return true;
			} else {
				return false;
			}
		} else {

			return false;
		}
	}

	// Given a string and an int n, return a string that removes n letters from the
	// 'middle' of the string.
	// The string length will be at least n, and be odd when the length of the input
	// is odd.

	// nMid("Hello", 3) ==> "Ho"
	// nMid("Chocolate", 3) ==> "Choate"
	// nMid("Chocolate", 1) ==> "Choclate"
	// nMid("rowley", 4) ==> "ry"

	public String nMid(String input, int a) {
		String output = "";
		int halfString = input.length() / 2;
		int halfInt = a / 2;
		if (input.length() % 2 == 1) {
			output = input.substring(0, halfString - halfInt)
					+ input.substring(halfString + halfInt + 1, input.length());
		} else if (input.length() % 2 == 0) {
			output = input.substring(0, halfString - halfInt) + input.substring(halfString + halfInt, input.length());
		}

		return output;
	}

	// Given a string, return the length of the largest "block" in the string.
	// A block is a run of adjacent chars that are the same.
	//
	// superBlock("hoopplla") ==> 2
	// superBlock("abbCCCddDDDeeEEE") ==> 3
	// superBlock("") ==> 0

	public int superBlock(String input) {
		input = input +" ";
		int count = 1;
		int result  = 0;
		ArrayList<Integer> totals = new ArrayList<Integer>();

		for (int i = 0; i < input.length() - 1; i++) {
			if (input.substring(i, i + 1).equals(input.substring(i + 1, i + 2))) {
				count += 1;
			} else {
				totals.add(count);
				count = 1;
			}
		}
		
		for (Integer j : totals) {
			if (result<j) {
				result =j;	
			}
		}
		return(result);
	}

	// given a string - return the number of times "am" appears in the String
	// ignoring case -
	// BUT ONLY WHEN the word "am" appears without being followed or proceeded by
	// other letters
	//
	// amISearch("Am I in Amsterdam") ==> 1
	// amISearch("I am in Amsterdam am I?") ==> 2
	// amISearch("I have been in Amsterdam") ==> 0

	public int amISearch(String arg1) {
		arg1 = " " + arg1.toLowerCase()+" ";
		int count = 0;
		for (int i = 0; i < arg1.length() - 3; i++) {
			if (arg1.substring(i, i + 4).equals(" am ")) {
				count += 1;
			}	
		}
		return count;

	}

	// given a number
	// if this number is divisible by 3 return "fizz"
	// if this number is divisible by 5 return "buzz"
	// if this number is divisible by both 3 and 5return "fizzbuzz"
	//
	// fizzBuzz(3) ==> "fizz"
	// fizzBuzz(10) ==> "buzz"
	// fizzBuzz(15) ==> "fizzbuzz"

	public String fizzBuzz(int arg1) {
		if (arg1 % 3 == 0 && arg1 % 5 == 0) {
			return "fizzbuzz";
		} else if (arg1 % 3 == 0) {
			return "fizz";
		} else if (arg1 % 5 == 0) {
			return "buzz";
		} else {
			return null;
		}
	}

	// Given a string split the string into the individual numbers present
	// then add each digit of each number to get a final value for each number
	// String example = "55 72 86"
	//
	// "55" will = the integer 10
	// "72" will = the integer 9
	// "86" will = the integer 14
	//
	// You then need to return the highest value
	//
	// largest("55 72 86") ==> 14
	// largest("15 72 80 164") ==> 11
	// largest("555 72 86 45 10") ==> 15

	public int largest(String arg1) {
		
		String[] nums = arg1.split(" ");
		ArrayList<Integer> values = new ArrayList<Integer>();
		int k = 0;
		int result = 0;

		for (int i = 0; i < nums.length; i++) {
			for (int j = 0; j < nums[i].length(); j++) {
				k += Integer.parseInt((nums[i].substring(j, j + 1)));
			}
			values.add(k);
			k = 0;
		}
		for (Integer j : values) {
			if (result < j) {
				result = j;
			}
		}
		return(result);

			
	}
}
