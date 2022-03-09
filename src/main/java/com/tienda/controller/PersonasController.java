/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.tienda.controller;

/**
 *
 * @author fabia
 */

import com.tienda.entity.Persona;
import com.tienda.service.IPersonaService;
import java.util.List;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@Slf4j
public class PersonasController {
 
    @Autowired
    private IPersonaService personaService;
    
    @GetMapping("/personas")
    public String index(Model model){
    
        List<Persona> listaPersonas=personaService.getAllPerson();
        model.addAttribute("titulo","Personas");
        model.addAttribute("personas", listaPersonas);
        return "personas";
    
    }
    
    @GetMapping("/personasN")
    public String crearPersona(Model model){
    
        model.addAttribute("persona", new Persona());
        
        return "crear";
    
    }
    
    @PostMapping("/save")
    public String guardarPersona(@ModelAttribute Persona persona){
    
        personaService.savePerson(persona);
        return "redirect:/persona";
        
    }
    
    @GetMapping("/delete/{id}")
    public String eliminarPersona(@PathVariable("id") Long id){
    
        personaService.delete(id);
        return "redirect:/persona";
    
    }
    
    /*
    @GetMapping("/modificarPersona/ {idPersona}")
    public String modificarPersona(Persona persona, Model model){
    
        persona = personaService.find(persona);
        model.addAttribute("persona", persona);
        return "modificarPersona";
        
    }
    */
}