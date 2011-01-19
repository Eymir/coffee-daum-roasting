package coffee.daum;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;

public class Main extends Activity implements OnClickListener{
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        findViewById(R.id.makebtn).setOnClickListener(this);
        findViewById(R.id.textbtn).setOnClickListener(this);
        findViewById(R.id.viewbtn).setOnClickListener(this);
    }

	@Override
	public void onClick(View v) {
		Intent intent;
		switch(v.getId()){
		case R.id.makebtn:
			intent = new Intent(Main.this, MakeRecipe.class);
			startActivity(intent);
			break;
		case R.id.textbtn:
			intent = new Intent(Main.this, ViewRecipeText.class);
			startActivity(intent);
			break;
		case R.id.viewbtn:
			intent = new Intent(Main.this, ViewRecipeImage.class);
			startActivity(intent);
			break;
		}
		
	}
    
}