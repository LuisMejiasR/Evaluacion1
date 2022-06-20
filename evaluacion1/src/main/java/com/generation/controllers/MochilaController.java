package com.generation.controllers;

import com.generation.models.Mochila;
import com.generation.services.MochilaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import java.util.List;

//apellidos
@Controller
@RequestMapping("/registro")
public class MochilaController {
    @Autowired
    MochilaService mochilaService;

    //primer metodo para desplegar el jsp
    @RequestMapping("")
    public String mochila(@ModelAttribute("mochila") Mochila mochila){
        return "index.jsp";
    }

    //ruta para capturar los datos de mochila
    @PostMapping("/mochila")
    public String guardarAuto(@Valid @ModelAttribute("mochila") Mochila mochila,
                              BindingResult result,
                              Model model){
        if(result.hasErrors()){
            model.addAttribute("msgError","Ingreso incorrecto de datos");
            return "index.jsp";
        }else {
            //capturamos el objeto con los atributos completos
            System.out.println(mochila.getModelo() + " " + mochila.getColor() + " " + mochila.getCapacidad());

            //y lo pasamos a service para que lo guarde
            mochilaService.saveMochila(mochila);

            //crear la lista de objetos para poderla mostrar en el jsp
            List<Mochila> listaMochilas= mochilaService.findAll();
            //con MODEL es que pasamos cosas al JSP
            model.addAttribute("mochilasCapturadas",listaMochilas);
            return "mochilas.jsp";
        }

    }

    @RequestMapping("/mostrar")
    public String mostrar(Model model){
        //crear la lista de objetos para poderla mostrar en el jsp
        List<Mochila> listaMochilas = mochilaService.findAll();
        //con MODEL es que pasamos cosas al JSP
        model.addAttribute("mochilasCapturadas",listaMochilas);
        return "mochilas.jsp";
    }

}
