package com.sistemasactivos.apirest.bff.interfaces;

import com.sistemasactivos.apirest.bff.model.BaseDTO;
import com.sistemasactivos.apirest.bff.model.PagedResponse;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author Ivan Andres Brestt
 */

public interface IBaseService <C extends BaseDTO, CR extends BaseDTO, ID extends Integer>{

    public Mono<PagedResponse<C>> findAllByStatusEquals(Boolean status, Integer page, Integer size) throws Exception;
    public Mono<C> findByIdActive(ID id)throws Exception; // Solo busca los activos
    public Mono<C> findById(ID id) throws Exception;  // Busca todos los registros, activos o no
    public Mono<C> save (CR entity) throws Exception;
    public Mono<C> update(ID id, CR entity) throws Exception;
    public Mono<Void> softDelete(ID id) throws Exception;
    public Mono<C> activate(ID id) throws Exception;  //Da de alta un recurso
    
}
