package com.example.api_rest.repository;

import com.example.api_rest.entity.MascotaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface MascotaRepository extends JpaRepository<MascotaEntity, UUID> {

    @Query(value = "SELECT * FROM mascotas WHERE especie ILIKE CONCAT('%', :especie, '%')", nativeQuery = true)
    List<MascotaEntity> findByEspecieNative(@Param("especie") String especie);
}
