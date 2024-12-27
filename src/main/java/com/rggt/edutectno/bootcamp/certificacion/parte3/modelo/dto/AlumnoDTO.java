package com.rggt.edutectno.bootcamp.certificacion.parte3.modelo.dto;


import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "alumnos")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class AlumnoDTO implements Serializable {

    @Id
    @Column(name = "run_alu")
    private String runAlu;

    @NotNull
    @Column(name = "nom_alu")
    private String nomAlu;
    @NotNull
    @Column(name = "ape_alu")
    private String apeAlu;

    @Transient
    private Double promedio;

    @Transient
    private String sitFinal;


    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EvaluacionDTO> evaluaciones = new ArrayList<>();


    @OneToMany(mappedBy = "alumno", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<CursoDTO> cursos = new ArrayList<>();

    public Double getPromedio(){
        if(evaluaciones == null || evaluaciones.isEmpty()){
            return 0.0;
        }
        return (double)Math.round(evaluaciones.stream().mapToDouble(EvaluacionDTO::getNotEvaluacion)
                .average()
                .orElse(0.0) * 10.0) / 10.0;
    }

    public String getSitFinal(){
        Double promedio = getPromedio();
        if(promedio != null && promedio >= 4.0){
            return "Aprobado";
        }else{
            return "Reprobado";
        }
    }


}