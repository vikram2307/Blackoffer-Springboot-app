package com.example.demo.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.dao.dao;
import com.example.demo.model.Datamodel;


@RestController

public class DataController 
{

	@Autowired
	dao cs;
	@RequestMapping("/api/v1")
	    public List<Datamodel> getAllData() {
	        return cs.display(); // Implement this method in your DataService
	   
	  }
	@GetMapping("/years")
	 public List<String> fetchAllStartYears() {
			List<String> data = cs.fetchAllStartYears();
	        return data;
	    }
	@GetMapping("/endyears")
	 public List<String> fetchAllEndYears() {
		 List<String> data = cs.fetchAllEndYears();
	        return data;
	    }
	@GetMapping("/intensity/all/startyear")
	 public List<String> fetchYearIntensity() {
	     
		 List<String> sumIntensity= cs.fetchStartYearIntensity();
	        return sumIntensity;
	    }	
	
	
	@GetMapping("/intensity/all/endyear")
	 public List<String> fetchEndYearIntensity() {
	     
		 List<String> sumIntensity= cs.fetchEndYearIntensity();
	        return sumIntensity;
	    }	
	
	
	
	
	@GetMapping("/likelihoodbystartyear")
	public List<String> fetchLikelihoodByStartYear() {
	   
		 List<String> sumLikelihood = cs.fetchStartYearLikelihood();
	        return sumLikelihood;
	}
	
	@GetMapping("/likelihoodbyendyear")
	public List<String> fetchLikelihoodByEndYear() {
	   
		 List<String> sumLikelihood = cs.fetchEndYearLikelihood();
	        return sumLikelihood;
	}
	
	@GetMapping("/Relevancebystartyear")
	public List<String> fetchRelevanceByStartYear() {
	   
		 List<String> sumRelevance= cs.fetchStartYearRelevance();
	        return sumRelevance;
	}
	
	@GetMapping("/Relevancebyendyear")
	public List<String> fetchRelevanceByEndYear() {
	   
		 List<String> sumRelevance = cs.fetchEndYearRelevance();
	        return sumRelevance;
	}
	
	
	//Country operations
	@GetMapping("/Country")
	 public List<String> fetchAllCountry() {
		 List<String> data = cs.fetchCountry();
	        return data;
	    }	 
	@GetMapping("/Country/intensity")
	 public List<String> fetchCountryIntensity() {
	     
		 List<String> sumIntensity= cs.fetchCountryIntensity();
	        return sumIntensity;
	    }	
	@GetMapping("/Country/relevance")
	 public List<String> fetchCountryRelevance() {
	     
		 List<String> sumIntensity= cs.fetchCountryRelevance();
	        return sumIntensity;
	    }
	@GetMapping("/Country/likelihood")
	 public List<String> fetchCountryLikelihood() {
	     
		 List<String> sumIntensity= cs.fetchCountryLikelihood();
	        return sumIntensity;
	    }
	
	
	//Topics operations
	@GetMapping("/Topics")
	 public List<String> fetchAllTopics() {
		 List<String> data = cs.fetchTopics();
	        return data;
	    }
	@GetMapping("/Topic/intensity")
	 public List<String> fetchTopicIntensity() {
	     
		 List<String> sumIntensity= cs.fetchTopicIntensity();
	        return sumIntensity;
	    }	
	@GetMapping("/Topic/likelihood")
	 public List<String> fetchTopiclikelihood() {
	     
		 List<String> sumIntensity= cs.fetchTopiclikelihood();
	        return sumIntensity;
	    }	
	@GetMapping("/Topic/relevance")
	 public List<String> fetchTopicRelevance() {
	     
		 List<String> sumIntensity= cs.fetchTopicRelevance();
	        return sumIntensity;
	    }	
	
	@GetMapping("/Topic/Country/")
	public List<String> fetchTopicCountry(@RequestParam(name = "Country", required = false) String country) {
	    if (country != null) {
	        List<String> data = cs.fetchTopicCountry(country);
	        return data;
	    } 
	      return null;
	    
	    }
	
	// Region operations
	
	@GetMapping("/Region")
	 public List<String> fetchAllRegion() {
		 List<String> data = cs.fetchRegion();
	        return data;
	    }
	@GetMapping("/Region/intensity")
	 public List<String> fetchRegionIntensity() {
	     
		 List<String> sumIntensity= cs.fetchRegionIntensity();
	        return sumIntensity;
	    }	
	@GetMapping("/Region/likelihood")
	 public List<String> fetchRegionLikelihood() {
	     
		 List<String> sumIntensity= cs.fetchRegionLikelihood();
	        return sumIntensity;
	    }	
	@GetMapping("/Region/relevance")
	 public List<String> fetchRegionRelevance() {
	     
		 List<String> sumIntensity= cs.fetchRegionRelevance();
	        return sumIntensity;
	    }	
	
	@GetMapping("/City")
	public List<String> fetchAllCity(){
		List<String> city=cs.fetchAllCity();
		return city;
		
	}
	
	@GetMapping("/City/intensity")
	 public List<String> fetchCityIntensity() {
	     
		 List<String> sumIntensity= cs.fetchCityIntensity();
	        return sumIntensity;
	    }	
		
	@GetMapping("/City/likelihood")
	 public List<String> fetchCityLikelihood() {
	     
		 List<String> sumIntensity= cs.fetchCityLikelihood();
	        return sumIntensity;
	    }	
	@GetMapping("/City/relevance")
	 public List<String> fetchCityRelevance() {
	     
		 List<String> sumIntensity= cs.fetchCityRelevance();
	        return sumIntensity;
	    }	
  }
	
//@GetMapping("/intensity")
//public List<String> fetchIntensity(@RequestParam(name = "endYear", required = false) String endYear) {
////    System.out.println("End Year: " + endYear);
//    if (endYear != null) {
//        List<String> data = cs.fetchIntensityByEndYear(endYear);
//      //  System.out.println("Intensity Data: " + data);
//        return data;
//    } else {
//        List<String> data = cs.fetchIntensity();
//       // System.out.println("Intensity Data: " + data);
//        return data;
//    }
//}
//@GetMapping("/intensity/all")
// public List<String> fetchAllIntensity() {
//        // Implement data retrieval logic to fetch all intensity data
//        // Return the complete list of intensity data
//	 List<String> data = cs.fetchIntensity();
//    //    System.out.println("Intensity Data: " + data);
//        return data;
//    }	 
//@GetMapping("/years")
//public List<String> fetchYears() {
//    return cs.fetchYears();
//}

