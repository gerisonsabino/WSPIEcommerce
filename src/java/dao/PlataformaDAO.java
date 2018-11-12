package dao;

import classes.Plataforma;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class PlataformaDAO 
{
    public Plataforma selectPlataformaByID(int id)
    {
        Plataforma p = null;
        
        try 
        {
            Connection con = Conexao.getConnection();
            
            String sql = "SELECT * FROM game_plataforma WHERE ID=?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) 
            {
                p = new Plataforma();
                
                p.setId(rs.getInt("ID"));
                p.setNome(rs.getString("Nome"));

                return p;
            }

            rs.close();
            ps.close();
            con.close();            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return p;
    }
    
    public ArrayList<Plataforma> selectPlataformas()
    {
        ArrayList<Plataforma> plataformas = new ArrayList<Plataforma>();
        
        try 
        {
            Connection con = Conexao.getConnection();
            
            String sql = "SELECT * FROM game_plataforma";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery(sql);
            
            while (rs.next()) 
            {
                Plataforma plataforma = new Plataforma();
                
                plataforma.setId(rs.getInt("ID"));
                plataforma.setNome(rs.getString("Nome"));

                plataformas.add(plataforma);
            }
            
            rs.close();
            ps.close();
            con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return plataformas;
    }
}