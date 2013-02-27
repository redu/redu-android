package com.example.encapsuladorandroid;

import br.com.developer.redu.DefaultReduClient;
import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.text.Editable;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ActInsertSubject extends Activity {
	
	private static final String CONSUMER_KEY = "YzbH0ulBcOjXSPtmhJuEHNFFf6eZGiamQeOBQhU1";
	private static final String CONSUMER_SECRET_KEY = "kUdQsrimVZqgS7u1JuCnMGvARWhmiLWcbrZKwYO8";
	private DefaultReduClient redu;
	
	private TextView tvSubjectName;
	private TextView tvSubjectDescription;
	private EditText edtSubjectName;
	private EditText edtSubjectDescription;
	private Button btnPost;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_act_insert_subject);
		redu = new DefaultReduClient(CONSUMER_KEY, CONSUMER_SECRET_KEY);
		String text = "YyULGvrohSGHz436a6Qe";
		redu.initClient(text);
		
		edtSubjectName = (EditText) findViewById(R.id.edtSubjectName);
		edtSubjectDescription = (EditText) findViewById(R.id.edtSubjectDescription);
		tvSubjectName = (TextView) findViewById(R.id.tvSubjectName);
		tvSubjectDescription = (TextView) findViewById(R.id.tvSubjectDescription);
		btnPost = (Button) findViewById(R.id.btnPost);
		
		edtSubjectName.requestFocus();
		
		btnPost.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				String subjectName = edtSubjectName.getText().toString();
				String subjectDescription = edtSubjectDescription.getText().toString();	
				
				redu.postSubject("2166", subjectName, subjectDescription);
				edtSubjectName.setText("");
				edtSubjectDescription.setText("");

			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_act_insert_subject, menu);
		return true;
	}

}
