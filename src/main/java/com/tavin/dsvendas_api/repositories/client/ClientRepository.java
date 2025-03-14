package com.tavin.dsvendas_api.repositories.client;

import com.tavin.dsvendas_api.infra.models.ClientModel;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, Long> {


    @Query("select c from ClientModel c where upper(c.name) like upper(:name) and c.cpf like :cpf")
    Page<ClientModel> findByCpfAndName(
            @Param("name") String name,
            @Param("cpf") String cpf, Pageable pageable);
}
