package com.example.encapsuladorandroid;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;

import br.com.developer.redu.DefaultReduClient;
import br.com.developer.redu.models.File;
import br.com.developer.redu.models.Folder;
import br.com.developer.redu.models.Lecture;
import br.com.developer.redu.models.Space;
import br.com.developer.redu.models.Status;
import br.com.developer.redu.models.Subject;
import android.os.Bundle;
import android.app.Activity;
import android.app.ExpandableListActivity;
import android.content.Intent;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.LinearLayout;
import android.widget.SimpleExpandableListAdapter;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private static final String CONSUMER_KEY = "YzbH0ulBcOjXSPtmhJuEHNFFf6eZGiamQeOBQhU1";
	private static final String CONSUMER_SECRET_KEY = "kUdQsrimVZqgS7u1JuCnMGvARWhmiLWcbrZKwYO8";
		
	private TextView tvSpace;
	private Button btnNewSubject;
	private Button btnSuportFiles;
	private DefaultReduClient redu;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		redu = new DefaultReduClient(CONSUMER_KEY, CONSUMER_SECRET_KEY);
		String text = "YyULGvrohSGHz436a6Qe";
		redu.initClient(text);
		 			
		btnSuportFiles = (Button) findViewById(R.id.btnSuportFiles);
		btnNewSubject= (Button) findViewById(R.id.btnNewSubject);
		tvSpace = (TextView) findViewById(R.id.tvSpace); 
		
	
		String StringIdSpace = "2166";
		
		redu.getSpace(StringIdSpace);
		Space s = redu.getSpace(StringIdSpace);
		tvSpace.setText(s.name);
		Log.i("REDU", "teste2");
		
		String spaceId = "2166";
  
	  //Listar Modulos
		String StringIdModulo = "3087";
		List<Subject> subjects = (List<Subject>) redu.getSubjectsBySpace(StringIdSpace);
		LinearLayout nBar = (LinearLayout) findViewById(R.id.navigationBar);
        TextView[] tx = new TextView[subjects.size()];
        for (int i=0;i<subjects.size();i++){
            tx[i] = (TextView) new TextView(this);
            tx[i].setText(subjects.get(i).id + ": " +subjects.get(i).name +" - "+ subjects.get(i).description);
            String subjectId = Integer.toString(subjects.get(i).id);
            List<Lecture> lecs = (List<Lecture>) redu.getLecturesBySubject(subjectId);
            TextView[] tvLecs = new TextView[lecs.size()];
            String teste = Integer.toString(lecs.size());
            Log.i("REDU", teste);

    		for (int j=0;j<lecs.size();j++){
				tvLecs[j].setText("Disciplina "+ lecs.get(i).id + ": " +lecs.get(i).name);
				nBar.addView(tvLecs[j]);
    		}
            nBar.addView(tx[i]);
            Log.i("REDU", "teste3");
        }	
				
		btnNewSubject.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent it = new Intent (MainActivity.this, ActInsertSubject.class);
				startActivity(it);
			}
		});
		
		btnSuportFiles.setOnClickListener(new Button.OnClickListener() {
			public void onClick(View v) {
				Intent it = new Intent (MainActivity.this, SuportFiles.class);
				startActivity(it);
			}
		});
	}	

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}
