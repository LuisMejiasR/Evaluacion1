package com.agendamigo.controllers;

import com.agendamigo.models.Usuario;
import com.agendamigo.services.UsuarioService;
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

@Controller
@RequestMapping("/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    //1ruta para desplegar jsp
    @RequestMapping("")
    public String desplegar(@ModelAttribute("usuario") Usuario usuario){
        return "index.jsp";
    }
    //2ruta para guardar los datos que nos pasa el usuario
    @PostMapping("/guardar")
    public String guardar(@Valid @ModelAttribute("usuario") Usuario usuario,
                          BindingResult result,
                          Model model){
        if(result.hasErrors()){
            model.addAttribute("msgError","Ingreso incorrecto de datos");
            return "index.jsp";
        }else {
            //capturamos el objeto con los atributos lleno y lo pasamos al sercie para que lo guarde
            usuarioService.guardarUsuario(usuario);
            //creamos la lista de usuarios para poder mostrar la tabla
            List<Usuario> listaUsuarios = usuarioService.findAll();
            //con model pasamos los objetos al JSP
            model.addAttribute("usuariosCapturados", listaUsuarios);
            return "tabla.jsp";
        }
    }
    //3ruta para mostrar la tabla solamente
    @RequestMapping("/tabla")
    public String tabla(Model model){
        //creamos la lista de usuarios para poder mostrar la tabla
        List<Usuario> listaUsuarios = usuarioService.findAll();
        //con model pasamos los objetos al JSP
        model.addAttribute("usuariosCapturados", listaUsuarios);
        return "tabla.jsp";
    }
    //4ruta para desplegar los datos en el jsp
    @RequestMapping("/editar/{id}")
    public String editar(@PathVariable("id") Long id,
                         Model model){
        Usuario usuario = usuarioService.buscarId(id);
        model.addAttribute("usuario",usuario);
        return "editarUsuario.jsp";
    }
    //5ruta para guardar los datos editados en el jsp
    @PostMapping("/actualizar/{id}")
    public String actualizar(@PathVariable("id")Long id,
                             @Valid @ModelAttribute("usuario") Usuario usuario,
                          BindingResult result,
                          Model model){
        if(result.hasErrors()){
            model.addAttribute("msgError","Ingreso incorrecto de datos");
            return "editarUsuario.jsp";
        }else {
            usuario.setId(id);
            //capturamos el objeto con los atributos lleno y lo pasamos al sercie para que lo guarde
            usuarioService.guardarUsuario(usuario);
            return "redirect:/usuario/tabla";
        }
    }
    //6ruta para eliminar
    @RequestMapping("/eliminar/{id}")
    public String eliminarUsuario(@PathVariable("id") Long id){
        usuarioService.eliminarPorId(id);
        return "redirect:/usuario/tabla";
    }

}
