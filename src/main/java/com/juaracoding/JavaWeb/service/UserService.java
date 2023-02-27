package com.juaracoding.JavaWeb.service;/*
IntelliJ IDEA 2022.3.2 (Ultimate Edition)
Build #IU-223.8617.56, built on January 26, 2023
@Author User a.k.a. Safril Efendi Lubis
Java Developer
Created on 2/27/2023 9:32 PM
@Last Modified 2/27/2023 9:32 PM
Version 1.1
*/
import com.juaracoding.JavaWeb.configuration.OtherConfig;
import com.juaracoding.JavaWeb.core.BcryptImpl;
import com.juaracoding.JavaWeb.model.User;
import com.juaracoding.JavaWeb.repo.UserRepo;
import com.juaracoding.JavaWeb.utils.LoggingFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.Random;

@Service
@Transactional
public class UserService {

    private UserRepo userRepo;

    private String [] strExceptionArr = new String[2];

    @Autowired
    public UserService(UserRepo userService) {
        strExceptionArr[0] = "UserService";
        this.userRepo = userService;
    }

    public String checkRegis(User userz) throws Exception {
        int intVerification = new Random().nextInt(100000,999999);
        List<User> listUserResult = userRepo.findByEmail(userz.getEmail());
//        User listUserResult = userRepo.findByEmail(userz.getEmail()).orElseThrow(
//                ()->null
//        );
        try
        {
            if(listUserResult.size()!=0)//kondisi mengecek apakah user terdaftar
//            if(listUserResult!=null)//kondisi mengecek apakah user terdaftar
            {
                if(listUserResult.get(0).getIsDelete()!=0)//sudah terdaftar dan aktif
//                if(listUserResult.getIsDelete()!=0)//sudah terdaftar dan aktif
                {
                    return "";
                }
            }
            else//belum terdaftar
            {
                userz.setPassword(BcryptImpl.hash(userz.getPassword()));
                userz.setToken(BcryptImpl.hash(String.valueOf(intVerification)));
                userRepo.save(userz);
            }
//            String [] strEmail = {userz.getEmail()};
//            SMTPCore sc = new SMTPCore();
//            ConfigProperties.getEmailPassword();
//            System.out.println(sc.sendMailWithAttachment(strEmail,
//                    "DEMO REGISTRATION -- TOKEN : "+intVerification,
//                    new ReadTextFileSB("\\data\\template-BCAF.html").getContentFile(),
//                    "SSL",
//                    new String[] {ResourceUtils.getFile("classpath:\\data\\sample.docx").getAbsolutePath()}));
            System.out.println("VERIFIKASI -> "+intVerification);
        }catch (Exception e)
        {
            System.out.println(e.getMessage()+" ---- "+e.getLocalizedMessage()+" ---- "+e.getCause());
            strExceptionArr[1]="checkRegis(User userz) --- LINE 62";
            LoggingFile.exceptionStringz(strExceptionArr,e, OtherConfig.getFlagLogging());
        }

        return userz.getEmail();//belum terdaftar ataupun sudah terdaftar namun belum aktif
    }
}
