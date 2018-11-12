package classes;

import dao.GameDAO;

public class Plataforma 
{
    private int id;
    private String nome;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
    
    public int countGames(int idGenero, int idDesenvolvedor)
    {
        return new GameDAO().selectCountByIDPlataforma(this.getId(), idGenero, idDesenvolvedor);
    }
}
