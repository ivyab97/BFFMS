package com.sistemasactivos.apirest.bff.interfaces;

import com.sistemasactivos.apirest.bff.model.BaseDTO;
import com.sistemasactivos.apirest.bff.model.PagedResponse;
import java.io.Serializable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

public interface IBaseController <E extends BaseDTO, D extends BaseDTO, ID extends Serializable>{
    
    public Mono<PagedResponse<E>> getAllRecord(@RequestParam Boolean status, @RequestParam Integer page, @RequestParam Integer size);
    public Mono<E> getRecordById(@PathVariable ID id);
    public Mono<E> activate(@PathVariable ID id);
    
    public Mono<E> getRecordByActiveId(@PathVariable ID id);
    public Mono<ResponseEntity<E>> save(@RequestBody D entity);
    public Mono<E> update(@PathVariable ID id, @RequestBody D entity);
    public Mono<?> delete(@PathVariable ID id);

    
}
