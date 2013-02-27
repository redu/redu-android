package br.com.developer.redu.models;

/**
 * Created with IntelliJ IDEA.
 * User: igor
 * Date: 8/31/12
 * Time: 10:35 AM
 * To change this template use File | Settings | File Templates.
 */
public class Thumbnail {
    public String size;
    public String href;

    @Override
    public String toString(){
        String retorno = String.format("size: %s\nhref: %s", size, href);
        return retorno;
    }
}
