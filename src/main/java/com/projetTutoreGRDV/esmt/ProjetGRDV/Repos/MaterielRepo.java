package com.projetTutoreGRDV.esmt.ProjetGRDV.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetTutoreGRDV.esmt.ProjetGRDV.MaterielLabo;

public interface MaterielRepo extends JpaRepository<MaterielLabo, Integer> {

	MaterielLabo findById(int id);
	
//	public void materielleListAll() {
//		//Iterable<MaterielLabo> iterable = 
//	}*
	
	List<MaterielLabo> findByNom(String nom);
	
	
}
