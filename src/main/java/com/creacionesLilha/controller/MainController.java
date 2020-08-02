package com.creacionesLilha.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.creacionesLilha.model.Producto;
import com.creacionesLilha.model.Usuario;
import com.creacionesLilha.service.usuarioService;
import com.creacionesLilha.service.usuarioServiceImp;




@Controller
@RequestMapping
public class MainController {

	//Inyeccción de clases
	@Autowired
	private Producto producto;
	
	@Autowired
	private Usuario usuario;
	
	@Autowired
	private usuarioService usuarioService;
	
	//home
	@GetMapping("/home") 
	public String main(Model model) {
		return "home";
	}
	
	//productos
	@GetMapping("/barbijos") 
	public String barbijos(Model model) {
		return "barbijos";
	}
	
	@GetMapping("/gorras") 
	public String gorras(Model model) {
		return "gorras";
	}
	
	@GetMapping("/mochilas") 
	public String mochilas(Model model) {
		return "mochilas";
	}
	
	@GetMapping("/sombreros") 
	public String sombreros(Model model) {
		return "sombreros";
	}
	
	//agregar un producto
	@GetMapping("/agregarProducto")
	public String agregarProducto(Model model) {
		model.addAttribute("AgregarProductos", producto);
		return "productoForm";
	}
	
	//Usuario
	@GetMapping("/nuevoUsuario")
	public String agregarU(Model model) {
		model.addAttribute("usuarioD", usuario);
		return "login";
	}
	@PostMapping("/saveUsuario")
	public String guardarU(@ModelAttribute Usuario usuario, Model model) {
		usuarioService.guardarUsuario(usuario);
		model.addAttribute("usuarioD", usuario);
		return "redirect:/login";
	}
	
	//contacto
	@GetMapping("/contacto") 
	public String contacto(Model model) {
		return "contacto";
	}
	
	//login
	@GetMapping("/login") 
	public String login(Model model) {
		return "login";
	}
}
