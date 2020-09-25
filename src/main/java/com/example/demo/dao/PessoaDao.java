package com.example.demo.dao;

import com.example.demo.model.Pessoa;

import java.util.List;
import java.util.Optional;

public interface PessoaDao {

    int insertPessoa(Pessoa pessoa);

    List<Pessoa> getPessoas();

    Optional<Pessoa> selectPessoaById(long id);

    int deletePessoaById(long id);

    int updatePessoaById(long id, Pessoa pessoa);

}
