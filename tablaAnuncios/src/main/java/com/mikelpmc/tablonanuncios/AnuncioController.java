package com.mikelpmc.tablonanuncios;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicInteger;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class AnuncioController {

	private Map<Integer, Anuncio> anuncios = new ConcurrentHashMap<>();
	private AtomicInteger id = new AtomicInteger();
	
	public AnuncioController() {
		int anuncioId1 = id.getAndIncrement();
		anuncios.put(anuncioId1, new Anuncio(anuncioId1, "Anuncio1", "Asunto1", ""));
		
		int anuncioId2 = id.getAndIncrement();
		anuncios.put(anuncioId2, new Anuncio(anuncioId2, "Anuncio2", "Asunto2", ""));
	}
	
	@RequestMapping("/")
	public String anuncios(Model model) {
		
		model.addAttribute("anuncios", anuncios.values());
		
		return "anuncios";
	}
	
	@RequestMapping("/anuncio/{id}")
	public String anuncio(Model model, @PathVariable int id) {
		
		Anuncio anuncio = anuncios.get(id);
		
		model.addAttribute("anuncio", anuncio);
		
		return "anuncio";
	}
	
	@RequestMapping("/guardaranuncio")
	public String guardarAnuncio(Model model, Anuncio anuncio) {
		
		int anuncioId = id.getAndIncrement();
		
		anuncio.setId(anuncioId);
		
		anuncios.put(anuncioId, anuncio);
		
		return "anuncioGuardado";
	}
	
	
	
}
