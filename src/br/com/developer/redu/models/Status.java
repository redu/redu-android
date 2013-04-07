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
	public final static String LOGEABLE_TYPE_FRIENDSHIP = "Friendship";
	
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
    	
    	if(isAnswerType()) {
    		String link = getLink("in_response_to");
    		String[] splitted = link.split("/");
    		id = splitted[splitted.length - 2];
    	}
    	
    	return id;
    }
    
    /**
     * http://www.redu.com.br/api/lectures/5874-introducao-a-fisica.
     * @return Position 0: local type (User, Space ou Lecture)
     * 			<br>Position 1: local id
     * 			<br>Position 2: local name
     */
    public Statusable getStatusable() {
    	Statusable statusable = new Statusable();

    	String link = getLink("statusable");
		
		if(link == null) {
			return null;
		}
		
		String[] linkSplitted = link.split("/");
		
		statusable.type = linkSplitted[linkSplitted.length - 2];
		
		if(statusable.isTypeUser()) {
			statusable.name = linkSplitted[linkSplitted.length - 1];
			
		} else if(statusable.isTypeLecture()) {
			String idAndName = linkSplitted[linkSplitted.length - 1];
			statusable.id = idAndName.substring(0, idAndName.indexOf('-'));
			statusable.name = idAndName.substring(idAndName.indexOf('-') + 1).replaceAll("-", " ");
	    
		} else if(statusable.isTypeSpace()) {
			statusable.name = linkSplitted[linkSplitted.length - 1];
	    }
		
		return statusable;
    }
    
    public boolean isActivityType() {
    	return TYPE_ACTIVITY.equals(type);
    }
    
    public boolean isAnswerType() {
    	return TYPE_ANSWER.equals(type);
    }
    
    public boolean isHelpType() {
    	return TYPE_HELP.equals(type);
    }
    
    public boolean isLogType() {
    	return TYPE_LOG.equals(type);
    }
    
    public boolean isLectureLogeableType() {
    	return LOGEABLE_TYPE_LECTURE.equals(logeable_type);
    }
    
    public boolean isSubjectLogeableType() {
    	return LOGEABLE_TYPE_SUBJECT.equals(logeable_type);
    }
    
    public boolean isCourseLogeableType() {
    	return LOGEABLE_TYPE_COURSE.equals(logeable_type);
    }
    
    public boolean isCourseEnrollmentLogeableType() {
    	return LOGEABLE_TYPE_COURSE_ENROLLMENT.equals(logeable_type);
    }
    
    public boolean isFriendshipLogeableType() {
    	return LOGEABLE_TYPE_FRIENDSHIP.equals(logeable_type);
    }
    
    @Override
    public String toString(){
        return String.format("id: %s\ntype: %s\nlogeable_type: %s\ncreated_at: %s\ntext: %s\nuser: %s\nlectureAreadySeen: %s\nlastSeen: %s\nlinks: %s",
                id, type, logeable_type, created_at,text, user, lectureAreadySeen, lastSeen, links);
    }

}
