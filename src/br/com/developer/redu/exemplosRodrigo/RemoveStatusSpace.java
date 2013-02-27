package br.com.developer.redu.exemplosRodrigo;

import java.util.Scanner;

import java.util.List;

import br.com.developer.redu.DefaultReduClient;
import br.com.developer.redu.models.Course;
import br.com.developer.redu.models.Environment;
import br.com.developer.redu.models.Space;
import br.com.developer.redu.models.Status;
import br.com.developer.redu.models.Subject;

public class RemoveStatusSpace {
	private static final String CONSUMER_KEY = "YzbH0ulBcOjXSPtmhJuEHNFFf6eZGiamQeOBQhU1";
	private static final String CONSUMER_SECRET_KEY = "kUdQsrimVZqgS7u1JuCnMGvARWhmiLWcbrZKwYO8";
	private static final String PIN = "z3nzIybwECnAxefLcdl0";
	
	public static void main(String[] args) {
		System.out.println("system on");
		DefaultReduClient client = new DefaultReduClient(CONSUMER_KEY, CONSUMER_SECRET_KEY, PIN);
	
		String StringIdSpace = "2166";
		//Remove um comentario especifico - ok
		String statusId = "89518";
		client.deleteStatus(statusId);
		
		System.out.println("system off");
	}
}
