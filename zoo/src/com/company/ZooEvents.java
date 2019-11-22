package com.company;

public class ZooEvents {
    static private String event1 = "zoo_keeper_come";
    static private String event2 = "herbivores_make_noise";
    static private String event3 = "feeding animals";
    static private String event4 = "night_come";
    static private String event5 = "morning_come";
    static private String event6 = "thunder";
    private static void herbivores_make_noise()
    {
        System.out.println("Какое-то травоядное животное кричит! Это привлечет внимание хищников!");
        generate_event_for_predators(event2);
    }
    public static void zoo_keeper_come_to_herbivores()
    {
        System.out.println("Смотритель зоопарка пришел кормить травоядных животных!");
        generate_event_for_herbivores(event1);
        herbivores_make_noise();
    }
    public static void zoo_keeper_come_to_predators()
    {
        System.out.println("Смотритель зоопарка пришел кормить хищных животных!");
        generate_event_for_predators(event1);
    }
    public static void feeding_predator_animal()
    {
        System.out.println("Смотритель только что покормил хищных животных!");
        generate_event_for_predators(event3);
    }
    public static void feeding_herbivores_animal()
    {
        System.out.println("Смотритель только что покормил травоядных животных!");
        generate_event_for_herbivores(event3);
    }
    public static void night_come()
    {
        System.out.println("Наступает ночь!");
        if (check_noise()==false)
        {
            System.out.println("Никто из животных не кричит, все могут спать!");
            generate_event_for_herbivores(event4);
            generate_event_for_predators(event4);
        }
        else
            {
                System.out.println("Какие-то животные кричат и мешают спать остальным!");
            }
    }
    public static void morning_come()
    {
        System.out.println("Наступает утро! Животные просыпаются!");
        generate_event_for_predators(event5);
        generate_event_for_herbivores(event5);
    }
    public static void thunder()
    {
        System.out.println("ГРОМ!!!");
        generate_event_for_predators(event6);
        generate_event_for_herbivores(event6);
    }
    private static void generate_event_for_predators(String EventName)
    {
        for(int i = 0; i < Main.size_of_predators; i++)
        {
            Main.list_of_predators.get(i).reaction_on_event(EventName);
        }
    }
    private static void generate_event_for_herbivores(String EventName)
    {
        for(int i = 0; i < Main.size_of_herbivores; i++)
        {
            Main.list_of_herbivores.get(i).reaction_on_event(EventName);
        }
    }
    private static boolean check_noise()
    {
        for (int i = 0; i < Main.size_of_herbivores; i++)
        {
            if(Main.list_of_herbivores.get(i).get_noise_status() == true)
            {
                return true;
            }
        }
        for (int i = 0; i < Main.size_of_predators; i++)
        {
            if(Main.list_of_predators.get(i).get_noise_status() == true)
            {
                return true;
            }
        }
        return false;
    }
}
