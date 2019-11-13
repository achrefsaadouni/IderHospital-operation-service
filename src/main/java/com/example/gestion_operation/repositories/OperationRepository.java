package com.example.gestion_operation.repositories;


import com.example.gestion_operation.models.Operation;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface OperationRepository extends JpaRepository<Operation, Integer> {
    @Query("select c from Operation c where c.nom_operation like :nom")
    public Page<Operation> operationByNom(@Param("nom") String n, Pageable pageable);
}
