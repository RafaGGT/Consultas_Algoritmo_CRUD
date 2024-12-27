package com.rggt.edutectno.bootcamp.certificacion.parte2;

import java.sql.*;

public class Menu extends MenuTemplate {

    private final Connection con;

    public Menu(Connection con) {
        this.con = con;
    }

    @Override
    public void newCarrera() {
        System.out.println("--- Ingreso de Nueva Carrera ---");
        System.out.println("-------------------------------------------------");
        System.out.print("Ingrese el nombre de la nueva carrera: ");
        String NomCarr = leer.nextLine();
        System.out.print("Ingrese el tipo de la nueva carrera (TÉCNICA o PROFESIONAL): ");
        String tpCarr = leer.nextLine();
        System.out.print("Ingrese la cantidad de semestres en total que tendrá la nueva carrera: ");
        int durCarr = leer.nextInt();
        leer.nextLine();
        System.out.println("-------------------------------------------------");
        System.out.print("Ingrese el RUN del nuevo director de carrera: ");
        String runDir = leer.nextLine();
        System.out.print("Ingrese el nombre del director para esta carrera: ");
        String nomDir = leer.nextLine();
        System.out.print("Ingrese el apellido del director para esta carrera: ");
        String apeDir = leer.nextLine();
        System.out.print("Ingrese la profesión del director para esta carrera: ");
        String proDir = leer.nextLine();
        System.out.println("-------------------------------------------------");

        String insDir = "INSERT INTO directores (run_dir, nom_dir, ape_dir, pro_dir) VALUES (?, ?, ?, ?)";
        String insCarr = "INSERT INTO carreras (nom_car, tip_car, dur_car, dir_car) VALUES (?, ?, ?, ?)";
        String listarCarr = "SELECT c.nom_car, c.tip_car, c.dur_car, d.nom_dir, d.ape_dir, d.pro_dir " +
                "FROM carreras c INNER JOIN directores d ON c.dir_car = d.run_dir";

        try (
                PreparedStatement stmt1 = con.prepareStatement(insDir);
                PreparedStatement stmt2 = con.prepareStatement(insCarr);
                Statement stmt3 = con.createStatement();
                ResultSet rs = stmt3.executeQuery(listarCarr)
        ) {
            stmt1.setString(1, runDir);
            stmt1.setString(2, nomDir);
            stmt1.setString(3, apeDir);
            stmt1.setString(4, proDir);
            stmt1.executeUpdate();

            stmt2.setString(1, NomCarr);
            stmt2.setString(2, tpCarr);
            stmt2.setInt(3, durCarr);
            stmt2.setString(4, runDir);
            stmt2.executeUpdate();

            System.out.println("¡Carrera creada con éxito! A continuación se mostrará un listado de todas las carreras junto a sus directores de carrera:");
            while (rs.next()) {
                System.out.println("- " + rs.getString("nom_car") + " (" + rs.getString("tip_car") + ", " + rs.getInt("dur_car") + " semestres): Dirigida por " + rs.getString("nom_dir") + " " + rs.getString("ape_dir") + " (" + rs.getString("pro_dir") + ")");
            }
        } catch (SQLException e) {
            System.out.println("Error al realizar la solicitud: " + e.getMessage());
        }
    }

    @Override
    public void totalAlumno() {
        System.out.println("--- Conteo Total de Alumnos y por Carrera ---");

        String totalAl = "SELECT COUNT(*) AS total_alumnos FROM alumnos";
        String totalPorCar = "SELECT c.nom_car, COUNT(a.run_alu) AS total_alumnos " +
                "FROM carreras c " +
                "LEFT JOIN alumnos a ON c.id_car = a.car_alu " +
                "GROUP BY c.nom_car";

        try (Statement stmt = con.createStatement()) {
            try (ResultSet rs = stmt.executeQuery(totalAl)) {
                if (rs.next()) {
                    System.out.println("Total de alumnos: " + rs.getInt("total_alumnos"));
                }
            }

            try (ResultSet rs = stmt.executeQuery(totalPorCar)) {
                System.out.println("\nCantidad de alumnos por carrera:");
                while (rs.next()) {
                    System.out.println("- " + rs.getString("nom_car") + ": " + rs.getInt("total_alumnos") + " alumnos");
                }
            }
        } catch (SQLException e) {
            System.out.println("Error al ejecutar la consulta: " + e.getMessage());
        }
    }
}
