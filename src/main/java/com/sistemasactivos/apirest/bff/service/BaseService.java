package com.sistemasactivos.apirest.bff.service;

import com.sistemasactivos.apirest.bff.interfaces.IBaseService;
import com.sistemasactivos.apirest.bff.model.BaseDTO;
import java.io.Serializable;

/**
 * @author Ivan Andres Brestt
 */

public abstract class BaseService<E extends BaseDTO, R extends BaseDTO, ID extends Serializable> implements IBaseService<E, R, Integer>{

}
