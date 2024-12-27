package com.rggt.edutectno.bootcamp.certificacion.parte3.modelo.dao;

import com.rggt.edutectno.bootcamp.certificacion.parte3.modelo.dto.AlumnoDTO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AlumnoRepository extends JpaRepository<AlumnoDTO, String> {
}
