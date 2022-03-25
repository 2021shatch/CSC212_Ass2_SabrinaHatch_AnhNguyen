
/**
 *. Class to represent the characteristics of
 *. one defendant from a dataset
 *
 *  @author Sabrina Hatch, Anh Nguyen
 *. @version Spring 2022
 */

 // this class will help us create "files" about each defedant to be stored in an array
public class Defendant implements ProPublica 
{


  /** Sex of defendant */
  private String sex;

	/** Race of defendant */
  private String race;

	/** Degree of defendant's charge */
  private String c_charge_degree;

	/** Description of defendant's charge */
  private String c_charge_desc;

	/** decile score of defendant */
  private int decile_score;

	/** Grouping based on decile score of defendant*/
  private String score_text;

	/** Whether there is recidivism in the next two years  */
  private int two_year_recid;

	/** Description of defendant's charge */
  private String r_charge_desc;

	/** Description of defendant's charge */
  private String r_charge_degree;

  /**
  * Constructor. Creates a defendant object with the following attributes
  * 
  * @param sex (required) defendant's sex
  * @param race (required) defendant's race
  * @param c_charge_degree (required) degree of defendant's * charge
	* @param c_charge_desc (required) description of defendant's * charge
	* @param decile_score (required) COMPAS score
	* @param score_text (required) tells the group of low/high * risk based on score
	* @param two_year_recid (required) 
	* @param r_charge_desc (required)
	* @param r_charge_degree (required)
  */
  public Defendant(String sex, String race, String c_charge_degree, String c_charge_desc, int decile_score, String score_text, int two_year_recid, String r_charge_desc, String r_charge_degree)
    {
        this.sex = sex;
        this.race = race;
        this.c_charge_degree = c_charge_degree;
        this.c_charge_desc = c_charge_desc;
        this.decile_score = decile_score;
        this.score_text = score_text;
        this.two_year_recid = two_year_recid;
        this.r_charge_desc = r_charge_desc ;
        this.r_charge_degree = r_charge_degree;
    }
	
	//setter for sex
	public void setSex(String sex) 
  {
   this.sex = sex;
	}
	
	//getter for sex
	public String getSex() 
  { 
		return sex; 
	}
	
	//setter for race
	public void setRace(String race) 
  {
   this.race = race;
	}
	
	//getter for race
	public String getRace() 
  { 
		return race; 
	}
	
	//setter for Degree of defendant's charge
	public void setCDegree(String c_charge_degree) 
  {
   this.c_charge_degree = c_charge_degree;
	}
	
	//getter for Degree of defendant's charge
	public String getCDegree() 
  { 
		return c_charge_degree; 
	}

	//setter for description of defendant's charge
	public void setCDesc(String c_charge_desc) 
  {
   this.c_charge_desc = c_charge_desc;
	}
	
	//getter for description of defendant's charge
	public String getCDesc() 
  { 
		return c_charge_desc; 
	}

	//setter for decile score
	public void setScore(int decile_score) 
  {
   this.decile_score = decile_score;
	}
	
	//getter for decile score
	public int getScore() 
  { 
		return decile_score; 
	}

	//setter for low/high risk 
	public void setScoreText(String score_text) 
  {
   this.score_text = score_text;
	}
	
	//getter for low/high risk 
	public String getScoreText() 
  { 
		return score_text; 
	}

	//setter for whether there is recidivism
	public void setTwoYearRecid(int two_year_recid) 
  {
   this.two_year_recid = two_year_recid;
	}
	
	//getter for whether there is recidivism
	public int getTwoYearRecid() 
  { 
		return two_year_recid; 
	}
	
	//setter for recidivism description
	public void setRDesc(String r_charge_desc) 
  {
   this.r_charge_desc = r_charge_desc;
	}
	
	//getter for recidivism description
	public String getRDesc() 
  { 
		return r_charge_desc; 
	}
	
	//setter for recidivism degree
	public void setRDeg(String r_charge_degree) 
  {
   this.r_charge_degree = r_charge_degree;
	}
	
	//getter for recidivism degree
	public String getRDeg() 
  { 
		return r_charge_degree; 
	}
	// converts what's saved in a defendant object to a string so it can be printed out and can check to see what's going on inside an object we create
	public String toString()
  {
		String defendantInfo;
		defendantInfo = sex + ", " + race + ", " + c_charge_degree + ", " + c_charge_desc + ", " + Integer.toString(decile_score) + ", " + score_text + ", " + Integer.toString(two_year_recid) + ", " + r_charge_desc + ", " + r_charge_degree;
		return defendantInfo;
	}

  /**
  * Constructor.
  * 
  * @param row (required) a line from "compas-score.csv"
  */
	public Defendant (String row) 
  {
    //this splits the string by commas, but ignores a comma if it's enclosed by a pair of parentheses - used to solve "3,4" dilemma
		String[] parseDefAtts = row.split(",(?=(?:[^\"]*\"[^\"]*\")*[^\"]*$)", -1);

		//sets each attribute to an index of the string array "row"
		this.sex = parseDefAtts[0];
		this.race = parseDefAtts[1];
		this.c_charge_degree = parseDefAtts[2];
		this.c_charge_desc = parseDefAtts[3];
		this.decile_score = Integer.parseInt(parseDefAtts[4]);
		this.score_text = parseDefAtts[5];
		this.two_year_recid = Integer.parseInt(parseDefAtts[6]);
		this.r_charge_desc = parseDefAtts[7];
		this.r_charge_degree = parseDefAtts[8];
    
	}
  
	// checks to see if the defendant is white, returns a boolean
	public boolean isWhite()
  {
		if (race.equals("Caucasian"))
    {
			return true;
		} 
    else 
    {
			return false;
		}
	}
	
	// checks to see if the defendant is black, returns a boolean
  public boolean isBlack()
  {
    if (race.equals("African-American"))
    {
      return true;
    }
    else
    {
      return false;
    }
		
	}
// checks to see if the defendant has reoffended, returns a boolean
  public boolean hasReoffended()
  {
		if (two_year_recid == 1)
    {
      return true;
    }
    else
    {
      return false;
    }
	}
// checks to see if the defendant is low risk, returns a boolean
  public boolean isLowRisk()
  {
		if (score_text.equals("Low"))
    {
      return true;
    }
    else
    {
      return false;
    }
	}
  
}