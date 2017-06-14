package com.image.indicator.entity;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
	//��û��ʵ����,�ǲ����������๹�����Ĳ���,��������Ϊ��̬
	
	private static final String DATABASE_NAME = "gaming.db"; //���ݿ�����
	private static final int version = 1; //���ݿ�汾 
	public DatabaseHelper(Context context) {//���캯��,������������Ϊ����,ֱ�ӵ��õĸ���Ĺ��캯
		super(context, DATABASE_NAME, null, version);
	//	this.onCreate();
	}
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL("CREATE TABLE IF NOT EXISTS Info (MID integer primary key autoincrement,Id TEXT,Deadline TEXT,Data TEXT,Address TEXT,Host TEXT,Award TEXT,Request TEXT,Rule TEXT,Review1 TEXT,Review2 TEXT);");
		db.execSQL("CREATE TABLE IF NOT EXISTS Game3 (MID integer primary key autoincrement,Id TEXT,Deadline TEXT,Data TEXT,Address TEXT,Host TEXT,Award TEXT,Request TEXT,Rule TEXT,Review1 TEXT,Review2 TEXT);");
		db.execSQL("CREATE TABLE IF NOT EXISTS Game4 (MID integer primary key autoincrement,Id TEXT,Deadline TEXT,Data TEXT,Address TEXT,Host TEXT,Award TEXT,Request TEXT,Rule TEXT,Review1 TEXT,Review2 TEXT);");
	}
	@Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {  
        if (oldVersion==1 && newVersion==2) {//�����ж�,�����������Ҫ�ټ������ж�,��1��3,��2��3  
            db.execSQL("ALTER TABLE restaurants ADD phone TEXT;");  
        }  
    }
	
	//���ر��е�����,where�ǵ���ʱ�򴫽�������������,orderby�������д��������б���������  
    public Cursor getAll(String where, String orderBy,int game) {
    	StringBuilder buf =null;
    	if(game == 0)
            buf=new StringBuilder("SELECT MID, Id, Deadline," +
           		" Data, Address, Host, Award, Request, Rule, Review1, Review2 FROM Info");  
    	/*
    	if(game == 1)
            buf=new StringBuilder("SELECT MID, Id, Deadline," +
           		" Data, Address, Host, Award, Request, Rule, Review1, Review2 FROM Game1");  
    	if(game == 2)
            buf=new StringBuilder("SELECT MID, Id, Deadline," +
           		" Data, Address, Host, Award, Request, Rule, Review1, Review2 FROM Game2");  
           		*/
    	if(game == 3)
         buf=new StringBuilder("SELECT MID, Id, Deadline," +
        		" Data, Address, Host, Award, Request, Rule, Review1, Review2 FROM Game3");  
    	if(game == 4)
            buf=new StringBuilder("SELECT MID, Id, Deadline," +
           		" Data, Address, Host, Award, Request, Rule, Review1, Review2 FROM Game4");    
        if (where!=null) {  
            buf.append(" WHERE ");  
            buf.append(where);  
        }  
          
        if (orderBy!=null) {  
            buf.append(" ORDER BY ");  
            buf.append(orderBy);  
        }  
          
        return(getReadableDatabase().rawQuery(buf.toString(), null));  
    }
    public Cursor getById(String id,int game) {//���ݵ���¼���ȡid,��ѯ���ݿ�  
    	String[] args={id};
    	if(game == 0) //��Ϣ��
    		return(getReadableDatabase().rawQuery("SELECT MID,Id, Deadline, Data, Address, Host, Award, Request, Rule, Review1, Review2 FROM Info WHERE MID=?",args));
    	if(game == 3) //¯ʯ��
    		return(getReadableDatabase().rawQuery("SELECT MID,Id, Deadline, Data, Address, Host, Award, Request, Rule, Review1, Review2 FROM Game3 WHERE MID=?",args));
    	if(game == 4) //DOTA��
    		return(getReadableDatabase().rawQuery("SELECT MID,Id, Deadline, Data, Address, Host, Award, Request, Rule, Review1, Review2 FROM Game4 WHERE MID=?",args));
    	return null;
    } 
    public void insert(int game,int MID, String Id, String Deadline, String Data, String Address, String Host,
    		String Award,String Request,String Rule,String Review1,String Review2) {  
        ContentValues cv=new ContentValues();  
         
        cv.put("MID", MID);
        cv.put("Id", Id);  
        cv.put("Deadline", Deadline);  
        cv.put("Data", Data);  
        cv.put("Address", Address);  
        cv.put("Host", Host);
        cv.put("Award", Award);
        cv.put("Request", Request);
        cv.put("Rule", Rule);
        cv.put("Review1", Review1);
        cv.put("Review2", Review2);
        if(game == 0)
        	getWritableDatabase().insert("Info", "MID", cv);
        if(game == 3)
        	getWritableDatabase().insert("Game3", "MID", cv);
        if(game == 4)
        	getWritableDatabase().insert("Game4", "MID", cv); 
    }
    //�������ݿ�
    public void update(String MID,String Id, String Deadline, String Data, String Address, String Host,
    		String Award,String Request,String Rule,String Review1,String Review2) {  
    	ContentValues cv=new ContentValues();  
    	String[] args={MID};  

        cv.put("Id", Id);  
        cv.put("Deadline", Deadline);  
        cv.put("Data", Data);  
        cv.put("Address", Address);
        cv.put("Host", Host);
        cv.put("Award", Award);
        cv.put("Request", Request);
        cv.put("Rule", Rule);
        cv.put("Review1", Review1);
        cv.put("Review2", Review2); 

    	getWritableDatabase().update("DetailTable", cv, "MID=?",  
                                    args);  
    }  
    public String getId(Cursor c) {  
        return(c.getString(1));  
    }  
    public String getDeadline(Cursor c) {  
        return(c.getString(2));  
    }
    public String getData(Cursor c) {  
        return(c.getString(3));  
    }
    public String getAddress(Cursor c) {  
        return(c.getString(4));  
    }
    public String getHost(Cursor c) {  
        return(c.getString(5));  
    } 
    public String getAward(Cursor c) {  
        return(c.getString(6));  
    }
    public String getRequest(Cursor c) {  
        return(c.getString(7));  
    }
    public String getRule(Cursor c) {  
        return(c.getString(8));
    }
    public String getReview1(Cursor c) {  
        return(c.getString(9));  
    }
    public String getReview2(Cursor c) {  
        return(c.getString(10));  
    }   
}
