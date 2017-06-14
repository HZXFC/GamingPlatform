package com.image.indicator.activity;

import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.image.indicator.R;



public class Login extends Activity {
	private EditText userName = null;
	private EditText password = null;
	private Button register = null;
	private Button instruction = null;
	private Button login = null;
	private TextView login_title = null;
	private TextView forgetPassword = null;
	private Handler handler = new Handler(){
		@Override
		public void handleMessage(Message msg) {
			// TODO Auto-generated method stub
			super.handleMessage(msg);
			if (msg.what == 1) {//当服务器返回给客户端的标记为1时，说明登陆成功
				Intent login_main = new Intent(Login.this, MainActivity.class);
				Log.i("login_main----------------->", "success");
				startActivity(login_main);
				finish();
			}else {
				Toast.makeText(Login.this, "登陆失败", Toast.LENGTH_SHORT)
				.show();
			}
		}
	};
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_login);
		init();
		initListener();
	}

	/*
	 * login页面参数初始化，获取login页面对应的元素
	 */
	private void init() {
		userName = (EditText) this.findViewById(R.id.userName);
		password = (EditText) this.findViewById(R.id.password);
		register = (Button) this.findViewById(R.id.register);
	//	instruction = (Button) this.findViewById(R.id.instruction);
		login = (Button) this.findViewById(R.id.login);
		login_title = (TextView) this.findViewById(R.id.login_title);
		forgetPassword =  (TextView) this.findViewById(R.id.forgetPassword);
	}

	/*
	 * 对login上的页面元素设置监听
	 */
	private void initListener() {
		this.login.setOnClickListener(new LoginListener());
		this.register.setOnClickListener(new ButtonRegister());
	//	this.instruction.setOnClickListener(new ButtonInstruction());
		this.forgetPassword.setOnClickListener(new TextForget());
	}
	/**
	 * 用户提供的数据和用户数据库中的数据进行匹配，有则可以登陆，无则提示先注册
	 */
	private class TextForget implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			Intent forget_click = new Intent(Login.this, Forget.class);
			Log.i("forget_click----------------->", "success");
			startActivity(forget_click);
			finish();
		}
	}
	 private class LoginListener implements OnClickListener{
		 String myUserName = userName.getText().toString();
			String passwd = password.getText().toString();

			@Override
			public void onClick(View v) {
				new Thread (){
					public void run() {
					/*	HttpClient client = new DefaultHttpClient();
						List<NameValuePair> list = new ArrayList<NameValuePair>();
						NameValuePair pair = new BasicNameValuePair("index", "0");
						list.add(pair);
						NameValuePair pair1 = new BasicNameValuePair("username", userName.getText().toString());
						NameValuePair pair2 = new BasicNameValuePair("password",  password.getText().toString());
						
						list.add(pair1);
						list.add(pair2);
						try {
							UrlEncodedFormEntity entity = new UrlEncodedFormEntity(list,"UTF-8");
							HttpPost post = new HttpPost("http://123.206.41.96:8080/GamingPlatform/matchInfo.jsp");
							post.setEntity(entity);
							HttpResponse response = client.execute(post);
							if (response.getStatusLine().getStatusCode() == 200) {
								InputStream in = response.getEntity().getContent();
								handler.sendEmptyMessage(in.read());//将服务器返回给客户端的标记直接传给handler
								in.close();
							}
						} catch (UnsupportedEncodingException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						*/
						//获得要传递的数据
					    String username =userName.getText().toString();
					    String passWord = password.getText().toString();
					    String url ="http://139.199.107.221:8080/user/login?";
					    // 创建HttpGet对象
					   
					    HttpGet request = new HttpGet(url +"userName="+username+"&passWord="+passWord);
					    System.out.println("开始登录");
					    // 使用execute方法发送HTTP GET请求，并返回HttpResponse对象
					    // DefaultHttpClient为Http客户端管理类，负责发送请
					    HttpClient hc = new DefaultHttpClient();
					    HttpResponse response;
						try {
							response = hc.execute(request);
						    // 判断请求响应状态码，状态码为200表示服务端成功响应了客户端的请求
						    if (response.getStatusLine().getStatusCode() == 200) {
						         // 使用getEntity方法获得返回结果
						         String data = EntityUtils.toString(response.getEntity(),"gbk");
						         System.out.println(data);
						         //获得Message对象
						     	handler.sendEmptyMessage(1);
						        
						    }
						} catch (ClientProtocolException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
					}
					
				}.start();
			}
			
			
	 }

	/**
	 * 设置register监听
	 */
	private class ButtonRegister implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub

			Intent login_agreement = new Intent(Login.this, Agreement.class);
			Log.i("login_agreement----------------->", "success");
			startActivity(login_agreement);
			finish();
		}
	}

	/*
	 * 设置instruction的监听
	 */
	private class ButtonInstruction implements OnClickListener {

		@Override
		public void onClick(View v) {
			// TODO Auto-generated method stub
			Intent login_instruction = new Intent(Login.this, UserZoom.class);
			startActivity(login_instruction);
		}
	}

}

