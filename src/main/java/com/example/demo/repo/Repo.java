package com.example.demo.repo;

import java.util.List;

import javax.xml.crypto.Data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.demo.model.Datamodel;



@Repository
public interface Repo extends JpaRepository<Datamodel, Integer> 
{

	List<String> findIntensityBy();

	List<Datamodel> findByCountry(String c);

	List<Datamodel> findByTopic(String c);

	List<Datamodel> findByRegion(String c);

	List<Datamodel> findByCity(String c);





}
