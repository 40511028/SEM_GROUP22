package com.napier.sem_group22;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInstance;

import java.util.ArrayList;
import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;

public class Integration_tests {
    static App app;

    static Issue1 issue1;
    static Issue2 issue2;
    static Issue3 issue3;
    static Issue4 issue4;
    static Issue5 issue5;
    static Issue6 issue6;
    static Issue7 issue7;
    static Issue17 issue17;
    static Issue18 issue18;
    static Issue19 issue19;
    static Issue20 issue20;
    static Issue21 issue21;
    static Issue24 issue24;
    static Issue25 issue25;
    static Issue26 issue26;
    static Issue28 issue28;
    static Issue29 issue29;
    static Issue30 issue30;

    @BeforeAll
    static void init() {
        app = new App();
        app.connect("localhost:33060", 0);

        issue1 = new Issue1();
        issue2 = new Issue2();
        issue3 = new Issue3();
        issue4 = new Issue4();
        issue5 = new Issue5();
        issue6 = new Issue6();
        issue7 = new Issue7();
        issue17 = new Issue17();
        issue18 = new Issue18();
        issue19 = new Issue19();
        issue20 = new Issue20();
        issue21 = new Issue21();
        issue24 = new Issue24();
        issue25 = new Issue25();
        issue26 = new Issue26();
        issue28 = new Issue28();
        issue29 = new Issue29();
        issue30 = new Issue30();
    }

    //test Issue 6
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
        for (int i = 0; i < pop1.size(); i++) {
            for (Population po : populations) {
                if (Objects.equals(po.name, pop1.get(i).name)) {
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

                assertEquals(pop1.get(i).name, pop2.get(i).name, "Test getIssue24 1/4 Failed");
                assertEquals(pop1.get(i).population, pop2.get(i).population, "Test getIssue24 2/4 Failed");
                assertEquals(pop1.get(i).inCities, pop2.get(i).inCities, "Test getIssue24 3/4 Failed");
                assertEquals(pop1.get(i).notinCities, pop2.get(i).notinCities, "Test getIssue24 4/4 Failed");
            }
        }

    }
