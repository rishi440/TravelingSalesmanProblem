/******************************************
**
** Rishi Remesh
** Advanced AI
** Travelling salesman problem using Genetic Algorithm
**
******************************************/



package tsp;

import java.lang.Object;

public class City 
{
   // x and y coordinates will determine the location 
   // of the city and how the cities are placed
   
    int x;
    int y;
    String cityName;
    static int count = 0;
    
    // Constructs a random placed city
    public City()
    {
        this.x = (int)(Math.random()*200);   //200 points on x axis
        this.y = (int)(Math.random()*200);   //200 points on y axis
        count++;
        this.cityName = "City " + Integer.toString(count);
    }
    
    // Constructs a city at chosen x, y location
    public City(int x, int y)
    {
        this.x = x;
        this.y = y;
        count++;
        this.cityName = "City " + Integer.toString(count) ;
    }
    
    // Gets city's x coordinate
    public int getX()
    {
        return this.x;
    }
    
    // Return city's y coordinate
    public int getY()
    {
        return this.y;
    }
    
    // Gets the distance to given city
    public double distanceTo(City city)
    {
        int xDist = Math.abs(getX() - city.getX());
        int yDist = Math.abs(getY() - city.getY());
        
        double dist = 0.0;
        dist = Math.sqrt( (xDist*xDist) + (yDist*yDist) );
        
        return dist;
    }
    
    public static boolean isEqual(City c1, City c2)
    {
      boolean b = false;
      
      if(c1.getX() == c2.getX() && c1.getY() == c2.getY())
         b = true;
      
      return b;
    }
      
    
    @Override
    public String toString()
    {
        return cityName + " is placed at (" +getX()+", "+getY()+")";
    }
    
    public String toString1()
    {
        return cityName;
    }

}