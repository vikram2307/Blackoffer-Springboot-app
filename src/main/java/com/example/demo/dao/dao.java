package com.example.demo.dao;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.demo.model.Datamodel;
import com.example.demo.repo.Repo;

@Service
public class dao {
	@Autowired
	Repo cr;

	public List<Datamodel> display() {
	return cr.findAll();
		
	}
	public List<String> fetchIntensity() {
        List<Datamodel> dataModels = cr.findAll();
        List<String> intensities = dataModels.stream().map(Datamodel::getIntensity).collect(Collectors.toList());
        return intensities;
    }
	public List<String> fetchYears() {
        List<Datamodel> dataModels = cr.findAll();
        List<String> years = new ArrayList<>();
        for (Datamodel dataModel : dataModels) {
            if (dataModel.getEnd_year() != null) {
                years.add(dataModel.getEnd_year().toString());
            }
        }
        return years;
    }
	
	public List<String> fetchIntensityByEndYear(String endYear) {
	    List<Datamodel> dataModels = cr.findAll();  
	    List<String> intensityValues = new ArrayList<>();
	    for (Datamodel data : dataModels) {
	        if (data.getEnd_year().equals(endYear)) { 
	            intensityValues.add(data.getIntensity().toString());
	        }
	    }
	    return intensityValues;
	    
	}
	public List<String> fetchLikelihoodByEndYear(String endYear) {
		// TODO Auto-generated method stub
		List<Datamodel> dataModels = cr.findAll();  
	    List<String> LikelihoodValues = new ArrayList<>();
	    for (Datamodel data : dataModels) {
	        if (data.getEnd_year().equals(endYear)) { 
	        	LikelihoodValues.add(data.getLikelihood().toString());
	        }
	    }
	    return LikelihoodValues;
	}
	public List<String> fetchLikelihood() {
		  List<Datamodel> dataModels = cr.findAll();
	        List<String> Likelihood = dataModels.stream().map(Datamodel::getLikelihood).collect(Collectors.toList());
	        return Likelihood;
	    }
	public List<String> fetchRelevanceByEndYear(String endYear) {
		List<Datamodel> dataModels = cr.findAll();  
	    List<String> RelevanceValues = new ArrayList<>();
	    for (Datamodel data : dataModels) {
	        if (data.getEnd_year().equals(endYear)) {
	        	RelevanceValues.add(data.getRelevance().toString());
	        }
	    }
	    return RelevanceValues;
	}
	public List<String> fetchRelevance() {
		 List<Datamodel> dataModels = cr.findAll(); 
	        List<String> Relevance = dataModels.stream().map(Datamodel::getRelevance).collect(Collectors.toList());
	        return Relevance;
	    }
	
	
	public List<String> fetchTopics() {
		 List<Datamodel> dataModels = cr.findAll(); 
		    List<String> uniqueTopic = dataModels.stream()
		            .map(Datamodel::getTopic)
		            .filter(topic -> topic != null && !topic.isEmpty())
		            .distinct()
		            .collect(Collectors.toList());

		    return uniqueTopic;
	}
	
	
	public List<String> fetchTopicIntensity() {
		 List<Datamodel> dataModels = cr.findAll(); 
		    List<String> uniqueTopics = dataModels.stream()
		            .map(Datamodel::getTopic)
		            .filter(Topic -> Topic != null && !Topic.isEmpty())
		            .distinct()
		            .collect(Collectors.toList());
		    List<String> sumIntensity= new ArrayList<>();
		    
		    	
		    	for(String c:uniqueTopics)
		    	{
		    		int sum=0;
		    		List<Datamodel> dm =cr.findByTopic(c);
		    		 for(Datamodel d:dm)
		    		 {
		    			 sum = sum + Integer.parseInt(d.getIntensity()) ;
		    			 
		    		 }
		    		 sumIntensity.add(String.valueOf(sum));
		    	}
		    return sumIntensity;
	}
	
