package com.example.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

import java.lang.annotation.Native;

@Entity

public class Servico extends Entidade {
    @NotNull
    @Min(value = 1)
    @Column(nullable = false)
    private int duracao;
    @NotNull
    @Min(value = 1)
    @Column(nullable = false)
    private int rh;

    public Servico(){

    }

    public Servico(String nome, String genero, double saldo, String local, int duracao, int rh) {
        super(nome, genero, saldo, local);
        this.duracao = duracao;
        this.rh = rh;
    }

    public int getDuracao() {
        return duracao;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public int getRh() {
        return rh;
    }

    public void setRh(int rh) {
        this.rh = rh;
    }
}
