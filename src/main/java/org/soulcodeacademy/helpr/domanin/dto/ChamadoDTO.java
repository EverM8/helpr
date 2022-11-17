package org.soulcodeacademy.helpr.domanin.dto;

import org.soulcodeacademy.helpr.domanin.enums.StatusChamado;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

public class ChamadoDTO {
    @NotBlank(message = "Titulo é obrigatório!")
    private String titulo;

    @NotBlank(message = "Descrição é obrigatória!")
    private String descricao;

    private StatusChamado status;

    @NotNull(message = "idCliente é obrigatória!")
    private Integer idCliente;

    private Integer idFuncionario;

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public StatusChamado getStatus() {
        return status;
    }

    public void setStatus(StatusChamado status) {
        this.status = status;
    }

    public Integer getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Integer idCliente) {
        this.idCliente = idCliente;
    }

    public Integer getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(Integer idFuncionario) {
        this.idFuncionario = idFuncionario;
    }
}