	public List<String> fetchTopiclikelihood() {
		List<Datamodel> dataModels = cr.findAll(); 
	    List<String> uniqueTopics = dataModels.stream()
	            .map(Datamodel::getTopic)
	            .filter(Topic -> Topic != null && !Topic.isEmpty())
	            .distinct()
	            .collect(Collectors.toList());
	    List<String> sumIntensity= new ArrayList<>();
	    
	    	
	    	for(String c:uniqueTopics)
	    	{
	    		int sum=0;
	    		List<Datamodel> dm =cr.findByTopic(c);
	    		 for(Datamodel d:dm)
	    		 {
	    			 sum = sum + Integer.parseInt(d.getLikelihood()) ;
	    			 
	    		 }
	    		 sumIntensity.add(String.valueOf(sum));
	    	}
	    return sumIntensity;
	}
	
	
	public List<String> fetchTopicRelevance() {
		// TODO Auto-generated method stub
		List<Datamodel> dataModels = cr.findAll(); 
	    List<String> uniqueTopics = dataModels.stream()
	            .map(Datamodel::getTopic)
	            .filter(Topic -> Topic != null && !Topic.isEmpty())
	            .distinct()
	            .collect(Collectors.toList());
	    List<String> sumIntensity= new ArrayList<>();
	    
	    	
	    	for(String c:uniqueTopics)
	    	{
	    		int sum=0;
	    		List<Datamodel> dm =cr.findByTopic(c);
	    		 for(Datamodel d:dm)
	    		 {
	    			 sum = sum + Integer.parseInt(d.getRelevance()) ;
	    			 
	    		 }
	    		 sumIntensity.add(String.valueOf(sum));
	    	}
	    return sumIntensity;
	
	}
	public List<String> fetchTopicCountry(String country) {
		
	    List<Datamodel> dataModels = cr.findByCountry(country);  
	    List<String> topicList = dataModels.stream()
	            .map(Datamodel::getTopic)
	            .filter(Topic -> Topic != null && !Topic.isEmpty())
	            .distinct()
	            .collect(Collectors.toList());
	    System.out.println(topicList);
	    return topicList;
	}

	
// Country Database Operations
	public List<String> fetchCountry() {
	    List<Datamodel> dataModels = cr.findAll(); //
	    List<String> uniqueCountries = dataModels.stream()
	            .map(Datamodel::getCountry)
	            .filter(country -> country != null && !country.isEmpty())
	            .distinct()
	            .collect(Collectors.toList());

	    return uniqueCountries;
	}
	
	
	public List<String> fetchCountryIntensity() {
	    List<Datamodel> dataModels = cr.findAll(); 
	    List<String> uniqueCountries = dataModels.stream()
	            .map(Datamodel::getCountry)
	            .filter(country -> country != null && !country.isEmpty())
	            .distinct()
	            .collect(Collectors.toList());
	    List<String> sumIntensity= new ArrayList<>();
	    
	    	
	    	for(String c:uniqueCountries)
	    	{
	    		int sum=0;
	    		 List<Datamodel> dm =cr.findByCountry(c);
	    		 for(Datamodel d:dm)
	    		 {
	    			 sum = sum + Integer.parseInt(d.getIntensity()) ;
	    			 
	    		 }
	    		 sumIntensity.add(String.valueOf(sum));
	    	}
	    return sumIntensity;
	}
	public List<String> fetchCountryRelevance() {
		 List<Datamodel> dataModels = cr.findAll(); 
		    List<String> uniqueCountries = dataModels.stream()
		            .map(Datamodel::getCountry)
		            .filter(country -> country != null && !country.isEmpty())
		            .distinct()
		            .collect(Collectors.toList());
		    List<String> sumIntensity= new ArrayList<>();
		    
		    	
		    	for(String c:uniqueCountries)
		    	{
		    		int sum=0;
		    		 List<Datamodel> dm =cr.findByCountry(c);
		    		 for(Datamodel d:dm)
		    		 {
		    			 sum = sum + Integer.parseInt(d.getRelevance()) ;
		    			 
		    		 }
		    		 sumIntensity.add(String.valueOf(sum));
		    	}
		    return sumIntensity;
	}
	public List<String> fetchCountryLikelihood() {
		 List<Datamodel> dataModels = cr.findAll(); 
		    List<String> uniqueCountries = dataModels.stream()
		            .map(Datamodel::getCountry)
		            .filter(country -> country != null && !country.isEmpty())
		            .distinct()
		            .collect(Collectors.toList());
		    List<String> sumIntensity= new ArrayList<>();
		    
		    	
		    	for(String c:uniqueCountries)
		    	{
		    		int sum=0;
		    		 List<Datamodel> dm =cr.findByCountry(c);
		    		 for(Datamodel d:dm)
		    		 {
		    			 sum = sum + Integer.parseInt(d.getLikelihood()) ;
		    			 
		    		 }
		    		 sumIntensity.add(String.valueOf(sum));
		    	}
		    return sumIntensity;
	}
	

