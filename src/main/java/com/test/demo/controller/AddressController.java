package com.test.demo.controller;

import com.test.demo.model.Address;
import com.test.demo.repository.AddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api")
public class AddressController {

    @Autowired
    private AddressRepository addressRepository;

    @GetMapping("/address")
    public ResponseEntity<List<Address>> findalladdress() {
        List<Address> addressList = addressRepository.findAll();
        return ResponseEntity.ok(addressList);

    }

    @GetMapping("/address/{id}")
    public ResponseEntity<Address> findAddressById(@PathVariable int id) {
        Optional<Address> optionalAddress = addressRepository.findById(id);
        if (optionalAddress.isPresent()) {
            return ResponseEntity.ok(optionalAddress.get());
        }
        return (ResponseEntity<Address>) ResponseEntity.status(HttpStatus.NO_CONTENT);
    }


}
