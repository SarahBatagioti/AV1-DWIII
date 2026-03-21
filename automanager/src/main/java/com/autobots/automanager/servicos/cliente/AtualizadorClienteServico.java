package com.autobots.automanager.servicos.cliente;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.modelo.dto.cliente.ClienteAtualizacaoDTO;
import com.autobots.automanager.modelo.entidade.cliente.ClienteAtualizador;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@Service
public class AtualizadorClienteServico {

    @Autowired
    private ClienteRepositorio repositorio;

    public Cliente atualizar(ClienteAtualizacaoDTO dto) {
        if (dto.getId() == null) {
            throw new IllegalArgumentException("Id obrigatorio para atualizacao");
        }

        Cliente cliente = repositorio.findById(dto.getId())
            .orElseThrow(() -> new IllegalArgumentException("Cliente nao encontrado"));

        Cliente entidadeAtualizacao = new Cliente();
        entidadeAtualizacao.setNome(dto.getNome());
        entidadeAtualizacao.setNomeSocial(dto.getNomeSocial());
        entidadeAtualizacao.setDataNascimento(dto.getDataNascimento());

        ClienteAtualizador atualizador = new ClienteAtualizador();
        atualizador.atualizar(cliente, entidadeAtualizacao);

        return repositorio.save(cliente);
    }
}