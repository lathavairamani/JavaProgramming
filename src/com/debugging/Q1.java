package com.debugging;

public class Q1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 findAbc("abcdkfjsksioehgjfhsdjfhksdfhuwabcabcajfieowj");
	}
	public static void findAbc(String input){
	       int index = input.indexOf("abc");
	       while (true){
	           if (index == -1 || index >= input.length() - 3){
	               break;
	           }
	           String found = input.substring(index+1, index+4);
	           System.out.println(found);
	           index = input.indexOf("abc",index+3);
	       }
	   }
}