	public List<String> fetchAllStartYears() {
	    Set<String> uniqueYears = new HashSet<>();
	    List<Datamodel> dataModels = cr.findAll();

	    for (Datamodel dataModel : dataModels) {
	        String startYear = dataModel.getStart_year();
	       

	        if (startYear != null && !startYear.isEmpty()) {
	            uniqueYears.add(startYear);
	        }
	    }

	    List<String> yearsList = new ArrayList<>(uniqueYears);
	    
	    // Sort the yearsList in ascending order
	    Collections.sort(yearsList);

	    return yearsList;
	}
	
	
	public List<String> fetchAllEndYears() {
		 Set<String> uniqueYears = new HashSet<>();
		    List<Datamodel> dataModels = cr.findAll();

		    for (Datamodel dataModel : dataModels) {
		        
		        String endYear = dataModel.getEnd_year();

		        if (endYear != null && !endYear.isEmpty()) {
		            uniqueYears.add(endYear);
		        }
 
		    }

		    List<String> yearsList = new ArrayList<>(uniqueYears);
		    
		    // Sort the yearsList in ascending order
		    Collections.sort(yearsList);

		    return yearsList;
	}
	
	
	
	public List<String> fetchStartYearIntensity() {
	    Set<String> uniqueYears = new HashSet<>();
	    List<Datamodel> dataModels = cr.findAll(); 

	    for (Datamodel dataModel : dataModels) {
	        String startYear = dataModel.getStart_year();

	        if (startYear != null && !startYear.isEmpty()) {
	            uniqueYears.add(startYear);
	        }
	    }
	    List<String> yearsList = new ArrayList<>(uniqueYears);
	    Collections.sort(yearsList);
	    
	    List<String> sumIntensity = new ArrayList<>();
	    
	    for (String year : yearsList) {
	        int sum = 0;
	        
	        for (Datamodel d : dataModels) {
	            String startYear = d.getStart_year();
	         
	            if (year.equals(startYear)) {
	                sum += Integer.parseInt(d.getIntensity());
	            }
	        }
	        
	        sumIntensity.add(String.valueOf(sum));
	    }

	    return sumIntensity;
	}

	public List<String> fetchEndYearIntensity() {
	    Set<String> uniqueYears = new HashSet<>();
	    List<Datamodel> dataModels = cr.findAll(); 

	    for (Datamodel dataModel : dataModels) {
	        
	        String endYear = dataModel.getEnd_year();

	        if (endYear != null && !endYear.isEmpty()) {
	            uniqueYears.add(endYear);
	        }
	    }
	    List<String> yearsList = new ArrayList<>(uniqueYears);
	    Collections.sort(yearsList);
	    
	    List<String> sumIntensity = new ArrayList<>();
	    
	    for (String year : yearsList) {
	        int sum = 0;
	        
	        for (Datamodel d : dataModels) {
	            String endYear = d.getEnd_year();
	           

	            if (year.equals(endYear)) {
	                sum += Integer.parseInt(d.getIntensity());
	            }
	        }
	        
	        
	        sumIntensity.add(String.valueOf(sum));
	    }

	    return sumIntensity;
	}
	
	
	public List<String> fetchStartYearLikelihood() {
	    Set<String> uniqueYears = new HashSet<>();
	    List<Datamodel> dataModels = cr.findAll(); 

	    for (Datamodel dataModel : dataModels) {
	        String startYear = dataModel.getStart_year();

	        if (startYear != null && !startYear.isEmpty()) {
	            uniqueYears.add(startYear);
	        }
	    }
	    List<String> yearsList = new ArrayList<>(uniqueYears);
	    Collections.sort(yearsList);
	    
	    List<String> sumLikelihood = new ArrayList<>();
	    
	    for (String year : yearsList) {
	        int sum = 0;
	        
	        for (Datamodel d : dataModels) {
	            String startYear = d.getStart_year();
	         
	            if (year.equals(startYear)) {
	                sum += Integer.parseInt(d.getLikelihood());
	            }
	        }
	        
	        sumLikelihood.add(String.valueOf(sum));
	    }
	    return sumLikelihood;
	}
	
