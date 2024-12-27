SELECT
    alu.run_alu,
    alu.nom_alu,
    alu.ape_alu,
    car.nom_car AS carrera,
    ROUND(AVG(eva.not_eva), 2) AS promedio_evaluaciones
FROM
    alumnos alu
        JOIN
    carreras car ON alu.car_alu = car.id_car
        LEFT JOIN
    evaluaciones eva ON alu.run_alu = eva.alu_eva
GROUP BY
    alu.run_alu, alu.nom_alu, alu.ape_alu, car.nom_car
ORDER BY
    promedio_evaluaciones ASC;