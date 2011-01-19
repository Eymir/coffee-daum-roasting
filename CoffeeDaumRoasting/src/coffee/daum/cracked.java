package coffee.daum;

public class cracked {
	String name;		//recipe name
	int num;			//crack number
	int firepower;		//# of fire power
	int nowtemperature;	//now temperature when changing option, 1st 2nd  cracked
	int damper;			//damper
	String time;		// now time
	
	public void setCrackList(String name,int num,int firepower,int nowtemperature,int damper,String time){
		this.name = name;
		this.num = num;
		this.firepower=firepower;
		this.nowtemperature=nowtemperature;
		this.damper=damper;
		this.time=time;
	}	
}