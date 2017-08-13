package tsp;

import java.util.*;

public class TSP_GeneticAlgorithm 
{

    public static void main(String[] args) 
    {
       int choice = 0;
                
       Scanner scan = new Scanner(System.in);
       
       
       System.out.println( "\n 1. generate random cities \t");
       System.out.println( "\n 2. use preset cities  \t");
       System.out.println( "\n Enter your choice \t");
       choice = scan.nextInt();
       
       if(choice == 2)
       {
       
        // Create and add our cities
        City city = new City(60, 200);
        CityList.addCity(city);
        City city2 = new City(180, 200);
        CityList.addCity(city2);
        City city3 = new City(80, 180);
        CityList.addCity(city3);
        City city4 = new City(140, 180);
        CityList.addCity(city4);
        City city5 = new City(20, 160);
        CityList.addCity(city5);
        City city6 = new City(100, 160);
        CityList.addCity(city6);
        City city7 = new City(200, 160);
        CityList.addCity(city7);
        City city8 = new City(140, 140);
        CityList.addCity(city8);
        City city9 = new City(40, 120);
        CityList.addCity(city9);
        City city10 = new City(100, 120);
        CityList.addCity(city10);
        City city11 = new City(180, 100);
        CityList.addCity(city11);
        City city12 = new City(60, 80);
        CityList.addCity(city12);
        City city13 = new City(120, 80);
        CityList.addCity(city13);
        City city14 = new City(180, 60);
        CityList.addCity(city14);
        City city15 = new City(20, 40);
        CityList.addCity(city15);
        City city16 = new City(100, 40);
        CityList.addCity(city16);
        City city17 = new City(200, 40);
        CityList.addCity(city17);
        City city18 = new City(20, 20);
        CityList.addCity(city18);
        City city19 = new City(60, 20);
        CityList.addCity(city19);
        City city20 = new City(160, 20);
        CityList.addCity(city20);
      }
      
      else if(choice == 1)
      {
         System.out.println("\n How many cities would you like to generate \t");
         choice = scan.nextInt();
         
         for(int i=0; i<choice; i++)
         {  
            City c = new City();
            
            for(int j=0; j<i ; j++)
            {
               if(City.isEqual(c, CityList.getCity(j)))
                  c = new City();
             
            }
            
            CityList.addCity(c);
         }
      }
            
         System.out.println("\n \n The Generated Cities are in positions with x and y coordinate \t");
         
         for(int i=0; i<CityList.numberOfCities() ; i++)
         {
            System.out.println("\n" + CityList.getCity(i).toString());
         }  
     

        // Initialize population
        Population pop = new Population(100, true);
        System.out.println("\n The initial population is \n " + pop.toString());
        System.out.println("Initial fittest distance is: " + pop.getFittest().getDistance());
        System.out.println(pop.getFittest());
        
        System.out.println("\n How many generations would you like to run the algorithm for? \n");
        int generations = 0;
        generations = scan.nextInt();
        
        // Evolve population for "generations" generations
        for (int i = 0; i < generations; i++) 
        {
            pop = GeneticAlgorithm.evolvePopulation(pop);
        }

        // Print final results
        System.out.println("\n After "+ Integer.toString(generations) +" generations \n");
        System.out.println("Final distance: " + pop.getFittest().getDistance());
        System.out.println("Solution:");
        System.out.println(pop.getFittest());
    }
}