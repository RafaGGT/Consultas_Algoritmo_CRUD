SELECT
    cur.nom_cur AS cursos,
    asi.nom_asi AS asignatura,
    CONCAT(doc.nom_doc, ' ', doc.ape_doc) AS docente,
    COUNT(alu.run_alu) AS conteo_alumnos
FROM
    cursos cur
        JOIN
    asignaturas asi ON cur.asi_cur = asi.id_asi
        JOIN
    docentes doc ON cur.doc_cur = doc.run_doc
        LEFT JOIN
    alumnos alu ON cur.alu_cur = alu.run_alu
GROUP BY
    cur.nom_cur, asi.nom_asi, docente
ORDER BY
    cur.nom_cur;
