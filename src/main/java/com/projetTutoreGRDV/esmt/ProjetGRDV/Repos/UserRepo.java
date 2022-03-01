package com.projetTutoreGRDV.esmt.ProjetGRDV.Repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.projetTutoreGRDV.esmt.ProjetGRDV.User;

public interface UserRepo extends JpaRepository<User, Integer>{

	List <User> findByEmailAndPassword(String email,String password);
}
