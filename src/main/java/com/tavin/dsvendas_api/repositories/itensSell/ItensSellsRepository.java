package com.tavin.dsvendas_api.repositories.itensSell;

import com.tavin.dsvendas_api.infra.models.sells.ItensSell;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItensSellsRepository extends JpaRepository<ItensSell, Long> {
}
