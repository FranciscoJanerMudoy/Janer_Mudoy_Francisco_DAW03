package servlets;

import connection.Connexio;

import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

@WebServlet("/formulari")
public class Formulari extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws  IOException {
        try {
            String nom = request.getParameter("nom");
            String descripcio = request.getParameter("descripcio");
            String preu = request.getParameter("preu");
            String categoria = request.getParameter("categoria");

            try (Connection conexion = Connexio.connection()) {
                String sql = "INSERT INTO la_meva_botiga.productes (nom, descripcio, preu, categoria_id) VALUES (?,?, ?, ?)";
                try (PreparedStatement pstmt = conexion.prepareStatement(sql)) {
                    pstmt.setString(1, nom);
                    pstmt.setString(2, descripcio);
                    pstmt.setDouble(3, Double.parseDouble(preu));
                    pstmt.setInt(4, Integer.parseInt(categoria));
                    pstmt.executeUpdate();
                }
            }
            response.sendRedirect("insercio");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
