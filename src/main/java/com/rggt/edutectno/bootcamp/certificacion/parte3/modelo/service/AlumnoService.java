package com.rggt.edutectno.bootcamp.certificacion.parte3.modelo.service;

import com.rggt.edutectno.bootcamp.certificacion.parte3.modelo.dao.AlumnoRepository;
import com.rggt.edutectno.bootcamp.certificacion.parte3.modelo.dto.AlumnoDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AlumnoService implements IAlumnoService{

    @Autowired
    AlumnoRepository alumnoRep;

    @Override
    public List<AlumnoDTO> listar() {
        return alumnoRep.findAll();
    }

    @Override
    public AlumnoDTO alumnoId(String id) {
        return alumnoRep.findById(id).orElse(null);
    }

    @Override
    public void borrar(String id) {
        alumnoRep.deleteById(id);
    }

    @Override
    public List<AlumnoDTO> situacionFinal(String sitFinal) {
        return alumnoRep.findAll().stream()
                .filter(alumno -> sitFinal.equals((alumno.getSitFinal())))
                .collect(Collectors.toList());
    }
}
