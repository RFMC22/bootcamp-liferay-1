package com.jw.bootcamp.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class GeneradorEncriptado {
    public static void main(String[] args) {
        BCryptPasswordEncoder encriptado = new BCryptPasswordEncoder();
        String passwordNormal = "123";
        String passwordEncriptado = encriptado.encode(passwordNormal);

        System.out.println(passwordEncriptado);
    }
}
