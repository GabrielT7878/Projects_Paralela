package computacao.paralela.produtor11.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Date;

@Entity
public class DadosProducao implements Serializable {

    @Id
    private Integer id;
    private Date data;
    private Integer tipoCafeColhido;
    private Double quantidadeColhida;
    private Double produtividade;


    public DadosProducao() {
    }

    @Override
    public String toString() {
        return "Dados{" +
                "id=" + id +
                ", data='" + data + '\'' +
                ", tipoCafeColhido=" + tipoCafeColhido +
                ", quantidadeColhida=" + quantidadeColhida +
                ", produtividade=" + produtividade +
                '}';
    }

    public DadosProducao(int id, Date data, int tipoCafeColhido, double quantidadeColhida, double produtividade) {
        this.id = id;
        this.data = data;
        this.tipoCafeColhido = tipoCafeColhido;
        this.quantidadeColhida = quantidadeColhida;
        this.produtividade = produtividade;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getData() { return data; }

    public void setData(Date data) {
        this.data = data;
    }

    public int getTipoCafeColhido() {return tipoCafeColhido;}

    public void setTipoCafeColhido(int tipoCafeColhido) {this.tipoCafeColhido = tipoCafeColhido;}

    public double getQuantidadeColhida() {
        return quantidadeColhida;
    }

    public void setQuantidadeColhida(double quantidadeColhida) {
        this.quantidadeColhida = quantidadeColhida;
    }

    public double getProdutividade() {
        return produtividade;
    }

    public void setProdutividade(double produtividade) {
        this.produtividade = produtividade;
    }


}
