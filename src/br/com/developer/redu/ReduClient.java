package br.com.developer.redu;

import br.com.developer.redu.api.Redu;
import br.com.developer.redu.http.ScribeHttpClient;
import br.com.developer.redu.models.*;
import br.com.developer.redu.http.HttpClient;
import br.com.developer.redu.http.ArgPair;
import com.google.gson.Gson;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * @author igor
 * 
 * Classe que faz uma implementação parcial do Wrapper do redu. 
 * Todos os objetos que representam recursos da api são parametrizados para
 * facilitar a customização. O objetivo principal dessa classe é abstrair o parsing e
 * a requisição dos recursos.
 *
 * @param <A> Tipo de Course
 * @param <B> Tipo de Enrollment
 * @param <C> Tipo de Environment
 * @param <D> Tipo de Space
 * @param <E> Tipo de Subject
 * @param <F> Tipo de User
 * @param <G> Tipo de Status
 * @param <H> Tipo de ChatMessage
 * @param <I> Tipo de Chat
 */
public abstract class ReduClient<A,B,C,D,E,F,G,H,I,J,L,M> implements Redu<A,B,C,D,E,F,G,H,I,J,L,M> {

    private HttpClient httpClient;
    private final String BASE_URL="http://www.redu.com.br/api/";
    private Gson gson;

    protected Type userList;
    protected Type statusList;
    protected Type courseList;
    protected Type spaceList;
    protected Type subjectList;
    protected Type enrollmentList;
    protected Type chatMessageList;
    protected Type chatList;
    protected Type lectureList;
    protected Type folderList;
    protected Type fileList;
    
    protected Class<A> courseClass;
    protected Class<B> enrollmentClass;
    protected Class<C> environmentClass;
    protected Class<D> spaceClass;
    protected Class<E> subjectClass;
    protected Class<F> userClass;
    protected Class<G> statusClass;
    protected Class<H> chatMessageClass;
    protected Class<I> chatClass;
    protected Class<J> lectureClass;
    protected Class<L> folderClass;
    protected Class<M> fileClass;
    


    public ReduClient(String consumerKey, String consumerSecret){
        this.initTypes();
        this.gson = new Gson();
        this.httpClient = new ScribeHttpClient(consumerKey, consumerSecret);
    }
    public ReduClient(String consumerKey, String consumerSecret, String pin){
        this.initTypes();
        this.gson = new Gson();
        this.httpClient = new ScribeHttpClient(consumerKey,consumerSecret,pin);
    }

    public String getAuthorizeUrl(){
        return this.httpClient.getAuthUrl();
    }
    public void initClient(String pin){
        this.httpClient.initClient(pin);
    }
    
    
    /**
     * Metódo abstrato que inicializa os tipos que representam os recursos da api.
     * É preciso inicializar TODOS os recursos se não null pointers vão aparecer.
     */
    protected abstract void initTypes();

    private <T> T getUrl(String url, Class<T> classOfT){
        String json = this.httpClient.get(url);
        T retorno = this.gson.fromJson(json, classOfT);
        return retorno;
    }
    private <T> T getUrl(String url, Class<T> classOfT, Map.Entry<String, String>... args){
        String json = this.httpClient.get(url, args);
        T retorno = this.gson.fromJson(json, classOfT);
        return retorno;
    }
    private <T> T getUrl(String url, Type typeOfT, Map.Entry<String, String>... args){
    	List<Map.Entry<String, String>> new_args = new ArrayList<Map.Entry<String, String>>();
    	for(Map.Entry<String, String> o : args){
    		if(o.getValue() != null){
    			new_args.add(o);
    		}
    	}
    	String json = "";
    	if(!new_args.isEmpty()){
    		json = this.httpClient.get(url, new_args.toArray(new ArgPair[args.length]));
    		System.out.println("json 3-primeirose:"+json);
    	}else{
    		json = this.httpClient.get(url);
   	}
        T retorno = this.gson.fromJson(json, typeOfT);
        return retorno;
    }
    private <T> T getUrl(String url, Type typeOfT){
        String json = this.httpClient.get(url);
        T retorno = this.gson.fromJson(json, typeOfT);
        return retorno;
    }

    private <T> T postUrl(String url, Class<T> classOfT, String payload, Map.Entry<String, String>... args){
        String json = this.httpClient.post(url, payload.getBytes(), args);
        T retorno = this.gson.fromJson(json, classOfT);
        return retorno;
    }
    
    public A getCourse(String courseId) {
        return this.getUrl(BASE_URL+"courses/"+courseId, this.courseClass);
    }
    
    public List<A> getCoursesByEnvironment(String environmentId){
    	return this.getUrl(BASE_URL+"environments/"+environmentId+"/courses", 
    			this.courseList);
    }

    public A postCourse(String environmentId, String name, String path, String workload, String description) {
        CoursePayload load = new CoursePayload(name, path, workload, description);
        String url = BASE_URL+"environments/"+environmentId+"/courses";
        String json = this.gson.toJson(load);
        return this.postUrl(url, this.courseClass, json);
    }

