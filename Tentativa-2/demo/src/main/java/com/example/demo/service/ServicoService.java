package com.example.demo.service;

import com.example.demo.model.Servico;
import com.example.demo.model.Entidade;
import com.example.demo.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;
import java.util.Optional;

@Service
public class ServicoService implements EntidadeInterface<Servico> {

    @Autowired
    ServicoRepository servicoRepository;

    @Override
    public List<Servico> listar() {
        return servicoRepository.findAll();
    }

    public Servico criar(Servico servico) {
        return servicoRepository.save(servico);
    }

    public Servico atualizar(Servico servico, Long id) {
        if(verificaID(id)) {
            servico.setId(id);
            return servicoRepository.save(servico);
        }
        return null;
    }

    private boolean verificaID(Long id) {
        if(servicoRepository.existsById(id)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean deletar(Long id) {
        if(verificaID(id)) {
            servicoRepository.deleteById(id);
            return true;
        } else {
            return false;
        }
    }

    public int qtdServico() {
        return servicoRepository.findAll().size();
    }

    public Optional<Servico> buscaPorID(Long id) {
        return servicoRepository.findById(id);
    }
}
