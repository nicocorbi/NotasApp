package com.example.notas.Controller;

public class controlador {
    public String encriptarCesar(String textoPlano, int desplazamiento) {


        String textoCifrado = "";

        for (char caracter : textoPlano.toCharArray()) {
            if (Character.isUpperCase(caracter)) {
                char base = 'A';
                textoCifrado += (char) (((caracter - base + desplazamiento) % 26) + base);
            } else if (Character.isLowerCase(caracter)) {
                char base = 'a';
                textoCifrado += (char) (((caracter - base + desplazamiento) % 26) + base);
            } else if (Character.isDigit(caracter)) {
                char base = '0';
                textoCifrado += (char) (((caracter - base + desplazamiento) % 10) + base);
            } else {
                textoCifrado += caracter;
            }
        }

        return textoCifrado;
    }

}