    public void editCourse(String courseId, String name, String path, String workload, String description) {
        CoursePayload load = new CoursePayload(name, path, workload, description);
        String url = BASE_URL+"courses/"+courseId;
        String json = this.gson.toJson(load);
        this.httpClient.put(url,json.getBytes());
    }
    public void deleteCourse(String courseId){
        this.httpClient.delete(BASE_URL+"courses/"+courseId);
    }
    
    public B getEnrollment(String enrollmentId) {
        return this.getUrl(BASE_URL+"enrollments/"+enrollmentId, this.enrollmentClass);
    }

    
    public B postEnrollment(String courseId, String email) {
        EnrollmentPayload load = new EnrollmentPayload(email);
        String json = this.gson.toJson(load);
        String url = BASE_URL+"courses/"+courseId+"/enrollments";
        return this.postUrl(url, this.enrollmentClass, json);
    }

    
    public List<B> getEnrollmentsByCourse(String courseId) {
        return this.getUrl(BASE_URL+"courses/"+courseId+"/enrollments", this.enrollmentList);
    }

    
    public void deleteEnrollment(String enrollmentId) {
        this.httpClient.delete(BASE_URL+"enrollments/"+enrollmentId);
    }

    
    public C getEnvironment(String environmentId) {
        return this.getUrl(BASE_URL+"environments/"+environmentId, this.environmentClass);
    }

    
    public C postEnvironment(String name, String path, String initials, String description) {
        EnvironmentPayload load = new EnvironmentPayload(name, path, initials, description);
        String json = this.gson.toJson(load);
        return this.postUrl(BASE_URL+"environments", this.environmentClass, json);
    }

    
    public void editEnvironment(String environmentId, String name, String path, String initials, String description) {
        EnvironmentPayload load = new EnvironmentPayload(name, path, initials, description);
        byte[] json = this.gson.toJson(load).getBytes();
        this.httpClient.put(BASE_URL+"environments/"+environmentId, json);

    }


    
    public void deleteEnvironment(String environmentId) {
        this.httpClient.delete(BASE_URL+"environments/"+environmentId);
    }

    
    public D getSpace(String spaceId) {
        return this.getUrl(BASE_URL+"spaces/"+spaceId, this.spaceClass);
    }

    
    public void editSpace(String spaceId, String name, String description) {
        SpacePayload load = new SpacePayload(name, description);
        byte [] json = this.gson.toJson(load).getBytes();
        this.httpClient.put(BASE_URL+"spaces/"+spaceId, json);
    }

    
    public D postSpace(String courseId, String name, String description) {
        SpacePayload load = new SpacePayload(name, description);
        String url = BASE_URL+"courses/"+courseId+"/spaces";
        String json = this.gson.toJson(load);
        return this.postUrl(url, this.spaceClass, json);
    }

    
    public List<D> getSpacesByCourse(String courseId) {
        return this.getUrl(BASE_URL+"courses/"+courseId+"/spaces", this.spaceList);
    }

    
    public void deleteSpace(String spaceId) {
        this.httpClient.delete(BASE_URL+"spaces/"+spaceId);
    }

    
    public E getSubject(String subjectId) {
        return this.getUrl(BASE_URL+"subjects/"+subjectId, this.subjectClass);
    }

    
    public List<E> getSubjectsBySpace(String spaceId) {
        return this.getUrl(BASE_URL+"spaces/"+spaceId+"/subjects", this.subjectList);
    }

//    @Override
//    public E postSubject(String spaceId, String title, String description) {
//        throw new RuntimeException("NOT SUPPORTED YET!");
//    }
    public E postSubject(String spaceId, String title, String description) {
        //   throw new RuntimeException("NOT SUPPORTED YET!");
         SubjectPayload load = new SubjectPayload(title, description);
         String url = BASE_URL+"spaces/"+spaceId+"/subjects";
         String json = this.gson.toJson(load);
         return this.postUrl(url, this.subjectClass, json);
           
       }

    public void editSubject(String subjectId, String title, String description) {
        throw new RuntimeException("NOT SUPPORTED YET!");
    }

    public void deleteSubject(String subjectId) {
        this.httpClient.delete(BASE_URL+"subjects/"+subjectId);
    }

    public F getUser(String userId) {
        return this.getUrl(BASE_URL+"users/"+userId, this.userClass);
    }

    public F getMe() {
        return this.getUrl(BASE_URL+"me", this.userClass);
    }

    public List<F> getUsersBySpace(String spaceId, String role) {
    	ArgPair arg = new ArgPair("role", role);
    	return this.getUrl(BASE_URL+"spaces/"+spaceId+"/users", this.userList, arg);

    }

    public G getStatus(String statusId) {
        return this.getUrl(BASE_URL+"statuses/"+statusId, this.statusClass);
    }

    public List<G> getAnswers(String statusId) {
        return this.getUrl(BASE_URL+"statuses/"+statusId+"/answers",this.statusList);
    }

