package classes;

import dao.GameDAO;

public class Genero 
{
    private int id;
    private String descricao;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }  
    
    public int countGames(int idPlataforma, int idDesenvolvedor)
    {
        return new GameDAO().selectCountByIDGenero(this.getId(), idPlataforma, idDesenvolvedor);
    }
}