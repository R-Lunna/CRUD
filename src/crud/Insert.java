/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package crud;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Rafael Luna
 */
public class Insert {
    
    private static Connection database;
    private PreparedStatement stm = null;
    
    public Insert() {
        
    }
    
    public Insert(Connection database) {
        this.database = database;
    }
    
    public void InsertDataBaseEmpregado(int codemp, String nome, int codprof, String sql) {
        try {
            stm = database.prepareStatement(sql);
            stm.setInt(1, codemp);
            stm.setString(2, nome);
            stm.setInt(3, codprof);
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertDataBaseCidade(int codcid, String nome, int codest, String sql) {
        try {
            stm = database.prepareStatement(sql);
            stm.setInt(1, codcid);
            stm.setString(2, nome);
            stm.setInt(3, codest);
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertDataBaseEstado(int codest, String nome, String sql) {
        try {
            stm = database.prepareStatement(sql);
            stm.setInt(1, codest);
            stm.setString(2, nome);
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertDataBaseProjeto(String codproj, String nome, int codempresa, String sql) {
        try {
            stm = database.prepareStatement(sql);
            stm.setString(1, codproj);
            stm.setString(2, nome);
            stm.setInt(3, codempresa);
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void insertDataBaseAlocacao(int codemp, String codproj, int qtdhoras, String sql) {
        try {
            stm = database.prepareStatement(sql);
            stm.setInt(1, codemp);
            stm.setString(2, codproj);
            stm.setInt(3, qtdhoras);
            stm.execute();
            stm.close();
        } catch (SQLException ex) {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
