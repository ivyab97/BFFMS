package com.sistemasactivos.apirest.bff.model;

import java.util.List;
import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class PagedResponse<D extends BaseDTO> extends BaseDTO{
    private List<D> content;
    private PageableDTO pageable;
    private boolean last;
    private int totalElements;
    private int totalPages;
    private boolean first;
    private int size;
    private int number;
    private SortDTO sort;
    private int numberOfElements;
    private boolean empty;
}
