package com.example.demo.service;

import com.example.demo.dao.PessoaDao;
import com.example.demo.model.Pessoa;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.xml.ws.ServiceMode;
import java.util.List;
import java.util.Optional;

@Service
public class PessoaService {

    private final PessoaDao pessoaDao;

    @Autowired
    public PessoaService(@Qualifier("fakeDao") PessoaDao pessoaDao) {
        this.pessoaDao = pessoaDao;
    }

    public int addPessoa(Pessoa pessoa) {
        return pessoaDao.insertPessoa(pessoa);
    }

    public List<Pessoa> getPessoas(){
        return pessoaDao.getPessoas();
    }

    public Optional<Pessoa> getPessoaById(long id) {
        return pessoaDao.selectPessoaById(id);
    }

    public int deletePessoa(long id) {
        return pessoaDao.deletePessoaById(id);
    }

    public Pessoa updatePessoa(long id, Pessoa pessoa) {
        return pessoaDao.updatePessoaById(id, pessoa);
    }

}
