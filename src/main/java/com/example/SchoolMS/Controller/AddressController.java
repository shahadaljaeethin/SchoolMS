package com.example.SchoolMS.Controller;

import com.example.SchoolMS.Api.ApiResponse;
import com.example.SchoolMS.DTO.AddressDTOin;
import com.example.SchoolMS.Model.Teacher;
import com.example.SchoolMS.Repository.AddressRepository;
import com.example.SchoolMS.Service.AddressService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
@RequestMapping("/api/v1/address")
public class AddressController {
    private final AddressService addressService;

    @GetMapping("/get")
    public ResponseEntity<?> getAll(){ return ResponseEntity.status(200).body(addressService.getAll()); }


    @PostMapping("/add")
    public ResponseEntity<?> addAddress(@RequestBody @Valid AddressDTOin address){
        addressService.addAddress(address);
        return ResponseEntity.status(200).body(new ApiResponse("added"));
    }

    @PutMapping("/update")
    public ResponseEntity<?> updateAddress(@RequestBody @Valid AddressDTOin address){
        addressService.updateAddress(address);
        return ResponseEntity.status(200).body(new ApiResponse("updated"));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> removeAddress(@PathVariable Integer id){
        addressService.deleteAddress(id);
        return ResponseEntity.status(200).body(new ApiResponse("removed"));
    }

}
