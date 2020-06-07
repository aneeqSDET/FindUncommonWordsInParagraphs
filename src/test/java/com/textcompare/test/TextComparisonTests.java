package com.textcompare.test;
import com.textCompare.TextComparison;
import com.util.ExcelUtility;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;

@Test (groups="AllTestCases")
public class TextComparisonTests {
	String firstSentence;
	String secondSentence;
	TextComparison txtComparison = new TextComparison();
	ExcelUtility excelUtil = new ExcelUtility();
	
	@BeforeTest
	public static void setup(){
	}
	@Test (priority=1, groups="CoreTests", description="Some non-matching words in both")
	public void testSomeUncommonWordsinBoth(){
		firstSentence=excelUtil.getFirstSentence(1);
		secondSentence=excelUtil.getSecondSentence(1);
		String[] expectedResult= excelUtil.getExpectedResults(1).split(" ");
		String[]actualResult = txtComparison.getDifferences(firstSentence, secondSentence);
		Assert.assertEquals(actualResult,expectedResult,"Test Passed");
		}
	@Test (priority=1, groups="CoreTests", description="Some non-matching words in First Sentence")
	public void testSomeUncommonWordsinFirst(){
		firstSentence="This is first sentence";
		secondSentence="This is sentence";
		String[] expectedResult= {"first"};
		String[]actualResult = txtComparison.getDifferences(firstSentence, secondSentence);
		Assert.assertEquals(actualResult,expectedResult,"Test Passed");
		}
	@Test (priority=1, groups="CoreTests", description="Some non-matching words in Second Sentence")
	public void testSomeUncommonWordsinSecond(){
		firstSentence="This is sentence";
		secondSentence="This is second sentence";
		String[] expectedResult= {"second"};
		String[]actualResult = txtComparison.getDifferences(firstSentence, secondSentence);
		Assert.assertEquals(actualResult,expectedResult,"Test Passed");
		}
	@Test (priority=1, groups="CoreTests", description="All non-matching words")
	public void testAllUncommonWords(){
		firstSentence="my favorite";
		secondSentence="butter pecan";
		String[] expectedResult= {"butter","favorite","my","pecan"};
		String[] actualResult = txtComparison.getDifferences(firstSentence, secondSentence);
		Assert.assertEquals(actualResult,expectedResult,"Test Passed");
		}
	@Test (priority=1, groups="CoreTests", description="All matching words")
	public void testNoUncommonWords(){
		firstSentence="Praline and Cream";
		secondSentence="Praline and Cream";
		String[] expectedResult= {};
		String[] actualResult = txtComparison.getDifferences(firstSentence, secondSentence);
		Assert.assertEquals(actualResult,expectedResult,"Test Passed");
		}
	@Test (priority=1, groups="CoreTests", description="Word is repeated with different case")
	public void testCaseSensitivityofUncommonWords(){
		firstSentence="Good Icecream";
		secondSentence="Good icecream";
		String[] expectedResult= {};
		String[] actualResult = txtComparison.getDifferences(firstSentence, secondSentence);
		Assert.assertEquals(actualResult,expectedResult,"Test Passed");
		}
	@Test (priority=1, groups="CoreTests", description="Word is repeated with punctuation")
	public void testUncommonWordsWithPunctuation(){
		firstSentence="Good Icecream.";
		secondSentence="Good Icecream";
		String[] expectedResult= {};
		String[] actualResult = txtComparison.getDifferences(firstSentence, secondSentence);
		Assert.assertEquals(actualResult,expectedResult,"Test Passed");
		}
	@Test (priority=1, groups="CoreTests", description="Word is repeated in same sentence but not present in second sentence")
	public void testRepeatingUncommonWords(){
		firstSentence="Very Very Good Icecream";
		secondSentence="Good Icecream";
		String[] expectedResult= {};
		//Since it was not mentioned in the doc/user story, assumption is being made that if a word appears twice in any 1 sentence then it will be considered as a repeating word and hence will not be included in the result string
		String[] actualResult = txtComparison.getDifferences(firstSentence, secondSentence);
		Assert.assertEquals(actualResult,expectedResult,"Test Passed");
		}
	@Test (groups="SecondaryTests", description="Word is repeated with numbers")
	//Group Name SecondaryTests does not represent the lack of importance of these tests but this group is made to demonstrate how grouping can help us compartmentalize tests into targeted groups.
	public void testUncommonWordsWithNumbers(){
		firstSentence="Good Icecream1";
		secondSentence="Good Icecream";
		String[] expectedResult= {"Icecream","Icecream1"};
		String[] actualResult = txtComparison.getDifferences(firstSentence, secondSentence);
		Assert.assertEquals(actualResult,expectedResult,"Test Passed");
		}
	@Test (groups="SecondaryTests", description="Paragraph")
	public void testLongSentence(){
		firstSentence="This is a really long and drawn out sentence to to test this: to see if the algo slows down. This string contains multiple sentences but it the same as the first string except for 1 word";
		secondSentence="This is a really long and drawn out sentence to to test this: to see if the algo slows down. This string contains multiple sentences but it the same as the first string except for 1 word"+" ThisIsTheOnlyUnCommonWord";
		String[] expectedResult= {"ThisIsTheOnlyUnCommonWord"};
		String[] actualResult = txtComparison.getDifferences(firstSentence, secondSentence);
		Assert.assertEquals(actualResult,expectedResult,"Test Passed");
		}
	@Test (groups="SecondaryTests", description="One Word")
	public void testOneWord(){
		firstSentence="Good";
		secondSentence="Good";
		String[] expectedResult= {};
		String[] actualResult = txtComparison.getDifferences(firstSentence, secondSentence);
		Assert.assertEquals(actualResult,expectedResult,"Test Passed");
		}
	@Test (groups="SecondaryTests", description="Empty String")
	public void testEmptyString(){
		firstSentence="";
		secondSentence="";
		String[] expectedResult= {};
		String[] actualResult = txtComparison.getDifferences(firstSentence, secondSentence);
		Assert.assertEquals(actualResult,expectedResult,"Test Passed");
		}
	@AfterTest
	public void teardown(){
		}
	/*
**********************************************************************
	Extent Report Block
	ExtentHtmlReporter htmlReporter = new ExtentHtmlReporter("./test-output/ExtentReport.html");
	ExtentReports extent = new ExtentReports();
	extentRep.attachReporter(extent);
**********************************************************************
*/
	/*
	 * //import com.util.ExcelUtility;
	 * 		//ExcelUtility e = new ExcelUtility();
		//System.out.println(e.getFirstSentence(2));
		//System.out.println(e.getSecondSentence(1));
		//System.out.println(e.getExpectedResults(1));
	 */
}