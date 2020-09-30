package com.example.demo.api;

import com.example.demo.model.Pessoa;
import com.example.demo.service.PessoaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping("api/pessoa")
@RestController
public class PessoaController {

    private final PessoaService pessoaService;

    @Autowired
    public PessoaController(PessoaService pessoaService) {
        this.pessoaService = pessoaService;
    }

    @PostMapping
    public void addPessoa(@RequestBody Pessoa pessoa) {
        pessoaService.addPessoa(pessoa);
    }

    @RequestMapping
    public List<Pessoa> getPessoas() {
        return pessoaService.getPessoas();
    }

    @GetMapping("{id}")
    public Pessoa getPessoaById(@PathVariable("id") long id) {
        return pessoaService.getPessoaById(id)
                .orElse(null);
    }

    @DeleteMapping("{id}")
    public void deletePessoaById(@PathVariable("id") long id) {
        pessoaService.deletePessoa(id);
    }

    @PutMapping("{id}")
    public void updatePessoaById(@PathVariable("id") long id, @RequestBody Pessoa pessoa) {
        pessoaService.updatePessoa(id, pessoa);
    }
}
