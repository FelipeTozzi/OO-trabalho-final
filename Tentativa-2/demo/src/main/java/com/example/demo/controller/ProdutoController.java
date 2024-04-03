package com.example.demo.controller;

import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import com.example.demo.service.ProdutoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/produto")
public class ProdutoController {
    @Autowired
    ProdutoService produtoService;

    @GetMapping
    public List<Produto> listar() {
        return produtoService.listar();
    }

    @PostMapping
    public Produto criar(@Valid @RequestBody Produto produto) {
        return produtoService.criar(produto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<?> atualizar (@RequestBody Produto produto, @PathVariable Long id){
        if(produtoService.atualizar(produto, id) == null){
            String mensagem = "O id não existe";
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        } else {
            return ResponseEntity.ok(produto);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletar(@PathVariable Long id){
        if(produtoService.deletar(id)) {
            String mensagem = "O id " + id + "foi removido com sucesso.";
            return ResponseEntity.status(HttpStatus.OK).body(mensagem);
        } else {
                String mensagem = "id não existe";
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(mensagem);
        }
    }
    @GetMapping("/qtd")
    public int qtdProduto() {
        return produtoService.qtdProduto();
    }

    @GetMapping("/{id}")
    public Optional<Produto> buscarPorID(@PathVariable Long id) {
        return produtoService.buscaPorID(id);
    }


}