package servlets;

import connection.Connexio;
import model.Producte;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@WebServlet("/insercio")
public class Insercio extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            List<Producte> productes = getProductes();

            request.setAttribute("productes", productes);

            RequestDispatcher dispatcher = request.getRequestDispatcher("botiga.jsp");

            dispatcher.forward(request, response);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    private List<Producte> getProductes() throws SQLException {
        List<Producte> productes = new ArrayList<>();
        try (Connection connexio = Connexio.connection()) {
            String sql = "SELECT * FROM la_meva_botiga.productes";
            try (PreparedStatement pstmt = connexio.prepareStatement(sql)) {
                try (ResultSet rs = pstmt.executeQuery()) {
                    while (rs.next()) {
                        productes.add(new Producte(rs.getString("nom"), rs.getString("descripcio"), rs.getDouble("preu"), rs.getInt("categoria_id")));
                    }
                }
            }
        }
        return productes;
    }
}
