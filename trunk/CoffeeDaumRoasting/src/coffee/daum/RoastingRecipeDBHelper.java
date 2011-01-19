package coffee.daum;

import java.util.*;

import android.content.*;
import android.database.*;
import android.database.sqlite.*;
import android.util.*;

public class RoastingRecipeDBHelper extends SQLiteOpenHelper{
	
	private final static String dbname="coffeerecipe.db";
	private final static String table1name="initrecipe";
	private final static String table2name="control";
	private SQLiteDatabase mDatabase;

	public RoastingRecipeDBHelper(Context context) {
		super(context, dbname, null, 1);
		mDatabase = this.getWritableDatabase();
		// TODO Auto-generated constructor stub
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		try{
			
			db.execSQL("CREATE TABLE initrecipe( _id INTEGER PRIMARY KEY AUTOINCREMENT,"+
					"name TEXT, bean TEXT, theyear TEXT, dried TEXT, theday TEXT, starttemperature INTEGER)");
			Log.d("DB onCreate", "initrecipe table is created!");
			db.execSQL("CREATE TABLE control( _id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT," +
					"num INTEGER, firepower INTEGER, nowtemperature INTEGER, damper INTEGER, time TEXT)");
			Log.d("DB onCreate", "control table is created!");
			db.setTransactionSuccessful();
			ContentValues v = new ContentValues();
			v.put("name", "테스트");
			v.put("bean", "테스트용");
			v.put("theyear","2010년");
			v.put("dried","건조방식은몰라");
			v.put("theday", "2010-12-08");
			v.put("starttemperature", 100);
			mDatabase.insert(table1name, null, v);
			
			Log.d("test", "table is created!");
			}catch(SQLException e){
				Log.e("DB onCreate", e.toString());
			}catch(Exception e){
				Log.e("DB oncreate", e.toString());
			}finally{
				//db.endTransaction();
			}
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		
	}
	//initrecipe table insert method
	public void insert(String name, String bean, String theyear, String dried, String theday, String sttem) throws Exception{
		ContentValues v = new ContentValues();
		v.put("name", name);
		v.put("bean", bean);
		v.put("theyear",theyear);
		v.put("dried",dried);
		v.put("theday", theday);
		v.put("starttemperature", sttem);
		mDatabase.insert(table1name, null, v);
	}
	//control table insert method
	public void insert(String name, int num, int firepower, int nowtemperature, int damper, String time){
		ContentValues v = new ContentValues();
		v.put("name", name);
		v.put("num", num);
		v.put("firepower", firepower);
		v.put("nowtemperature", nowtemperature);
		v.put("damper", damper);
		v.put("time", time);
		mDatabase.insert(table2name, null, v);
	}
	
	//delete both tables
	public void delete(String name) throws Exception{
		String sql = "delete from initrecipe where name='"+name+"' ";
		mDatabase.execSQL(sql);
		sql = "delete from control where name='"+name+"'";
		mDatabase.execSQL(sql);
	}
	
	public void update(){
		
	}
	
	public ArrayList<String> select(int _id) throws Exception{
		ArrayList<String> v = new ArrayList<String>();
		
		Cursor c = mDatabase.query(table1name, new String[]{"name", "bean","theyear","dried", "theday", "starttemperature",},"_id='"+_id+"'", null,null,null,null);
		c.moveToFirst();
		
		v.add(c.getString(0));
		v.add(c.getString(1));
		v.add(c.getString(2));
		v.add(c.getString(3));
		v.add(c.getString(4));
		v.add(c.getString(5));
		c.close();
		
		return v;
	}
}
