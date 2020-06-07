package com.textCompare;
import java.util.Scanner;

import com.textCompare.TextComparison;

import java.util.Arrays;

public class TextComparisonLauncher {
	public static void main(String[] args) {
		String firstSentence, secondSentence;
		String[] result;
		Scanner scan = new Scanner(System.in);
		System.out.println("Enter the first sentence");
		firstSentence = scan.nextLine();
		System.out.println("Enter the second sentence");
		secondSentence = scan.nextLine();
		TextComparison txtcmpr = new TextComparison();
		result = txtcmpr.getDifferences(firstSentence, secondSentence);
		if(result.length==0)
		{
			System.out.println("There are no unique words in the two sentences you entered");
		}
		else
		{
			System.out.println("Unique Words in the two sentences are: "+ Arrays.toString(result));	
		}
		scan.close();
	}
}