package br.com.developer.redu.models;

public class ProgressPayload {
	in progress;

    public ProgressPayload(String id, String finalized){
        progress = new in(id, finalized);
    }

    class in{
        String id;
        String finalized;

        public in(String id, String finalized){
            this.id = id;
            this.finalized = finalized;
        }
    }
}
