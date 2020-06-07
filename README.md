Find common words in 2 paragraphs using Java and test automation framework (TestNG) to test the algorithm.

Here is a small intro to the important areas of the repo
1.	TextComparisonLauncher.java has the main method and can be used to launch the application.
  a.	package com.textCompare;
2.	TextComparison.java has the implementation of the method that does that comparison between the two sentences.
  a.	package com.textCompare;
3.	TextComparisonTests.java has all the test cases. Framework developed using TestNG.
  a.	A total of 12 Test Cases that go through different permutations to test the accuracy of the algorithm implemented in TextComparison.java.
  b.	package com.textcompare.test;
4.	TestNG test-runners are 
  a.	RunAllTests.xml
  b.	RunCoreTests.xml
  c.	RunCoreTestsInParallel.xml
5.	Default TestNG Reports are at
  a.	./TextCompare/test-output/index.html
  b.	./TextCompare/test-output/emailable-report.html
6.	Data Driven testing using Excel integration has been implemented for one test case as a proof of concept.
7.	Java Doc is at  ./TextCompare/doc/index.html
8.	Extent Reports are still being worked on.
