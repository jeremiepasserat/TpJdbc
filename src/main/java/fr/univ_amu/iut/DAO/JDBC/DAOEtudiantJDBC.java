package fr.univ_amu.iut.DAO.JDBC;

import fr.univ_amu.iut.DAO.DAOEtudiant;
import fr.univ_amu.iut.beans.ConnexionUnique;
import fr.univ_amu.iut.beans.Etudiant;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;



public class DAOEtudiantJDBC implements DAOEtudiant {
    @Override
    public int computeNbEtudiant() {
        return 0;
    }

    @Override

    public List<Etudiant> findByAnnee(int annee) {
        final String req = "SELECT NUM_ET, NOM_ET, PRENOM_ET " +
                "FROM ETUDIANT "+
                "WHERE ANNEE =" + annee ;

        List<Etudiant> etudiants = new ArrayList<>();

        // Connexion a la base
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);

            // Recherche des resultats attendus liés à la requete req
            while (rset.next()){
                Etudiant etu = new Etudiant();
                etu.setNomEt(rset.getString("NOM_ET"));
                etu.setPrenomEt(rset.getString("PRENOM_ET"));
                etu.setNumEt(rset.getInt("NUM_ET"));
                etudiants.add(etu);

            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return etudiants;
    }

    @Override
    public List<Etudiant> findByGroupe(int groupe) {
        final String req = "SELECT NUM_ET, NOM_ET, PRENOM_ET " +
                "FROM ETUDIANT "+
                "WHERE GROUPE =" + groupe ;

        List<Etudiant> etudiants = new ArrayList<>();

        // Connexion a la base
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);

            // Recherche des resultats attendus liés à la requete req
            while (rset.next()){
                Etudiant etu = new Etudiant();
                etu.setNomEt(rset.getString("NOM_ET"));
                etu.setPrenomEt(rset.getString("PRENOM_ET"));
                etu.setNumEt(rset.getInt("NUM_ET"));
                etudiants.add(etu);

            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return etudiants;

    }

    @Override
    public List<Etudiant> findByNom(String nomEt) {
        final String req = "SELECT NUM_ET, NOM_ET, PRENOM_ET " +
                "FROM ETUDIANT "+
                "WHERE NOM_ET =" + nomEt ;

        List<Etudiant> etudiants = new ArrayList<>();

        // Connexion a la base
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);

            // Recherche des resultats attendus liés à la requete req
            while (rset.next()){
                Etudiant etu = new Etudiant();
                etu.setNomEt(rset.getString("NOM_ET"));
                etu.setPrenomEt(rset.getString("PRENOM_ET"));
                etu.setNumEt(rset.getInt("NUM_ET"));
                etudiants.add(etu);

            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return etudiants;

    }

    @Override
    public boolean delete(Etudiant obj) {

        final String req = "DELETE * " +
                "FROM ETUDIANT"+
                "WHERE NUM_ET=" + obj.getNumEt();

        // Connexion a la base
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);


            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return false;

    }

    @Override
    public List<Etudiant> FindAll() {
        final String req = "SELECT * " +
                "FROM ETUDIANT ";

        List<Etudiant> etudiants = new ArrayList<>();

        // Connexion a la base
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);

            // Recherche des resultats attendus liés à la requete req
            while (rset.next()){
                Etudiant etu = new Etudiant();
                etu.setNomEt(rset.getString("NOM_ET"));
                etu.setPrenomEt(rset.getString("PRENOM_ET"));
                etu.setNumEt(rset.getInt("NUM_ET"));
                etudiants.add(etu);

            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return etudiants;

    }

    @Override
    public Etudiant getById(int id) {

        final String req = "SELECT NUM_ET, NOM_ET, PRENOM_ET " +
                "FROM ETUDIANT "+
                "WHERE NUM_ET =" + id ;

        Etudiant etu = new Etudiant();

        // Connexion a la base
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);

            // Recherche des resultats attendus liés à la requete req
            while (rset.next()){
                etu.setNomEt(rset.getString("NOM_ET"));
                etu.setPrenomEt(rset.getString("PRENOM_ET"));
                etu.setNumEt(rset.getInt("NUM_ET"));

            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return etu;
        ;
    }

    @Override
    public Etudiant insert(Etudiant obj) {

        final String req = "INSERT * " +
                "FROM ETUDIANT";
        Etudiant etudiant = new Etudiant();


        // Connexion a la base
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);

            while (rset.next()){
                etudiant.setAnnee(rset.getInt("ANNEE"));
                etudiant.setCpEt(rset.getString("CP_ET"));
                etudiant.setGroupe(rset.getInt("GROUPE"));
                etudiant.setNomEt(rset.getString("NOM_ET"));
                etudiant.setNumEt(rset.getInt("NUM_ET"));
                etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
                etudiant.setVilleEt(rset.getString("VILLE_ET"));
            }

            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();

        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return etudiant ;

    }


    @Override
    public boolean update(Etudiant obj) {
        final String req = "UPDATE * " +
                "FROM ETUDIANT "+
                "WHERE NUM_ET =" + obj.getNumEt() ;

            Etudiant etudiant=new Etudiant();
        // Connexion a la base
        try (Connection conn = ConnexionUnique.getInstance().getConnection()){
            System.out.println("Connecte\n");
            // Creation d'une instruction SQL
            Statement stmt = conn.createStatement();
            // Execution de la requete
            System.out.println("Execution de la requete : " + req );
            ResultSet rset = stmt.executeQuery(req);

            // Recherche des resultats attendus liés à la requete req
            while (rset.next()){

            }
            etudiant.setAnnee(rset.getInt("ANNEE"));
            etudiant.setCpEt(rset.getString("CP_ET"));
            etudiant.setGroupe(rset.getInt("GROUPE"));
            etudiant.setNomEt(rset.getString("NOM_ET"));
            etudiant.setNumEt(rset.getInt("NUM_ET"));
            etudiant.setPrenomEt(rset.getString("PRENOM_ET"));
            etudiant.setVilleEt(rset.getString("VILLE_ET"));

            }
            // Fermeture de l'instruction (liberation des ressources)
            stmt.close();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();// Arggg!!!
            System.out.println(e.getMessage() + "\n");
        }
        return false;

}
