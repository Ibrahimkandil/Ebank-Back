package com.example.ebank.Services;

import com.example.ebank.Entity.Admin;
import com.example.ebank.Entity.Client;
import com.example.ebank.Entity.Employee;
import com.example.ebank.Repository.IAdminRepo;
import com.example.ebank.Services.Dtos.AdminsDtos.AdminInputDto;
import com.example.ebank.Services.Dtos.AdminsDtos.AdminOutputDto;
import com.example.ebank.Services.Dtos.ClientDtos.ClientOutputDto;
import com.example.ebank.Services.Dtos.EmployeeDtos.EmployeeOutputDto;
import com.example.ebank.Services.Mappers.AdminMappers.AdminInputMapper;
import com.example.ebank.Services.Mappers.AdminMappers.AdminMapper;
import com.example.ebank.Services.Mappers.AdminMappers.AdminOutputMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminService  implements IAdminService {

    @Autowired
    private IAdminRepo iAdminRepo;
    @Autowired
    private AdminOutputMapper adminOutputMapper;
    @Autowired
    private AdminInputMapper adminInputMapper;
    @Autowired
    private AdminMapper adminMapper;
    @Override
    public AdminOutputDto getAdmin(String identification, String password) {
        Admin admin = iAdminRepo.findByIdentificationAndPassword(identification,password);
        return this.adminOutputMapper.toDto(admin);
    }

    @Override
    public AdminOutputDto getAdminById(long id) {
        Admin admin=iAdminRepo.findById(id).get();
                return this.adminOutputMapper.toDto(admin);
    }

    @Override
    public AdminOutputDto addAdmin(AdminInputDto admin) {
        Admin ad=this.adminInputMapper.toEntity(admin);
        Admin admin1 = iAdminRepo.save(ad);
        return this.adminOutputMapper.toDto(admin1);
    }

    @Override
    public AdminOutputDto updateAdmin(AdminInputDto admin,Long id) {
        Admin admin1= iAdminRepo.findById(id).get();
        Admin ad = this.adminInputMapper.toEntity(admin);
        ad=this.adminMapper.partialUpdate(admin1,ad);
        return this.adminOutputMapper.toDto(ad);
        }

    @Override
    public void deleteAdmin(long id) {
        Admin admin = this.iAdminRepo.findById(id).get();
        this.iAdminRepo.delete(admin);

    }


    @Override
    public AdminOutputDto getAdminByIdentificationNumber2(String id) {
        Admin admin=iAdminRepo.findByIdentificationNumber(id).get();
        AdminOutputDto adminOutputDto=adminOutputMapper.toDto(admin);
        return adminOutputDto;
    }
    @Override
    public Admin getAdminByIdentificationNumber(String id) {
                Admin admin=iAdminRepo.findByIdentificationNumber(id).get();
        return admin;
    }
    @Override
    public List<AdminOutputDto> getAllAdmins() {
        List<Admin> admins = this.iAdminRepo.findAll();
        return admins.stream()
                .map(adminOutputMapper::toDto)// Map each Client entity to AdminOutputDto using the mapper
                .collect(Collectors.toList()); // Collect the mapped ClientOutputDto objects into a list
    }



//    @Override
//    public void deleteAdmin(long id) {
//
//    }
//
//    @Override
//    public void deleteAdmin(Admin admin) {
//
//    }
//
//    @Override
//    public Admin getAdminByIdentificationNumber(String id) {
//        Admin admin=iAdminRepo.findByIdentificationNumber(id).get();
//        return admin;
//    }
}
