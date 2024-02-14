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
class SortDTO implements Serializable{
    private boolean empty;
    private boolean sorted;
    private boolean unsorted;
}
