package com.napier.sem_group22;

import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;

/*
 * Author: Andrej Legen
 * Date: 21/04/22
 * Purpose:
 * Get all the top N populated cities in a region where N is provided by the user.
 */
public class Issue14 {

    /**
     * ------------ getTopNIssue14 ---------------
     * .
     * @param app = get the app class instance for connection
     * @param N = specifies number of results shown
     * @param region = specified region
     * @return  ArrayList<City> = return an array list with all the cities
     * purpose = Get all the top N populated cities in a region where N is provided by the user.
     */

    public ArrayList<City> getTopNIssue14(String N, App app, String region) {

        try
        {
            // Create an SQL statement
            Statement stmt = app.con.createStatement();

            // Create string for SQL statement
            String strIssue14 =
                    "SELECT city.name, country.name, district, city.population "
                            +"FROM city JOIN country ON country.Capital = city.ID "
                            +"WHERE country.region LIKE '" + region + "'"
                            + "ORDER BY city.population DESC "
                            + "LIMIT " + N + ";";

            // Execute SQL statement
            ResultSet rset = stmt.executeQuery(strIssue14);

            //Create City ArrayList
            ArrayList<City> cities = new ArrayList<City>();

            // Check one is returned and go through all cities to get the details
            while (rset.next())
            {
                City acity = new City();
                acity.name = rset.getString("city.name");
                acity.countryName = rset.getString("country.name");
                acity.district = rset.getString("district");
                acity.population = rset.getInt("city.population");
                cities.add(acity); // add city in ArrayList<City> cities

            }
            return cities; // return ArrayList
        }
        catch (Exception e) //no city found
        {
            System.out.println(e.getMessage());
            System.out.println("Failed to get countries population");
            return null;
        }
    }
}

//*  To place into main
//** Create instance of Issue14 Class-- this will have the required methods */
//Issue14 issue14 = new Issue14();
//ArrayList<City> cities = issue14.getTopNIssue14("4",a, "Eastern Europe");
// /** Print countries and column names */
// a.printCities(cities);
