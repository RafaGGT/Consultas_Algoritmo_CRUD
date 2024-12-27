package com.rggt.edutectno.bootcamp.certificacion.parte3.modelo.dto;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "evaluaciones")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class EvaluacionDTO implements Serializable {

    @Id
    @Column(name = "id_eva")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idEvaluacion;

    @NotNull
    @Column(name = "nom_eva")
    private String nombreEvaluacion;

    @NotNull
    @Column(name = "fec_eva")
    private Date fechaEvaluacion;

    @NotNull
    @Column(name = "not_eva")
    private Double notEvaluacion;

    @ManyToOne
    @JoinColumn(name = "alu_eva")
    private AlumnoDTO alumno;

    @ManyToOne
    @JoinColumn(name = "asi_eva")
    private AsignaturaDTO asignatura;
}
