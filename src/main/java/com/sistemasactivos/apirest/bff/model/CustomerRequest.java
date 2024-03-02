package com.sistemasactivos.apirest.bff.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Digits;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import java.time.LocalDate;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

/**
 * @author Ivan Andres Brestt
 */

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CustomerRequest extends BaseDTO{
    
    @Schema(description = "Id of user", example = "10")
    @NotNull(message = "UserId no puede ser null.")
    @JsonProperty(required = true)    
    private Long userId;
    
    @Schema(description = "Customer name", example = "Leonel")
    @NotNull(message = "Name no puede ser null.")
    @Size(min = 2, max = 30, message = "Name debe tener entre 2 y 20 caracteres.")
    @JsonProperty(required = true)    
    private String name;
    
    @Schema(description = "Customer surname", example = "Lorenzo")
    @NotNull(message = "Surname no puede ser null.")
    @Size(min = 2, max = 30, message = "Surname debe tener entre 2 y 20 caracteres.")
    @JsonProperty(required = true)    
    private String surname;
    
    @Schema(description = "Customer DNI", example = "11111111")
    @NotNull(message = "DNI no puede ser null.")
    @Digits(fraction = 0, integer = 9, message = "DNI debe tener de 1 a 9 digitos.")    
    @JsonProperty(required = true)    
    private Integer dni;

    @Schema(description = "Date of birth")
    @NotNull(message = "DateOfBirth no puede ser null.")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonProperty(required = true)    
    private LocalDate dateOfBirth;
    
    @Schema(description = "Nationality of customer", example = "Argentina")
    @NotNull(message = "Nationality no puede ser null.")
    @Size(min = 4, max = 30, message = "Nationality debe tener entre 4 y 30 caracteres.")
    @JsonProperty(required = true)    
    private String nationality;
    
    @Schema(description = "Sex of the customer. Expected values are 'M' for male and 'F' for female.", example = "M")
    @Pattern(regexp = "^[MF]$", message = "Sex debe tener solo 'M' o 'F'.")
    @Size(min = 1, max = 1, message = "Sex solo debe tener un caracter.")
    @JsonProperty(required = true)    
    private String sex;

}
