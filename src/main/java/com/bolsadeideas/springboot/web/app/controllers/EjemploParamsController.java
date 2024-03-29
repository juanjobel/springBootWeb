package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {

	@GetMapping("/")
	public String index (@RequestParam(defaultValue = "texto por defecto") String texto, Model model) {
		
		model.addAttribute("resultado", "El texto enviado es: "+texto);
		
		return "params/index";
	}
	
	@GetMapping("/string")
	public String paramString (@RequestParam(defaultValue = "texto por defecto") String texto, Model model) {
		
		model.addAttribute("resultado", "El texto enviado es: "+texto);
		
		return "params/ver";
	}
	
	@GetMapping("/mix-params")
	public String paramString (@RequestParam String saludo, @RequestParam Integer numero, Model model) {
		
		model.addAttribute("resultado", "El texto enviado es: "+saludo+" y el número es: "+numero);
		
		return "params/ver";
	}
}
