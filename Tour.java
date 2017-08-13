package tsp;

import java.util.ArrayList;
import java.util.Collections;

public class Tour
{

    private ArrayList tour = new ArrayList<City>();
    private double fitness = 0;
    private int distance = 0;
    public double tourProbability ; //new
    
    // Constructs a blank tour
    public Tour()
    {
        for (int i = 0; i < CityList.numberOfCities(); i++) 
        {
            tour.add(null);
        }
    }
    
    public Tour(ArrayList tour)
    {
        this.tour = tour;
    }
    
      // Creates a random individual
    public void generateIndividual() 
    {
        // Loops through all destination cities and adds them to the tour
        for (int cityIndex = 0; cityIndex < CityList.numberOfCities(); cityIndex++) 
        {
          setCity(cityIndex, CityList.getCity(cityIndex));
        }
        
        // shuffles the list to create a random individual
        Collections.shuffle(tour);
    }
    
    public void setTourProbability(double total, double fitness)
    {
      this.tourProbability = fitness/total;
    }

    // returns City at a given position
    public City getCity(int index) 
    {
        return (City)tour.get(index);
    }

    // Sets a city in a certain position within a tour
    public void setCity(int pos, City city) 
    {
        tour.set(pos, city);
        fitness = 0;
        distance = 0;
    }
    
        
    // Gets the total distance of the tour
    public int getDistance()
    {
        if (distance == 0) 
        {
            int tourDistance = 0;
            
                for (int cityIndex=0; cityIndex < getSize(); cityIndex++)
                {
                
                  City fromCity = getCity(cityIndex);
                  City destinationCity;
              
                  if(cityIndex+1 < getSize())
                  destinationCity = getCity(cityIndex+1);
                  else
                  destinationCity = getCity(0);
                  
                  //Distance between the cities
                  tourDistance += fromCity.distanceTo(destinationCity);
               }
            
               distance = tourDistance;
        }
        return distance;
    }
    
    // Gets the tours fitness
    public double getFitness() 
    {
        if (fitness == 0) 
        fitness = 1/(double)getDistance(); // the fitness value is inversely proportional to the distance of the tour
        
        
        return fitness;
    }


    // Get number of cities on our tour
    public int getSize() 
    {
        return tour.size();
    }
    
    // Check if the tour contains a city
    public boolean hasCity(City city)
    {
        return tour.contains(city);
    }
    
    
    public String toString() 
    {
        String gene = "|";
        for (int i = 0; i < getSize(); i++) 
        {
            gene += getCity(i).toString1() +"|";
        }
        
        return gene;
    }
}