package com.unit.test;

import com.image.indicator.activity.MainActivity;
import com.image.indicator.entity.ContestDetailData;
import com.image.indicator.entity.DatabaseHelper;

public class UnitDatabaseTest {
	private DatabaseHelper db_test = MainActivity.dbp;
	private static final int GAME3_TEST = 3;
	private static final int MID_TEST = 5;
	private static final String MID_String_TEST = "4";
	private static final String Id_TEST = "���Ա� ¯ʯ����"; 
	private static final String Deadline_TEST = "����ʱ�� 6��6��"; 
	private static final String Data_TEST = "�������� 6/18-6/18"; 
	private static final String Address_TEST = "���Ե�ַ �������Ῡ"; 
	private static final String Host_TEST = "���Ծٰ췽 ����"; 
	private static final String Award_TEST = "���Խ��� 8888888"; 
	private static final String Request_TEST = "����Ҫ�� ����˧"; 
	private static final String Rule_TEST = "���Թ��� �����̭"; 
	private static final String Review1_TEST = "�������� ������"; 
	private static final String Review2_TEST = "�������� �������"; 
		public UnitDatabaseTest()
		{
			db_test.insert(GAME3_TEST, MID_TEST, Id_TEST, Deadline_TEST, Data_TEST,
					Address_TEST, Host_TEST, Award_TEST, Request_TEST, Rule_TEST,
					Review1_TEST, Review2_TEST);
		//	db_test.getAll(null,null, GAME3_TEST);
			System.out.println("��Ԫ����-----���ݿ�д�빦��");
			System.out.println(ContestDetailData.getId(MID_TEST-1, GAME3_TEST));
			System.out.println(ContestDetailData.getDeadline(MID_TEST-1, GAME3_TEST));
			System.out.println(ContestDetailData.getData(MID_TEST-1, GAME3_TEST));
			System.out.println(ContestDetailData.getAddress(MID_TEST-1, GAME3_TEST));
			System.out.println(ContestDetailData.getHost(MID_TEST-1, GAME3_TEST));
			System.out.println(ContestDetailData.getAward(MID_TEST-1, GAME3_TEST));
			System.out.println(ContestDetailData.getRequest(MID_TEST-1, GAME3_TEST));
			System.out.println(ContestDetailData.getRule(MID_TEST-1, GAME3_TEST));
			System.out.println(ContestDetailData.getReview1(MID_TEST-1, GAME3_TEST));
			System.out.println(ContestDetailData.getReview2(MID_TEST-1, GAME3_TEST));
		}
}
