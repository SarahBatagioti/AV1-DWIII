package com.autobots.automanager.servicos.cliente;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.autobots.automanager.entidades.Cliente;
import com.autobots.automanager.modelo.dto.cliente.ClienteCadastroDTO;
import com.autobots.automanager.repositorios.ClienteRepositorio;

@Service
public class CadastradorClienteServico {

    @Autowired
    private ClienteRepositorio repositorio;

    public Cliente cadastrar(ClienteCadastroDTO dto) {
        Cliente cliente = new Cliente();
        cliente.setNome(dto.getNome());
        cliente.setNomeSocial(dto.getNomeSocial());
        cliente.setDataNascimento(dto.getDataNascimento());
        cliente.setDataCadastro(new Date());
        return repositorio.save(cliente);
    }
}