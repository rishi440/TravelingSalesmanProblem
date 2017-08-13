package tsp;

import java.util.*;

public class GeneticAlgorithm 
{

    /* GeneticAlgorithm parameters */
    private static final double mutationRate = 0.005;
       
    // Evolves a population over one generation
    public static Population evolvePopulation(Population pop) 
    {
        
        Population newPopulation = new Population(pop.getSize(), false);
        
        newPopulation.saveTour(0,pop.getFittest());               //elitism setting first and last
        newPopulation.saveTour(pop.getSize()-1,pop.getFittest()); //elements in population to best in that generation


        for(int i=0; i<pop.getSize(); i++)
        {
            Tour temp = new Tour();
            temp = rouletteWheelSelection(pop);
            newPopulation.saveTour(i,temp);
        }
       
        newPopulation.saveTour(0,pop.getFittest());         //elitism as above
        newPopulation.saveTour(pop.getSize()-1,pop.getFittest());
        
        System.out.println("\n Selected Population is \n"+ newPopulation.toString());
        
             
        Tour parent1 = new Tour();
        Tour parent2 = new Tour();

        for (int i = 1; i < pop.getSize()-1; i++)
        {
                 
            if(i%2==1)
            {
               parent1 = newPopulation.getTour(i);
               parent2 = newPopulation.getTour(i+1);
            }
            
            System.out.println("\n The parents are \n" + parent1.toString() + " and \n " + parent2.toString());
            
            // Crossover parents
            Tour child = crossover(parent1, parent2);
            
            System.out.println("\n The Child is \n" + child.toString());
            
            // Add child to new population
            newPopulation.saveTour(i, child);
        }

        // Mutate the new population 
        for (int i = 0; i <pop.getSize(); i++) 
        {
            mutate(newPopulation.getTour(i));
        }

        return newPopulation;
    }

    // Applies crossover to a set of parents and creates offspring
    public static Tour crossover(Tour parent1, Tour parent2) 
    {
        // Create new child tour
        Tour child = new Tour();

        // Get start and end sub tour positions for parent1's tour
        int startPos = (int) (Math.random() * parent1.getSize());
        int endPos = (int) (Math.random() * parent1.getSize());

        // Loop and add the sub tour from parent1 to our child
        for (int i = 0; i < parent1.getSize(); i++) 
        {
            // If our start position is less than the end position
            if (startPos < endPos && i > startPos && i < endPos) 
            {
                child.setCity(i, parent1.getCity(i));
            } // If our start position is larger
            else if (startPos > endPos) 
            {
                if (!(i < startPos && i > endPos)) 
                {
                    child.setCity(i, parent1.getCity(i));
                }
            }
        }

        // Loop through parent2's city tour
        for (int i = 0; i < parent2.getSize(); i++) 
        {
            // If child doesn't have the city add it
            if (!child.hasCity(parent2.getCity(i))) 
            {
                for (int j = 0; j < child.getSize(); j++) 
                {
                    // If an empty spot is found, add city
                    if (child.getCity(j) == null)
                    {
                        child.setCity(j, parent2.getCity(i));
                        break;
                    }
                }
            }
        }
        return child;
    }

    // Mutate a tour using swap/shuffle mutation
    private static void mutate(Tour tour) 
    {
        // Loop through tour cities
        for(int tourPos1=0; tourPos1 < tour.getSize(); tourPos1++)
        {
            // Apply mutation rate
            if(Math.random() < mutationRate)
            {
            
                System.out.println("\n Mutation Occurred at \n" + tour.toString());
                
                // Get a second random position in the tour
                int tourPos2 = (int) (tour.getSize() * Math.random());

                // Get the cities at target position in tour
                City city1 = tour.getCity(tourPos1);
                City city2 = tour.getCity(tourPos2);

                // Swap them around
                //tour.setCity(tourPos2, city1);
                //tour.setCity(tourPos1, city2);
                
                tour.generateIndividual();                 
                System.out.println("\n It is now \n" + tour.toString());
            }
        }
    }
    
    public static Tour rouletteWheelSelection(Population p)
    {
      double totalSum = 0.0;
      Tour t = new Tour();
         
      for(int i=0; i<p.getSize(); i++)
      {
         totalSum += p.getTour(i).getFitness();
      }
      
      for(int i=0; i<p.getSize(); i++)
      {
         p.getTour(i).setTourProbability(totalSum, p.getTour(i).getFitness());
      }
      
      double partialSum = 0;
      double roulette = 0;
      roulette = (double)(Math.random());
      
      for(int i=0; i<p.getSize(); i++)
      {
         partialSum+=p.getTour(i).tourProbability;
         
         if(partialSum>=roulette)
         {
            t = p.getTour(i);
            break;
         }
      }
      
      return t;
   }
}