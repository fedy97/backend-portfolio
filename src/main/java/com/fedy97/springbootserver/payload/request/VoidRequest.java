package com.fedy97.springbootserver.payload.request;

public class VoidRequest extends PageableRequest {
    public VoidRequest(int size, int page, String[] sort, boolean doSort) {
        super(size, page, sort, doSort);
    }

    public VoidRequest() {
        super();
    }
}
