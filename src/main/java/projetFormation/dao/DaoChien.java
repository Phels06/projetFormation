package projetFormation.dao;

import java.util.List;

import projetFormation.entity.Chien;

public interface DaoChien extends DaoGeneric<Chien, Integer> {
	List<Chien> findBySurnom(String surnom);
	
}
