package com.rggt.edutectno.bootcamp.certificacion.parte3.controller;

import com.rggt.edutectno.bootcamp.certificacion.parte3.modelo.service.IAlumnoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class AlumnoController {

        @Autowired
        IAlumnoService alumnoService;

        @GetMapping("/")
            public String index(Model model) {
            model.addAttribute("titulo", "Listar Alumnos");
            return "redirect:/listarAlumnos";
       }


        @GetMapping("/listarAlumnos")
        public String listarAlumnos(Model model) {
            model.addAttribute("titulo", "Listar Alumnos");
            model.addAttribute("alumnos", alumnoService.listar());
            return "alumnos";
        }
        @PostMapping("/listarAlumnosFiltrados")
        public String listarAlumnosFiltrados(Model model,
                                             @RequestParam String runAlu,
                                             @RequestParam String sitFinal) {
            model.addAttribute("titulo", "Listar Alumnos");

            if(runAlu != null && !runAlu.isEmpty()) {
                model.addAttribute("alumnos", alumnoService.alumnoId(runAlu));
                model.addAttribute("subTitulo", "Buscando por run: " + runAlu);
                return "alumnos";
            }

            if ("todos".equals(sitFinal)) {
                return "redirect:/listarAlumnos";
            } else if(sitFinal != null && !sitFinal.isEmpty()) {
                model.addAttribute("alumnos", alumnoService);
                model.addAttribute("alumnos", alumnoService.situacionFinal(sitFinal));
                return "alumnos";
            }
            model.addAttribute("alumnos", alumnoService.listar());
            return "alumnos";
        }

        @GetMapping ("/eliminarAlumno/{runAlu}")
        public String eliminarAlumno(Model model, @PathVariable(value = "runAlu") String runAlu) {

            if(runAlu !=null && !runAlu.isEmpty()) {
                alumnoService.borrar(runAlu);
                model.addAttribute("titulo", "Listar Alumnos");
                model.addAttribute("alumnos", alumnoService.listar());
                return "redirect:/listarAlumnos";
            }else{
                model.addAttribute("titulo", "No llego el id");
                model.addAttribute("alumnos", alumnoService.listar());
            }
            return "alumnos";
        }
    }
