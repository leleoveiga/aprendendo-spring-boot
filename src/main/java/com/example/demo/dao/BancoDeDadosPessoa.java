package com.example.demo.dao;

import com.example.demo.model.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository("fakeDao")
public class BancoDeDadosPessoa implements PessoaDao {

    private int contadorId = 0;
    private static List<Pessoa> DB = new ArrayList<>();

    @Override
    public int insertPessoa(Pessoa pessoa) {
        DB.add(new Pessoa(++contadorId, pessoa.getNome()));
        return 1;
    }

    @Override
    public List<Pessoa> getPessoas() {
        return DB;
    }

    @Override
    public Optional<Pessoa> selectPessoaById(long id) {
        return DB.stream()
                .filter(pessoa -> pessoa.getId() == id)
                .findFirst();
    }

    @Override
    public int deletePessoaById(long id) {
        return 0;
    }

    @Override
    public int updatePessoaById(long id, Pessoa pessoa) {
        return 0;
    }


}
