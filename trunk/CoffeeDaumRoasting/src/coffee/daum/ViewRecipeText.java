package coffee.daum;

import java.util.*;

import android.app.*;
import android.database.*;
import android.database.sqlite.*;
import android.os.*;
import android.util.*;
import android.view.*;
import android.view.View.OnClickListener;
import android.widget.*;

public class ViewRecipeText extends Activity implements OnClickListener{
	Button btn;
	TextView viewName;
	TextView viewBean;
	TextView viewTheYear;
	TextView viewDried;
	TextView viewTheDay;
	TextView viewStartTemperature;
	
	RoastingRecipeDBHelper roastingDB;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.viewimage);
		
		viewName = (TextView)findViewById(R.id.viewnametv);
		viewBean = (TextView)findViewById(R.id.viewbeantv);
		viewTheYear = (TextView)findViewById(R.id.viewtheyeartv);
		viewDried = (TextView)findViewById(R.id.viewdriedtv);
		viewTheDay = (TextView)findViewById(R.id.viewthedaytv);
		viewStartTemperature = (TextView)findViewById(R.id.viewstarttemperaturetv);
		
		roastingDB = new RoastingRecipeDBHelper(this);
		findViewById(R.id.testbtn).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		ArrayList<String> tmp = new ArrayList<String>();
		SQLiteDatabase db;
		Cursor cursor;
		Log.d("test","db start");
		switch(v.getId()){
			case R.id.testbtn:
				db = roastingDB.getReadableDatabase();
				try {
					tmp = roastingDB.select(1);
					viewName.setText(tmp.get(0));
					viewBean.setText(tmp.get(1));
					viewTheYear.setText(tmp.get(2));
					viewDried.setText(tmp.get(3));
					viewTheDay.setText(tmp.get(4));
					viewStartTemperature .setText(tmp.get(5));
				} catch (Exception e) {
					// TODO Auto-generated catch block
					Log.d("test","select exception");
					e.printStackTrace();
				}
				cursor = db.rawQuery("SELECT * FROM initrecipe", null);
				cursor.close();
				//String str = " ";
				//str = cursor.toString();
				//Log.d("test",str);
				
			break;
		}
		
	}
}
