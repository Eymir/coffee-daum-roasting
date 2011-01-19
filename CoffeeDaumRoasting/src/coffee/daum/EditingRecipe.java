package coffee.daum;

import java.util.*;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class EditingRecipe extends Activity{
	Button timerbtn;
	TextView timerShow;
	int hour;
	int min;
	int sec;
	TextView iName;
	TextView iBean;
	//TextView iDried;
	//TextView iTheYear;
	TextView iTheDay;
	TextView resultOutput;
	
	
	EditText tempratureEt;
	EditText damperEt;
	EditText firePowerEt;
	
	RecipeInfo recipeInfo;
	
	StringBuilder output;
	int crackcount = 1;
	private Handler handler;
	
	RoastingRecipeDBHelper recipeDBHelper;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		//initialize
		super.onCreate(savedInstanceState);
		setContentView(R.layout.timer);
		timerShow = (TextView)findViewById(R.id.timershow);
		timerbtn = (Button)findViewById(R.id.timer);
		iName = (TextView)findViewById(R.id.intentnametv);
		iBean = (TextView)findViewById(R.id.intentbeantv);
		//iDried = (TextView)findViewById(R.id.intentdriedtv);
		//iTheYear = (TextView)findViewById(R.id.intenttheyeartv);
		iTheDay = (TextView)findViewById(R.id.intentthedaytv);
		resultOutput = (TextView)findViewById(R.id.outputtv);
		
		tempratureEt = (EditText)findViewById(R.id.temperatureet);
		damperEt = (EditText)findViewById(R.id.damperet);
		firePowerEt = (EditText)findViewById(R.id.firepoweret);
		
		recipeInfo = new RecipeInfo();
		recipeInfo.crackList = new ArrayList<cracked>();
		
		handler = new Handler();
		
		Intent intent = getIntent();
		
		output = new StringBuilder();
		
		recipeDBHelper = new RoastingRecipeDBHelper(this);
		
		hour = 0;
		min = 0;
		sec = 0;
		
		//intent data setting
		String temp1 = intent.getStringExtra("name");
		iName.setText(temp1);
		recipeInfo.setName(temp1);
		String temp2 = intent.getStringExtra("bean");
		iBean.setText(temp2);
		recipeInfo.setBean(temp2);
		String temp3 = intent.getStringExtra("dried");
		//iDried.setText(temp3);
		recipeInfo.setDried(temp3);
		String temp4 = intent.getStringExtra("theyear");
		//iTheYear.setText(temp3);
		recipeInfo.setTheyear(temp4);
		String temp5 = intent.getStringExtra("theday");
		iTheDay.setText(temp5);
		recipeInfo.setTheday(temp5);
		try {
			recipeDBHelper.insert(temp1, temp2, temp4, temp3, temp5, "0");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//timer start button
		//if clicked, timer move.
		timerbtn.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
					TimerTask task = new TimerTask(){
						@Override 
						public void run(){
							Runnable r = new Runnable(){
								public void run(){
									sec++;
									if(sec>=60){
										min++;
										sec=0;
									}
									if(min>=60){
										hour++;
										min=0;
									}
									timerShow.setText(
											" " + String.format("%02d", hour) + 
											":" + String.format("%02d", min) + 
											":" + String.format("%02d", sec));
								}
							};
							handler.post(r);
						}
					};
					Timer timer = new Timer();
					timer.schedule(task, 0,1000);
					
				}
		});
		
		//change setting. temperature, damper, firepower, and crack number is written to DB
		findViewById(R.id.settingchangetbtn).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String t1;
				int t2 = 0;
				int t3 = 0;
				int t4 = 0;
				cracked crk = new cracked();
				t1 = timerShow.getText().toString();
				t2 = Integer.parseInt(tempratureEt.getText().toString());
				if(t2==0){
					t2 = 100;
				}
				t3 = Integer.parseInt(damperEt.getText().toString());
				if(t3==0){
					t3 = 5;
				}
				if(t3>5){
					t3 = 5;
				}
				t4 = Integer.parseInt(firePowerEt.getText().toString());
				if(t4==0){
					t4 = 5;
				}
				if(t4>5){
					t4 = 5;
				}
				crk.setCrackList(recipeInfo.getName(), crackcount, t4, t2, t3, t1);
				recipeInfo.crackList.add(crk);
				recipeDBHelper.insert(crk.name, crk.num, crk.firepower, crk.nowtemperature, crk.damper, crk.time);
				output.append(R.string.sigan+":" + t1 + " " 
						+ R.string.ondo+":" + t2 + R.string.subssi + " "  
						+ R.string.damper + ":" + t3 + " " 
						+ R.string.hwaryuk + ":" + t4 + "\n");
				//output.append(timerShow.getText().toString().trim());
				resultOutput.setText(output);
				
			}
			
		});

		findViewById(R.id.crack1stbtn).setOnClickListener(new OnClickListener(){
			
			@Override
			public void onClick(View v) {
				String str = "test\n";
				output.append(str);
				resultOutput.setText(output);
			}
			
		});

		findViewById(R.id.crack2stbtn).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String str = "test\n";
				output.append(str);
				resultOutput.setText(output);
			}
			
		});	
		
		findViewById(R.id.endroastingbtn).setOnClickListener(new OnClickListener(){

			@Override
			public void onClick(View v) {
				String str = "test\n";
				output.append(str);
				resultOutput.setText(output);				
			}
			
		});		
	}
	
/*		mHandler.sendEmptyMessage(0);
		timerbtn.setOnClickListener(new OnClickListener(){
			public void onClick(View v) {
				
				}
		});
	}
	
	Handler mHandler = new Handler(){
		public void HandleMessage(Message msg){
			sec++;
			if(sec>=60){sec=0;min++;}
			if(min>=60){min=0;hour++;}
			timerShow.setText(" TIMER : "+hour+":"+min+":"+sec);
			mHandler.sendEmptyMessageDelayed(0, 1000);
			//timerShow.invalidate();
		}
	};*/
	
	
}
