package com.sistemasactivos.apirest.bff.model;

import java.io.Serializable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
class PageableDTO implements Serializable{
    private int pageNumber;
    private int pageSize;
    private SortDTO sort;
    private int offset;
    private boolean unpaged;
    private boolean paged;
}