    public G postAnswer(String statusId, String text) {
        StatusPayload load = new StatusPayload(text);
        String url = BASE_URL+"statuses/"+statusId+"/answers";
        String json = this.gson.toJson(load);
        return this.postUrl(url, this.statusClass, json);
    }

    public List<G> getStatusesByUser(String userId, String type, String page) {
        Map.Entry<String, String> arg = new ArgPair("type", type);
        Map.Entry<String, String> arg1 = new ArgPair("page", page);
        return this.getUrl(BASE_URL+"users/"+userId+"/statuses", this.statusList, arg, arg1);
    }

    public List<G> getStatusesTimelineByUser(String userId, String type, String page) {
        Map.Entry<String, String> arg = new ArgPair("type", type);
        Map.Entry<String, String> arg1 = new ArgPair("page", String.valueOf(page));
        return this.getUrl(BASE_URL+"users/"+userId+"/statuses/timeline", this.statusList, arg, arg1);
    }

    
    public List<G> getStatusesTimelineBySpace(String spaceId, String type, String page) {
        Map.Entry<String, String> arg = new ArgPair("type", type);
        Map.Entry<String, String> arg1 = new ArgPair("page", type);
        return this.getUrl(BASE_URL+"spaces/"+spaceId+"/statuses/timeline", this.statusList, arg, arg1);
    }

    
    public G postStatusUser(String userId, String status) {
        StatusPayload load = new StatusPayload(status);
        String url = BASE_URL+"users/"+userId+"/statuses";
        String json = this.gson.toJson(load);
        return this.postUrl(url, this.statusClass, json);
    }

    
    public List<G> getStatusesBySpace(String spaceId, String type, String page) {
        Map.Entry<String, String> arg = new ArgPair("type", type);
        Map.Entry<String, String> arg1 = new ArgPair("page", type);
        return this.getUrl(BASE_URL+"spaces/"+spaceId+"/statuses", this.statusList, arg, arg1);
    }

    
    public G postStatusSpace(String spaceId, String text) {
        StatusPayload load = new StatusPayload(text);
        String url = BASE_URL+"spaces/"+spaceId+"/statuses";
        String json = this.gson.toJson(load);
        return this.postUrl(url, this.statusClass, json);
    }

    
    public List<G> getStatusesByLecture(String lectureId) {
        return this.getUrl(BASE_URL+"lectures/"+lectureId+"/statuses", this.statusList);
    }

    
    public G postStatusLecture(String lectureId, String status, String type) {
        StatusPayload load = new StatusPayload(status, type);
        String url = BASE_URL+"lectures/"+lectureId+"/statuses";
        String json = this.gson.toJson(load);
        return this.postUrl(url, this.statusClass, json);
    }

    
    public void deleteStatus(String statusId) {
        this.httpClient.delete(BASE_URL+"statuses/"+statusId);
    }
    
     
    public H getChatMessage(String chatMessageId){
    	return this.getUrl(BASE_URL+"chat_messages/"+chatMessageId, this.chatMessageClass);
    }
    
    public List<H> getChatMessagesByChat(String chatId){
    	return this.getUrl(BASE_URL+"chats/"+chatId+"/chat_messages", 
    			this.chatMessageList);
    }
    
    public I getChat(String chatId){
    	return this.getUrl(BASE_URL+"chats/"+chatId, this.chatClass);
    }
    
    public List<I> getChatsByUser(String userId){
    	return this.getUrl(BASE_URL+"users/"+userId+"/chats",this.chatList);
    }
    
    public J getLecture(String lectureId){
    	return this.getUrl(BASE_URL+"lectures/"+lectureId, this.lectureClass);
    }
    
    //rodrigo - metodo para retornar json da disciplina from subject
    public List<J> getLecturesBySubject(String subjectId) {
        return this.getUrl(BASE_URL+"subjects/"+subjectId+"/lectures", this.lectureList);
    }    
    
    //rodrigo - metodo para retornar json das pastas de uma disciplina from subject
    public List<L> getFoldersBySpace(String spaceId) {
        return this.getUrl(BASE_URL+"spaces/"+spaceId+"/folders", this.folderList);
//        return this.getUrl(BASE_URL+"spaces/"+spaceId+"/files/", this.folderList);
    }
    public String getFolderID(String spaceId){
    	List<Folder> f = (List<Folder>) this.getFoldersBySpace(spaceId);
    	String folderID = f.get(0).id;
//    	this.getUrl(BASE_URL+"spaces/"+spaceId+"/folders", this.folderClass);
    	return folderID;
    }
    public L getFolder(String folderId){
    	return this.getUrl(BASE_URL+"folders/"+folderId, this.folderClass);
    }
    public List<L> getFolders(String folderId){
    	return this.getUrl(BASE_URL+"folders/"+folderId+"/folders/", this.folderList);
    }    
    public List<M> getFilesByFolder(String folderId) {
        return this.getUrl(BASE_URL+"folders/"+folderId+"/files", this.fileList);
    }
}
