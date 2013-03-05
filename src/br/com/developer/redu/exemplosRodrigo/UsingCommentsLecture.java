package br.com.developer.redu.exemplosRodrigo;

import java.util.Scanner;

import java.util.List;

import br.com.developer.redu.DefaultReduClient;
import br.com.developer.redu.models.Course;
import br.com.developer.redu.models.Environment;
import br.com.developer.redu.models.Space;
import br.com.developer.redu.models.Status;
import br.com.developer.redu.models.Subject;

public class UsingCommentsLecture {
	private static final String CONSUMER_KEY = "YzbH0ulBcOjXSPtmhJuEHNFFf6eZGiamQeOBQhU1";
	private static final String CONSUMER_SECRET_KEY = "kUdQsrimVZqgS7u1JuCnMGvARWhmiLWcbrZKwYO8";
	private static final String PIN = "z3nzIybwECnAxefLcdl0";
	
	public static void main(String[] args) {
		System.out.println("system on");
		DefaultReduClient client = new DefaultReduClient(CONSUMER_KEY, CONSUMER_SECRET_KEY, PIN);
				
		String StringIdSpace = "2166";
		String lectureId = "4838";
				
		//posta comment no mural da disciplina - ok
		//String text = "testing the remove function";
		//client.postStatusLecture(lectureId, text, "Activity");
		
		System.out.println("printing the status");
		//retorna todos os status de uma disciplina - ok
		List<Status> statuss = (List<Status>) client.getStatusesByLecture(lectureId);
		System.out.println(statuss);	
		
		//Remove um comentario especifico - ok
		//String statusId = "88511";
		//client.deleteStatus(statusId);
		
			
		
		System.out.println("system off");
	}
}
