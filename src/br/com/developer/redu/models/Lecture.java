package br.com.developer.redu.models;

import java.util.List;

/**
 * User: rgcrocha
 * Date: 02/02/13
 * Time: 10:49 AM
 */

public class Lecture {
    
    public String name;
    public int position;
    public int rating;
    public String type;
    public List<Link> links;
    public int view_count;
    public String mimetype;
    public String created_at;
    public int id;
    public String updated_at;
    
    

    @Override
	public String toString() {
		return "Lecture [name=" + name + ", position=" + position + ", rating="
				+ rating + ", type=" + type + ", links=" + links
				+ ", view_count=" + view_count + ", mimetype=" + mimetype
				+ ", created_at=" + created_at + ", id=" + id + ", updated_at="
				+ updated_at + "]";
	}
}
