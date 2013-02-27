package br.com.developer.redu.models;

import br.com.developer.redu.models.CoursePayload.course;

import com.google.gson.Gson;

/**
 * Created with IntelliJ IDEA.
 * User: igor
 * Date: 9/5/12
 * Time: 9:23 AM
 * To change this template use File | Settings | File Templates.
 */
public class SubjectPayload {
    private subject subject;

    public SubjectPayload(String name, String description){
    	subject = new subject();
    	subject.name = name;
    	subject.description = description;
    }

    class subject{
        public String name;
        public String description;
    }
    public static void main(String[] args){
        SubjectPayload sp = new SubjectPayload("testeeeee", "testeeeeetesteeeeetesteeeeetesteeeeetesteeeee");
        Gson g = new Gson();
        System.out.println(g.toJson(sp));
    }

}
