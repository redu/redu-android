package br.com.developer.redu.models;

import java.io.Serializable;

/**
 * Created with IntelliJ IDEA.
 * User: igor
 * Date: 8/31/12
 * Time: 10:11 AM
 * To change this template use File | Settings | File Templates.
 */
public class Link implements Serializable {

	private static final long serialVersionUID = -1206498696461639631L;
	
	public String rel;
    public String href;
    public String name;
    public String permalink;

    @Override
    public String toString(){
        return String.format("rel: %s\nhref: %s\nname: %s\npermalink: %s", rel, href, name, permalink);
    }
}