	public List<String> fetchEndYearLikelihood() {
	    Set<String> uniqueYears = new HashSet<>();
	    List<Datamodel> dataModels = cr.findAll();

	    for (Datamodel dataModel : dataModels) {
	        
	        String endYear = dataModel.getEnd_year();

	        if (endYear != null && !endYear.isEmpty()) {
	            uniqueYears.add(endYear);
	        }
	    }
	    List<String> yearsList = new ArrayList<>(uniqueYears);
	    Collections.sort(yearsList);
	    List<String> sumLikelihood = new ArrayList<>();
	    
	    for (String year : yearsList) {
	        int sum = 0;
	        
	        for (Datamodel d : dataModels) {
	            String endYear = d.getEnd_year();
	           

	            if (year.equals(endYear)) {
	                sum += Integer.parseInt(d.getLikelihood());
	            }
	        }
	        
	        
	        sumLikelihood.add(String.valueOf(sum));
	    }

	    return sumLikelihood;
	}
	
	
	public List<String> fetchStartYearRelevance() {
	    Set<String> uniqueYears = new HashSet<>();
	    List<Datamodel> dataModels = cr.findAll();

	    for (Datamodel dataModel : dataModels) {
	        String startYear = dataModel.getStart_year();

	        if (startYear != null && !startYear.isEmpty()) {
	            uniqueYears.add(startYear);
	        }
	    }
	    List<String> yearsList = new ArrayList<>(uniqueYears);
	    Collections.sort(yearsList);
	    
	    List<String> sumRelevance = new ArrayList<>();
	    
	    for (String year : yearsList) {
	        int sum = 0;
	        
	        for (Datamodel d : dataModels) {
	            String startYear = d.getStart_year();
	         
	            if (year.equals(startYear)) {
	                sum += Integer.parseInt(d.getRelevance());
	            }
	        }
	        
	        sumRelevance.add(String.valueOf(sum));
	    }
	    return sumRelevance;
	}
	
	public List<String> fetchEndYearRelevance() {
	    Set<String> uniqueYears = new HashSet<>();
	    List<Datamodel> dataModels = cr.findAll(); 

	    for (Datamodel dataModel : dataModels) {
	        
	        String endYear = dataModel.getEnd_year();

	        if (endYear != null && !endYear.isEmpty()) {
	            uniqueYears.add(endYear);
	        }
	    }
	    List<String> yearsList = new ArrayList<>(uniqueYears);
	    Collections.sort(yearsList);
	    List<String> sumRelevance = new ArrayList<>();
	    
	    for (String year : yearsList) {
	        int sum = 0;
	        
	        for (Datamodel d : dataModels) {
	            String endYear = d.getEnd_year();
	           

	            if (year.equals(endYear)) {
	                sum += Integer.parseInt(d.getRelevance());
	            }
	        }
	        
	        
	        sumRelevance.add(String.valueOf(sum));
	    }

	    return sumRelevance;
	}
	
	//Region operations
	public List<String> fetchRegion() {
			 List<Datamodel> dataModels = cr.findAll();
			    List<String> uniqueRegion = dataModels.stream()
			            .map(Datamodel::getRegion)
			            .filter(Region -> Region != null && !Region.isEmpty())
			            .distinct()
			            .collect(Collectors.toList());
			    return uniqueRegion;
		}
	
	public List<String> fetchRegionIntensity() {
			 List<Datamodel> dataModels = cr.findAll(); // Replace with your actual fetch method
			    List<String> uniqueRegion = dataModels.stream()
			            .map(Datamodel::getRegion)
			            .filter(Region -> Region != null && !Region.isEmpty())
			            .distinct()
			            .collect(Collectors.toList());
			    List<String> sumIntensity= new ArrayList<>();
			    
			    	
			    	for(String c:uniqueRegion)
			    	{
			    		int sum=0;
			    		 List<Datamodel> dm =cr.findByRegion(c);
			    		 for(Datamodel d:dm)
			    		 {
			    			 sum = sum + Integer.parseInt(d.getIntensity()) ;
			    			 
			    		 }
			    		 sumIntensity.add(String.valueOf(sum));
			    	}
			    return sumIntensity;
		}

	public List<String> fetchRegionLikelihood() {
		 List<Datamodel> dataModels = cr.findAll(); // Replace with your actual fetch method
		    List<String> uniqueRegion = dataModels.stream()
		            .map(Datamodel::getRegion)
		            .filter(Region -> Region != null && !Region.isEmpty())
		            .distinct()
		            .collect(Collectors.toList());
		    List<String> sumIntensity= new ArrayList<>();
		    
		    	
		    	for(String c:uniqueRegion)
		    	{
		    		int sum=0;
		    		 List<Datamodel> dm =cr.findByRegion(c);
		    		 for(Datamodel d:dm)
		    		 {
		    			 sum = sum + Integer.parseInt(d.getLikelihood()) ;
		    			 
		    		 }
		    		 sumIntensity.add(String.valueOf(sum));
		    	}
		    return sumIntensity;
	}
	public List<String> fetchRegionRelevance() {
		 List<Datamodel> dataModels = cr.findAll(); 
	    List<String> uniqueRegion = dataModels.stream()
	            .map(Datamodel::getRegion)
	            .filter(Region -> Region != null && !Region.isEmpty())
	            .distinct()
	            .collect(Collectors.toList());
	    List<String> sumIntensity= new ArrayList<>();
	    
	    	
	    	for(String c:uniqueRegion)
	    	{
	    		int sum=0;
	    		 List<Datamodel> dm =cr.findByRegion(c);
	    		 for(Datamodel d:dm)
	    		 {
	    			 sum = sum + Integer.parseInt(d.getRelevance()) ;
	    			 
	    		 }
	    		 sumIntensity.add(String.valueOf(sum));
	    	}
	    return sumIntensity;
	}
	
	
//City operations
		public List<String> fetchAllCity() {
			List<Datamodel> dataModels = cr.findAll(); 
		    List<String> uniqueCity = dataModels.stream()
		            .map(Datamodel::getCity)
		            .filter(City -> City != null && !City.isEmpty())
		            .distinct()
		            .collect(Collectors.toList());
		    return uniqueCity;
		}
	
