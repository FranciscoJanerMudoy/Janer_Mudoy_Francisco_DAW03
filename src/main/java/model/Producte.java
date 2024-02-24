package model;

public class Producte {
    private String nom;
    private String descripcio;
    private double preu;
    private int categoria;

    public Producte(String nom, String descripcio, double preu, int categoria) {
        this.nom = nom;
        this.descripcio = descripcio;
        this.preu = preu;
        this.categoria = categoria;
    }

    public String getNom() {
        return nom;
    }

    public String getDescripcio() {
        return descripcio;
    }

    public double getPreu() {
        return preu;
    }

    public int getCategoria() {
        return categoria;
    }
}
