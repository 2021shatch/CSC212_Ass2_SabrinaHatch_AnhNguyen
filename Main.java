import java.util.*;
import java.io.*;  

/**
 *. Main method runs all of our tests and the proPublica 
 *. method
 * 
 *  @author Sabrina Hatch, Anh Nguyen
 *. @version Spring 2022
 */
public class Main 
{
  // this runs the test and also creates a new instance of DefendantGroup which contains all the data in the csv file
  // it also runs the analysis code
  public static void main(String[] args) 
  {
		// create new instance of DefendantGroup
		DefendantGroup defendantGroup = new DefendantGroup("compas-scores.csv");
		// run proPublica analysis
		defendantGroup.proPublica();

		// run various tests
    testConstructor();
    testSetters();
    testBools();
    testStringConstructor();
		//testDef();
    //testFile is commented out because it prints the whole data file to the console and it's insane.
    //testFileReader();
  }    

  
  
	/* Tests the Defendant construction method */
  public static void testConstructor() 
  {
    /* dummy Defendant object to be used as a test case */
		Defendant testMe = new Defendant("female", "African American", "M", "grand theft auto", 1, "Low", 1, "arsony", "M4");
  
    /* tests the constructer and the getter methods for each field
    */
		TestCode.beginTest("Contructor");
    TestCode.subTest("Constructor sex", testMe.getSex().equals("female"));
		TestCode.subTest("Constructor race", testMe.getRace().equals("African American"));
		TestCode.subTest("Constructor charge degree", testMe.getCDegree().equals("M"));
		TestCode.subTest("Constructor charge degree", testMe.getCDesc().equals("grand theft auto"));
		TestCode.subTest("Constructor charge degree", testMe.getScore()==1);
		TestCode.subTest("Constructor charge degree", testMe.getScoreText().equals("Low"));
		TestCode.subTest("Constructor charge degree", testMe.getTwoYearRecid()==1);
		TestCode.subTest("Constructor charge degree", testMe.getRDesc().equals("arsony"));
		TestCode.subTest("Constructor charge degree", testMe.getRDeg().equals("M4"));
    TestCode.concludeTest();
  }

	/* tests the accessor and manipulator methods for DefendantGroup class */
    
   public static void testDef()
  {
    // constructs an object 
		DefendantGroup defendantGroup = new DefendantGroup("compas-scores.csv");
		
		Defendant testMe = new Defendant("female", "African American", "M", "grand theft auto", 1, "Low", 1, "arsony", "M4");
  
    //test the accessor and manipulator method for each field
		defendantGroup.addDefendant(testMe);
		System.out.println(defendantGroup.getDefendant(defendantGroup.size()-1));
		defendantGroup.removeDefendant(defendantGroup.size()-1);
		System.out.println(defendantGroup.getDefendant(defendantGroup.size()-1));
  } 
 

	/* Tests the Defendant setter methods */
	public static void testSetters() 
  {
		/* constructs a dummy object to be used as a test case */
		Defendant testMe = new Defendant("female", "White", "M", "jaywalking", 2, "High", 3, "robberry", "H");
		
		/* setting new value to fields */
		testMe.setSex("male");
		testMe.setRace("African American");
		testMe.setCDegree("M");
		testMe.setCDesc("grand theft auto");
		testMe.setScore(1);
		testMe.setScoreText("Low");
		testMe.setTwoYearRecid(1);
		testMe.setRDesc("arsony");
		testMe.setRDeg("M4");

		/* test that new values from setter are correct using getter methods for each field
    */
		TestCode.beginTest("Setter");
    TestCode.subTest("Setter sex", testMe.getSex().equals("male"));
		TestCode.subTest("Setter race", testMe.getRace().equals("African American"));
		TestCode.subTest("Setter charge degree", testMe.getCDegree().equals("M"));
		TestCode.subTest("Setter charge degree", testMe.getCDesc().equals("grand theft auto"));
		TestCode.subTest("Setter charge degree", testMe.getScore()==1);
		TestCode.subTest("Setter charge degree", testMe.getScoreText().equals("Low"));
		TestCode.subTest("Setter charge degree", testMe.getTwoYearRecid()==1);
		TestCode.subTest("Setter charge degree", testMe.getRDesc().equals("arsony"));
		TestCode.subTest("Setter charge degree", testMe.getRDeg().equals("M4"));
    TestCode.concludeTest();
	}
	
	/* Tests the isWhite(), isBlack(), hasReoffended(), isLowRisk(), and isHighRisk() methods */
  public static void testBools() 
  {
    /* dummy object to be use as a test case */
		Defendant testMe = new Defendant("female,African-American,M,grand theft auto,1,Low,1,arsony,M4");
  
    /* tests the isWhite(), isBlack(), hasReoffended(), and isLowRisk() method using booleans
    */
		TestCode.beginTest("Booleans");
    TestCode.subTest("White", testMe.isWhite() == false);
		TestCode.subTest("Black", testMe.isBlack() == true);
		TestCode.subTest("Reoffended", testMe.hasReoffended() == true);
		TestCode.subTest("Low risk", testMe.isLowRisk() == true);
    TestCode.concludeTest();
  }

	/* Tests the constructor that makes an instance of Defendant from a row in the CSV file */
  public static void testStringConstructor() 
  {
	/* constructs a dummy object to be used as a test case */
	Defendant testMe = new Defendant("female,African American,M,grand theft auto,1,Low,1,arsony,M4");

	/* tests the constructor and getter methods for each field
	*/
	TestCode.beginTest("String contructor");
	TestCode.subTest("Constructor sex", testMe.getSex().equals("female"));
	TestCode.subTest("Constructor race", testMe.getRace().equals("African American"));
	TestCode.subTest("Constructor charge degree", testMe.getCDegree().equals("M"));
	TestCode.subTest("Constructor charge degree", testMe.getCDesc().equals("grand theft auto"));
	TestCode.subTest("Constructor charge degree", testMe.getScore()==1);
	TestCode.subTest("Constructor charge degree", testMe.getScoreText().equals("Low"));
	TestCode.subTest("Constructor charge degree", testMe.getTwoYearRecid()==1);
	TestCode.subTest("Constructor charge degree", testMe.getRDesc().equals("arsony"));
	TestCode.subTest("Constructor charge degree", testMe.getRDeg().equals("M4"));
	TestCode.concludeTest();
  }

	/* Tests the construction of instances of Defendant from each row from the CSV file */
  public static void testFileReader() 
  {
    Scanner file = null;
		try 
    {
			file = new Scanner(new File("compas-scores.csv"));
		} 
    catch (FileNotFoundException e) 
    {
			System.err.println("Cannot locate file.");
			System.exit(-1);
		}
		while (file.hasNextLine()) 
    {
			//take each row or "file" in CSV and save to line
			String line = file.nextLine();
      Defendant d = new Defendant(line);
		}
		file.close();
	}

}