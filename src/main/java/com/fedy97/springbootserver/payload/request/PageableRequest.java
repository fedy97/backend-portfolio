package com.fedy97.springbootserver.payload.request;

import com.fedy97.springbootserver.errors.InvalidPageException;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

@Getter
@Setter
@ToString
public abstract class PageableRequest {
    private int size;
    private int page;

    private String[] sort;
    private boolean doSort;
    private Pageable pageable;

    protected PageableRequest() {
        this.size = 1000;
        this.page = 0;
        setDefaultSort();
    }

    protected PageableRequest(int size, int page, String[] sort, boolean doSort) {
        if (doSort && (sort == null || sort.length == 0))
            throw new InvalidPageException();
        this.size = size;
        this.page = page;
        this.sort = sort;
        this.doSort = doSort;
        this.pageable = createPage();
    }

    private Pageable createPage() {
        Pageable newPage;
        if (isDoSort() && getSort()[1] != null && getSort()[1].equals("asc"))
            newPage = PageRequest.of(getPage(), getSize(),
                    Sort.by(getSort()[0]).ascending());
        else if (isDoSort())
            newPage = PageRequest.of(getPage(), getSize(),
                    Sort.by(getSort()[0]).descending());
        else {
            newPage = PageRequest.of(getPage(), getSize());
        }
        return newPage;
    }

    public void setDefaultSort() {
        this.sort = new String[]{"_id", "asc"};
        setDoSort(true);
        this.pageable = createPage();
    }

    public void setSort(String[] sort) {
        this.sort = sort;
        setDoSort(true);
        setPageable(createPage());
    }
}
