package com.example.demo.model;

public class Pessoa {
    private long id;
    private String nome;

    public Pessoa(long id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }
}
