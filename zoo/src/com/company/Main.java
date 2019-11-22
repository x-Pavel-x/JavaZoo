package com.company;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Main
{
    public static int size_of_predators, size_of_herbivores;
    public static ArrayList<predators> list_of_predators;
    public static ArrayList<herbivores> list_of_herbivores;
    public static void main(String[] args) throws IOException, FileNotFoundException, ParseException
    {
        list_of_predators = new ArrayList<>();
        list_of_herbivores = new ArrayList<>();
       Object obj = new JSONParser().parse(new FileReader("src\\com\\company\\AList.json"));
       JSONObject jo = (JSONObject) obj;
       String kind, animal_sound;
       long number;
       number = (long) jo.get("number1");
       for (long i = 0; i < number; i++)
        {
            kind = (String) jo.get("kind1");
            animal_sound = (String) jo.get("animal_sound1");
            list_of_herbivores.add(new herbivores(kind,animal_sound));
        }
        number = (long) jo.get("number2");
        for (long i = 0; i < number; i++)
        {
            kind = (String) jo.get("kind2");
            animal_sound = (String) jo.get("animal_sound2");
            list_of_herbivores.add(new herbivores(kind,animal_sound));
        }
        number = (long) jo.get("number3");
        for (long i = 0; i < number; i++)
        {
            kind = (String) jo.get("kind3");
            animal_sound = (String) jo.get("animal_sound3");
            list_of_predators.add(new predators(kind,animal_sound));
        }
        number = (long) jo.get("number4");
        for (long i = 0; i < number; i++)
        {
            kind = (String) jo.get("kind4");
            animal_sound = (String) jo.get("animal_sound4");
            list_of_predators.add(new predators(kind,animal_sound));
        }
        size_of_herbivores = list_of_herbivores.size();
        size_of_predators = list_of_predators.size();
/*
ZooEvents.zoo_keeper_come_to_predators();
ZooEvents.feeding_predator_animal();
ZooEvents.zoo_keeper_come_to_herbivores();
ZooEvents.feeding_herbivores_animal();
ZooEvents.zoo_keeper_come_to_predators();
ZooEvents.feeding_predator_animal();
ZooEvents.night_come();
ZooEvents.thunder();
ZooEvents.zoo_keeper_come_to_herbivores();
ZooEvents.feeding_herbivores_animal();
ZooEvents.zoo_keeper_come_to_predators();
ZooEvents.feeding_predator_animal();*/
    }
}
