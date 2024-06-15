package com.example.ebank.Services;

import com.example.ebank.Entity.Admin;
import com.example.ebank.Services.Dtos.AdminsDtos.AdminInputDto;
import com.example.ebank.Services.Dtos.AdminsDtos.AdminOutputDto;
import com.example.ebank.Services.Dtos.ClientDtos.ClientOutputDto;

import java.util.List;

public interface IAdminService {
    public List<AdminOutputDto> getAllAdmins();

    public AdminOutputDto getAdminByIdentificationNumber2(String id);
    AdminOutputDto getAdmin(String identification, String password);
    public AdminOutputDto getAdminById(long id) ;
    AdminOutputDto addAdmin(AdminInputDto admin);
    AdminOutputDto updateAdmin(AdminInputDto admin, Long id);
    public void deleteAdmin(long id);

    public Admin getAdminByIdentificationNumber(String id);
}
