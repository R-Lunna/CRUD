
package DTO;

import banco.ConnectionDataBase;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;
import view.JFrameRoot;

public class Projeto extends Table
{
    private String codProj = "";
    private String lastID = "";
    private String nome;
    private int codeEmp;

    private Connection connection = ConnectionDataBase.getConnection();
    
    public Projeto()
    {
    }

    public Projeto(String codProj, String nome, int codeEmp)
    {
        this.codProj = codProj;
        this.lastID = codProj;
        this.nome = nome;
        this.codeEmp = codeEmp;
    }

    public String getCodProj()
    {
        return codProj;
    }

    public void setCodProj(String codProj)
    {
        if( !lastID.equals(this.codProj) )
           lastID = this.codProj;
        this.codProj = codProj;
    }

    public String getNome()
    {
        return nome;
    }

    public void setNome(String nome)
    {
        this.nome = nome;
    }

    public int getCodeEmp()
    {
        return codeEmp;
    }

    public void setCodeEmp(int codeEmp)
    {
        this.codeEmp = codeEmp;
    }
    
    @Override
    public void insert()
    {
        try( PreparedStatement preparedStatement = connection.prepareStatement("INSERT INTO projeto(codproj, nome, codempresa) VALUES (?, ?, ?);"))
        {
            preparedStatement.setString(1, codProj);
            preparedStatement.setString(2, nome);
            preparedStatement.setInt(3, codeEmp);
            preparedStatement.execute();
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog( new JFrameRoot().getFrame() ,"Error processing query", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update()
    {
        try( PreparedStatement preparedStatement = connection.prepareStatement("UPDATE projeto set codproj = ?, nome = ?, codeempresa = ? WHERE codproj = ?"))
        {
            preparedStatement.setString(1, codProj);           
            preparedStatement.setString(2, nome);
            preparedStatement.setInt(3, codeEmp);
            
             if( lastID.equals("") )
                preparedStatement.setString(4, codProj);
            else
                preparedStatement.setString(4, lastID);
             
            preparedStatement.execute();
        } catch (SQLException ex) 
        {
           JOptionPane.showMessageDialog( new JFrameRoot().getFrame() ,"Error processing query", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void delete()
    {
        try( PreparedStatement preparedStatement = connection.prepareStatement("DELETE FROM projeto WHERE codproj = ?;"))
        {
            preparedStatement.setString(1, codProj);
            preparedStatement.execute();
        } catch (SQLException ex) 
        {
            JOptionPane.showMessageDialog( new JFrameRoot().getFrame() ,"Error processing query", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public List<Projeto> read()
    {
        ArrayList<Projeto> list = new ArrayList<>();
        
        try( PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM projeto;") )
        {
            preparedStatement.execute();
            
            ResultSet resultSet = preparedStatement.getResultSet();
            
            while( resultSet.next() )
            {
                Projeto projeto = new Projeto();
                
                projeto.setCodProj(resultSet.getString("codproj"));
                projeto.setCodeEmp(resultSet.getInt("codeempresa"));
                projeto.setNome( resultSet.getString("nome"));
                
                list.add(projeto);
            }
            
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao criar lista: " + e.getMessage());
        }
        
        return list;
    }
    
}
