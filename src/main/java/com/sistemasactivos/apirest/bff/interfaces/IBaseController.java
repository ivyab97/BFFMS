package com.sistemasactivos.apirest.bff.interfaces;

import com.sistemasactivos.apirest.bff.model.BaseDTO;
import java.io.Serializable;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;

public interface IBaseController <E extends BaseDTO, D extends BaseDTO, ID extends Serializable>{
    
    public Mono<?> getAllRecord(@RequestParam Boolean status, @RequestParam Integer page, @RequestParam Integer size);
    public Mono<?> getRecordById(@PathVariable ID id);
    public Mono<?> activate(@PathVariable ID id);
    
    public Mono<?> getRecordByActiveId(@PathVariable ID id);
    public Mono<?> save(@RequestBody D entity);
    public Mono<?> update(@PathVariable ID id, @RequestBody D entity);
    public Mono<?> delete(@PathVariable ID id);

    
}
