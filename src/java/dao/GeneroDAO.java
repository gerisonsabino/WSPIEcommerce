package dao;

import classes.Genero;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

public class GeneroDAO 
{
    public Genero selectGeneroByID(int id)
    {
        Genero g = null;
        
        try 
        {
            Connection con = Conexao.getConnection();
            
            String sql = "SELECT * FROM game_genero WHERE ID=?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) 
            {
                g = new Genero();
                
                g.setId(rs.getInt("ID"));
                g.setDescricao(rs.getString("Descricao"));

                return g;
            }

            rs.close();
            ps.close();
            con.close();            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return g;
    }
    
    public ArrayList<Genero> selectGeneros()
    {
        ArrayList<Genero> generos = new ArrayList<Genero>();
        
        try 
        {
            Connection con = Conexao.getConnection();
            
            Statement stmt = con.createStatement();
            String sql = "SELECT * FROM game_genero";
            
            ResultSet rs = stmt.executeQuery(sql);
            
            while (rs.next()) 
            {
                Genero genero = new Genero();
                
                genero.setDescricao(rs.getString("Descricao"));
                genero.setId(rs.getInt("ID"));

                generos.add(genero);
            }
            
            rs.close();
            stmt.close();
            con.close();
            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return generos;
    }
}