package com.fedy97.springbootserver.payload.request;

public class VoidRequest extends PageableRequest {
    public VoidRequest(int size, int page, String[] sort) {
        super(size, page, sort);
    }

    public VoidRequest() {
        super();
    }
}
