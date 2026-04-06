package com.example.api_rest.repository;

import com.example.api_rest.entity.PropietarioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public interface PropietarioRepository extends JpaRepository<PropietarioEntity, UUID> {

    @Query(value = "SELECT * FROM propietarios WHERE email = :email", nativeQuery = true)
    Optional<PropietarioEntity> findByEmailNative(@Param("email") String email);

    @Query(value = "SELECT * FROM propietarios WHERE dni = :dni", nativeQuery = true)
    Optional<PropietarioEntity> findByDniNative(@Param("dni") String dni);

    @Query(value = "SELECT * FROM propietarios WHERE apellidos ILIKE CONCAT('%', :apellido, '%')", nativeQuery = true)
    List<PropietarioEntity> findByApellidoLikeNative(@Param("apellido") String apellido);

    @Query(value = "SELECT * FROM propietarios WHERE fecha_registro > :fecha", nativeQuery = true)
    List<PropietarioEntity> findByFechaRegistroAfterNative(@Param("fecha") LocalDate fecha);

    @Transactional(readOnly = true)
    @Query("SELECT p FROM PropietarioEntity p LEFT JOIN FETCH p.mascotas WHERE p.id = :id")
    Optional<PropietarioEntity> findByIdWithMascotas(@Param("id") UUID id);
}
