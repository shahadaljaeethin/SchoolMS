package com.example.SchoolMS.Service;

import com.example.SchoolMS.Api.ApiException;
import com.example.SchoolMS.DTO.AddressDTOin;
import com.example.SchoolMS.Model.Address;
import com.example.SchoolMS.Model.Teacher;
import com.example.SchoolMS.Repository.AddressRepository;
import com.example.SchoolMS.Repository.TeacherRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class AddressService {
    private final AddressRepository addressRepository;
    private final TeacherRepository teacherRepository;

    public List<Address> getAll(){return addressRepository.findAll();}

    public void addAddress(AddressDTOin dto){
        Teacher teacher = teacherRepository.findTeacherById(dto.getTeacherId());
        if(teacher==null) throw new ApiException("teacher not found");

        Address address = new Address(dto.getTeacherId(), dto.getArea(), dto.getStreet(), dto.getBuildingNumber(), teacher);
        addressRepository.save(address);
    }

    public void updateAddress(AddressDTOin dto){
        Address address = addressRepository.findAddressById(dto.getTeacherId());
        if(address==null) throw new ApiException("address not found");

        address.setArea(dto.getArea());
        address.setStreet(dto.getStreet());
        address.setBuildingNumber(dto.getBuildingNumber());

        addressRepository.save(address);
    }

    public void deleteAddress(Integer id){
        Address address = addressRepository.findAddressById(id);
        if(address==null) throw new ApiException("address not found");

        address.setArea(""); //to make data null
        address.setStreet("");
        address.setBuildingNumber("");

        addressRepository.save(address);
    }



}
