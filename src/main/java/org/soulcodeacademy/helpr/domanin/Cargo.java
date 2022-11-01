package org.soulcodeacademy.helpr.domanin;

import javax.persistence.*;

// Transformar a classe em uma entidade/tabela no banco
@Entity
public class Cargo { // nome da tabela = cargo
    @Id //PRIMARY KEY Usa o atributo abaixo como chave primária
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AUTO_INCREMENT
    private Integer idCargo; // Será a chave primária da tabela

    // @Column serve para customizar a coluna
   @Column(nullable = false, length = 50) // NOT NULL, e máximo de 50 caracteres.
    private String nome;
    @Column(nullable = false, length = 120) // NOT NULL, e máximo de 120 caracteres.
    private String descricao;
   @Column(nullable = false) // @Column serve para customizar a coluna
    private double salario;

    public Cargo(){} // a ORM irá este construtor em conjunto com os Getters/Setters

    public Cargo(Integer idCargo, String nome, String descricao, double salario) {
        this.idCargo = idCargo;
        this.nome = nome;
        this.descricao = descricao;
        this.salario = salario;
    }

    public Integer getIdCargo() {
        return idCargo;
    }

    public void setIdCargo(Integer idCargo) {
        this.idCargo = idCargo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }
}
