package Vue;

import Modele.Etudiant;
import Control.EtudiantC;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Window extends JFrame implements ActionListener {

    public Window(){
        setTitle("Gestion des etudiants");
        setSize(600,200);
        setLocationRelativeTo(null);
        contenu = getContentPane();
        contenu.setLayout(new FlowLayout());
        ajouter = new JButton("Ajouter");
        chercher = new JButton("Chercher");
        modifier = new JButton("Modifier");
        supprimer = new JButton("Supprimer");

        ajouter.addActionListener(this);
        chercher.addActionListener(this);
        modifier.addActionListener(this);
        supprimer.addActionListener(this);

        id = new JLabel("Identifiant :");
        contenu.add(id);
        tid = new JTextField(10);
        contenu.add(tid);

        nom = new JLabel("Nom :");
        contenu.add(nom);
        tnom = new JTextField(30);
        contenu.add(tnom);

        prenom = new JLabel("Prenom :");
        contenu.add(prenom);
        tprenom = new JTextField(30);
        contenu.add(tprenom);

        contenu.add(ajouter);
        contenu.add(chercher);
        contenu.add(modifier);
        contenu.add(supprimer);

    }
    public void actionPerformed(ActionEvent ev){
        Etudiant et = new Etudiant();
        EtudiantC ec = new EtudiantC();
        try{ 
            int n = Integer.parseInt(tid.getText());
            et.setId(n);
        }catch(NumberFormatException ex) {
            JOptionPane.showMessageDialog(null,"Id must be a number","Erreur",JOptionPane.ERROR_MESSAGE);
        }
        et.setNom(tnom.getText());
        et.setPrenom(tprenom.getText());
        Object source = ev.getSource();
        if(source == ajouter)
            ec.ajouterEtudiant(et);
        if(source == chercher) {
           ec.chercherEtudiant(et);
        }
        if(source == modifier)
            ec.updateEtudiant(et);
        if(source == supprimer)
            ec.deleteEtudiant(et);
    }
    private Container contenu;
    private JLabel id , nom , prenom;
    private JTextField tid , tnom , tprenom;
    private JButton ajouter , chercher , modifier , supprimer;
}
