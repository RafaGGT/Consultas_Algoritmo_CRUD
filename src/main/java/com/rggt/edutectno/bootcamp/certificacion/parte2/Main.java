package com.rggt.edutectno.bootcamp.certificacion.parte2;

import java.sql.Connection;

public class Main {
    public static void main(String[] args) {
        try (Connection con = ConexDB.getInstance()) {

            if (con == null || con.isClosed()) {
                System.out.println("Error: No se pudo establecer la conexión.");
                return;
            }
            Menu menu = new Menu(con);
            menu.algorit();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    }
