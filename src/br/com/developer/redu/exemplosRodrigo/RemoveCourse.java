package br.com.developer.redu.exemplosRodrigo;

import java.util.Scanner;

import java.util.List;

import br.com.developer.redu.DefaultReduClient;
import br.com.developer.redu.models.Course;
import br.com.developer.redu.models.Environment;

public class RemoveCourse {
	private static final String CONSUMER_KEY = "YzbH0ulBcOjXSPtmhJuEHNFFf6eZGiamQeOBQhU1";
	private static final String CONSUMER_SECRET_KEY = "kUdQsrimVZqgS7u1JuCnMGvARWhmiLWcbrZKwYO8";
	private static final String PIN = "z3nzIybwECnAxefLcdl0";
	
	public static void main(String[] args) {
		DefaultReduClient client = new DefaultReduClient(CONSUMER_KEY, CONSUMER_SECRET_KEY, PIN);
		Scanner in = new Scanner(System.in);

		//Course curso = client.postCourse("ufrpe-uag","Testing MobileApp", "tmobileapp", "60", "Curso para testar MobileApplication");

		//Listando os Ambientes do usuario
		System.out.println("Please, insert the environment ID");
		String idEnvironment = in.nextLine();
		client.getEnvironment(idEnvironment);

		
		//Listando os cursos do ambiente especifico
		List<Course> curso = (List<Course>) client.getCoursesByEnvironment("ufrpe-uag");
		System.out.println(curso);
		
		//Removendo o curso atraves do ID do mesmo
		
		System.out.println("Please, insert the course ID");
		String idCursoRemove = in.nextLine();
		client.deleteCourse(idCursoRemove);
		System.out.println("Removed");
	}
}
