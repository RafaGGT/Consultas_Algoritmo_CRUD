SELECT
    car.nom_car AS carrera,
    car.dur_car AS semestres,
    COUNT(asi.id_asi) AS conteo_asignaturas
FROM
    carreras car
        LEFT JOIN
    asignaturas asi ON car.id_car = asi.car_asi
WHERE
    car.tip_car = 'Profesional'
GROUP BY
    car.nom_car, car.dur_car
ORDER BY
    car.nom_car;
