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
import br.com.developer.redu.models.Space;
import br.com.developer.redu.models.Subject;

public class viewSubjects {
	private static final String CONSUMER_KEY = "YzbH0ulBcOjXSPtmhJuEHNFFf6eZGiamQeOBQhU1";
	private static final String CONSUMER_SECRET_KEY = "kUdQsrimVZqgS7u1JuCnMGvARWhmiLWcbrZKwYO8";
	private static final String PIN = "z3nzIybwECnAxefLcdl0";
	
	public static void main(String[] args) {
		System.out.println("system on");

		DefaultReduClient client = new DefaultReduClient(CONSUMER_KEY, CONSUMER_SECRET_KEY, PIN);

		String StringIdSpace = "2166";
		
		List<Subject> subjects = (List<Subject>) client.getSubjectsBySpace(StringIdSpace);
		//System.out.println(subjects);
		for (int i=0;i<subjects.size();i++){
				System.out.println("modulo "+ subjects.get(i).id + ": " +subjects.get(i).name +" - "+ subjects.get(i).description);	
		}
		
		/*

		//Course curso = client.postCourse("ufrpe-uag","Testing MobileApp", "tmobileapp", "60", "Curso para testar MobileApplication");

		//Listando os Ambientes do usuario
		String idEnv = "ufrpe-uag";
		//System.out.println("Please, insert the environment ID");
		//String idEnvironment = in.nextLine();
		client.getEnvironment(idEnv);

		
		//Listando os cursos do ambiente especifico
//		List<Course> courses = (List<Course>) client.getCoursesByEnvironment("ufrpe-uag");
//		System.out.println(courses);
		
		
//		String StringIdCourse = "1460";
//		List<Space> spaces = (List<Space>) client.getSpacesByCourse(StringIdCourse);
//		System.out.println(spaces);
		
		String StringIdSpace = "2166";
//		List<Subject> subjects = (List<Subject>) client.getSubjectsBySpace(StringIdModulo);
		String JSonFile = client.getSubjectssBySpace(StringIdSpace);
		System.out.println(JSonFile);
		
//		Gson myGson = new Gson();
//	      JsonParser jsonParser = new JsonParser();
//	      int i = 0;
//	      JsonArray modArray =  jsonParser.parse(subjects.toString()).getAsJsonArray();
//	      List modulos = new ArrayList<Subject>();
//	      for ( JsonElement aMod : modArray ){
//	    	Subject mod = myGson.fromJson(aMod, Subject.class);
//	        modulos.add(mod);
//	        System.out.println(modulos.get(i));
//	      }
//	      for ( Subject tMod : modulos){
//	        System.out.println(tMod);
//	      }
      //Testando segunda opcao
		JsonElement json = new JsonParser().parse(JSonFile);
		JsonArray array= json.getAsJsonArray();
		Iterator iterator = (Iterator) array.iterator();
		List<Subject> modulos = new ArrayList<Subject>();
		while(iterator.hasNext()){
			JsonElement json2 = (JsonElement)iterator.next();
			Gson gson = new Gson();
			Subject modulo = gson.fromJson(json2, Subject.class);

			modulos.add(modulo);

		}
		System.out.println("tamanho do array de modulos: "+ modulos.size());
		for (int j=0;j<modulos.size();j++){
			System.out.println("id: "+ modulos.get(j).id);
			System.out.println("nome: "+ modulos.get(j).name);
			System.out.println("description: "+ modulos.get(j).description);
		}	


		
		
		
		
//		Subject modulo = gson.fromJson(subjects.toString(), Subject.class);
//		System.out.println(modulo.name);
		
		
		*/
		
		
//		String StringIdDisciplines = "2999";
//		List<Subject> subjects = (List<Subject>) client.getSubjectsBySpace(StringIdModulo);
//		client.getenr
		
		System.out.println("system off");
	}
}
