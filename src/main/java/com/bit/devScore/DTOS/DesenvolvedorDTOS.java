package com.bit.devScore.DTOS;

import jakarta.persistence.Column;

import jakarta.validation.constraints.Email;
import org.hibernate.validator.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.Getter;

@Data

public class DesenvolvedorDTOS {


   @NotBlank(message =" atributo nao pode estar vazio")
   @Size(max = 70, message = "nome muito longo")

    private String nome;
    @NotBlank(message =" atributo nao pode estar vazio")
    private String nick;
    @Email(message = "Email nao valido")
    @NotBlank(message =" atributo nao pode estar vazio")
    private String email;

    @NotBlank(message =" atributo nao pode estar vazio")
    private String senha;

    public DesenvolvedorDTOS(String nome, String nick, String email, String senha) {
        this.nome = nome;
        this.nick = nick;
        this.email = email;
        this.senha = senha;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNick() {
        return nick;
    }

    public void setNick(String nick) {
        this.nick = nick;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
}
