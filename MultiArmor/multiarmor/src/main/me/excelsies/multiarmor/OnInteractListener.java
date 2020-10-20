package me.excelsies.multiarmor;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.Material;
import org.bukkit.Server;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.permissions.Permission;

public class OnInteractListener implements Listener {

    @EventHandler
    public void onInteractListener(PlayerInteractEvent event){
        Action action = event.getAction();
        Player player = event.getPlayer();
        
        Server admin = Bukkit.getServer();

        ItemStack i = event.getItem();

        if(action.equals(Action.RIGHT_CLICK_AIR) || action.equals(Action.RIGHT_CLICK_BLOCK)){
            if(event.getItem().getType() == Material.CLOCK){
                if(i.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Time Stone")){
                    if(i.getItemMeta().getLore().contains(ChatColor.BLUE + "A stone that controls time")){
                        player.sendMessage("You used the " + i.getItemMeta().getDisplayName() + "!");
                        admin.dispatchCommand(admin.getConsoleSender(), "minecraft:time set 0d");
                    }
                }
            }
            else if(event.getItem().getType() == Material.BLAZE_ROD){
                if(i.getItemMeta().getDisplayName().equals(ChatColor.DARK_PURPLE + "Weather Stick")){
                    if(i.getItemMeta().getLore().contains(ChatColor.BLUE + "A stick that controls the weather")){
                        player.sendMessage("You used the " + i.getItemMeta().getDisplayName() + "!");
                        admin.dispatchCommand(admin.getConsoleSender(), "minecraft:weather clear");
                    }
                }
            }
            
        }
    }

}
