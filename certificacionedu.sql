CREATE TABLE alumnos (
    run_alu VARCHAR(100) NOT NULL,
    nom_alu VARCHAR(100) NOT NULL,
    ape_alu VARCHAR(100) NOT NULL,
    car_alu INT NOT NULL,
    PRIMARY KEY (run_alu)
);

CREATE TABLE asignaturas (
    id_asi  INT NOT NULL AUTO_INCREMENT,
    nom_asi VARCHAR(100) NOT NULL,
    tip_asi VARCHAR(100) NOT NULL,
    car_asi INT NOT NULL,
    doc_asi VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_asi)
);

CREATE TABLE carreras (
    id_car  INT NOT NULL AUTO_INCREMENT,
    nom_car VARCHAR(100) NOT NULL,
    tip_car VARCHAR(100) NOT NULL,
    dur_car INT NOT NULL,
    dir_car VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_car)
);

CREATE TABLE cursos (
    id_cur  INT NOT NULL AUTO_INCREMENT,
    nom_cur VARCHAR(100) NOT NULL,
    jor_cur VARCHAR(100) NOT NULL,
    asi_cur INT NOT NULL,
    doc_cur VARCHAR(100) NOT NULL,
    alu_cur VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_cur)
);

CREATE TABLE directores (
    run_dir VARCHAR(100) NOT NULL,
    nom_dir VARCHAR(100) NOT NULL,
    ape_dir VARCHAR(100) NOT NULL,
    pro_dir VARCHAR(100) NOT NULL,
    PRIMARY KEY (run_dir)
);

CREATE TABLE docentes (
    run_doc VARCHAR(100) NOT NULL,
    nom_doc VARCHAR(100) NOT NULL,
    ape_doc VARCHAR(100) NOT NULL,
    PRIMARY KEY (run_doc)
);

CREATE TABLE evaluaciones (
    id_eva  INT NOT NULL AUTO_INCREMENT,
    nom_eva VARCHAR(100) NOT NULL,
    fec_eva DATE NOT NULL,
    not_eva DECIMAL(2, 1) NOT NULL,
    asi_eva INT NOT NULL,
    alu_eva VARCHAR(100) NOT NULL,
    PRIMARY KEY (id_eva)
);

ALTER TABLE alumnos
    ADD CONSTRAINT alumnos_carreras_fk FOREIGN KEY (car_alu)
        REFERENCES carreras(id_car);

ALTER TABLE asignaturas
    ADD CONSTRAINT asignaturas_carreras_fk FOREIGN KEY (car_asi)
        REFERENCES carreras(id_car);

ALTER TABLE asignaturas
    ADD CONSTRAINT asignaturas_docentes_fk FOREIGN KEY (doc_asi)
        REFERENCES docentes(run_doc);

ALTER TABLE carreras
    ADD CONSTRAINT carreras_directores_fk FOREIGN KEY (dir_car)
        REFERENCES directores(run_dir);

ALTER TABLE cursos
    ADD CONSTRAINT cursos_alumnos_fk FOREIGN KEY (alu_cur)
        REFERENCES alumnos(run_alu);

ALTER TABLE cursos
    ADD CONSTRAINT cursos_asignaturas_fk FOREIGN KEY (asi_cur)
        REFERENCES asignaturas(id_asi);

ALTER TABLE cursos
    ADD CONSTRAINT cursos_docentes_fk FOREIGN KEY (doc_cur)
        REFERENCES docentes(run_doc);

ALTER TABLE evaluaciones
    ADD CONSTRAINT evaluaciones_alumnos_fk FOREIGN KEY (alu_eva)
        REFERENCES alumnos(run_alu);

ALTER TABLE evaluaciones
    ADD CONSTRAINT evaluaciones_asignaturas_fk FOREIGN KEY (asi_eva)
        REFERENCES asignaturas(id_asi);
        
        
select * from directores;

 INSERT INTO directores (run_dir, nom_dir, ape_dir, pro_dir) VALUES
('17.266.346-K', 'Felipe', 'Cuevas', 'Ingeniero Informático Civil'),
('12.345.678-9', 'Ana', 'González', 'Ingeniero en Computación'),
('23.456.789-K', 'Luis', 'Martínez', 'Ingeniero Civil Informático'),
('34.567.890-1', 'Marta', 'Hernández', 'Ingeniera en Telecomunicaciones'),
('45.678.901-2', 'Juan', 'Ramírez', 'Ingeniero en Sistemas de Información');

INSERT INTO carreras (nom_car, tip_car, dur_car, dir_car) VALUES
('Ingeniería en Sistemas de Información', 'Profesional', 10, '17.266.346-K'),
('Técnico en Desarrollo de Software', 'Técnica', 6, '12.345.678-9'),
('Ingeniería Civil Informática', 'Profesional', 12, '23.456.789-K'),
('Técnico en Redes y Telecomunicaciones', 'Técnica', 6, '34.567.890-1'),
('Ingeniería en Computación y Sistemas', 'Profesional', 10, '45.678.901-2');

INSERT INTO docentes (run_doc, nom_doc, ape_doc) VALUES
('19.876.543-2', 'Nelson', 'Carvajal'),
('20.987.654-3', 'Laura', 'Martínez'),
('21.234.567-4', 'José', 'Gutiérrez'),
('22.345.678-5', 'Elena', 'Rodríguez'),
('23.456.789-6', 'Santiago', 'Vásquez');

