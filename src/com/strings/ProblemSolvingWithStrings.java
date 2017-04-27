package com.strings;

public class ProblemSolvingWithStrings {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String str1 =  "a";
		String str2 = "banana";
		if(twoOccurences(str1, str2)){
			System.out.println("Given string " + str1 + " has two occurences in the string " + str2);
		}else{
			System.out.println("No two occurences");
		}
		System.out.println("Last part is " + lastPart("an", str2));
		System.out.println("Last part is " + lastPart("a", str2));
		System.out.println("Last part is " + lastPart("zoo", "forest"));
		System.out.println("Count is " + howMany("GAA", "ATGAACGAATTGAATC"));
		System.out.println("Count is " + howMany("AA", "ATTAAAATC"));
	}
	
	// This method returns true if stringa appears at least twice in stringb, otherwise it returns false. 
	// For example, the call twoOccurrences(“by”, “A story by Abby Long”) returns true as there are two occurrences of “by”, 
	// the call twoOccurrences(“a”, “banana”) returns true as there are three occurrences of “a” so “a” occurs at least twice, 
	// and the call twoOccurrences(“atg”, “ctgtatgta”) returns false as there is only one occurence of “atg”.
	private static boolean twoOccurences(String str1, String str2){
		int count = 0;
		while (str2.contains(str1)){
		    str2 = str2.replaceFirst(str1, "-");
		    count++;
		}
		if(count >=2){
			return true;
		}
		return false;
	}
	
	// This method finds the first occurrence of stringa in stringb, and returns the part of stringb that follows stringa. 
	// If stringa does not occur in stringb, then return stringb. 
	// For example, the call lastPart(“an”, “banana”) returns the string “ana”, the part of the string after the first “an”. 
	// The call lastPart(“zoo”, “forest”) returns the string “forest” since “zoo” does not appear in that word.
	private static String lastPart(String str1, String str2){
		int startIndex = str2.indexOf(str1);
		if(startIndex == -1){
			return str2;
		}
		String subString = str2.substring(startIndex + str1.length());
		return subString;
	}
	
	private static int howMany(String str1, String str2){
		int count = 0;
		while (str2.contains(str1)){
		    str2 = str2.replaceFirst(str1, "-");
		    count++;
		}
		return count;
	}
	
}
