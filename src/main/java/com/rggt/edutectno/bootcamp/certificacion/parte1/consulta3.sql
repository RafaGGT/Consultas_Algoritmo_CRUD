SELECT
    car.nom_car AS carrera,
    dir.nom_dir AS director_nombre,
    dir.ape_dir AS director_apellido,
    COUNT(doc.run_doc) AS cantidad_docentes
FROM
    carreras car
        JOIN
    directores dir ON car.dir_car = dir.run_dir
        LEFT JOIN
    asignaturas asi ON asi.car_asi = car.id_car
        LEFT JOIN
    docentes doc ON asi.doc_asi = doc.run_doc
GROUP BY
    car.nom_car, dir.nom_dir, dir.ape_dir;
