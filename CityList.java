/*************************************
** Rishi Remesh
** CS 548
** Final Project
**
*************************************/

package tsp;

import java.util.ArrayList;

public class CityList 
{

     
   private static ArrayList destinations = new ArrayList<City>();

    // Add a city to the destinations
    public static void addCity(City city) 
    {
       destinations.add(city);
    }
    
    // Return City at given index
    public static City getCity(int index)
    {
        return (City)destinations.get(index);
    }
    
    // Get the number of destination cities
    public static int numberOfCities()
    {
        return destinations.size();
    }
}