INSERT INTO asignaturas (nom_asi, tip_asi, car_asi, doc_asi) VALUES
('Algoritmos y Estructuras de Datos', 'Teórica', 1, '19.876.543-2'),
('Bases de Datos', 'Teórica', 1, '20.987.654-3'),
('Redes de Computadores', 'Práctica', 2, '21.234.567-4'),
('Programación Avanzada', 'Teórica', 3, '22.345.678-5'),
('Desarrollo de Aplicaciones Web', 'Práctica', 4, '23.456.789-6');

INSERT INTO alumnos (run_alu, nom_alu, ape_alu, car_alu) VALUES
('12.987.654-0', 'Juan', 'Gómez', 1),
('19.123.456-7', 'Paula', 'Sánchez', 2),
('25.678.901-3', 'Ricardo', 'Fernández', 3),
('18.234.567-8', 'Luisa', 'Paredes', 4),
('11.456.789-1', 'Antonio', 'Ramírez', 5);

-- Evaluaciones para el alumno 1 (Juan Gómez)
INSERT INTO evaluaciones (nom_eva, fec_eva, not_eva, asi_eva, alu_eva) VALUES
('Evaluación 1', '2024-03-15', 6.5, 1, '12.987.654-0'),
('Evaluación 2', '2024-05-10', 5.0, 1, '12.987.654-0'),
('Evaluación 3', '2024-07-25', 7.0, 1, '12.987.654-0');  

-- Evaluaciones para el alumno 2 (Paula Sánchez)
INSERT INTO evaluaciones (nom_eva, fec_eva, not_eva, asi_eva, alu_eva) VALUES
('Evaluación 1', '2024-03-15', 4.5, 2, '19.123.456-7'),
('Evaluación 2', '2024-05-10', 6.0, 2, '19.123.456-7'),
('Evaluación 3', '2024-07-25', 5.5, 2, '19.123.456-7');  

-- Evaluaciones para el alumno 3 (Ricardo Fernández)
INSERT INTO evaluaciones (nom_eva, fec_eva, not_eva, asi_eva, alu_eva) VALUES
('Evaluación 1', '2024-03-15', 6.0, 3, '25.678.901-3'),
('Evaluación 2', '2024-05-10', 4.0, 3, '25.678.901-3'),
('Evaluación 3', '2024-07-25', 5.0, 3, '25.678.901-3');  

-- Evaluaciones para el alumno 4 (Luisa Paredes)
INSERT INTO evaluaciones (nom_eva, fec_eva, not_eva, asi_eva, alu_eva) VALUES
('Evaluación 1', '2024-03-15', 7.0, 4, '18.234.567-8'),
('Evaluación 2', '2024-05-10', 6.0, 4, '18.234.567-8'),
('Evaluación 3', '2024-07-25', 6.5, 4, '18.234.567-8');   

-- Evaluaciones para el alumno 5 (Antonio Ramírez)
INSERT INTO evaluaciones (nom_eva, fec_eva, not_eva, asi_eva, alu_eva) VALUES
('Evaluación 1', '2024-03-15', 5.5, 5, '11.456.789-1'),
('Evaluación 2', '2024-05-10', 4.0, 5, '11.456.789-1'),
('Evaluación 3', '2024-07-25', 6.0, 5, '11.456.789-1');   

-- Curso 1: A1_Diurna - Asignatura Bases de Datos
INSERT INTO cursos (nom_cur, jor_cur, asi_cur, doc_cur, alu_cur) VALUES
('A1_Diurna', 'Diurna', 2, '19.876.543-2', '12.987.654-0'),
('A1_Diurna', 'Diurna', 2, '19.876.543-2', '19.123.456-7'),
('A1_Diurna', 'Diurna', 2, '19.876.543-2', '25.678.901-3');

-- Curso 2: A2_Vespertina - Asignatura Redes de Computadores
INSERT INTO cursos (nom_cur, jor_cur, asi_cur, doc_cur, alu_cur) VALUES
('A2_Vespertina', 'Vespertina', 3, '21.234.567-4', '18.234.567-8'),
('A2_Vespertina', 'Vespertina', 3, '21.234.567-4', '25.678.901-3'),
('A2_Vespertina', 'Vespertina', 3, '21.234.567-4', '19.123.456-7');

-- Curso 3: A3_Diurna - Asignatura Programación Avanzada
INSERT INTO cursos (nom_cur, jor_cur, asi_cur, doc_cur, alu_cur) VALUES
('A3_Diurna', 'Diurna', 4, '22.345.678-5', '12.987.654-0'),
('A3_Diurna', 'Diurna', 4, '22.345.678-5', '19.123.456-7'),
('A3_Diurna', 'Diurna', 4, '22.345.678-5', '25.678.901-3');

-- Curso 4: A4_Vespertina - Asignatura Desarrollo de Aplicaciones Web
INSERT INTO cursos (nom_cur, jor_cur, asi_cur, doc_cur, alu_cur) VALUES
('A4_Vespertina', 'Vespertina', 5, '23.456.789-6', '18.234.567-8'),
('A4_Vespertina', 'Vespertina', 5, '23.456.789-6', '25.678.901-3'),
('A4_Vespertina', 'Vespertina', 5, '23.456.789-6', '12.987.654-0');

-- Curso 5: A5_Diurna - Asignatura Algoritmos y Estructuras de Datos
INSERT INTO cursos (nom_cur, jor_cur, asi_cur, doc_cur, alu_cur) VALUES
('A5_Diurna', 'Diurna', 1, '19.876.543-2', '12.987.654-0'),
('A5_Diurna', 'Diurna', 1, '19.876.543-2', '18.234.567-8'),
('A5_Diurna', 'Diurna', 1, '19.876.543-2', '25.678.901-3');








    