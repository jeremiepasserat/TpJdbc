package fr.univ_amu.iut;

import fr.univ_amu.iut.beans.ConnexionUnique;
import fr.univ_amu.iut.beans.Etudiant;
import fr.univ_amu.iut.beans.Module;
import fr.univ_amu.iut.beans.Prof;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import static fr.univ_amu.iut.TestJDBC.CONNECT_URL;

/**
 * Created by p16016063 on 26/09/17.
 */
public class TestAsso1 {
    // La requete de test
    static final String req = "SELECT NUM_PROF, NOM_PROF, PRENOM_PROF, MAT_SPEC " +
            "FROM PROF, MODULE "; //+
    //"WHERE VILLE_ET = 'AIX-EN-PROVENCE'";

    public static void main(String[] args) throws SQLException {
        // Connexion a la base
        System.out.println("Connexion a " + CONNECT_URL);
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);
            // Affichage du resultat
            ArrayList<Prof> profs = new ArrayList<Prof>();

            while (rset.next()){
                Module module = new Module();
                Prof prof = new Prof();
                module.setCode(rset.getString("MAT_SPEC")); //selectionne la spécialité
                prof.setMatSpec(module);
                prof.setNumProf(rset.getInt("NUM_PROF"));
                prof.setNomProf(rset.getString("NOM_PROF"));
                prof.setPrenomProf(rset.getString("PRENOM_PROF"));
                profs.add(prof);
            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            System.out.println(profs);
            System.out.println("\nOk.\n");
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
    }
}
