package classes;

import java.sql.Date;
import java.text.NumberFormat;
import java.util.Currency;
import java.util.Locale;

public class Game 
{
    private int id;
    private String titulo;
    private Double preco;
    private String precoFormatado;
    private Date lancamento;
    private String descricao;
    private String imagemUrl;
    private int idDesenvolvedor;
    private int idGenero;
    private int idPlataforma;
    
    private Desenvolvedor desenvolvedor;
    private Genero genero;
    private Plataforma plataforma;
    
    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
        this.setPrecoFormatado();
    }

    public Date getLancamento() {
        return lancamento;
    }

    public void setLancamento(Date lancamento) {
        this.lancamento = lancamento;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao.replace("\n", "<br />");
    }

    public String getImagemUrl() {
        return imagemUrl;
    }

    public void setImagemUrl(String imagemUrl) {
        this.imagemUrl = imagemUrl;
    }

    public int getIdDesenvolvedor() {
        return idDesenvolvedor;
    }

    public void setIdDesenvolvedor(int idDesenvolvedor) {
        this.idDesenvolvedor = idDesenvolvedor;
    }

    public int getIdGenero() {
        return idGenero;
    }

    public void setIdGenero(int idGenero) {
        this.idGenero = idGenero;
    }

    public int getIdPlataforma() {
        return idPlataforma;
    }

    public void setIdPlataforma(int idPlataforma) {
        this.idPlataforma = idPlataforma;
    }
    
        public Desenvolvedor getDesenvolvedor() {
        return desenvolvedor;
    }

    public void setDesenvolvedor(Desenvolvedor desenvolvedor) {
        this.desenvolvedor = desenvolvedor;
    }

    public Genero getGenero() {
        return genero;
    }

    public void setGenero(Genero genero) {
        this.genero = genero;
    }

    public Plataforma getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(Plataforma plataforma) {
        this.plataforma = plataforma;
    }
    
    public String getPrecoFormatado() {
        return this.precoFormatado;
    }
    
    public void setPrecoFormatado() {
        Double currencyAmount = new Double(this.getPreco());
        
        Locale locale = new Locale("pt", "BR");
        Currency currentCurrency = Currency.getInstance(locale);
        NumberFormat currencyFormatter = new java.text.DecimalFormat("###,###,##0.00");
        NumberFormat.getCurrencyInstance(locale);

        this.precoFormatado = currentCurrency.getSymbol() + " " + currencyFormatter.format(currencyAmount);
    }
}