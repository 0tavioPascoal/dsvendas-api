package com.tavin.dsvendas_api.repositories.sell;

import com.tavin.dsvendas_api.infra.models.sells.SellModel;
import com.tavin.dsvendas_api.repositories.sell.projections.SellPerMonth;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface SellRepository extends JpaRepository<SellModel, Long> {
    @Query(nativeQuery = true,
            value = "select "
                    + "	extract( month from v.created ) as month, "
                    + "	sum(v.total) as value"
                    + " from tb_sell as v"
                    + " where extract (year from v.created) = :year"
                    + " group by extract( month from v.created )"
                    + " order by extract( month from v.created )"
    )
    List<SellPerMonth> GetSumPerMonth(@Param("year") Integer year);
}
