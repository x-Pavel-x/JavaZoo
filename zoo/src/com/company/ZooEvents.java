package com.company;
import java.util.ArrayList;

import static com.company.Main.list_of_herbivores;
import static com.company.Main.list_of_predators;
import static com.company.Main.size_of_predators;
import static com.company.Main.size_of_herbivores;
public class ZooEvents {
    static protected String event1 = "zoo_keeper_come";
    static protected String event2 = "herbivores_make_noise";
    static protected String event3 = "feeding animals";
    static protected String event4 = "night_come";
    static protected String event5 = "morning_come";
    static protected String event6 = "thunder";
    private static void herbivores_make_noise(ArrayList<predators> list_of_predators)
    {
        System.out.println("Какое-то травоядное животное кричит! Это привлечет внимание хищников!");
        generate_event_for_predators(list_of_predators,event2);
    }
    public static void zoo_keeper_come_to_herbivores(ArrayList<predators> list_of_predators,ArrayList<herbivores> list_of_herbivores)
    {
        System.out.println("Смотритель зоопарка пришел кормить травоядных животных!");
        generate_event_for_herbivores(list_of_herbivores,event1);
        herbivores_make_noise(list_of_predators);
    }
    public static void zoo_keeper_come_to_predators(ArrayList<predators> list_of_predators)
    {
        System.out.println("Смотритель зоопарка пришел кормить хищных животных!");
        generate_event_for_predators(list_of_predators,event1);
    }
    public static void feeding_predator_animal(ArrayList<predators> list_of_predators)
    {
        System.out.println("Смотритель только что покормил хищных животных!");
        generate_event_for_predators(list_of_predators,event3);
    }
    public static void feeding_herbivores_animal(ArrayList<herbivores> list_of_herbivores)
    {
        System.out.println("Смотритель только что покормил травоядных животных!");
        generate_event_for_herbivores(list_of_herbivores,event3);
    }
    public static void night_come(ArrayList<herbivores> list_of_herbivores,ArrayList<predators> list_of_predators)
    {
        System.out.println("Наступает ночь!");
        if (check_noise()==false)
        {
            System.out.println("Никто из животных не кричит, все могут спать!");
            generate_event_for_herbivores(list_of_herbivores,event4);
            generate_event_for_predators(list_of_predators,event4);
        }
        else
            {
                System.out.println("Какие-то животные кричат и мешают спать остальным!");
            }
    }
    public static void morning_come(ArrayList<herbivores> list_of_herbivores,ArrayList<predators> list_of_predators)
    {
        System.out.println("Наступает утро! Животные просыпаются!");
        generate_event_for_predators(list_of_predators,event5);
        generate_event_for_herbivores(list_of_herbivores,event5);
    }
    public static void thunder(ArrayList<herbivores> list_of_herbivores,ArrayList<predators> list_of_predators)
    {
        System.out.println("ГРОМ!!!");
        generate_event_for_predators(list_of_predators,event6);
        generate_event_for_herbivores(list_of_herbivores,event6);
    }

    protected static void generate_event_for_predators(ArrayList<predators>list_of_predators, String EventName)
    {
        for(int i = 0; i < list_of_predators.size(); i++)
        {
            list_of_predators.get(i).reaction_on_event(EventName);
        }
    }

    protected static void generate_event_for_herbivores(ArrayList<herbivores>list_of_herbivores,String EventName)
    {
        for(int i = 0; i < list_of_herbivores.size(); i++)
        {
            list_of_herbivores.get(i).reaction_on_event(EventName);
        }
    }

    private static boolean check_noise()
    {
        for (int i = 0; i < size_of_herbivores; i++)
        {
            if(list_of_herbivores.get(i).get_noise_status() == true)
            {
                return true;
            }
        }
        for (int i = 0; i < size_of_predators; i++)
        {
            if(list_of_predators.get(i).get_noise_status() == true)
            {
                return true;
            }
        }
        return false;
    }
}
