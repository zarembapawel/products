package pl.zarembapawel.products.model;

import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
public abstract class Element {

    private Integer id;
    @NotNull
    private String name;
    private LocalDateTime dateAdd;
    private LocalDateTime dateUpdate;
}
