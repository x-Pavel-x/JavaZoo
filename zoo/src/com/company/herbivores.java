package com.company;

public class herbivores extends Animal implements AnimalActions {
    herbivores(String kind, String animal_sound)
    {
        this.kind=kind;
        this.animal_sound=animal_sound;
        this.noise_status=false;
        this.sleep_status=false;
    }
    @Override
    public void make_noise()
    {
        if(sleep_status == true)
        {
            wake_up();
        }
        System.out.println("Животное " + kind +" кричит " + animal_sound);
        noise_status = true;
    }
    @Override
    public void go_sleep()
    {
        System.out.println("Животное " + kind + " сейчас спит");
        sleep_status = true;
    }
    @Override
    public void wake_up()
    {
        if(sleep_status == true)
        {
            System.out.println("Животное " + kind + " проснулось");
            sleep_status=false;
        }
    }
    @Override
    public void eat()
    {
        System.out.println("Животное " + kind + " покушало и перестало кричать");
        noise_status=false;
    }
    @Override
    public void reaction_on_event(String Event_Name)
    {
        switch(Event_Name)
        {
            case ("zoo_keeper_come"):
                make_noise();
                break;
            case ("herbivores_make_noise"):
                // травоядные никак не реагируют на крики себеподобных
                break;
            case ("feeding animals"):
                eat();
                break;
            case ("night_come"):
                go_sleep();
                break;
            case ("morning_come"):
                wake_up();
                break;
            case ("thunder"):
                wake_up();
                make_noise();
                break;
            default:
                System.out.println("Произошло нечто, и животное " + kind + " не знает как на это реагировать");
        }
    }
}
