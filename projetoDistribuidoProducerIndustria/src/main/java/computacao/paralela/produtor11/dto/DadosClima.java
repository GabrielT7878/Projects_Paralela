package computacao.paralela.produtor11.dto;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;

import java.io.Serializable;
import java.util.Date;

@Entity
public class DadosClima implements Serializable {

    @Id
    private Integer id;
    private String dataInicial;
    private String dataFinal;
    private String cidade;
    private String estado;
    private Double umidadeMedia;
    private Double temperaturaMedia;
    private String condicaoClima;

    public String getDataInicial() {
        return dataInicial;
    }

    public void setDataInicial(String dataInicial) {
        this.dataInicial = dataInicial;
    }

    public String getDataFinal() {
        return dataFinal;
    }

    public void setDataFinal(String dataFinal) {
        this.dataFinal = dataFinal;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public Double getUmidadeMedia() {
        return umidadeMedia;
    }

    public void setUmidadeMedia(Double umidadeMedia) {
        this.umidadeMedia = umidadeMedia;
    }

    public Double getTemperaturaMedia() {
        return temperaturaMedia;
    }

    public void setTemperaturaMedia(Double temperaturaMedia) {
        this.temperaturaMedia = temperaturaMedia;
    }

    public String getCondicaoClima() {
        return condicaoClima;
    }

    public void setCondicaoClima(String condicaoClima) {
        this.condicaoClima = condicaoClima;
    }
}
