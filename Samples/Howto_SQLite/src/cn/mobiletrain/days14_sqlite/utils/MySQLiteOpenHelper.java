package cn.mobiletrain.days14_sqlite.utils;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * @author: xiongcong
 * @类   说   明:	
 * @version 1.0
 * @创建时间：2015-11-13 下午3:05:04
 * 
 */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {
	
	public MySQLiteOpenHelper(Context context, String name,
			CursorFactory factory, int version) {
		super(context, name, factory, version);
		
	}

	@Override
	public void onCreate(SQLiteDatabase db) {
		String sql = "CREATE TABLE IF NOT EXISTS person(id integer PRIMARY KEY AUTOINCREMENT, name VARCHAR2(20), salary VARCHAR2(20))";
		db.execSQL(sql);

	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
	}

}
