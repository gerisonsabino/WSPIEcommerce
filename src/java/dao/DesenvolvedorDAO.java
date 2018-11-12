package dao;

import classes.Desenvolvedor;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class DesenvolvedorDAO 
{
    public Desenvolvedor selectDesenvolvedorByID(int id)
    {
        Desenvolvedor dev = null;
        
        try 
        {
            Connection con = Conexao.getConnection();
            
            String sql = "SELECT * FROM game_desenvolvedor WHERE ID=?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) 
            {
                dev = new Desenvolvedor();
                
                dev.setId(rs.getInt("ID"));
                dev.setNome(rs.getString("Nome"));

                return dev;
            }

            rs.close();
            ps.close();
            con.close();            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return dev;
    }
    
    public ArrayList<Desenvolvedor> selectDesenvolvedores()
    {
        ArrayList<Desenvolvedor> desenvolvedores = new ArrayList<Desenvolvedor>();
        
        try 
        {
            Connection con = Conexao.getConnection();
            
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM game_desenvolvedor";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) 
            {
                Desenvolvedor dev = new Desenvolvedor();
                
                dev.setId(rs.getInt("ID"));
                dev.setNome(rs.getString("Nome"));

                desenvolvedores.add(dev);
            }
            
            rs.close();
            stmt.close();
            con.close();
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return desenvolvedores;
    }
}