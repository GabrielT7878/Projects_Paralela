package computacao.paralela.produtor11.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;

@Entity
public class DadosEnergia implements Serializable {

    @Id
    private Integer id;
    private String data;
    private String momeUsina;
    private Integer capacidadeGeracao;
    private Integer geracaoAtual;

    public DadosEnergia() {
    }

    public DadosEnergia(Integer id, String data, String momeUsina, Integer capacidadeGeracao, Integer geracaoAtual) {
        this.id = id;
        this.data = data;
        this.momeUsina = momeUsina;
        this.capacidadeGeracao = capacidadeGeracao;
        this.geracaoAtual = geracaoAtual;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getMomeUsina() {
        return momeUsina;
    }

    public void setMomeUsina(String momeUsina) {
        this.momeUsina = momeUsina;
    }

    public Integer getCapacidadeGeracao() {
        return capacidadeGeracao;
    }

    public void setCapacidadeGeracao(Integer capacidadeGeracao) {
        this.capacidadeGeracao = capacidadeGeracao;
    }

    public Integer getGeracaoAtual() {
        return geracaoAtual;
    }

    public void setGeracaoAtual(Integer geracaoAtual) {
        this.geracaoAtual = geracaoAtual;
    }
}
