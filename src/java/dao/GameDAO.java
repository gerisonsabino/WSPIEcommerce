package dao;

import classes.Desenvolvedor;
import classes.Game;
import classes.Genero;
import classes.Plataforma;
import com.google.gson.Gson;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

public class GameDAO 
{
    public Game selectGameByID(int id)
    {
        Game game = null;
        
        try 
        {
            Connection con = Conexao.getConnection();
            
            String sql = "SELECT * FROM game WHERE ID=?;";
            
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setInt(1, id);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) 
            {
                game = new Game();
                
                game.setDescricao(rs.getString("Descricao"));
                game.setId(rs.getInt("ID"));
                game.setIdDesenvolvedor(rs.getInt("IDDesenvolvedor"));
                game.setIdGenero(rs.getInt("IDGenero"));
                game.setIdPlataforma(rs.getInt("IDPlataforma"));
                game.setImagemUrl(rs.getString("ImagemURL"));
                game.setLancamento(rs.getDate("Lancamento"));
                game.setPreco(rs.getDouble("Preco"));
                game.setTitulo(rs.getString("Titulo"));
            }

            rs.close();
            ps.close();
            con.close();            
            
            game.setDesenvolvedor(new DesenvolvedorDAO().selectDesenvolvedorByID(game.getIdDesenvolvedor()));
            game.setGenero(new GeneroDAO().selectGeneroByID(game.getIdGenero()));
            game.setPlataforma(new PlataformaDAO().selectPlataformaByID(game.getIdPlataforma()));
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return game;
    }
    
