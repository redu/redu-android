package br.com.developer.redu.exemplosRodrigo;

import java.util.ArrayList;
import java.util.Scanner;

import java.util.List;
import java.util.Iterator;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonParser;
import com.google.gson.JsonElement;
import com.google.gson.reflect.TypeToken;

import br.com.developer.redu.DefaultReduClient;
import br.com.developer.redu.models.Course;
import br.com.developer.redu.models.Environment;
import br.com.developer.redu.models.File;
import br.com.developer.redu.models.Folder;
import br.com.developer.redu.models.Lecture;
import br.com.developer.redu.models.Space;
import br.com.developer.redu.models.Subject;

public class viewFoldersFiles {
	private static final String CONSUMER_KEY = "YzbH0ulBcOjXSPtmhJuEHNFFf6eZGiamQeOBQhU1";
	private static final String CONSUMER_SECRET_KEY = "kUdQsrimVZqgS7u1JuCnMGvARWhmiLWcbrZKwYO8";
	private static final String PIN = "z3nzIybwECnAxefLcdl0";
	
	public static void main(String[] args) {
		System.out.println("system on");
		DefaultReduClient client = new DefaultReduClient(CONSUMER_KEY, CONSUMER_SECRET_KEY, PIN);
		
		//Visualizando uma aula especifica - ok
		String lectureId = "5260";
		String subjectId = "3285";
		
		//space Ciencia da Computacao
		String spaceId = "2166";
		
		System.out.println(client.getSpace(spaceId));
		//Retorna a pasta em si
		//System.out.println(client.getFolder(folderId));
//		List<Folder> folds = (List<Folder>) client.getFoldersBySpace(spaceId);
//		String fRootId =  folds.get(0).id;
//		System.out.println("id da raiz é: "+fRootId);
//		for (int i=0;i<folds.size();i++){
//			System.out.println("Pasta: " + folds.get(i).id + folds.get(i).name);	
//		}
		String idFolderRaiz = client.getFolderID(spaceId);
		System.out.println(idFolderRaiz);
		
		List<Folder> folders = (List<Folder>) client.getFolders(idFolderRaiz);
		for (int i=0;i<folders.size();i++){
			System.out.println("Pasta: " +folders.get(i).id +" - "+ folders.get(i).name);	
		}
		List<File> files = (List<File>) client.getFilesByFolder(idFolderRaiz);
		for (int i=0;i<files.size();i++){
			System.out.println((i+1)+": "+files.get(i).id +" - "+ files.get(i).name);	
		}
		System.out.println("system off");
	}
}