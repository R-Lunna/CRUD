package DTO;

import banco.ConnectionDataBase;
import crud.Insert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Alocacao extends Table
{
    private int codEmp = -1;
    private int lastID = -1;
    private String codProj;
    private String lastID2 = "";
    private int qtdHoras;

    private Connection connection = ConnectionDataBase.getConnection();

    public Alocacao()
    {
    }

    public Alocacao( int codEmp, String codProj, int qtdHoras)
    {
        this.codEmp = codEmp;
        this.lastID = codEmp;
        this.codProj = codProj;
        this.lastID2 = codProj;
        this.qtdHoras = qtdHoras;
    }

    public int getCodEmp()
    {
        return codEmp;
    }

    public void setCodEmp(int codEmp)
    {
        if( lastID != this.codEmp )
            lastID = this.codEmp;
        this.codEmp = codEmp;
    }

    public String getCodProj()
    {
        return codProj;
    }

    public void setCodProj(String codProj)
    {
        if( !lastID2.equals(codProj) )
            lastID2 = this.codProj;
        this.codProj = codProj;
    }

    public int getQtdHoras()
    {
        return qtdHoras;
    }

    public void setQtdHoras(int qtdHoras)
    {
        this.qtdHoras = qtdHoras;
    }

    
    @Override
    public void insert()
    {
        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO alocacao(codemp, codproj, qtdhoras) VALUES (?, ?, ?);"))
        {
            preparedStatement.setInt(1, codEmp);
            preparedStatement.setString(2, codProj);
            preparedStatement.setInt(3, qtdHoras);
            preparedStatement.execute();
        } catch (SQLException ex) 
        {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update()
    {
        try(PreparedStatement preparedStatement = connection.prepareStatement("UPDATE alocacao set codemp = ?, codproj = ?, qtdhoras = ? WHERE codemp = ? AND qtdhoras = ?"))
        {
            preparedStatement.setInt(1, codEmp);           
            preparedStatement.setString(2, codProj);
            preparedStatement.setInt(3, qtdHoras);
            
             if( lastID == -1 && lastID2.equals("") )
             {
                 preparedStatement.setInt(4, codEmp);
                 preparedStatement.setString(5, codProj);
             }
                
            else
             {
                 preparedStatement.setInt(4, lastID);
                 preparedStatement.setString(5, lastID2);
             }
                
             
            preparedStatement.execute();
        } catch (SQLException ex) 
        {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete()
    {
        try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM alocacao WHERE codemp = ? AND codproj = ?;"))
        {
            preparedStatement.setInt(1, codEmp);
            preparedStatement.setString(2, codProj);
            preparedStatement.execute();
        } catch (SQLException ex) 
        {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void read()
    {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
