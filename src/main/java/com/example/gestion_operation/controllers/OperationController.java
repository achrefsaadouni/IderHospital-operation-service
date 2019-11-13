package com.example.gestion_operation.controllers;

import com.example.gestion_operation.models.*;
import com.example.gestion_operation.services.OperationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;


@RestController
@RequestMapping(value = "/api/operations")
public class OperationController {
    private static String ipaddress = "192.168.1.100";
    @Autowired
    private OperationService operationService;

    @Autowired
    private RestTemplate restTemplate;




    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public ResponseEntity<Operation> createOperation(@RequestBody Operation operation){
        operationService.addOperation(operation);
        return new ResponseEntity<>(operationService.addOperation(operation), HttpStatus.CREATED);
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public ResponseEntity<List<OperationView>> getOperations(){
        List<OperationView> array = new ArrayList<>();
        operationService.getOperation().forEach(e->{
            String url = "http://"+ipaddress+":8089/operatingRooms/"+e.getRoomId();
            OperatingRoom room = restTemplate.getForObject(url, OperatingRoom.class);
            url = "http://"+ipaddress+":8092/patients/"+e.getPatientId();
            Patient p = restTemplate.getForObject(url, Patient.class);
            url = "http://"+ipaddress+":8092/personnels/"+e.getDoctorId();
            Personnel d = restTemplate.getForObject(url, Personnel.class);
            OperationView opv = new OperationView(e,room,p,d);
            array.add(opv);
        });
        return new ResponseEntity<>(array, HttpStatus.CREATED);
    }

    @PutMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Operation> updateOperation(@PathVariable(value = "id") int id, @RequestBody Operation operation){
        return new ResponseEntity<>(operationService.updateOperation(id, operation), HttpStatus.ACCEPTED);
    }

    @DeleteMapping(value="/{id}", produces = MediaType.APPLICATION_JSON_VALUE)
    @ResponseStatus(HttpStatus.ACCEPTED)
    public ResponseEntity<Boolean> deleteOperation(@PathVariable(value = "id") int id){
        return new ResponseEntity<>(operationService.deleteOperation(id), HttpStatus.OK);
    }
}
