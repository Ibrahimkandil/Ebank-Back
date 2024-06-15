package com.example.ebank.Controllers;

import com.example.ebank.Services.AdminService;
import com.example.ebank.Services.Dtos.AdminsDtos.AdminOutputDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/admin")
public class AdminController {
    @Autowired
    private AdminService adminService;

    @GetMapping
    public  String SayHello(){
        return "Hello it's Admin";
    }


    @GetMapping("/all")
    public List<AdminOutputDto> getAllAdmins() {
        return this.adminService.getAllAdmins();
    }

    @GetMapping("/{id}")
    public AdminOutputDto getClientById(@PathVariable Long id){
        return adminService.getAdminById(id);
    }
}
