package com.projetTutoreGRDV.esmt.ProjetGRDV.Repos;

//import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetTutoreGRDV.esmt.ProjetGRDV.Admin;

public interface AdminRepo extends JpaRepository<Admin, Integer> {

//	List<Admin> findByLoginPassword(String login, String password);
}
