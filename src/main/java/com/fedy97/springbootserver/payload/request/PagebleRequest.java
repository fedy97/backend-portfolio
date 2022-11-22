package com.fedy97.springbootserver.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public abstract class PagebleRequest {
    private int size;
    private int page;

    private String[] sort;

    protected PagebleRequest() {
        this.size = 10;
        this.page = 0;
        sort = new String[]{};
    }

}
