package com.example.demo.dao;

import com.example.demo.model.Pessoa;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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
        Optional<Pessoa> pessoa = selectPessoaById(id);
        if (!pessoa.isPresent()){
            return 0;
        }
        DB.remove(pessoa.get());
        return 1;
    }

    @Override
    public Pessoa updatePessoaById(long id, Pessoa pessoaNova) {
        return selectPessoaById(id).map(pessoa -> DB.set(DB.indexOf(pessoa), new Pessoa(id, pessoaNova.getNome()))).orElse(null);
    }

}
