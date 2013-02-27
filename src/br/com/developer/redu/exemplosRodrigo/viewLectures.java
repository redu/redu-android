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
import br.com.developer.redu.models.Lecture;
import br.com.developer.redu.models.Space;
import br.com.developer.redu.models.Subject;

public class viewLectures {
	private static final String CONSUMER_KEY = "YzbH0ulBcOjXSPtmhJuEHNFFf6eZGiamQeOBQhU1";
	private static final String CONSUMER_SECRET_KEY = "kUdQsrimVZqgS7u1JuCnMGvARWhmiLWcbrZKwYO8";
	private static final String PIN = "z3nzIybwECnAxefLcdl0";
	
	public static void main(String[] args) {
		System.out.println("system on");
		DefaultReduClient client = new DefaultReduClient(CONSUMER_KEY, CONSUMER_SECRET_KEY, PIN);
		

		//Visualizando uma aula especifica - ok
		String lectureId = "5260";
		Lecture lec = client.getLecture(lectureId); 
		System.out.println(lec.id);
		System.out.println(lec.name);
		System.out.println(lec.created_at);
		
		String subjectId = "3285";
		List<Lecture> lecs = (List<Lecture>) client.getLecturesBySubject(subjectId);
		
		//Visualizando aulas de um modulo especifico
		for (int i=0;i<lecs.size();i++){
				System.out.println("Disciplina "+ lecs.get(i).id + ": " +lecs.get(i).name);	
		}
		
		
		
		
		
		System.out.println("system off");
	}
}