    public ArrayList<Game> selectGames()
    {
        ArrayList<Game> games = new ArrayList<Game>();
        ArrayList<Desenvolvedor> desenvolvedores = new DesenvolvedorDAO().selectDesenvolvedores();
        ArrayList<Genero> generos = new GeneroDAO().selectGeneros();
        ArrayList<Plataforma> plataformas = new PlataformaDAO().selectPlataformas();
        
        try 
        {
            Connection con = Conexao.getConnection();
            
            String sql = "SELECT * FROM game ORDER BY Titulo";

            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
            {
                Game game = new Game();
                
                game.setDescricao(rs.getString("Descricao"));
                game.setId(rs.getInt("ID"));
                game.setIdDesenvolvedor(rs.getInt("IDDesenvolvedor"));
                game.setIdGenero(rs.getInt("IDGenero"));
                game.setIdPlataforma(rs.getInt("IDPlataforma"));
                game.setImagemUrl(rs.getString("ImagemURL"));
                game.setLancamento(rs.getDate("Lancamento"));
                game.setPreco(rs.getDouble("Preco"));
                game.setTitulo(rs.getString("Titulo"));

                int i = 0;
               
                do
                {
                    if (desenvolvedores.get(i).getId() == game.getIdDesenvolvedor())
                        game.setDesenvolvedor(desenvolvedores.get(i));
                    
                    i++;
                }
                while(game.getDesenvolvedor() == null);
                
                i = 0;

                do
                {
                    if (generos.get(i).getId() == game.getIdGenero())
                        game.setGenero(generos.get(i));
                    
                    i++;
                }
                while(game.getGenero() == null);
                
                i = 0;
                                
                do
                {
                    if (plataformas.get(i).getId() == game.getIdPlataforma())
                        game.setPlataforma(plataformas.get(i));
                    
                    i++;
                }
                while(game.getPlataforma() == null);
                
                games.add(game);
            }
            
            rs.close();
            ps.close();
            con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return games;
    }
    
    public ArrayList<Game> selectGames(int idPlataforma, int idGenero, int idDesenvolvedor)
    {
        ArrayList<Game> games = new ArrayList<Game>();
        ArrayList<Desenvolvedor> desenvolvedores = new DesenvolvedorDAO().selectDesenvolvedores();
        ArrayList<Genero> generos = new GeneroDAO().selectGeneros();
        ArrayList<Plataforma> plataformas = new PlataformaDAO().selectPlataformas();
        
        try 
        {
            Connection con = Conexao.getConnection();
            
            String sql = "SELECT * FROM game ";
            
            if (idPlataforma + idGenero + idDesenvolvedor > 0) 
                sql += "WHERE ";
            
            if (idPlataforma > 0) 
                sql += "IDPlataforma=" + idPlataforma + (idGenero + idDesenvolvedor > 0 ? " AND " : " ");
            
            if (idGenero > 0) 
                sql += "IDGenero=" + idGenero + (idDesenvolvedor > 0 ? " AND " : " ");
            
            if (idDesenvolvedor > 0) 
                sql += "IDDesenvolvedor=" + idDesenvolvedor + " ";
            
            sql += "ORDER BY Titulo;";

            PreparedStatement ps = con.prepareStatement(sql);

            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
            {
                Game game = new Game();
                
                game.setDescricao(rs.getString("Descricao"));
                game.setId(rs.getInt("ID"));
                game.setIdDesenvolvedor(rs.getInt("IDDesenvolvedor"));
                game.setIdGenero(rs.getInt("IDGenero"));
                game.setIdPlataforma(rs.getInt("IDPlataforma"));
                game.setImagemUrl(rs.getString("ImagemURL"));
                game.setLancamento(rs.getDate("Lancamento"));
                game.setPreco(rs.getDouble("Preco"));
                game.setTitulo(rs.getString("Titulo"));

                int i = 0;
               
                do
                {
                    if (desenvolvedores.get(i).getId() == game.getIdDesenvolvedor())
                        game.setDesenvolvedor(desenvolvedores.get(i));
                    
                    i++;
                }
                while(game.getDesenvolvedor() == null);
                
                i = 0;

                do
                {
                    if (generos.get(i).getId() == game.getIdGenero())
                        game.setGenero(generos.get(i));
                    
                    i++;
                }
                while(game.getGenero() == null);
                
                i = 0;
                                
                do
                {
                    if (plataformas.get(i).getId() == game.getIdPlataforma())
                        game.setPlataforma(plataformas.get(i));
                    
                    i++;
                }
                while(game.getPlataforma() == null);
                
                games.add(game);
            }
            
            rs.close();
            ps.close();
            con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return games;
    }

    public int selectCountByIDDesenvolvedor(int idDesenvolvedor, int idGenero, int idPlataforma)
    {
        int c = 0;
        
        try 
        {
            Connection con = Conexao.getConnection();
            
            String sql = "SELECT COUNT(*) AS C FROM game WHERE IDDesenvolvedor= " + idDesenvolvedor;
            
            if (idGenero > 0)
                sql += " AND IDGenero=" + idGenero;
            
            if (idPlataforma > 0)
                sql += " AND IDPlataforma=" + idPlataforma;
            
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) 
                c = rs.getInt("C");

            rs.close();
            ps.close();
            con.close();            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return c;
    }
    
    public int selectCountByIDGenero(int idGenero, int idPlataforma, int idDesenvolvedor)
    {
        int c = 0;
        
        try 
        {
            Connection con = Conexao.getConnection();
            
            String sql = "SELECT COUNT(*) AS C FROM game WHERE IDGenero=" + idGenero;
            
            if (idPlataforma > 0)
                sql += " AND IDPlataforma=" + idPlataforma;
            
            if (idDesenvolvedor > 0)
                sql += " AND IDDesenvolvedor=" + idDesenvolvedor;
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) 
                c = rs.getInt("C");

            rs.close();
            ps.close();
            con.close();            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return c;
    }
    
    public int selectCountByIDPlataforma(int idPlataforma, int idGenero, int idDesenvolvedor)
    {
        int c = 0;
        
        try 
        {
            Connection con = Conexao.getConnection();
            
            String sql = "SELECT COUNT(*) AS C FROM game WHERE IDPlataforma=" + idPlataforma;
            
            if (idGenero > 0)
                sql += " AND IDGenero=" + idGenero;
            
            if (idDesenvolvedor > 0)
                sql += " AND IDDesenvolvedor=" + idDesenvolvedor;
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            if (rs.next()) 
                c = rs.getInt("C");

            rs.close();
            ps.close();
            con.close();            
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return c;
    }
    
    public ArrayList<Game> pesquisarGames(String termo)
    {
        ArrayList<Game> games = new ArrayList<Game>();
        ArrayList<Desenvolvedor> desenvolvedores = new DesenvolvedorDAO().selectDesenvolvedores();
        ArrayList<Genero> generos = new GeneroDAO().selectGeneros();
        ArrayList<Plataforma> plataformas = new PlataformaDAO().selectPlataformas();
        
        try 
        {
            Connection con = Conexao.getConnection();
            
            String sql = "SELECT game.*, game_plataforma.Nome FROM game INNER JOIN game_plataforma ON game_plataforma.Nome LIKE '" + termo + "%' OR game.Titulo LIKE '" + termo + "%' WHERE game.IDPlataforma = game_plataforma.ID;";
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
            {
                Game game = new Game();
                
                game.setDescricao(rs.getString("Descricao"));
                game.setId(rs.getInt("ID"));
                game.setIdDesenvolvedor(rs.getInt("IDDesenvolvedor"));
                game.setIdGenero(rs.getInt("IDGenero"));
                game.setIdPlataforma(rs.getInt("IDPlataforma"));
                game.setImagemUrl(rs.getString("ImagemURL"));
                game.setLancamento(rs.getDate("Lancamento"));
                game.setPreco(rs.getDouble("Preco"));
                game.setTitulo(rs.getString("Titulo"));

                int i = 0;
               
                do
                {
                    if (desenvolvedores.get(i).getId() == game.getIdDesenvolvedor())
                        game.setDesenvolvedor(desenvolvedores.get(i));
                    
                    i++;
                }
                while(game.getDesenvolvedor() == null);
                
                i = 0;

                do
                {
                    if (generos.get(i).getId() == game.getIdGenero())
                        game.setGenero(generos.get(i));
                    
                    i++;
                }
                while(game.getGenero() == null);
                
                i = 0;
                                
                do
                {
                    if (plataformas.get(i).getId() == game.getIdPlataforma())
                        game.setPlataforma(plataformas.get(i));
                    
                    i++;
                }
                while(game.getPlataforma() == null);
                
                games.add(game);
            }
            
            rs.close();
            ps.close();
            con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return games;
    }
    
    public ArrayList<Game> selectRecomendacoes(int[] gameIds) 
    {
        ArrayList<Game> games = new ArrayList<Game>();
        ArrayList<Desenvolvedor> desenvolvedores = new DesenvolvedorDAO().selectDesenvolvedores();
        ArrayList<Genero> generos = new GeneroDAO().selectGeneros();
        ArrayList<Plataforma> plataformas = new PlataformaDAO().selectPlataformas();
        
        String in = "";
        
        for (int i = 0; i < gameIds.length; i++) 
        {
            in += gameIds[i] + (i + 1 < gameIds.length ? ", " : "");
        }
        
        try 
        {
            Connection con = Conexao.getConnection();
            
            String sql = "SELECT game.* FROM game AS GAME LEFT JOIN game AS GAME2 ON GAME.IDGenero = GAME2.IDGenero AND GAME.IDPlataforma = GAME2.IDPlataforma OR GAME.IDDesenvolvedor = GAME2.IDDesenvolvedor WHERE GAME2.ID IN (" + in + ") AND GAME.ID  NOT IN (" + in + ");";
            
            PreparedStatement ps = con.prepareStatement(sql);
            
            ResultSet rs = ps.executeQuery();
            
            while (rs.next()) 
            {
                Game game = new Game();
                
                game.setDescricao(rs.getString("Descricao"));
                game.setId(rs.getInt("ID"));
                game.setIdDesenvolvedor(rs.getInt("IDDesenvolvedor"));
                game.setIdGenero(rs.getInt("IDGenero"));
                game.setIdPlataforma(rs.getInt("IDPlataforma"));
                game.setImagemUrl(rs.getString("ImagemURL"));
                game.setLancamento(rs.getDate("Lancamento"));
                game.setPreco(rs.getDouble("Preco"));
                game.setTitulo(rs.getString("Titulo"));

                int i = 0;
               
                do
                {
                    if (desenvolvedores.get(i).getId() == game.getIdDesenvolvedor())
                        game.setDesenvolvedor(desenvolvedores.get(i));
                    
                    i++;
                }
                while(game.getDesenvolvedor() == null);
                
                i = 0;

                do
                {
                    if (generos.get(i).getId() == game.getIdGenero())
                        game.setGenero(generos.get(i));
                    
                    i++;
                }
                while(game.getGenero() == null);
                
                i = 0;
                                
                do
                {
                    if (plataformas.get(i).getId() == game.getIdPlataforma())
                        game.setPlataforma(plataformas.get(i));
                    
                    i++;
                }
                while(game.getPlataforma() == null);
                
                games.add(game);
            }
            
            rs.close();
            ps.close();
            con.close();
        } 
        catch (Exception e) 
        {
            e.printStackTrace();
        }
        
        return games;
    }
}