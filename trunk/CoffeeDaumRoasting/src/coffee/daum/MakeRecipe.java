package coffee.daum;

import java.util.Calendar;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.EditText;

public class MakeRecipe  extends Activity implements OnClickListener{
	EditText nameEt;
	EditText beanEt;
	EditText driedEt;
	EditText theyearEt;
	EditText thedayEt;
	
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.inputrecipe);
		nameEt = (EditText)findViewById(R.id.nameet);
		beanEt = (EditText)findViewById(R.id.beanet);
		thedayEt = (EditText)findViewById(R.id.thedayet);
		driedEt = (EditText)findViewById(R.id.driedet);
		theyearEt = (EditText)findViewById(R.id.theyearet);
		
		Calendar c = Calendar.getInstance();
		thedayEt.setText(c.get(Calendar.YEAR)+"년"+(c.get(Calendar.MONTH)+1)+"일"+c.get(Calendar.DATE)+"일");
		
		findViewById(R.id.startbtn).setOnClickListener(this);
	}

	@Override
	public void onClick(View v) {
		
		Intent intent = new Intent(MakeRecipe.this, EditingRecipe.class);
		intent.putExtra("name", nameEt.getText().toString());
		intent.putExtra("bean", beanEt.getText().toString());
		intent.putExtra("theday", thedayEt.getText().toString());
		intent.putExtra("dried", driedEt.getText().toString());
		intent.putExtra("theyear", theyearEt.getText().toString());
		startActivity(intent);
	}
	
}
