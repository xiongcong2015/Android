package cn.mobiletrain.days14_sqlite.utils;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * @author: xiongcong
 * @类   说   明:	
 * @version 1.0
 * @创建时间：2015-11-13 上午11:07:41
 * 
 */
public class DBUtils {

	private SQLiteDatabase db;
	private String sql;
	private Cursor c;

	public DBUtils(Context context) {
		// 创建或打开数据库
//		db = context.openOrCreateDatabase("android.db", MainActivity.MODE_PRIVATE, null);
		MySQLiteOpenHelper openHelper = new MySQLiteOpenHelper(context, "android.db", null, 1);
		db = openHelper.getWritableDatabase();
//		createPersonTable();
	}
	
	// 创建数据库表
	public void createPersonTable() {
		sql = "CREATE TABLE IF NOT EXISTS PERSON(id integer PRIMARY KEY AUTOINCREMENT, name VARCHAR2(20), salary VARCHAR2(20))";
		db.execSQL(sql);
	}

	// 在数据库中增加一条数据，两种方式
	public void insert1(String name, String salary) {
		sql = "INSERT INTO person(name, salary) VALUES(?, ?)";
		db.execSQL(sql, new Object[]{name, salary});
	}
	public void insert2(String name, String salary) {
		ContentValues values = new ContentValues();
		values.put("name", name);
		values.put("salary", salary);
		db.insert("person", null, values);
	}
	
	// 在数据库中删除一条数据，两种方式
	public void delete1(String id) {
		sql = "DELETE FROM PERSON WHERE ID = ?";
		db.execSQL(sql, new String[]{id});
	}
	public void delete2(String id) {
		db.delete("person", "id = ?", new String[]{id});
	}
	
	// 修改数据，两种方式
	public void update1(String id, String salary) {
		sql = "UPDATE person SET salary = ? WHERE id = ?";
		db.execSQL(sql, new String[]{salary, id});
	}
	public void update2(String id, String salary) {
		ContentValues values = new ContentValues();
		values.put("salary", salary);
		db.update("person", values, "id = ?", new String[]{id});
	}
	
	// 在数据库中查询数据，两种方式
	public Cursor query1() {
//		sql = "SELECT id _id, name, salary FROM person";
		sql = "SELECT id _id, name, salary FROM person limit 0, 10";
		c = db.rawQuery(sql, null);
		return c;
	}
	public Cursor query2() {
		/**
		 * Open Declaration Cursor android.database.sqlite.SQLiteDatabase.query(String table, String[] columns, String selection, String[] selectionArgs, String groupBy, String having, String orderBy)
		 * Query the given table, returning a Cursor over the result set.
		 */
		c = db.query("person", new String[]{"id _id", "name", "salary"}, null, null, null, null, null, "0, 10");
		return c;
	}
}
