package com.strings;

import edu.duke.FileResource;
import edu.duke.StorageResource;

public class FindGene {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String dnaString = "ATGATTTGATATGTGGTAAA";
		System.out.println("DNA string is " + dnaString);
		String gene = findSimpleGene(dnaString);
		System.out.println("Gene is " + gene);
		gene = findSimpleGeneReorganized(dnaString, "ATG", "TAA");
		System.out.println("Gene is " + gene);
		//dnaString = "atgtagtaaa";
		System.out.println("DNA string is " + dnaString);
		gene = findSimpleGeneReorganized(dnaString, "ATG", "TAA");
		System.out.println("Gene is " + gene);
		gene = findGene(dnaString, 0);
		System.out.println("Gene is is " + gene);
		printAllGenes(dnaString);
		System.out.println("Count of genes is  " + countGenes(dnaString) );
		FileResource fr = new FileResource("brca1line.fa");
		 dnaString= fr.asString();
		 System.out.println(dnaString);
		StorageResource geneList = getAllGenes(dnaString);
		for(String g:geneList.data()){
			System.out.println("gENES" + g);
		}
	}
	
	private static String findSimpleGene(String dnaString){
		int startIndex = dnaString.indexOf("ATG");
		if(startIndex == -1){
			return "";
		}
		int stopIndex = dnaString.indexOf("TAA", startIndex + 3);
		if(stopIndex == -1){
			return "";
		}
		String gene = dnaString.substring(startIndex, stopIndex + 3);
		return gene;
	}
	
	private static String findSimpleGeneReorganized(String dnaString, String startCodon, String stopCodon){
		int startIndex = dnaString.toUpperCase().indexOf(startCodon);
		if(startIndex == -1){
			return "";
		}
		int stopIndex = dnaString.toUpperCase().indexOf(stopCodon, startIndex + 3);
		if(stopIndex == -1){
			return "";
		}
		String gene = dnaString.substring(startIndex, stopIndex + 3);
		return gene;
	}
	
	private static int findStopCodon(String dnaString, int startIndex, String stopCodon){
		int currentIndex = dnaString.indexOf(stopCodon, startIndex + 3);
		while (currentIndex != -1){
			int diff = currentIndex - startIndex;
			if(diff % 3 == 0){
				return currentIndex;
			}
			else{
				currentIndex = dnaString.indexOf(stopCodon, currentIndex + 1);
			}
		}
		return -1;
	}
	
	private static String findGene(String dnaString, int index){
		int startIndex = dnaString.indexOf("ATG", index);
		if(startIndex == -1){
			return "";
		}
		int taaIndex = findStopCodon(dnaString, startIndex, "TAA");
		int tagIndex = findStopCodon(dnaString, startIndex, "TAG");
		int tgaIndex = findStopCodon(dnaString, startIndex, "TGA");
		
		int minIndex = 0;
		if(taaIndex == -1 || tgaIndex != -1 && tgaIndex < taaIndex){
			minIndex = tgaIndex;
		}
		else{
			minIndex = taaIndex;
		}
		if(minIndex == -1 || tagIndex != -1 && tagIndex < minIndex){
			minIndex = tagIndex;
		}
		if(minIndex == -1)
			return "";
		return dnaString.substring(startIndex, minIndex + 3);
		
	}
	
	private static void printAllGenes(String dnaString){
		int startIndex = 0;
		while(true){
			String gene = findGene(dnaString, startIndex);
			if(gene.isEmpty())
				break;
			System.out.println("Gene - " + gene);
			startIndex = dnaString.indexOf(gene, startIndex) + gene.length();
		}
	}
	
	private static int countGenes(String dnaString){
		int startIndex = 0;
		int count = 0;
		while(true){
			String gene = findGene(dnaString, startIndex);
			if(gene.isEmpty())
				break;
			count++;
			startIndex = dnaString.indexOf(gene, startIndex) + gene.length();
		}
		return count;
	}
	
	public static StorageResource getAllGenes(String dnaString){
		StorageResource geneList = new StorageResource();
		int startIndex = 0;
		while(true){
			String gene = findGene(dnaString, startIndex);
			geneList.add(gene);
			if(gene.isEmpty())
				break;
			startIndex = dnaString.indexOf(gene, startIndex) + gene.length();
		}
		return geneList;
		
	}
}
