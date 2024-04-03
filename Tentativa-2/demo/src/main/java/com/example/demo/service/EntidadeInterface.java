package com.example.demo.service;

import com.example.demo.model.Servico;
import com.example.demo.model.Entidade;
import com.example.demo.model.Produto;
import com.example.demo.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

public interface EntidadeInterface<E extends Entidade> {

    public List<E> listar();

    public E criar(E e);

    public E atualizar(E e, Long id);

    public boolean deletar(Long id);
}
