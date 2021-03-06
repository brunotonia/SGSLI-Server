/*
 * Copyright (C) 2016 Bruno Roberto Vasconcelos Tonia
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.com.brunotonia.DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexoes {

    private final String driver = "org.postgresql.Driver";
    private final String url = "jdbc:postgresql://127.0.0.1:5432/sgsli";
    private final String usuario = "bruno";
    private final String password = "angra1";

    public Connection getConexao() throws Exception {
        try {
            Class.forName(driver);
            return DriverManager.getConnection(url, usuario, password);
        } catch (SQLException e) {
            e.printStackTrace();
            //throw new RuntimeException(e);
            return null;
        }

    }

}
