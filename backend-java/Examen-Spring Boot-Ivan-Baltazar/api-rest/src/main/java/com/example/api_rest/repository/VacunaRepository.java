package com.example.api_rest.repository;

import com.example.api_rest.entity.VacunaEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.UUID;

public interface VacunaRepository extends JpaRepository<VacunaEntity, UUID> {

    @Query(value = "SELECT * FROM vacunas WHERE nombre ILIKE CONCAT('%', :nombre, '%')", nativeQuery = true)
    List<VacunaEntity> findByNombreLikeNative(@Param("nombre") String nombre);
}
