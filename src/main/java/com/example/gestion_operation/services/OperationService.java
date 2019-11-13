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
        if (operationRepository.findById(id).isPresent()) {
			Operation existingOperation = operationRepository.findById(id).get();
            existingOperation.setDate_operation(newOperation.getDate_operation());
            existingOperation.setDoctorId(newOperation.getDoctorId());
            existingOperation.setNom_operation(newOperation.getNom_operation());
            existingOperation.setPatientId(newOperation.getPatientId());
            existingOperation.setRoomId(newOperation.getRoomId());
			return operationRepository.save(existingOperation);
		} else {
			return null;
		}
    }

    public Boolean deleteOperation(int id) {
        if (operationRepository.findById(id).isPresent()) {
            operationRepository.deleteById(id);
            return true;
        } else {
            return false;
        }


    }
}
