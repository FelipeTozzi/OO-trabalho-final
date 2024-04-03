package com.example.demo.service;

import com.example.demo.model.Produto;
import com.example.demo.model.Entidade;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ProdutoService implements EntidadeInterface<Produto>{

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<Produto> listar(){
        return produtoRepository.findAll();
    }

    public Produto criar(Produto produto){
        return produtoRepository.save(produto);
    }

    public Produto atualizar(Produto produto, Long id) {
        if(verificaID(id)) {
            //verdadeiro
            produto.setId(id);
            return produtoRepository.save(produto);
        }
        return null;
    }

    private boolean verificaID(Long id) {
        if(produtoRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deletar(Long id) {
        if(verificaID(id)) {
            produtoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }
    public int qtdProduto() {
        return produtoRepository.findAll().size();
    }

    public Optional<Produto> buscaPorID(Long id) {
        return produtoRepository.findById(id);
    }
}
