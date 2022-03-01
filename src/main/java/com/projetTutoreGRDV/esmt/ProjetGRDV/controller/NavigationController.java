package com.projetTutoreGRDV.esmt.ProjetGRDV.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.projetTutoreGRDV.esmt.ProjetGRDV.Answer;
import com.projetTutoreGRDV.esmt.ProjetGRDV.MaterielLabo;
import com.projetTutoreGRDV.esmt.ProjetGRDV.Rdv;
import com.projetTutoreGRDV.esmt.ProjetGRDV.User;
import com.projetTutoreGRDV.esmt.ProjetGRDV.Repos.AdminRepo;
import com.projetTutoreGRDV.esmt.ProjetGRDV.Repos.AwserRepo;
import com.projetTutoreGRDV.esmt.ProjetGRDV.Repos.MaterielRepo;
import com.projetTutoreGRDV.esmt.ProjetGRDV.Repos.RdvRepo;
import com.projetTutoreGRDV.esmt.ProjetGRDV.Repos.UserRepo;
import com.projetTutoreGRDV.esmt.ProjetGRDV.Service.Service;


@Controller
public class NavigationController {

	@Autowired private Service service;
	
	@Autowired
	AwserRepo awserRepo;
	@Autowired
	AdminRepo adminRepo;
	@Autowired
	UserRepo repo;
	@Autowired
	MaterielRepo materielRepo;
	@Autowired
	RdvRepo rdvRepo;
/************************************************************************/
	/***
	 * Creation Patient
	 * @return
	 */
	@RequestMapping("/inscription")
	public String indexPage() {
		return "inscription";
	}
	
	@RequestMapping("/inscriptEffe")

	public String savePatient(User p)
	{
		repo.save(p);
		return "inscriptEffe";
	}
/***************************************f************************************/
	/****
	 * Creation Rendez-vous
	 * @return
	 */
	@RequestMapping("/rdv")
	public String rdv() {
		return "connexion";
	}
	
	@RequestMapping("/rdvAdd")
	public String saverdv(Rdv dv)
	{
		rdvRepo.save(dv);
		return "rdvAdd";
	}
/***************************************************************************/
	/****
	 * Creation Personnel Sante
	 * @return
	 */
	@RequestMapping("/gestion")
	public String indexGes() {
		return "gestion";
	}
	
	@RequestMapping("/gestionAdd")
	public String saveDocteur(User p)
	{
		repo.save(p);
		return "gestionAdd";
	}
/***************************************************************************/
	/****
	 * Creation Reponse-rdv
	 * @return
	 */
	@RequestMapping("/consultation")
	public String answ() {
		return "connexion";
	}
	
	@RequestMapping("/consulAdd")
	public String saveRecep(Answer ans)
	{
		awserRepo.save(ans);
		return "consulAdd";
	}
/***************************************************************************/
	/****
	 * Creation Materiel
	 * @return
	 */
	
	@RequestMapping("/deleteLabo/{id}")
	public String deleteLabo(@PathVariable("id") Integer id, Model model) {
		materielRepo.findById(id);
		model.addAttribute("laboUpdate", "laboUpdate")	;	
		model.addAttribute("pageTitle ", "Le materiel "+ id + "Supprimer avec success");
		return "laboDelete";
	}
	@RequestMapping("/findLabo")
	public String findLabo(String nom, Model model) {
		List<MaterielLabo> lismat = materielRepo.findByNom(nom);
		model.addAttribute("lismat", lismat);
		model.addAttribute("labo", "labo")	;	
		return "labo";
	}
	@RequestMapping("/deleteLabo")
	public String deleteLabo() {
		return "laboDelete";
	}
	@RequestMapping("/laboAjou")
	public String laboAjou() {  
		return "laboAjou";
	}
	@RequestMapping("/UpdateLabo")
	public String laboUp() {
		return "laboUpdate";
	}
	@GetMapping("/UpdateLabo/{id}")
	public String laboUp(@PathVariable("id") Integer id, Model model) {
		materielRepo.findById(id);
		model.addAttribute("laboUpdate", "laboUpdate")	;	
		model.addAttribute("pageTitle ", "Mise à jour du materiel numero "+ id + "");
		return "laboUpdate";
	}
	
