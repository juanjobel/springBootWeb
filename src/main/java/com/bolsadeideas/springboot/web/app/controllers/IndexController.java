package com.bolsadeideas.springboot.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	@Value("${texto.indexcontroller.index.titulo}")
	private String textoIndex;
	
	@Value("${texto.indexcontroller.perfil.titulo}")
	private String textoPerfil;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textoListar;
	
	@GetMapping({"/index","/", "","/home"})
	public String index(Model model) {
		model.addAttribute("titulo", textoIndex);
		return "index";
	}
	
	/*@GetMapping({"/index","/","/home"})
	public String index(ModelMap model) {
		model.addAttribute("titulo", "Hola mundo");
		return "index";
	}*/
	
	/*@GetMapping({"/index","/","/home"})
	public String index(Map<String, Object> map) {
		map.put("titulo", "Hola mundo con Map");
		return "index";
	}*/
	
	
	/*@GetMapping({ "/index", "/", "/home" })
	public ModelAndView index(ModelAndView mv) {
		mv.addObject("titulo", "Hola mundo con ModelAndView");
		mv.setViewName("index");
		return mv;
	}*/
	
	@RequestMapping("/perfil")
	public String perfil(Model model) {
		
		Usuario usuario = new Usuario();
		usuario.setNombre("Juan José");
		usuario.setApellido("Beltrán Martín");
		usuario.setEmail("juan@correo.com");
		
		model.addAttribute("titulo", textoPerfil.concat(usuario.getNombre()));
		model.addAttribute("usuario", usuario);
		
		return "perfil";
	}

	@RequestMapping("/listar")
	public String listar(Model model) {
		
		/*
		 * List<Usuario>usuarios= new ArrayList<>(); 
		 * usuarios.add(new Usuario("Juan","Beltrán", "juan@correo.com"));
		 * usuarios.add(new Usuario("Silvia","García", "silvia@correo.com"));
		 * usuarios.add(new Usuario("Daniel","Beltrán", "dani@correo.com"));
		 */
		
		List<Usuario>usuarios= Arrays.asList(new Usuario("Juan","Beltrán", "juan@correo.com"),
				new Usuario("Silvia","García", "silvia@correo.com"),new Usuario("Daniel","Beltrán", "dani@correo.com"),
				new Usuario("Manuela","Bocanegra", "manuela@correo.com"));
		model.addAttribute("titulo",textoListar); 
		//model.addAttribute("usuarios", usuarios);
		
		
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<Usuario> poblarUsuarios(){
		List<Usuario>usuarios= Arrays.asList(new Usuario("Juan","Beltrán", "juan@correo.com"),
				new Usuario("Silvia","García", "silvia@correo.com"),new Usuario("Daniel","Beltrán", "dani@correo.com"),
				new Usuario("Manuela","Bocanegra", "manuela@correo.com"));
		return usuarios;
	}

}
