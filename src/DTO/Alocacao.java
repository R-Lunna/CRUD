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

public class Alocacao extends Table
{
    private int codEmp = -1;
    private int lastID = -1;
    private String codProj = "";
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
            JOptionPane.showMessageDialog( new JFrameRoot().getFrame() ,"Error processing query", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public void update()
    {
        try(PreparedStatement preparedStatement = connection.prepareStatement("UPDATE alocacao set codemp = ?, codproj = ?, qtdhoras = ? WHERE codemp = ? AND codproj = ?"))
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
            JOptionPane.showMessageDialog( new JFrameRoot().getFrame() ,"Error processing query", "Error", JOptionPane.ERROR_MESSAGE);
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
            JOptionPane.showMessageDialog( new JFrameRoot().getFrame() ,"Error processing query", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    @Override
    public List<Alocacao> read()
    {
        ArrayList<Alocacao> list = new ArrayList<>();
        
        try( PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM alocacao;") )
        {
            preparedStatement.execute();
            
            ResultSet resultSet = preparedStatement.getResultSet();
            
            while( resultSet.next() )
            {
                Alocacao alocacao = new Alocacao();
                
                alocacao.setCodEmp( resultSet.getInt("codemp"));
                alocacao.setCodProj( resultSet.getString("codproj"));
                alocacao.setQtdHoras( resultSet.getInt("qtdhoras"));
                
                list.add(alocacao);
            }
            
        }
        catch (SQLException e)
        {
            System.err.println("Erro ao criar lista: " + e.getMessage());
        }
        
        return list;
    }
    
}
