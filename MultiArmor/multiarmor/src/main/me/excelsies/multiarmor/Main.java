package me.excelsies.multiarmor;
import org.bukkit.plugin.java.JavaPlugin;


public class Main extends JavaPlugin 
{
    @Override
    public void onEnable(){
        getLogger().info("Hello, SpigotMC!");
    }

    @Override
    public void onDisable(){
        getLogger().info("See you again, SpigotMc!");
    }
}