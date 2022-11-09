package org.soulcodeacademy.helpr.domanin;

import org.soulcodeacademy.helpr.domanin.enums.Perfil;

import javax.persistence.Entity;

//- Cliente extends Usuario (entidade): telefone (nova coluna)
//- ClienteRepository
//- ClienteDTO extends UsuarioDTO
//- ClienteService
//- ClienteController
@Entity
public class Cliente extends Usuario{
    private String telefone;

    public Cliente(){}

    //Integer id, String nome, String email, String cpf, String senha,
    public Cliente(Integer id, String nome, String email, String cpf, String senha, String telefone){
        super(id, nome, email, cpf, senha, Perfil.CLIENTE);
        this.telefone=telefone;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }
}
