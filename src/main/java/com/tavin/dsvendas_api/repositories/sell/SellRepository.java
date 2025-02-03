package com.tavin.dsvendas_api.repositories.sell;

import com.tavin.dsvendas_api.infra.models.sells.SellModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SellRepository extends JpaRepository<SellModel, Long> {
}
