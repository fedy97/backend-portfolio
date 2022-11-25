package com.fedy97.springbootserver.payload.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
public abstract class PageableRequest {
    private int size;
    private int page;

    private String[] sort;
    private boolean doSort;

    protected PageableRequest() {
        this.size = 1000;
        this.page = 0;
        this.doSort = false;
        sort = new String[]{"_id","asc"};
    }

    public void setSort(String[] sort) {
        this.sort = sort;
        setDoSort(true);
    }
}
