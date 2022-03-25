import java.util.*;
import java.io.*;
/**
 *. Class to represent the whole dataset of defendants
 *
 *  @author Sabrina Hatch, Anh Nguyen
 *. @version Spring 2022
 */
 //

public class DefendantGroup
{
	/* ArrayList that stores all the instances of Defendant*/
  private ArrayList<Defendant> arrayOfDef = new ArrayList<Defendant>();

	/* Reads file then creates and adds a Defendant from each line in the file */
	public DefendantGroup(String filename) 
  {
		Scanner file = null;
		try 
    {
			file = new Scanner(new File(filename));
		} 
    catch (FileNotFoundException e) 
    {
			System.err.println("Cannot locate file.");
			System.exit(-1);
		}
		while (file.hasNextLine()) 
    {
			//take each line n CSV and save to line
			String line = file.nextLine();
      Defendant d = new Defendant(line);
			arrayOfDef.add(d);
		}
		file.close();
	}

  /* adds one Defendant object to the collection */
  public void addDefendant(Defendant d)
  {
    arrayOfDef.add(d);
  }

	/* returns the i_th Defendant stored in the collection */
  public Defendant getDefendant(int i)
  {
    return arrayOfDef.get(i);
  }

	/* deletes the i_th Defendant stored in the collection */
  public void removeDefendant(int i)
  {
    arrayOfDef.remove(i);
  }

	/* return the total number of defendants stored in the collection. */
   public int size()
  {
    return arrayOfDef.size();
  }
	
	/* reproduce the ProPublica results */
  public void proPublica()
  {
    // variables to count particular categories
	// note that medium and high risk are counted here as high
	int wly = 0; // White, low risk, has reoffended
	int wln = 0; // White, low risk, has not reoffended
	int bly = 0; // Black, low risk, has reoffended
	int bln = 0; // Black, low risk, has not reoffended
	int why = 0; // White, high risk, has reoffended
	int whn = 0; // White, high risk, has not reoffended
	int bhy = 0; // Black, high risk, has reoffended
	int bhn = 0; // Black, high risk, has not reoffended

	// loops to count sums
	for (int i = 0; i < size(); i++) 
  {
		Defendant d = getDefendant(i);
		if (d.isWhite()&&d.isLowRisk()&&d.hasReoffended()) 
    {
			wly++;
		} 
    else if (d.isWhite()&&d.isLowRisk()&&!d.hasReoffended())
    {
			wln++;
		} 
    else if (d.isBlack()&&d.isLowRisk()&&d.hasReoffended()) 
    {
			bly++;
		} 
    else if (d.isBlack()&&d.isLowRisk()&&!d.hasReoffended()) 
    {
			bln++;
		} 
    else if (d.isWhite()&&!d.isLowRisk()&&d.hasReoffended())
    {
			why++;
		} 
    else if (d.isWhite()&&!d.isLowRisk()&&!d.hasReoffended()) 
    {
			whn++;
		} 
    else if (d.isBlack()&&!d.isLowRisk()&&d.hasReoffended())
    {
			bhy++;
		} 
    else if (d.isBlack()&&!d.isLowRisk()&&!d.hasReoffended()) 
    {
			bhn++;
		}
	}

	// prints the results of ProPublica data analysis
	System.out.println("White, high risk, didn't reoffend: "+whn*100.0/(whn+wln)+" %");
	System.out.println("Black, high risk, didn't reoffend: "+bhn*100.0/(bhn+bln)+" %");
	System.out.println("White, low risk, did reoffend: "+wly*100.0/(wly+why)+" %");
	System.out.println("Black, low risk, did reoffend: "+bly*100.0/(bly+bhy)+" %");
		}
}