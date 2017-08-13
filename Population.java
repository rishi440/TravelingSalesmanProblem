package tsp;

public class Population 
{

    Tour[] tours;

    public Population(int getSize, boolean initialize) 
    {
        tours = new Tour[getSize];
        
        if (initialize) 
        {
            for (int i = 0; i < getSize(); i++) 
            {
                Tour newTour = new Tour();
                newTour.generateIndividual();
                saveTour(i, newTour);
            }
        }
    }
    
    // Saves a tour
    public void saveTour(int index, Tour tour) 
    {
        tours[index] = tour;
    }
    
    //returns tour at given index 
    public Tour getTour(int index) 
    {
        return tours[index];
    }

    
    public Tour getFittest() 
    {
        Tour fittest = tours[0];
        
        for (int i = 1; i < getSize(); i++) 
        {
            if (fittest.getFitness() <= getTour(i).getFitness()) 
            {
                fittest = getTour(i);
            }
        }
        return fittest;
    }
    
    @Override
    public String toString()
    {
      String out = new String();
      
      for(int i = 0; i<getSize(); i++)
      {
         out += "\n" + tours[i].toString();
      }
      
      return out;
    }
       
    
    public int getSize() 
    {
        return tours.length;
    }
}