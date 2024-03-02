package com.sistemasactivos.apirest.bff.interfaces;

import com.sistemasactivos.apirest.bff.model.BaseDTO;
import com.sistemasactivos.apirest.bff.model.PagedResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Ivan Andres Brestt
 */

public interface IBaseService <C extends BaseDTO, CR extends BaseDTO, ID extends Long>{

    public Mono<PagedResponse<C>> findAllByEnabledEquals(Boolean enabled, Integer page, Integer size);
    public Mono<C> findByIdActive(ID id); // Solo busca los activos
    public Mono<C> findById(ID id);  // Busca todos los registros, activos o no
    public Mono<C> save (CR request);
    public Mono<C> update(ID id, CR request);
    public Mono<?> softDelete(ID id);
    public Mono<C> activate(ID id) ;  //Da de alta un recurso
    
}
