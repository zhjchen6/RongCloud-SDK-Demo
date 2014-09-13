package com.example.android_private_demo;

import io.rong.imkit.RongIM;
import io.rong.imkit.RongIM.OnConversationStartedListener;
import io.rong.imlib.RongIMClient.ConnectCallback;
import io.rong.imlib.RongIMClient.ConversationType;
import io.rong.imlib.RongIMClient.UserInfo;
import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.Handler.Callback;
import android.os.Message;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity implements Callback {

	private static final String TOKEN = "qQgeZyhf00Mricm04ex6M3VGYCP5Q2FZZ1ksQCyMgnBgcpt1104vMaxOzFJyJ3JmNvbkynIx82w=";

	private Button mButton;
	private Handler mHandler;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		setContentView(R.layout.activity_main);

		mButton = (Button) findViewById(android.R.id.button1);

		mHandler = new Handler(this);

		mButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {

				Toast.makeText(MainActivity.this, "正在连接。。。", Toast.LENGTH_LONG)
						.show();

				mButton.post(new Runnable() {

					@Override
					public void run() {

						RongIM.connect(TOKEN, new ConnectCallback() {

							@Override
							public void onSuccess(String userId) {

								mHandler.obtainMessage(0, userId).sendToTarget();

							}

							@Override
							public void onError(ErrorCode arg0) {
								// TODO Auto-generated method stub

							}
						});

					}
				});

			}
		});
	}

	@Override
	public boolean handleMessage(Message msg) {
		String userId= (String) msg.obj;

		Toast.makeText(MainActivity.this, "连接成功:userId:" + userId,
				Toast.LENGTH_LONG).show();

		// 自己和自己聊天
		RongIM.getInstance().startPrivateChat(this, userId, "光头强",
				new OnConversationStartedListener() {

					@Override
					public void onDestroyed() {
						// TODO Auto-generated method stub

					}

					@Override
					public void onCreated(ConversationType arg0, String arg1) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onClickUserPortrait(UserInfo arg0) {
						// TODO Auto-generated method stub

					}

					@Override
					public void onClickMessage(
							io.rong.imlib.RongIMClient.Message arg0) {
						// TODO Auto-generated method stub

					}
				});

		return false;
	}
}
