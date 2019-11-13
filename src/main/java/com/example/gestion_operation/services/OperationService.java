package com.example.gestion_operation.services;

import com.example.gestion_operation.models.Operation;
import com.example.gestion_operation.repositories.OperationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperationService {

    @Autowired
    private OperationRepository operationRepository;

    public Operation addOperation(Operation operation) {
        return operationRepository.save(operation);
    }
    public List<Operation> getOperation() {
        return operationRepository.findAll();
    }
    public Operation updateOperation(int id, Operation newOperation) {
        return new Operation();
    }

    public Boolean deleteOperation(int id) {
        return true;
    }
}
