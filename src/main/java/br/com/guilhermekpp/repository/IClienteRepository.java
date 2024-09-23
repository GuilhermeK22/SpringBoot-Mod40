package br.com.guilhermekpp.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import br.com.guilhermekpp.domain.Cliente;

@Repository
public interface IClienteRepository extends CrudRepository<Cliente, Long> {

}
