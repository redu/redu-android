package br.com.developer.redu.exemplosRodrigo;

import br.com.developer.redu.DefaultReduClient;
import br.com.developer.redu.models.Course;
import br.com.developer.redu.models.Environment;

public class CriaCourse {
	private static final String CONSUMER_KEY = "YzbH0ulBcOjXSPtmhJuEHNFFf6eZGiamQeOBQhU1";
	private static final String CONSUMER_SECRET_KEY = "kUdQsrimVZqgS7u1JuCnMGvARWhmiLWcbrZKwYO8";
	private static final String PIN = "z3nzIybwECnAxefLcdl0";
	
	public static void main(String[] args) {
		DefaultReduClient client = new DefaultReduClient(CONSUMER_KEY, CONSUMER_SECRET_KEY, PIN);
		Course curso = client.postCourse("ufrpe-uag","Flamengo", "MEngaoooo", "30", "testando com Julianaplication");

		// A resposta deve ser um objeto do tipo course contendo as informações do course criado
		System.out.println(curso);
	}
}
