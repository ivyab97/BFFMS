package com.sistemasactivos.apirest.bff.interfaces;

import com.sistemasactivos.apirest.bff.model.BaseDTO;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

/**
 * @author Ivan Andres Brestt
 */

public interface IBaseService <C extends BaseDTO, CR extends BaseDTO, ID extends Integer>{

    public Page<C> findAllByStatusEquals(Boolean status, Pageable pageable) throws Exception;
    public C findByIdActive(ID id)throws Exception; // Solo busca los activos
    public C findById(ID id) throws Exception;  // Busca todos los registros, activos o no
    public C save (CR entity) throws Exception;
    public C update(ID id, CR entity) throws Exception;
    public boolean softDelete(ID id) throws Exception;
    public C activate(ID id) throws Exception;  //Da de alta un recurso
    
}
