package br.com.developer.redu.api;

import java.util.List;

/**
 * @author rgcrocha
 *
 * @param <T> - Tipo do Space
 */
public interface FileMethods<T> {

	/**
	 * Retorna os arquivos da pasta em questão.
	 * @param folderId - ID pasta
	 */
	public List<T> getFilesByFolder(String folderId);


}
