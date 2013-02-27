package com.example.encapsuladorandroid;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import br.com.developer.redu.DefaultReduClient;
import br.com.developer.redu.models.File;
import br.com.developer.redu.models.Folder;

import android.os.Bundle;
import android.app.Activity;
import android.app.ExpandableListActivity;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListAdapter;
import android.widget.ListView;
import android.widget.SimpleExpandableListAdapter;

public class SuportFiles extends Activity {
	private static final String CONSUMER_KEY = "YzbH0ulBcOjXSPtmhJuEHNFFf6eZGiamQeOBQhU1";
	private static final String CONSUMER_SECRET_KEY = "kUdQsrimVZqgS7u1JuCnMGvARWhmiLWcbrZKwYO8";
	private static final String PIN = "z3nzIybwECnAxefLcdl0";
	
	private ListView lstFoldersFiles;

	private ArrayAdapter<String> listAdapter ;
//	private ArrayAdapter<Folder> FolderAdapter ;
//	private ArrayAdapter<File> FileAdapter ;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_suport_files);
//		lstFolders	= (ListView) findViewById( R.id.lstFolders);
//		lstFiles	= (ListView) findViewById( R.id.lstFiles );
		
		lstFoldersFiles	= (ListView) findViewById( R.id.lstFoldersFiles);

		DefaultReduClient client = new DefaultReduClient(CONSUMER_KEY, CONSUMER_SECRET_KEY, PIN);
		String spaceId = "2166";
		
		String idFolderRaiz = client.getFolderID(spaceId);
	
//	    ArrayAdapter<Folder> FolderAdapter = new ArrayAdapter<Folder>(this, R.layout.simple_row);
//	    ArrayAdapter<File> FileAdapter = new ArrayAdapter<File>(this, R.layout.simple_row);
		// Criando the listadapter com a lista de arquivos e pastas jah, atraves de um array list.  
	    // listAdapter = new ArrayAdapter<String>(this, R.layout.simple_row, FilesList);
		
	    listAdapter = new ArrayAdapter<String>(this, R.layout.simple_row);

		List<Folder> folders = (List<Folder>) client.getFolders(idFolderRaiz);
	    List<File> files = (List<File>) client.getFilesByFolder(idFolderRaiz);
	    
		for (int i=0;i<folders.size();i++){
			listAdapter.add(folders.get(i).name);
		}
		for (int i=0;i<files.size();i++){
			listAdapter.add(files.get(i).name);
		}
		
  		// Set the ArrayAdapter as the ListView's adapter.
		lstFoldersFiles.setAdapter( listAdapter );
		
//		lstFolders.setAdapter( FolderAdapter. );   
//		lstFiles.setAdapter( FolderAdapter );
		
//		lstFoldersFiles.setOnItemClickListener();
/*		lstFoldersFiles.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View view, int position,long id) {
                Log.i("REDU", "Rodrigo Gusmao de Carvalho Rocha");
//              String item = ((TextView)view).getText().toString();
//                Toast.makeText(getBaseContext(), item, Toast.LENGTH_LONG).show();
                
            }
        });*/
		
	}

	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.activity_suport_files, menu);
		return true;
	}	
}


