package com.fedy97.springbootserver.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
@AllArgsConstructor
public abstract class PageableRequest {
    private int size;
    private int page;

    private String[] sort;

    protected PageableRequest() {
        this.size = 1000;
        this.page = 0;
        sort = new String[]{};
    }

}
