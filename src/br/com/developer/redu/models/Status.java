package br.com.developer.redu.models;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: igor
 * Date: 8/31/12
 * Time: 11:56 AM
 * To change this template use File | Settings | File Templates.
 */
public class Status {
	
	public final static String TYPE_ACTIVITY = "Activity";
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

    @Override
    public String toString(){
        return String.format("id: %s\ntype: %s\nlogeable_type: %s\ncreated_at: %s\ntext: %s\nuser: %s\nlectureAreadySeen: %s\nlastSeen: %s\nlinks: %s",
                id, type, logeable_type, created_at,text, user, lectureAreadySeen, lastSeen, links);
    }

}
