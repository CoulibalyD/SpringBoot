package com.projetTutoreGRDV.esmt.ProjetGRDV.Service;

import java.util.List;
import java.util.Optional;

import javax.naming.NameNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;

import com.projetTutoreGRDV.esmt.ProjetGRDV.MaterielLabo;
import com.projetTutoreGRDV.esmt.ProjetGRDV.Repos.MaterielRepo;

@org.springframework.stereotype.Service
public class Service {

	@Autowired
	private MaterielRepo materielRepo;
	
	public List<MaterielLabo> listAll(){
		return(List<MaterielLabo>) materielRepo.findAll();
	}
	
	
	
	public MaterielLabo get(Integer id)  throws Exception{
		Optional<MaterielLabo> result = materielRepo.findById(id);
		if(result.isPresent()) {
			return result.get();
		}
		throw new Exception(" id materiel introuval" + id);
	}
}
