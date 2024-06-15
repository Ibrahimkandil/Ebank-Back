package com.example.ebank.Config.service.Serviceimpl;


import com.example.ebank.Config.service.UserService;
import com.example.ebank.Repository.*;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final IClientRepo iClientRepo;
    private final IAdminRepo iAdminRepo;
    private final IEmployeeRepo iEmployeeRepo;



    @Override
    public UserDetailsService userDetailsService() {
        return new UserDetailsService() {
            @Override
            public UserDetails loadUserByUsername(String identificationNumber) {
                if(identificationNumber.charAt(0)=='0'){
                    return (UserDetails) iAdminRepo.findByIdentificationNumber(identificationNumber).orElseThrow(() -> new UsernameNotFoundException("User not found"));
                }else if (identificationNumber.charAt(0)=='1') {
                    return (UserDetails) iEmployeeRepo.findByIdentificationNumber(identificationNumber).orElseThrow(() -> new UsernameNotFoundException("User not found"));
                }else{
                    return (UserDetails) iClientRepo.findByIdentificationnumber(identificationNumber).orElseThrow(() -> new UsernameNotFoundException("User not found"));

                }

            }
        };
    }

}
