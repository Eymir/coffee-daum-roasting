package coffee.daum;

import java.util.*;


public class RecipeInfo {
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getBean() {
		return bean;
	}

	public void setBean(String bean) {
		this.bean = bean;
	}

	public String getTheyear() {
		return theyear;
	}

	public void setTheyear(String theyear) {
		this.theyear = theyear;
	}

	public String getDried() {
		return dried;
	}

	public void setDried(String dried) {
		this.dried = dried;
	}

	public String getTheday() {
		return theday;
	}

	public void setTheday(String theday) {
		this.theday = theday;
	}

	public int getStarttemperature() {
		return starttemperature;
	}

	public void setStarttemperature(int starttemperature) {
		this.starttemperature = starttemperature;
	}

	private String name;			//recipe name
	private String bean;			//coffee bean name
	private String theyear;			//bean birth year
	private String dried;			//kind of bean dried
	private String theday;			//today
	private int starttemperature;	//roasting start temperature
	ArrayList<cracked> crackList;	//set option, 1st cracked, 2nd cracked
	
	public ArrayList<cracked> getCrackList() {
		return crackList;
	}

	public void setCrackList(ArrayList<cracked> crackList) {
		this.crackList = crackList;
	}



}


//db.execSQL("CREATE TABLE initrecipe( _id INTEGER PRIMARY KEY AUTOINCREMENT,"+
//"name TEXT, bean TEXT, theyear TEXT, dried TEXT, theday TEXT, starttemperature INTEGER)");
//Log.d("DB onCreate", "initrecipe table is created!");
//db.execSQL("CREATE TABLE control( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT, crack INTEGER," +
//"num INTEGER, firepower INTEGER, nowtemperature INTEGER, damper INTEGER, time TEXT)");
//Log.d("DB onCreate", "control table is created!");
//db.setTransactionSuccessful();