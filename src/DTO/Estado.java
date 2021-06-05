
package DTO;

import banco.ConnectionDataBase;
import crud.Insert;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Estado extends Table
{
    private int codEst = -1;
    private int lastID = -1;
    private String nome;

    private Connection connection = ConnectionDataBase.getConnection();
    
    public Estado()
    {
    }

    public Estado( int codEst, String nome)
    {
        this.codEst = codEst;
        this.lastID = codEst;
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

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }
    
    @Override
    public void insert()
    {
        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO estado(codest, nome ) VALUES (?, ?);"))
        {
            preparedStatement.setInt(1, codEst);
            preparedStatement.setString(2, nome);
            preparedStatement.execute();
        } catch (SQLException ex) 
        {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update()
    {
        try( PreparedStatement preparedStatement = connection.prepareStatement("UPDATE estado set codest = ?, nome = ? WHERE codest = ?"))
        {
            preparedStatement.setInt(1, codEst);           
            preparedStatement.setString(2, nome);
            
             if( lastID == -1 )
                preparedStatement.setInt(3, codEst);
            else
                preparedStatement.setInt(3, lastID);
             
            preparedStatement.execute();
        } catch (SQLException ex) 
        {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void delete()
    {
        try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM empregado WHERE codest = ?;"))
        {
            preparedStatement.setInt(1, codEst);
            preparedStatement.execute();
        } catch (SQLException ex) 
        {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Estado> read()
    {
        ArrayList<Estado> list = new ArrayList<>();
        
        try( PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM estado;") )
        {
            preparedStatement.execute();
            
            ResultSet resultSet = preparedStatement.getResultSet();
            
            while( resultSet.next() )
            {
                Estado estado = new Estado();
                
                estado.setCodEst(resultSet.getInt("codest"));
                estado.setNome(resultSet.getString("nome"));
                
                list.add(estado);
            }
            
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao criar lista: " + e.getMessage());
        }
        
        return list;
    }
}
