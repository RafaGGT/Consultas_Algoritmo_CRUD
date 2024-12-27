SELECT
    a.nom_asi AS asignatura,
    al.nom_alu AS alumno,
    al.ape_alu AS apellido_alumno,
    ROUND(AVG(e.not_eva), 1) AS promedio
FROM
    evaluaciones e
        INNER JOIN
    alumnos al ON e.alu_eva = al.run_alu
        INNER JOIN
    asignaturas a ON e.asi_eva = a.id_asi
GROUP BY
    a.nom_asi, al.nom_alu, al.ape_alu
ORDER BY
    promedio DESC
    LIMIT 3;
