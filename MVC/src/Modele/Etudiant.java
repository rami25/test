package Modele;

public class Etudiant {
    private int id;
    private String nom , prenom;
    public Etudiant(int id, String nom , String prenom){
        this.id = id;
        this.nom = nom;
        this. prenom = prenom;
    }
    public Etudiant(int id){
        this.id = id;
    }
    public Etudiant(){}

    public void setId(int id) {
        this.id = id;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public int getId() {
        return id;
    }

    public String getNom() {
        return nom;
    }

    public String getPrenom() {
        return prenom;
    }
}
