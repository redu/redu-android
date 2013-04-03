package br.com.developer.redu.models;

import java.io.Serializable;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: igor
 * Date: 8/31/12
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class Status implements Serializable {
	
	private static final long serialVersionUID = -7806882147919355625L;

	public final static String LOGEABLE_TYPE_LECTURE = "Lecture";
	public final static String LOGEABLE_TYPE_SUBJECT = "Subject";
	public final static String LOGEABLE_TYPE_COURSE = "Course";
	public final static String LOGEABLE_TYPE_COURSE_ENROLLMENT = "CourseEnrollment";
	
	public final static String TYPE_ACTIVITY = "Activity";
	public final static String TYPE_ANSWER = "Answer";
	public final static String TYPE_HELP = "Help";
	public final static String TYPE_LOG = "Log";
	
	public String id;
    public String type;
    public String logeable_type;
    public String created_at;
    public String text;
    public User user;
    public List<Link> links;

    public long created_at_in_millis;
    public boolean lectureAreadySeen;
    public boolean lastSeen;

    private String getLink(String rel) {
    	String href = null;
    	for(Link link : links) {
			if(link.rel.equals(rel)) {
				href = link.href;
				break;
			}
		}
    	return href;
    }
    
    /**
     * A link example: http://www.redu.com.br/api/statuses/107070/answers
     * @return the id of the in response to the status
     */
    public String getInResponseToStatusId() {
    	String id = null;
    	
    	if(isTypeAnswer()) {
    		String link = getLink("in_response_to");
    		String[] splitted = link.split("/");
    		id = splitted[splitted.length - 2];
    	}
    	
    	return id;
    }
    
    public boolean isTypeActivity() {
    	return TYPE_ACTIVITY.equals(type);
    }
    
    public boolean isTypeAnswer() {
    	return TYPE_ANSWER.equals(type);
    }
    
    public boolean isTypeHelp() {
    	return TYPE_HELP.equals(type);
    }
    
    public boolean isTypeLog() {
    	return TYPE_LOG.equals(type);
    }
    
    public boolean isLogeableTypeLecture() {
    	return LOGEABLE_TYPE_LECTURE.equals(logeable_type);
    }
    
    public boolean isLogeableTypeSubject() {
    	return LOGEABLE_TYPE_SUBJECT.equals(logeable_type);
    }
    
    public boolean isLogeableTypeCourse() {
    	return LOGEABLE_TYPE_COURSE.equals(logeable_type);
    }
    
    public boolean isLogeableTypeCourseEnrollment() {
    	return LOGEABLE_TYPE_COURSE_ENROLLMENT.equals(logeable_type);
    }
    
    @Override
    public String toString(){
        return String.format("id: %s\ntype: %s\nlogeable_type: %s\ncreated_at: %s\ntext: %s\nuser: %s\nlectureAreadySeen: %s\nlastSeen: %s\nlinks: %s",
                id, type, logeable_type, created_at,text, user, lectureAreadySeen, lastSeen, links);
    }

}