		public List<String> fetchCityIntensity() {
			 List<Datamodel> dataModels = cr.findAll(); 
			    List<String> uniqueCity = dataModels.stream()
			            .map(Datamodel::getCity)
			            .filter(City -> City != null && !City.isEmpty())
			            .distinct()
			            .collect(Collectors.toList());
			    List<String> sumIntensity= new ArrayList<>();
			    
			    	
			    	for(String c:uniqueCity)
			    	{
			    		int sum=0;
			    		 List<Datamodel> dm =cr.findByCity(c);
			    		 for(Datamodel d:dm)
			    		 {
			    			 sum = sum + Integer.parseInt(d.getIntensity()) ;
			    			 
			    		 }
			    		 sumIntensity.add(String.valueOf(sum));
			    	}
			    return sumIntensity;
		}
		public List<String> fetchCityLikelihood() {
			 List<Datamodel> dataModels = cr.findAll();
			    List<String> uniqueCity = dataModels.stream()
			            .map(Datamodel::getCity)
			            .filter(City -> City != null && !City.isEmpty())
			            .distinct()
			            .collect(Collectors.toList());
			    List<String> sumIntensity= new ArrayList<>();
			    
			    	
			    	for(String c:uniqueCity)
			    	{
			    		int sum=0;
			    		 List<Datamodel> dm =cr.findByCity(c);
			    		 for(Datamodel d:dm)
			    		 {
			    			 sum = sum + Integer.parseInt(d.getLikelihood()) ;
			    			 
			    		 }
			    		 sumIntensity.add(String.valueOf(sum));
			    	}
			    return sumIntensity;
		}
		public List<String> fetchCityRelevance() {
			 List<Datamodel> dataModels = cr.findAll(); 
			    List<String> uniqueCity = dataModels.stream()
			            .map(Datamodel::getCity)
			            .filter(City -> City != null && !City.isEmpty())
			            .distinct()
			            .collect(Collectors.toList());
			    List<String> sumIntensity= new ArrayList<>();
			    
			    	
			    	for(String c:uniqueCity)
			    	{
			    		int sum=0;
			    		 List<Datamodel> dm =cr.findByCity(c);
			    		 for(Datamodel d:dm)
			    		 {
			    			 sum = sum + Integer.parseInt(d.getRelevance()) ;
			    			 
			    		 }
			    		 sumIntensity.add(String.valueOf(sum));
			    	}
			    return sumIntensity;
		}
	
	
	
	
	
	
}
	
//	
//	public List<String> fetchIntensityByEndYear(String startYear,String endYear) {
//	    // Implement data retrieval logic to fetch intensity data filtered by endYear
//	    // In this example, we'll return intensity values as strings for the specified endYear
//	    List<Datamodel> dataModels = cr.findAll();
//	    List<String> intensityValues = new ArrayList<>();
//	    for (Datamodel data : dataModels) {
//	    	if (data.getEnd_year().equals(endYear) && data.getStart_year().equals(startYear)) { // Use .equals() for string comparison
//	            intensityValues.add(data.getIntensity().toString());
//	        }
//	    }
//	    System.out.println(intensityValues);
//	    return intensityValues;
//	    
//	}


//public List<String> fetchCountry() {
//List<Datamodel> dataModels = cr.findAll(); // Replace with your actual fetch method
//  List<String> Country = dataModels.stream().map(Datamodel::getCountry).collect(Collectors.toList());
//  List<String> sortedCountries= new ArrayList<>();
////  for(String c: Country) {
////	   if(c != ""|| c !=null) {
////		   sortedCountries.add(c);
////	   }
////  }
//  System.out.println("sortedCountries"+sortedCountries);
//return sortedCountries;
//}


