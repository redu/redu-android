package br.com.developer.redu.api;

import br.com.developer.redu.models.Progress;

public interface ProgressMethods<T> {
	
	public T getProgress(String lectureId);
	public T editProgress(Progress progress, String lectureId);
}

