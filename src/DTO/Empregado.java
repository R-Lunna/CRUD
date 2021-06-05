package DTO;

import crud.Insert;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import banco.ConnectionDataBase;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;


public class Empregado extends Table
{
    private int codEmp = -1;
    private String nome;
    private int codProf;
    
    private int lastID = -1;
    
    private Connection connection = ConnectionDataBase.getConnection();

    public Empregado()
    {
    }

    public Empregado(int id, String nome, int codProf)
    {
        this.codEmp = id;
        this.lastID = id;
        this.nome = nome;
        this.codProf = codProf;
    }
    
    public int getCodEmp()
    {
        return codEmp;
    }

    public void setCodEmp( int codEmp )
    {
        if( lastID != this.codEmp )
            lastID = this.codEmp;
        this.codEmp = codEmp;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getCodProf()
    {
        return codProf;
    }

    public void setCodProf(int codProf)
    {
        this.codProf = codProf;
    }

    @Override
    public void insert()
    {
        try(PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO empregado(codemp, nome, codprof) VALUES (?, ?, ?);"))
        {
            preparedStatement.setInt(1, codEmp);
            preparedStatement.setString(2, nome);
            preparedStatement.setInt(3, codProf);
            preparedStatement.execute();
        } catch (SQLException ex) 
        {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void update()
    {
        try(PreparedStatement preparedStatement = connection.prepareStatement("UPDATE empregado set codemp = ?, nome = ?, codprof = ? WHERE codemp = ?"))
        {
            preparedStatement.setInt(1, codEmp);           
            preparedStatement.setString(2, nome);
            preparedStatement.setInt(3, codProf);
            
             if( lastID == -1 )
                preparedStatement.setInt(4, codEmp);
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
        try(PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM empregado WHERE codemp = ?;"))
        {
            preparedStatement.setInt(1, codEmp);
            preparedStatement.execute();
        } catch (SQLException ex) 
        {
            Logger.getLogger(Insert.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public List<Empregado> read()
    {
        ArrayList<Empregado> list = new ArrayList<>();
        
        try( PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM empregado;") )
        {
            preparedStatement.execute();
            
            ResultSet resultSet = preparedStatement.getResultSet();
            
            while( resultSet.next() )
            {
                Empregado empregado = new Empregado();
                
                empregado.setCodEmp( resultSet.getInt("codemp"));
                empregado.setCodProf( resultSet.getInt("codprof"));
                empregado.setNome( resultSet.getString("nome"));
                
                list.add(empregado);
            }
            
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao criar lista: " + e.getMessage());
        }
        
        return list;
    }
    
}
