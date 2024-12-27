package com.rggt.edutectno.bootcamp.certificacion.parte3.modelo.dto;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "cursos")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CursoDTO {

    @Id
    @Column(name = "id_cur")
    private Integer idCurso;

    @ManyToOne
    @JoinColumn(name = "alu_cur")
    private AlumnoDTO alumno;
}