package com.image.indicator.activity;

import com.image.indicator.R;
import com.image.indicator.entity.ContestDetailData;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import android.content.Context;

public class DetailContest extends Activity {
	private String result;
	private TextView text_id;
	private TextView text_deadline;
	private TextView text_data;
	private TextView text_address;
	private TextView text_host;
	private TextView text_request;
	private TextView text_rule;
	private TextView text_award;
	private TextView text_review1;
	private TextView text_review2;

	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.page_detail_contest);
		final Context self = this;
		// text_id = new TextView(this);
		text_id = (TextView) findViewById(R.id.textView_detail_id);
		text_deadline = (TextView) findViewById(R.id.textView_detail_deadline);
		text_data = (TextView) findViewById(R.id.textView_detail_data);
		text_address = (TextView) findViewById(R.id.textView_detail_address);
		text_host = (TextView) findViewById(R.id.textView_detail_host);
		text_request = (TextView) findViewById(R.id.textView_detail_request);
		text_rule = (TextView) findViewById(R.id.textView_detail_rule);
		text_award = (TextView) findViewById(R.id.textView_detail_award);
		text_review1 = (TextView) findViewById(R.id.textView_detail_review_1);
		text_review2 = (TextView) findViewById(R.id.textView_detail_review_2);
		intialContestDetaill(InfoNews.listView_position); // ���ر�������

		final Button button_detail_1 = (Button) findViewById(R.id.button_detail_apply);
		button_detail_1.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				new AlertDialog.Builder(self)
						.setTitle("ȷ������")
						.setMessage("ȷ��Ҫ���� YF��-¯ʯ��˵������")
						.setPositiveButton("ȷ������",
								new DialogInterface.OnClickListener() {
									@Override
									public void onClick(DialogInterface dialog,
											int which) {
										// TODO Auto-generated method stub
										try {
											Thread.sleep(2000);
										} catch (InterruptedException e) {
											// TODO Auto-generated catch block
											e.printStackTrace();
										}
										new AlertDialog.Builder(self)
												.setTitle("�ɹ�")
												.setMessage("��ϲ�㱨���ɹ�")
												.setPositiveButton("ȷ��", null)
												.show();
									}

								}).setNegativeButton("ȡ��", null).show();

				MainActivity.total_info++;
				MainActivity.dbp.insert(
						0,
						MainActivity.total_info,
						ContestDetailData.getId(InfoNews.listView_position,
								TopicNews.GameOnTouch) + "\n�����ɹ���", "״̬���ȴ�����",
						"�ò��ϵĲ���hh", "�ò��ϵĲ���hh", ContestDetailData.getHost(
								InfoNews.listView_position,
								TopicNews.GameOnTouch), "�ò��ϵĲ���hh",
						"��ʾ�����ѱ����ɹ����ǵð�ʱ����", ContestDetailData.getData(
								InfoNews.listView_position,
								TopicNews.GameOnTouch), "�ò��ϵĲ���hh", "�ò��ϵĲ���hh");
				// dbp.insert(0,1,"YF���ȱ� ¯ʯ��˵���� �����ɹ���",
				// "״̬���ȴ�����","����ʱ�䣺5/18-5/18","�ص㣺������ͨ��ѧYF��¥",
				// "�ٰ췽��YF����", "�ܽ���2000Ԫ", "��ʾ�����ѱ����ɹ����ǵð�ʱ����",
				// "������������3����һ����������飬��������̭","������¯ʯ��˵�ú���", "������̫�����ˣ�");
				button_detail_1.setClickable(false);
			}
		});
		final Button button_detail_2 = (Button) findViewById(R.id.button_detail_detail);
		button_detail_2.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				new AlertDialog.Builder(self)
				.setTitle("��������")
				.setMessage("������:16��\n�ѱ�����:2��,��ʣ����:14��")
				.setPositiveButton("ˢ��",null)
				.setNegativeButton("ȡ��", null).show();
			}
		});
		final Button button_detail_3 = (Button) findViewById(R.id.button_detail_focus);
		button_detail_3.setOnClickListener(new View.OnClickListener() {
			public void onClick(View v) {
				new AlertDialog.Builder(self)
				.setTitle("�ɹ�")
				.setMessage("��ע�ɹ�") 
				.setPositiveButton("ȷ��", null)
				.show();
				MainActivity.total_info++;
				// MainActivity.dbp.insert(game, MID, Id, Deadline, Data,
				// Address, Host, Award, Request, Rule, Review1, Review2);
				MainActivity.dbp.insert(
						0,
						MainActivity.total_info,
						ContestDetailData.getId(InfoNews.listView_position,
								TopicNews.GameOnTouch) + "\n��ע�ɹ���",
						ContestDetailData.getDeadline(
								InfoNews.listView_position,
								TopicNews.GameOnTouch), ContestDetailData
								.getData(InfoNews.listView_position,
										TopicNews.GameOnTouch),
						ContestDetailData.getAddress(
								InfoNews.listView_position,
								TopicNews.GameOnTouch), ContestDetailData
								.getHost(InfoNews.listView_position,
										TopicNews.GameOnTouch),
						ContestDetailData.getAward(InfoNews.listView_position,
								TopicNews.GameOnTouch), ContestDetailData
								.getRequest(InfoNews.listView_position,
										TopicNews.GameOnTouch),
						ContestDetailData.getRule(InfoNews.listView_position,
								TopicNews.GameOnTouch), ContestDetailData
								.getReview1(InfoNews.listView_position,
										TopicNews.GameOnTouch),
						ContestDetailData.getReview2(
								InfoNews.listView_position,
								TopicNews.GameOnTouch));
				button_detail_3.setClickable(false);
			}
		});
	}

	public void intialContestDetaill(int i) {
		text_id.setText(ContestDetailData.getId(i, TopicNews.GameOnTouch));
		text_deadline.setText(ContestDetailData.getDeadline(i,
				TopicNews.GameOnTouch));
		text_data.setText(ContestDetailData.getData(i, TopicNews.GameOnTouch));
		text_address.setText(ContestDetailData.getAddress(i,
				TopicNews.GameOnTouch));
		text_host.setText(ContestDetailData.getHost(i, TopicNews.GameOnTouch));
		text_request.setText(ContestDetailData.getRequest(i,
				TopicNews.GameOnTouch));
		text_rule.setText(ContestDetailData.getRule(i, TopicNews.GameOnTouch));
		text_award
				.setText(ContestDetailData.getAward(i, TopicNews.GameOnTouch));
		text_review1.setText(ContestDetailData.getReview1(i,
				TopicNews.GameOnTouch));
		text_review2.setText(ContestDetailData.getReview2(i,
				TopicNews.GameOnTouch));
	}
}
