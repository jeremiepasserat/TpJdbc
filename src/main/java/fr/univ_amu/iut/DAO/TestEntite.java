package fr.univ_amu.iut;// Ne pas faire un copier/coller du pdf...

// Importer les classes jdbc
import fr.univ_amu.iut.beans.ConnexionUnique;
import fr.univ_amu.iut.beans.Etudiant;

import java.nio.channels.ClosedChannelException;
import java.sql.*;
import java.util.ArrayList;

public class TestEntite {
    ConnexionUnique connectionunique = new ConnexionUnique ();
    // Chaine de connexion
    static final String CONNECT_URL = "jdbc:mysql://mysql-jeremiepasserat.alwaysdata.net:3306/jeremiepasserat_bdd";
    static final String LOGIN = "144397_user";
    static final String PASSWORD = "123";
    // La requete de test
    static final String req = "SELECT NUM_ET, NOM_ET, PRENOM_ET " +
            "FROM ETUDIANT " +
            "WHERE VILLE_ET = 'AIX-EN-PROVENCE'";

    public static void main(String[] args) throws SQLException {
        // Connexion a la base
        System.out.println("Connexion a " + CONNECT_URL);
        try (Connection conn = DriverManager.getConnection(CONNECT_URL,LOGIN,PASSWORD)){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat

            ArrayList<Etudiant> etudiants = new ArrayList<>();

            while (rset.next()){
                Etudiant etudiant = new Etudiant();

                etudiant.setAnnee(rset.getInt("ANNEE"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setGroupe(rset.getInt("GROUPE"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiant.setVilleEt(rset.getString("VILLE_ET"));
                etudiants.add(etudiant);
                etudiants.toString();
                /*System.out.print(rset.getInt("NUM_ET") + " ");
                System.out.print(rset.getString("NOM_ET") + " ");
                System.out.println(rset.getString("PRENOM_ET"));*/
            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }
}
