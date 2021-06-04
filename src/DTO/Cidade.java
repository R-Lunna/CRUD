
package DTO;

import banco.ConnectionDataBase;
import crud.Insert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cidade extends Table
{
    private int codCid = -1;
    private int lastID = -1;
    private String nome;
    private int codEst;
    private Connection connection = ConnectionDataBase.getConnection();

    public int getCodCid()
    {
        return codCid;
    }

    public void setCodCid(int codCid)
    {
        if( lastID != this.codCid )
            lastID = this.codCid;
        this.codCid = codCid;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getCodEst()
    {
        return codEst;
    }

    public void setCodEst(int codEst)
    {
        this.codEst = codEst;
    }
    
    @Override
    public void insert()
    {
         try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO cidade(codcid, nome, codest) VALUES (?, ?, ?);"))
        {
            preparedStatement.setInt(1, codCid);
            preparedStatement.setString(2, nome);
            preparedStatement.setInt(3, codEst);
            preparedStatement.execute();
        } catch (SQLException ex) 
        {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update()
    {
            try(PreparedStatement preparedStatement = connection.prepareStatement("UPDATE cidade set codcid = ?, nome = ?, codest = ? WHERE codcid = ?"))
        {
            preparedStatement.setInt(1, codCid);           
            preparedStatement.setString(2, nome);
            preparedStatement.setInt(3, codEst);
            
             if( lastID == -1 )
                preparedStatement.setInt(4, codCid);
            else
                preparedStatement.setInt(4, lastID);
             
            preparedStatement.execute();
        } catch (SQLException ex) 
        {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete()
    {
        try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM cidade WHERE codcid = ?;"))
        {
            preparedStatement.setInt(1, codCid);
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
