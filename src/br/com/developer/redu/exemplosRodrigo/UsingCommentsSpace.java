package br.com.developer.redu.exemplosRodrigo;

import java.util.Scanner;

import java.util.List;

import br.com.developer.redu.DefaultReduClient;
import br.com.developer.redu.models.Course;
import br.com.developer.redu.models.Environment;
import br.com.developer.redu.models.Space;
import br.com.developer.redu.models.Status;
import br.com.developer.redu.models.Subject;

public class UsingCommentsSpace {
	private static final String CONSUMER_KEY = "YzbH0ulBcOjXSPtmhJuEHNFFf6eZGiamQeOBQhU1";
	private static final String CONSUMER_SECRET_KEY = "kUdQsrimVZqgS7u1JuCnMGvARWhmiLWcbrZKwYO8";
	private static final String PIN = "z3nzIybwECnAxefLcdl0";
	
	public static void main(String[] args) {
		System.out.println("system on");
		DefaultReduClient client = new DefaultReduClient(CONSUMER_KEY, CONSUMER_SECRET_KEY, PIN);
		//Scanner in = new Scanner(System.in);

		//Course curso = client.postCourse("ufrpe-uag","Testing MobileApp", "tmobileapp", "60", "Curso para testar MobileApplication");

		//Listando os Ambientes do usuario
		String idEnv = "ufrpe-uag";
		//System.out.println("Please, insert the environment ID");
		//String idEnvironment = in.nextLine();
		//client.getEnvironment(idEnv);

		
		//Listando os cursos do ambiente especifico
		//List<Course> courses = (List<Course>) client.getCoursesByEnvironment("ufrpe-uag");
		//System.out.println(courses);
		
		
		String StringIdCourse = "1460";
		//List<Space> spaces = (List<Space>) client.getSpacesByCourse(StringIdCourse);
		//System.out.println(spaces);
		
		String StringIdSpace = "2166";
		//List<Subject> subjects = (List<Subject>) client.getSubjectsBySpace(StringIdSpace);
		//System.out.println(subjects);
		
		//posta comment no mural da disciplina - ok
		//String text = "Vamos ver com faremos na proxima semana";
		//client.postStatusSpace(StringIdSpace, text);
		
		//Remove um comentario especifico - ok
		//String statusId = "88503";
		//client.deleteStatus(statusId);
		
		System.out.println("printing the status");
		//retorna todos os status de uma disciplina - ok
		List<Status> statuss = (List<Status>) client.getStatusesBySpace(StringIdSpace, "Activity", "1");
		System.out.println(statuss);
		//client.getStatusesBySpace(StringIdSpace, "1", "1");
		
		
		
		//retorna status de uma aula
		//client.getStatusesByLecture(lectureId)
		
		//posta no mural da aula
		//client.postStatusLecture(lectureId, status, type)
		
		
		System.out.println("system off");
	}
}
