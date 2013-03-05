package br.com.developer.redu.models;

import java.util.List;

/**
 * User: rgcrocha
 * Date: 13/02/13
 * Time: 07:49 AM
 */

public class Folder {
    
	public String id;
    public String name;
    public List<Link> links;
    public String created_at;
	@Override
	public String toString() {
		return "Folder [ID=" + id + ", name=" + name + ", links=" + links
				+ ", created_at=" + created_at + "]";
	}
	
}
