package com.kh.aboo.myapt.institutions.controller;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;

import com.kh.aboo.user.admin.model.vo.Admin;
import com.kh.aboo.user.apartment.model.service.ApartmentService;
import com.kh.aboo.user.apartment.model.vo.Apartment;
import com.kh.aboo.user.generation.model.vo.Generation;

@RequestMapping("myapt")
@Controller
public class InstitutionsController {
	
	private final ApartmentService apartmentService;
	
	public InstitutionsController(ApartmentService apartmentService) {
		this.apartmentService = apartmentService;
	}
	
	/**
	 * @author: MinHee
	 * @Date: 2021. 3. 24.
	 * @work:
	 */
	@GetMapping("institutions")
	public String intList(HttpSession session, Model model) {
		Apartment apartment = new Apartment();
		
		if(session.getAttribute("generation") != null) {
			Generation generation = (Generation) session.getAttribute("generation");
			apartment = apartmentService.selectApartmentByIdx(generation.getApartmentIdx());
		}else if(session.getAttribute("admin") != null) {
			Admin admin = (Admin) session.getAttribute("admin");
			apartment = apartmentService.selectApartmentByIdx(admin.getApartmentIdx());
		}else {
			apartment.setApartmentAddress("공릉동");
			apartment.setApartmentLat("37.62613598143792");
			apartment.setApartmentLng("127.08042933625218");
		}
		
		model.addAttribute("apt", apartment);
		
		return "myapt/institutions/institutions";
	}
	
}
