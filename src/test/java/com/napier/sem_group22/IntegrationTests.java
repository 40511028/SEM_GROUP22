package com.napier.sem_group22;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class IntegrationTests {
    static App app;

    static Issue1 issue1;
    static Issue2 issue2;
    static Issue3 issue3;
    static Issue4 issue4;
    static Issue5 issue5;
    static Issue6 issue6;
    static Issue7 issue7;
    static Issue8 issue8;
    static Issue17 issue17;
    static Issue18 issue18;
    static Issue19 issue19;
    static Issue20 issue20;
    static Issue21 issue21;
    static Issue23 issue23;
    static Issue24 issue24;
    static Issue25 issue25;
    static Issue26 issue26;
    static Issue28 issue28;
    static Issue29 issue29;
    static Issue30 issue30;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:33060", 3000);

        issue1 = new Issue1();
        issue2 = new Issue2();
        issue3 = new Issue3();
        issue4 = new Issue4();
        issue5 = new Issue5();
        issue6 = new Issue6();
        issue7 = new Issue7();
        issue8 = new Issue8();
        issue17 = new Issue17();
        issue18 = new Issue18();
        issue19 = new Issue19();
        issue20 = new Issue20();
        issue21 = new Issue21();
        issue23 = new Issue23();
        issue24 = new Issue24();
        issue25 = new Issue25();
        issue26 = new Issue26();
        issue28 = new Issue28();
        issue29 = new Issue29();
        issue30 = new Issue30();
    }

    /**
     * -------------------- Tests for Issue6 ------------------------
     * -getNTopPopCountriesRegionTest() -- test that the sql statement works
     * -getNTopPopCountriesRegionTestNullN() -- test error handling if N null
     * -getNTopPopCountriesRegionTestNullRegion() -- test error handling if Region null
     * -getNTopPopCountriesRegionTestNullApp() -- test error handling if App instance class null
     * -getNTopPopCountriesRegionTestNullAllParams() -- test error handling if all @param null
     */
    @Test
    void getNTopPopCountriesRegionTest()
    {
        ArrayList<Country> countries1 = issue6.getNTopPopCountriesRegion("1", app, "Central America");
        ArrayList<Country> countries2 = new ArrayList<>();
        Country c1 = new Country();
        c1.code = "MEX";
        c1.name = "Mexico";
        c1.continent = "North America";
        c1.region = "Central America";
        c1.population = 98881000;
        c1.capitalName = "Ciudad de México";

        countries2.add(c1);

        for(int i = 0; i < countries1.size(); i++ ) {
            assertEquals(countries2.get(i).code, countries1.get(i).code);
            assertEquals(countries2.get(i).name, countries1.get(i).name);
            assertEquals(countries2.get(i).continent, countries1.get(i).continent);
            assertEquals(countries2.get(i).region, countries1.get(i).region);
            assertEquals(countries2.get(i).population, countries1.get(i).population);
            assertEquals(countries2.get(i).capitalName, countries1.get(i).capitalName);
        }
    }

    @Test
    void getNTopPopCountriesRegionTestNullN()
    {
        ArrayList<Country> countries1 = issue6.getNTopPopCountriesRegion(null, app, "Central America");

    }

    @Test
    void getNTopPopCountriesRegionTestNullRegion()
    {
        ArrayList<Country> countries1 = issue6.getNTopPopCountriesRegion("2", app, null);

    }

    @Test
    void getNTopPopCountriesRegionTestNullApp()
    {
        ArrayList<Country> countries1 = issue6.getNTopPopCountriesRegion("2", null, "Central America");

    }

    @Test
    void getNTopPopCountriesRegionTestNullAllParams()
    {
        ArrayList<Country> countries1 = issue6.getNTopPopCountriesRegion(null, null, null);

    }

    /**
     * -------------------- Tests for Issue8 ------------------------
     * -getCitiesLargeSmallPopTest -- test that the sql statement works
     * -getCitiesLargeSmallPopNullContinent() -- test error handling if Continent null
     * -getCitiesLargeSmallPopNullApp() -- test error handling if App instance class null
     * -getCitiesLargeSmallPopNullAllParams() -- test error handling if all @param null
     */
    @Test
    void getCitiesLargeSmallPopTest()
    {
        ArrayList<City> cities = issue8.getCitiesLargeSmallPop(app, "Europe");
        ArrayList<City> cities1 = new ArrayList<>();
        City c1 = new City();
        c1.name = "Moscow";
        c1.countryName = "Russian Federation";
        c1.district = "Moscow (City)";
        c1.population = 8389200;

        City c2 = new City();
        c2.name = "London";
        c2.countryName = "United Kingdom";
        c2.district = "England";
        c2.population = 7285000;

        cities1.add(c1);
        cities1.add(c2);
        ArrayList<City> cities2 = new ArrayList<>();
        for (int i = 0; i < cities1.size(); i++) {
            for (City c : cities) {
                if (Objects.equals(c.name, cities1.get(i).name)) {
                    City city = new City();
                    city.name = c.name;
                    city.countryName = c.countryName;
                    city.district = c.district;
                    city.population = c.population;

                    cities2.add(city);
                }
            }
        }
        for (int i = 0; i < cities1.size(); i++) {

            assertEquals(cities1.get(i).name, cities2.get(i).name, "Test getIssue8 1/4 Failed");
            assertEquals(cities1.get(i).countryName, cities2.get(i).countryName, "Test getIssue8 2/4 Failed");
            assertEquals(cities1.get(i).district, cities2.get(i).district, "Test getIssue8 3/4 Failed");
            assertEquals(cities1.get(i).population, cities2.get(i).population, "Test getIssue8 4/4 Failed");
        }
    }


    @Test
    void getCitiesLargeSmallPopNullContinent()
    {
        ArrayList<City> cities1 = issue8.getCitiesLargeSmallPop(app, null);

    }

    @Test
    void getCitiesLargeSmallPopNullApp()
    {
        ArrayList<City> cities1 = issue8.getCitiesLargeSmallPop(null, "Europe");

    }

    @Test
    void getCitiesLargeSmallPopNullAllParams()
    {
        ArrayList<City> cities1 = issue8.getCitiesLargeSmallPop(null, null);

    }

    //Issue23
    @Test
    void getIssue23Test() {
        ArrayList<Population> pop1 = new ArrayList<>();
        Population pop = new Population();
        pop.name = "South America";
        pop.population = 345780000;
        pop.inCities = 49.75355911254883;
        pop.notinCities = 50.24644088745117;
        pop1.add(pop);

        ArrayList<Population> populations = issue23.getIssue23(app);

        ArrayList<Population> pop2 = new ArrayList<>();
        for (Population population : pop1) {
            for (Population po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    Population p = new Population();
                    p.name = po.name;
                    p.population = po.population;
                    p.inCities = po.inCities;
                    p.notinCities = po.notinCities;
                    pop2.add(p);
                }
            }
        }
        for (int i = 0; i < pop1.size(); i++) {

            assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue24 1/4 Failed (Name not matching)");
            assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue24 2/4 Failed (Population not matching)");
            assertEquals(pop1.get(i).inCities, pop2.get(i).inCities, "Test getIssue24 3/4 Failed (% living in cities not matching)");
            assertEquals(pop1.get(i).notinCities, pop2.get(i).notinCities, "Test getIssue24 4/4 Failed (% not living in cities not matching)");
        }
    }

    //Issue24
    @Test
    void getIssue24Test() {
        ArrayList<Population> pop1 = new ArrayList<>();
        Population pop = new Population();
        pop.name = "Middle East";
        pop.population = 188380700;
        pop.inCities = 37.355934143066406;
        pop.notinCities = 62.644065856933594;
        pop1.add(pop);

        ArrayList<Population> populations = issue24.getIssue24(app);

        ArrayList<Population> pop2 = new ArrayList<>();
        for (Population population : pop1) {
            for (Population po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    Population p = new Population();
                    p.name = po.name;
                    p.population = po.population;
                    p.inCities = po.inCities;
                    p.notinCities = po.notinCities;
                    pop2.add(p);
                }
            }
        }
            for (int i = 0; i < pop1.size(); i++) {

                assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue24 1/4 Failed (Name not matching)");
                assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue24 2/4 Failed (Population not matching)");
                assertEquals(pop1.get(i).inCities, pop2.get(i).inCities, "Test getIssue24 3/4 Failed (% living in cities not matching)");
                assertEquals(pop1.get(i).notinCities, pop2.get(i).notinCities, "Test getIssue24 4/4 Failed (% not living in cities not matching)");
            }
        }

    //Issue25
    @Test
    void getIssue25Test() {
        ArrayList<Population> pop1 = new ArrayList<>();
        Population pop = new Population();
        pop.name = "United Kingdom";
        pop.population = 59623400;
        pop.inCities = 37.630645751953125;
        pop.notinCities = 62.369354248046875;
        pop1.add(pop);

        ArrayList<Population> populations = issue25.getIssue25(app);

        ArrayList<Population> pop2 = new ArrayList<>();
        for (Population population : pop1) {
            for (Population po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    Population p = new Population();
                    p.name = po.name;
                    p.population = po.population;
                    p.inCities = po.inCities;
                    p.notinCities = po.notinCities;
                    pop2.add(p);
                }
            }
        }
        for (int i = 0; i < pop1.size(); i++) {

            assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue24 1/4 Failed (Name not matching)");
            assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue24 2/4 Failed (Population not matching)");
            assertEquals(pop1.get(i).inCities, pop2.get(i).inCities, "Test getIssue24 3/4 Failed (% living in cities not matching)");
            assertEquals(pop1.get(i).notinCities, pop2.get(i).notinCities, "Test getIssue24 4/4 Failed (% not living in cities not matching)");
        }
    }

    //Issue26
    @Test
    void getIssue26Test() {
        ArrayList<Population> pop1 = new ArrayList<>();
        Population pop = new Population();
        pop.name = "Entire world";
        pop.population = 6078749450L;
        pop.inCities = 23.517335197949308;
        pop.notinCities = 76.48266480205069;
        pop1.add(pop);

        ArrayList<Population> populations = issue26.getIssue26(app);

        ArrayList<Population> pop2 = new ArrayList<>();
        for (Population population : pop1) {
            for (Population po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    Population p = new Population();
                    p.name = po.name;
                    p.population = po.population;
                    p.inCities = po.inCities;
                    p.notinCities = po.notinCities;
                    pop2.add(p);
                }
            }
        }
        for (int i = 0; i < pop1.size(); i++) {

            assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue24 1/4 Failed (Name not matching)");
            assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue24 2/4 Failed (Population not matching)");
            assertEquals(pop1.get(i).inCities, pop2.get(i).inCities, "Test getIssue24 3/4 Failed (% living in cities not matching)");
            assertEquals(pop1.get(i).notinCities, pop2.get(i).notinCities, "Test getIssue24 4/4 Failed (% not living in cities not matching)");
        }
    }



    //Issue28
    @Test
    void getIssue28Test() {
        ArrayList<Population> pop1 = new ArrayList<>();
        Population pop = new Population();
        pop.name = "Middle East";
        pop.population = 188380700;
        pop.inCities = 37.355934143066406;
        pop.notinCities = 62.644065856933594;
        pop1.add(pop);

        ArrayList<Population> populations = issue28.getIssue28(app, pop1.get(0).name);

        ArrayList<Population> pop2 = new ArrayList<>();
        for (Population population : pop1) {
            for (Population po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    Population p = new Population();
                    p.name = po.name;
                    p.population = po.population;
                    p.inCities = po.inCities;
                    p.notinCities = po.notinCities;
                    pop2.add(p);
                }
            }
        }
        for (int i = 0; i < pop1.size(); i++) {

            assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue24 1/4 Failed (Name not matching)");
            assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue24 2/4 Failed (Population not matching)");
            assertEquals(pop1.get(i).inCities, pop2.get(i).inCities, "Test getIssue24 3/4 Failed (% living in cities not matching)");
            assertEquals(pop1.get(i).notinCities, pop2.get(i).notinCities, "Test getIssue24 4/4 Failed (% not living in cities not matching)");
        }
    }

    //Issue29
    @Test
    void getIssue29Test() {
        ArrayList<Population> pop1 = new ArrayList<>();
        Population pop = new Population();
        pop.name = "United Kingdom";
        pop.population = 59623400;
        pop.inCities = 37.630645751953125;
        pop.notinCities = 62.369354248046875;
        pop1.add(pop);

        ArrayList<Population> populations = issue29.getIssue29(app, pop1.get(0).name);

        ArrayList<Population> pop2 = new ArrayList<>();
        for (Population population : pop1) {
            for (Population po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    Population p = new Population();
                    p.name = po.name;
                    p.population = po.population;
                    p.inCities = po.inCities;
                    p.notinCities = po.notinCities;
                    pop2.add(p);
                }
            }
        }
        for (int i = 0; i < pop1.size(); i++) {

            assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue24 1/4 Failed (Name not matching)");
            assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue24 2/4 Failed (Population not matching)");
            assertEquals(pop1.get(i).inCities, pop2.get(i).inCities, "Test getIssue24 3/4 Failed (% living in cities not matching)");
            assertEquals(pop1.get(i).notinCities, pop2.get(i).notinCities, "Test getIssue24 4/4 Failed (% not living in cities not matching)");
        }
    }

    //Issue30
    @Test
    void getIssue30Test() {
        ArrayList<Population> pop1 = new ArrayList<>();
        Population pop = new Population();
        pop.name = "Seoul";
        pop.population = 9981619;
        pop.inCities = 100;
        pop.notinCities = 0;
        pop1.add(pop);

        ArrayList<Population> populations = issue30.getIssue30(app, pop1.get(0).name);

        ArrayList<Population> pop2 = new ArrayList<>();
        for (Population population : pop1) {
            for (Population po : populations) {
                if (Objects.equals(po.name, population.name)) {
                    Population p = new Population();
                    p.name = po.name;
                    p.population = po.population;
                    p.inCities = po.inCities;
                    p.notinCities = po.notinCities;
                    pop2.add(p);
                }
            }
        }
        for (int i = 0; i < pop1.size(); i++) {

            assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue24 1/4 Failed (Name not matching)");
            assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue24 2/4 Failed (Population not matching)");
            assertEquals(pop1.get(i).inCities, pop2.get(i).inCities, "Test getIssue24 3/4 Failed (% living in cities not matching)");
            assertEquals(pop1.get(i).notinCities, pop2.get(i).notinCities, "Test getIssue24 4/4 Failed (% not living in cities not matching)");
        }
    }
}
