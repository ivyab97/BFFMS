package com.sistemasactivos.apirest.bff.model;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * @author Ivan Andres Brestt
 */

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerResponse extends BaseDTO{

    @Schema(description = "Identifier attribute", example = "10")
    private Integer customerId;
    
    @Schema(description = "Id of user", example = "10")
    private Long userId;
    
    @Schema(description = "Customer name", example = "Leonel")
    @Size(min = 2, max = 30)
    private String name;
    
    @Schema(description = "Customer surname", example = "Lorenzo")
    @Size(min = 2, max = 30)
    private String surname;
    
    @Schema(description = "Customer DNI", example = "11111111")
    private Integer dni;

    @Schema(description = "Date of birth")
    private LocalDate dateOfBirth;
    
    @Schema(description = "Nationality of customer", example = "Argentina")
    @Size(min = 4, max = 30)
    private String nationality;
    
    @Schema(description = "Sex of the customer. Expected values are 'M' for male and 'F' for female.", example = "M")
    private String sex;
    
    @Schema(description = "Status of soft delete")
    private Boolean enabled;
    
    @Schema(description = "Date of creation")
    private Date createdAt;
    
    @Schema(description = "Date of update")
    private Date updatedAt;
 
}