package com.sistemasactivos.apirest.bff.controller;

import com.sistemasactivos.apirest.bff.interfaces.IBaseController;
import com.sistemasactivos.apirest.bff.model.BaseDTO;
import com.sistemasactivos.apirest.bff.model.PagedResponse;
import com.sistemasactivos.apirest.bff.resources.exception.HTTPError;
import com.sistemasactivos.apirest.bff.service.BaseService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import reactor.core.publisher.Mono;


public abstract class BaseController <E extends BaseDTO, D extends BaseDTO, S extends BaseService<E, D, Integer>> implements IBaseController<E, D, Integer>{
    
    @Autowired
    public S service;
    
    
    @Override
    @GetMapping("")
     @Operation(
        summary = "Obtener todos los registros.",
        description = "Obtiene todos los registros.",
        responses = {
            @ApiResponse(responseCode = "200", content = @Content(schema = @Schema(implementation = PagedResponse.class))),
            @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = HTTPError.class)))
        }
    )
    public Mono<PagedResponse<E>> getAllRecord(
            @RequestParam(required = false) Boolean status,
            @RequestParam(defaultValue = "0") Integer page,
            @RequestParam(defaultValue = "10") Integer size) {
        return service.findAllByStatusEquals(status, page, size);
    }
    
    
    @Override
    @GetMapping("/{id}/admin")
    @Operation(
        summary = "Obtener un registro por ID.",
        description = "Obtiene un registro especifico dado su ID.",
        responses = {
            @ApiResponse(responseCode = "200", ref = "okAPI"),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = HTTPError.class))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = HTTPError.class))),
            @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = HTTPError.class)))
        }
    )
    public Mono<E> getRecordById(@PathVariable Integer id) {
        return service.findById(id);
    }
    
    
    @Override
    @GetMapping("/{id}")
    @Operation(
        summary = "Obtener un registro por ID.",
        description = "Obtiene un registro especifico dado su ID.",
        responses = {
            @ApiResponse(responseCode = "200", ref = "okAPI"),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = HTTPError.class))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = HTTPError.class))),
            @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = HTTPError.class)))
        }
    )
    public Mono<E> getRecordByActiveId(@PathVariable Integer id) {
        return service.findByIdActive(id);
    }
    

    @Override
    @Operation(
        summary = "Dar de alta un registro con su respectiva información.",
        description = "Dar de alta un registro.",
        responses = {
            @ApiResponse(responseCode = "201", ref = "createdAPI"),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = HTTPError.class))),
            @ApiResponse(responseCode = "409", content = @Content(schema = @Schema(implementation = HTTPError.class))),
            @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = HTTPError.class)))
        }
    )
    public Mono<ResponseEntity<E>> save(@RequestBody D entity) {
        return service.save(entity)
                .map(savedEntity -> ResponseEntity.status(HttpStatus.CREATED).body(savedEntity));
    }

    @Override
    @PutMapping("/{id}")
    @Operation(
        summary = "Modificar un registro por ID.",
        description = "Modificar información de un registro pasando como parametro su identificador.",
        responses = {
            @ApiResponse(responseCode = "200", ref = "okAPI"),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = HTTPError.class))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = HTTPError.class))),
            @ApiResponse(responseCode = "409", content = @Content(schema = @Schema(implementation = HTTPError.class))),
            @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = HTTPError.class)))
        }
    )
    public Mono<E> update(@PathVariable Integer id, @RequestBody D entity) {
        return service.update(id, entity);
    }
    
    
    @PutMapping("/{id}/activate")
    @Operation(
        summary = "Dar de alta un recurso desactivado.",
        description = "Activar un recurso desactivado y todos sus registros asociadas.",
        responses = {
            @ApiResponse(responseCode = "200", ref = "noContentAPI"),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = HTTPError.class))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = HTTPError.class))),
            @ApiResponse(responseCode = "409", content = @Content(schema = @Schema(implementation = HTTPError.class))),
            @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = HTTPError.class)))
        }
    )
    public Mono<E> activate(@PathVariable Integer id) {
            return service.activate(id);
    }
    

    @Override
    @DeleteMapping("/{id}")
     @Operation(
        summary = "Eliminar un registro por ID.",
        description = "Eliminar un registro pasando como parametro su identificador.",
        responses = {
            @ApiResponse(responseCode = "204", ref = "noContentAPI"),
            @ApiResponse(responseCode = "400", content = @Content(schema = @Schema(implementation = HTTPError.class))),
            @ApiResponse(responseCode = "404", content = @Content(schema = @Schema(implementation = HTTPError.class))),
            @ApiResponse(responseCode = "500", content = @Content(schema = @Schema(implementation = HTTPError.class)))
        }
    )
    public Mono<?> delete(@PathVariable Integer id) {
            return service.softDelete(id);
    }
    
}
