package com.example.demo.controller;

import com.example.demo.model.Servico;
import com.example.demo.repository.ServicoRepository;
import com.example.demo.service.ServicoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/(servico")
public class ServicoController {

    @Autowired
    ServicoService servicoService;

    @GetMapping
    public List<Servico> listar() {
        return servicoService.listar();
    }

    @PostMapping
    public Servico criar(@Valid @RequestBody Servico servico) {
        return servicoService.criar(servico);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar(@RequestBody Servico servico, @PathVariable Long id) {
        if (servicoService.atualizar(servico, id) == null) {
            String mensagem = "ID não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(servico);
        }
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id) {
        if(servicoService.deletar(id)){
            String mensagem = "O id " + id + " foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
            String mensagem = "O id informado não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }
    @GetMapping("/qtd")
    public int qtdServico() {
        return servicoService.qtdServico();
    }

    @GetMapping("/{id}")
    public Optional<Servico> buscarPorID(@PathVariable Long id) {
        return servicoService.buscaPorID(id);
    }

}
