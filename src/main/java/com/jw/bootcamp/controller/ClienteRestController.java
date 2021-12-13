package com.jw.bootcamp.controller;

import java.util.*;

import com.jw.bootcamp.model.Pokemon;

// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

public class ClienteRestController {

    private static final String  URL = "https://pokeapi.co/api/v2/pokemon/{id}";

    static RestTemplate restTemplate = new RestTemplate();
    public static void main(String[] args) {
        listaPokemones(10);
    }

    private static Pokemon consumoPorId(Integer id){
        Map<String,Integer> parametros = new HashMap<>();
        parametros.put("id", id);
        Pokemon pokemon = restTemplate.getForObject(URL, Pokemon.class, parametros);
        return pokemon;
    }

    private static List<Pokemon> listaPokemones(Integer index){
        List<Pokemon> listaPokemon = new ArrayList<>();
        for(int i = 1; i <= index ; i++){
            listaPokemon.add(consumoPorId(i));
        }
        System.out.println(listaPokemon);
        return listaPokemon;
    }

    // @GetMapping
    // public String entregaLista(Model model){

    // }
}
