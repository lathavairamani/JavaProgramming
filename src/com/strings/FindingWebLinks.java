package com.strings;

import edu.duke.URLResource;

public class FindingWebLinks {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		findLinks();
	}

	private static void findLinks(){
		URLResource urlResource = new URLResource("http://www.dukelearntoprogram.com/course2/data/manylinks.html");
		for(String words:urlResource.words()){
			if(words.toLowerCase().contains("youtube.com")){
				System.out.println(words);
				int beginIndex = words.indexOf("\"");
				int endIndex = words.lastIndexOf("\"");
				String link = words.substring(beginIndex + 1, endIndex);
				System.out.println(link);
			}
		}
	}
}