	@RequestMapping("/laboAdd")
	public String savelabo(Model model,MaterielLabo mat, RedirectAttributes ra)
	{
		materielRepo.save(mat);
		List<MaterielLabo> lismat = service.listAll();
		model.addAttribute("lismat", lismat);
		ra.addFlashAttribute("message", "Le Materiel est ajouter avec success");
		return "redirect:/labo";
	}
/***************************************************************************/
/***************************************************************************/
	/****
	 * Creation Reception
	 * @return
	 */
	@RequestMapping("/receptions")
	public String recps() {
		return "reception";
	}
	
	
	/***
	 * DELETE MATERIELLE
	 * @param id
	 * @return
	 */
	
	@RequestMapping("/delete")
	public String deleteda(Model model,@RequestParam("id") int id, RedirectAttributes ra)
	{
		try {
			service.get(id);
		} catch (Exception e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		 MaterielLabo labo  = materielRepo.findById(id);
			try {
				materielRepo.deleteById(id);
				
			} catch (Exception e) {
				
			}
			ra.addFlashAttribute("danger", "Le "+labo.getId()+" Materiel supprimer avec success");
			List<MaterielLabo> lismat = service.listAll();
			model.addAttribute("lismat", lismat);
		return "redirect:/labo";
	}
	/***
	 * UPDATE MATERIELLE
	 * @param id
	 * @param nom
	 * @param etat
	 * @return
	 */
	
	@RequestMapping("/updates")
	public String UpdateLabo(Model model, @RequestParam("id") int id, @RequestParam("nom") String nom, @RequestParam("etat") String etat, RedirectAttributes ra)
	{
		MaterielLabo labos = materielRepo.findById(id);
		labos.setNom(nom);
		labos.setEtat(etat);
		materielRepo.save(labos);
		List<MaterielLabo> lismat = service.listAll();
		model.addAttribute("lismat", lismat);
		ra.addFlashAttribute("info", "Le Materiel "+labos.getId()+" est mis à jour avec success " );
		return "redirect:/labo";
	}
	
	
/***************************************************************************/
    
    @GetMapping("/covid")
    public String getCovid(Model model){
        model.addAttribute("activePage", "covid");
        return "covid";
        
    }
    
    
    @GetMapping("/connexion")
    public String getConnexion(Model model){
        model.addAttribute("activePage", "connexion");
        return "connexion";
        
    }
    
   
    @GetMapping("/contact")
    public String getContact(Model model){
        model.addAttribute("activePage", "contact");
        return "contact";
    }
    
    @GetMapping("/reception")
    public String getReception(Model model){
        model.addAttribute("activePage", "reception");
        return "reception";
    }
    
    
    @GetMapping("/admin")
    public String getAdmin(Model model){
        model.addAttribute("activePage", "admin");
        return "admin";
    }
    /***************************************************************************/
    /***************************************************************************/
    @PostMapping("/connexion")
    public String authentification(@ModelAttribute("user") User user, Model model)
    {
    	List<User> list = repo.findByEmailAndPassword(user.getEmail(), user.getPassword());
    	
    		if(list.size() == 0) {
        		return "connexion";
        	}
    		
    			User users = list.get(0);
        		if(users.getType().compareTo("Medecin") == 0)
        		{
        			List<Rdv> listpatient = rdvRepo.findAll();
        			model.addAttribute("listpatient", listpatient);
        			return "consultation";
        		}else if(users.getType().compareTo("patient") == 0)
        		{
        			List<Answer> listanwser = awserRepo.findAll();
        			model.addAttribute("listanwser", listanwser);
        			return "rdv";
        		}else if(users.getType().compareTo("Laborantin") == 0)
        		{
     
        			List<MaterielLabo> lismat = service.listAll();
        			model.addAttribute("lismat", lismat);
        			
        			return "labo";
        		}
        		else if(users.getType().compareTo("Administrateur") == 0)
        		{
        			return "gestion";
        		}	
        	
    	return "connexion";
    	
    }
    @RequestMapping("/labo")
	public String labo(Model model) {
    	List<MaterielLabo> lismat = service.listAll();
		model.addAttribute("lismat", lismat);
		return "labo";
	}
    
    
    

}
