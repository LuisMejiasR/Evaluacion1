package com.generation.controllers;

import com.generation.models.Mochila;
import com.generation.services.MochilaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
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

    //tercero para desplegar todos
    @RequestMapping("/mostrar")
    public String mostrar(Model model){
        //crear la lista de objetos para poderla mostrar en el jsp
        List<Mochila> listaMochilas = mochilaService.findAll();
        //con MODEL es que pasamos cosas al JSP
        model.addAttribute("mochilasCapturadas",listaMochilas);
        return "mochilas.jsp";
    }
    //cuarto para desplegar nuevamente los datos de la mochila editada
    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id,
                         Model model){
        Mochila mochila = mochilaService.buscarId(id);
        model.addAttribute("mochila", mochila);
        return "editarMochilas.jsp";
    }

    //quinto para guardar los datos en la base de datos, para la persistencia en la base de datos
    @PostMapping("/actualizar/{id}")
    public String actualizarAuto(@Valid @ModelAttribute("mochila") Mochila mochila,
                              BindingResult result,
                              Model model){
        if(result.hasErrors()){
            model.addAttribute("msgError","Ingreso incorrecto de datos");
            return "editarMochilas.jsp";
        }else {
            //capturamos el objeto con los atributos completos
            //y lo pasamos a service para que lo guarde
            mochilaService.saveMochila(mochila);
            return "redirect:/registro/mostrar";
        }

    }

    @RequestMapping("/eliminar/{id}")
    public String eliminar(@PathVariable("id") Long id){
        mochilaService.eliminarPorId(id);
        return "redirect:/registro/mostrar";
    }

}
