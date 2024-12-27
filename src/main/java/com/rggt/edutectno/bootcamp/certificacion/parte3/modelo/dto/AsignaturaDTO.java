package com.rggt.edutectno.bootcamp.certificacion.parte3.modelo.dto;



import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "asignaturas")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AsignaturaDTO implements Serializable {

    @Id
    @Column(name = "id_asi")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAsi;

    @NotNull
    @Column(name = "nom_asi")
    private String nomAsi;

    @NotNull
    @Column(name = "tip_asi")
    private String tipAsi;

    @OneToMany(mappedBy = "asignatura",  cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EvaluacionDTO> evaluaciones = new ArrayList<>();
}
