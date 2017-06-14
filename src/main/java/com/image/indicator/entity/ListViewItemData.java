package com.image.indicator.entity;


import com.image.indicator.R;
import com.image.indicator.activity.MainActivity;
import com.image.indicator.activity.TopicNews;


import android.R.string;
import android.content.Context;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

public class ListViewItemData {

//	 private static Context context;
//	  public ListViewItemData(Context context)
//	  {
//	  this.context=context;
//	  }
//	private static Bitmap rawBitmap = BitmapFactory.decodeResource(context.getResources(),R.drawable.p1); 
	private static Context mc;
	public static String getTitle(int i,int game) {
		// TODO Auto-generated method stub
		Cursor c = MainActivity.dbp.getById(String.valueOf(i+1),game);
		while(c.moveToNext())
		{
			return c.getString(1);
		}
		return null;
	}

	public static int getPhotoResId(int i,int game) {
		// TODO Auto-generated method stub
//		if (i == 0)
//			return 0x7f020022;
//		if (i == 1)
	//	return 0x7f020023;
//		if (i == 2)
// p1=0x7f020028;
// p2=0x7f020029;
// p3=0x7f02002a;
// p4=0x7f02002b;
		if(game == 4)
		return	0x7f020032;
		return 0x7f020033;
	//		return rawBitmap; //报名成功
	
//		return 0;
	}

	public static String getSummary(int i,int game) {
		// TODO Auto-generated method stub
		Cursor c = MainActivity.dbp.getById(String.valueOf(i+1),game);
		while(c.moveToNext())
		{
			return c.getString(7)+"\r\n"+c.getString(8);
		}
		return null;
	}

	public static String getAuthor(int i,int game) {
		// TODO Auto-generated method stub
		Cursor c = MainActivity.dbp.getById(String.valueOf(i+1),game);
		while(c.moveToNext())
		{
			return c.getString(5);
		}
		return null;
	}

	public static String getPublishtime(int i,int game) {
		// TODO Auto-generated method stub
		Cursor c = MainActivity.dbp.getById(String.valueOf(i+1),game);
		while(c.moveToNext())
		{
			return c.getString(2);
		}
		return null;
	}

	public static int getItemNum() {
		// TODO Auto-generated method stub
		//获得行数
		return MainActivity.dbp.getAll(null, null, TopicNews.GameOnTouch).getCount();
	}

}
