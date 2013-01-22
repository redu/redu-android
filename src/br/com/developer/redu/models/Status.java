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
    public String type;
    public String created_at;
    public String text;
    public User user;
    public List<Link> links;

    @Override
    public String toString(){
        return String.format("type: %s\ncreated_at: %s\ntext: %s\nuser: %s\nlinks: %s",
                type, created_at,text, user, links);
    }

}
