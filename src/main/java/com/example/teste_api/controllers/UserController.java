package com.example.teste_api.controllers;

import com.example.teste_api.dtos.UserDto;
import com.example.teste_api.enums.UserRoleEnums;
import com.example.teste_api.models.CompanyModel;
import com.example.teste_api.models.ProductModel;
import com.example.teste_api.models.UserModel;
import com.example.teste_api.repositories.UserRepository;
import com.example.teste_api.services.AutorizationService;
import com.example.teste_api.services.CompanyService;
import com.example.teste_api.services.UserSevice;
import jakarta.validation.Valid;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@RestController
public class UserController {
    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private UserSevice userSevice;

    @Autowired
    private CompanyService companyService;

    @Autowired
    private AutorizationService autorizationService;





    @PostMapping("/user/{companyId}")
    public ResponseEntity<?> saveEmployee(@PathVariable UUID companyId, @RequestBody @Valid UserDto userDto){

            Optional<CompanyModel> comp0 = companyService.getCompany(companyId);
            if(comp0.isEmpty()){
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("empresa inválida, por favor digite um id válido");
            }

            return ResponseEntity.status(HttpStatus.CREATED).body(userSevice.addUserEmployee(userDto));

        }


    @PostMapping("/login")
    public ResponseEntity<?> login(UserDto userDto){
        Authentication authentication = new UsernamePasswordAuthenticationToken(userDto.email(),userDto.pasword());
        authenticationManager.authenticate(authentication);

        UserModel user =  userSevice.findUser( userDto.email());
        if(user == null){
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("O usuario nao está cadastrado no sistema");
        }

        String Token =  autorizationService.generateToken( user.getUuid(),user.getCompany().getUuid());


        return ResponseEntity.status(HttpStatus.OK).body(Token);
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> getEmployee(@PathVariable UUID userId){


        return ResponseEntity.status(HttpStatus.OK).body(userSevice.findUserById(userId));
    }

    @GetMapping("/user/{userId}")
    public ResponseEntity<?> deleteEmployee(@PathVariable UUID userId){
        userSevice.deleteUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body("usuário deletado com sucesso");
    }

    @GetMapping("/user/{companyId}")
        public ResponseEntity<?> getAllEmployee(@PathVariable UUID companyId){
            return ResponseEntity.status(HttpStatus.OK).body(companyService.getCompany(companyId).get().getEmployeelist());
        }












    }









