//192.168.61.24
package com.example.android_client;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

import android.os.AsyncTask;
import android.os.Bundle;
import android.app.Activity;
import android.database.CursorJoiner.Result;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	private static final String ServerURL = "10.0.2.2";
	private Button button = null;
	private EditText edit = null;
		
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		edit = (EditText)findViewById(R.id.EditText);
		button = (Button)findViewById(R.id.Button);
		button.setOnClickListener(new View.OnClickListener() {			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				System.out.println("---------->Button Clicked");
				
				SendMsgTask sendTask = new SendMsgTask(edit.getText().toString());
				sendTask.execute();
		}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	
	private class SendMsgTask extends AsyncTask<String, Integer, String>{
		DataOutputStream Output;
		DataInputStream Input;
		Socket socket;
		String InputString = null;
		public SendMsgTask(String string) {
			// TODO Auto-generated constructor stub
			InputString = string;
		}
		@Override
		protected String doInBackground(String... params) {
			// TODO Auto-generated method stub
			System.out.println("---------->Do in Backgroud");
			try {
				socket = new Socket(ServerURL,12000);
				Output = new DataOutputStream(socket.getOutputStream());
				Input = new DataInputStream(socket.getInputStream()) ;
				System.out.println("---------->Gonna Write");
				Output.writeUTF(InputString);
				System.out.println("---------->" + Input.readUTF());
				
				Output.close();
				Input.close();
				socket.close();
			} catch (UnknownHostException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

			return null;
		}
		
	}
}


