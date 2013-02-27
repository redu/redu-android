package br.com.developer.redu.models;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: igor
 * Date: 8/31/12
 * Time: 10:49 AM
 * To change this template use File | Settings | File Templates.
 */
public class Subject {
    public int id;
    public String name;
    public String description;
    public String created_at;
    public List<Link> links;

    @Override
    public String toString(){
        return String.format("id: %s\ntitle: %s\ndescription: %s\ncreated_at: %s\nlinks: %s",
                id, name, description,created_at, links);
    }
}
