package br.com.developer.redu.api;

/**
 * Created with IntelliJ IDEA.
 * modified: rgcrocha
 * User: igor
 * Date: 9/3/12
 * Time: 10:14 AM
 * To change this template use File | Settings | File Templates.
 */
public interface Redu<A,B,C,D,E,F,G,H,I,J,L,M> extends CourseMethods<A>, EnrollnmentMethods<B>, EnvironmentMethods<C>,
        SpaceMethods<D>, SubjectMethods<E>, UserMethods<F>, WallMethods<G>, 
        ChatMessageMethods<H>, ChatMethods<I>, LectureMethods<J>, FoldersMethods<L>, FileMethods<M>{

}
