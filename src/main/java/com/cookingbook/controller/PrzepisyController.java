package com.cookingbook.controller;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;
import javax.sql.rowset.serial.SerialException;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.cookingbook.model.Komentarz;
import com.cookingbook.model.Przepis;
import com.cookingbook.service.KomentarzService;
import com.cookingbook.service.PrzepisService;

@Controller
public class PrzepisyController {
    @Autowired
    private PrzepisService przepisService;
    
    @Autowired
    private KomentarzService komentarzService;
    
    @GetMapping("/dodajPrzepis")
    public String przepisy(Model model) {
        model.addAttribute("przepisForm", new Przepis());
    	model.addAttribute("listaPrzepisow", przepisService.getPrzepisy());
        return "dodajPrzepis";
    }

    @PostMapping("/dodajPrzepis")
    public String dodajPrzepisy(@RequestParam("zdjecie") MultipartFile zdjecie, 
    		@RequestParam("opis") String opis, 
    		@RequestParam("rodzajPotrawy") String rodzajPotrawy,
    		@RequestParam("poziomTrudnosci") String poziomTrudnosci,
    		@RequestParam("czasWykonania") String czasWykonania
    		)throws IOException, SerialException, SQLException {
    	byte[] zdjecieBytes = zdjecie.getBytes();
    	Blob blob = new javax.sql.rowset.serial.SerialBlob(zdjecieBytes);
    	Przepis przepis = new Przepis();
    	przepis.setOpis(opis);
    	przepis.setRodzajPotrawy(rodzajPotrawy);
    	przepis.setPoziomTrudnosci(poziomTrudnosci);
    	przepis.setCzasWykonania(czasWykonania);
    	przepis.setZdjecie(blob);
        przepisService.save(przepis);

        return "redirect:/dodajPrzepis";
    }
    
    @RequestMapping(value = "/przepis/{id}", method = RequestMethod.GET)
    public String getPrzepisWithId(@PathVariable Long id,  Model model) {
    	model.addAttribute("przepisById", przepisService.getPrzepisById(id).iterator().next());
    	model.addAttribute("komentarzeDoPrzepisu", komentarzService.getKomentarzByPrzepisId(id));
    	return "przepis";
    	
    }
    
    @RequestMapping(value = "/przepis/{id}", method = RequestMethod.POST)
    public String dodajKomentarz(@PathVariable Long id,  Model model, @ModelAttribute("komentarzForm") Komentarz komentarzForm) {
    	komentarzService.save(komentarzForm, przepisService.getPrzepisById(id).iterator().next());
    	return "redirect:/przepis/"+id;
    	
    }
    
    @RequestMapping(value = "/filters", method = RequestMethod.GET)
    public String getWynikFiltrowania( Model model) {
    	return "filters";
    }
    
    @RequestMapping(value = "/filters", method = RequestMethod.POST)
    public String filtrujPrzepisy(Model model, @ModelAttribute("przepisFilterForm") Przepis przepis) {
    	Set<Przepis> przepisyUserNazwaUzytkownika = przepisService.getPrzepisyByUserUsername(przepis.getCzasWykonania());
    	Set<Przepis> przepisyRodzajPotrawy = przepisService.getPrzepisyByRodzajPotrawy(przepis.getRodzajPotrawy());
    	Set<Przepis> przepisyPoziomTrudnosci = przepisService.getPrzepisyByPoziomTrudnosci(przepis.getPoziomTrudnosci());
    	przepisyRodzajPotrawy.retainAll(przepisyPoziomTrudnosci);
    	przepisyRodzajPotrawy.retainAll(przepisyUserNazwaUzytkownika);
    	model.addAttribute("listaPrzepisow", przepisyRodzajPotrawy);
    	return "filters";
    	
    }
    
	@RequestMapping(value = "/getZdjecie/{id}")
	public void getZdjecie(HttpServletResponse response, @PathVariable("id") long id){
		try {
			response.setContentType("image/jpeg");
			Blob blob = przepisService.getJedenPrzepisById(id).getZdjecie();
			byte[] bytes =  blob.getBytes(1, (int) blob.length());
			InputStream inputStream = new ByteArrayInputStream(bytes);
			IOUtils.copy(inputStream, response.getOutputStream());
		}catch(Exception e) {}
	}
}
