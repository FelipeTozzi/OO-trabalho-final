package com.example.demo.model;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Produto extends Entidade{
    @NotNull
    @Min(value = 1)
    @Column(nullable = false)
    private int quantidade;

    @Size(min = 1, max = 50)
    private String Marca;

    public Produto() {
    }

    public Produto(String nome, String genero, double saldo, String local, int quantidade, String marca) {
        super(nome, genero, saldo, local);
        this.quantidade = quantidade;
        Marca = marca;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getMarca() {
        return Marca;
    }

    public void setMarca(String marca) {
        Marca = marca;
    }
}
