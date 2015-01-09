package com.example.sqlite;

import android.app.Activity;
import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	EditText name, number;
	TextView tv;
	SQLiteDatabase db;
	SQLite dbHelper;
	String DATABASE_TABLE = "table1";
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		name = (EditText) findViewById(R.id.editText1);
		number = (EditText) findViewById(R.id.editText2);
		tv = (TextView) findViewById(R.id.textView3);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	// ·s¼W
	public void bt1(View v) {
		String aa = name.getText().toString();
		String bb = number.getText().toString();
		//¶}±Ò¸ê®Æ®w
		dbHelper = new SQLite(getBaseContext());
		db =dbHelper.getWritableDatabase();
		//¼g¤JSQLite
		ContentValues cv = new ContentValues();
		cv.put("Name", aa);
		cv.put("Number", bb);
		db.insert(DATABASE_TABLE,null,cv);
		//Ãö³¬¸ê®Æ®w
		dbHelper.close();
		db.close();
		tv.setText("·s¼W¤@µ§¸ê®Æ");
		
	}		
	// ­×§ï™¤
	public void bt2(View v) {
		String aa = name.getText().toString();
		String bb = number.getText().toString();
		//¶}±Ò¸ê®Æ®w
		dbHelper = new SQLite(getBaseContext());
		db =dbHelper.getWritableDatabase();
		//¼g¤JSQLite
		ContentValues cv = new ContentValues();
		cv.put("Name", aa);
		cv.put("Number", bb);
		//
		db.update(DATABASE_TABLE,cv,"Name='" + aa +"'", null );
		//Ãö³¬¸ê®Æ®w
		dbHelper.close();
		db.close();
		tv.setText("­×§ï¤@µ§¸ê®Æ");
	}

	// ²¾°£”¹
	public void bt3(View v) {
		String aa = name.getText().toString();
		//
		//¶}±Ò¸ê®Æ®w
		dbHelper = new SQLite(getBaseContext());
		db =dbHelper.getWritableDatabase();
		//
		db.delete(DATABASE_TABLE, "Name ,'" + aa +"'", null );
		//Ãö³¬¸ê®Æ®w
		dbHelper.close();
		db.close();
		tv.setText("§R°£¤@µ§¸ê®Æ");
	}

	// ¬d¸ß
	public void bt4(View v) {
		String[] item = { "_id", "Name" , "Number" };
		StringBuffer sb = new StringBuffer();
		sb.append("ID");
		sb.append("\t");
		sb.append("©m¦W");
		sb.append("\t\t\t");
		sb.append("¾Ç¸¹");
		sb.append("\n");
//		tv.setText(sb);

		//¶}±Ò¸ê®Æ®w
		dbHelper = new SQLite(getBaseContext());
		db =dbHelper.getWritableDatabase();
		//¬d¸ß
		Cursor c = db.query(DATABASE_TABLE, item, null, null, null, null, null);
		c.moveToFirst();
		
		for (int i = 0; i < c.getCount(); i++){
			sb.append(c.getString(0));
			sb.append("\t");
			sb.append(c.getString(1));
			sb.append("\t");
			sb.append(c.getString(2));
			sb.append("\n");
			c.moveToNext();
		}
		tv.setText(sb);
		//Ãö³¬¸ê®Æ®w
		dbHelper.close();
		db.close();
		
	}	

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
