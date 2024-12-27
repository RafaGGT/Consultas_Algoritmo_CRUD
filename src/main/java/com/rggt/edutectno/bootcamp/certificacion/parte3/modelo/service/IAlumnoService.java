package com.rggt.edutectno.bootcamp.certificacion.parte3.modelo.service;

import com.rggt.edutectno.bootcamp.certificacion.parte3.modelo.dto.AlumnoDTO;

import java.util.List;

public interface IAlumnoService {
    List<AlumnoDTO> listar();

    AlumnoDTO alumnoId(String id);

    void borrar(String id);

    List<AlumnoDTO> situacionFinal(String sitFinal);
}
