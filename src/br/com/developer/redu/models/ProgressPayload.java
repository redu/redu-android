package br.com.developer.redu.models;

public class ProgressPayload {
	in progress;

    public ProgressPayload(String id, String done){
        progress = new in(id, done);
    }

    class in{
        String id;
        String done;

        public in(String id, String done){
            this.id = id;
            this.done = done;
        }
    }
}
