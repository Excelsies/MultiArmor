package me.excelsies.multiarmor;

import java.util.LinkedList;
import java.util.List;
import java.util.UUID;

import org.bukkit.Material;

import org.bukkit.ChatColor;
import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeModifier;
import org.bukkit.attribute.AttributeModifier.Operation;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.PrepareSmithingEvent;
import org.bukkit.inventory.EquipmentSlot;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.Damageable;
import org.bukkit.inventory.meta.ItemMeta;

public class OnSmithingListener implements Listener {
    
    @EventHandler
    public void onSmithingListener(PrepareSmithingEvent event){

        if(event.getResult().getType() == Material.ELYTRA){
            ItemStack result = new ItemStack(Material.ELYTRA);

            if(event.getInventory().getItem(0).getType() ==  Material.LEATHER_CHESTPLATE){
                result.setItemMeta(createArmorMeta(result, "Leather Elytra", 3, 0, 80));
                event.setResult(result);
            }
            else if(event.getInventory().getItem(0).getType() ==  Material.CHAINMAIL_CHESTPLATE){
                result.setItemMeta(createArmorMeta(result, "Chainmail Elytra", 5, 0, 240));
                event.setResult(result);
            }
            else if(event.getInventory().getItem(0).getType() ==  Material.IRON_CHESTPLATE){
                result.setItemMeta(createArmorMeta(result, "Iron Elytra", 6, 0, 240));
                event.setResult(result);
            }
            else if(event.getInventory().getItem(0).getType() ==  Material.GOLDEN_CHESTPLATE){
                result.setItemMeta(createArmorMeta(result, "Golden Elytra", 5, 0, 112));
                event.setResult(result);
            }
            else if(event.getInventory().getItem(0).getType() ==  Material.DIAMOND_CHESTPLATE){
                result.setItemMeta(createArmorMeta(result, "Diamond Elytra", 8, 2, 528));
                event.setResult(result);
            }
            else if(event.getInventory().getItem(0).getType() ==  Material.NETHERITE_CHESTPLATE){
                ItemMeta meta = createArmorMeta(result, "Netherite Elytra", 8, 3, 592);
                meta.addAttributeModifier(Attribute.GENERIC_KNOCKBACK_RESISTANCE, new AttributeModifier(UUID.randomUUID(), "generic.knockback_resistence", 1, Operation.ADD_NUMBER, EquipmentSlot.CHEST));
                result.setItemMeta(meta);
                event.setResult(result);
            }
        }
        
    }

    private ItemMeta createArmorMeta(ItemStack item, String name, double armor, double toughness, int health) {

        ItemMeta meta = item.getItemMeta();
        meta.setDisplayName(ChatColor.DARK_PURPLE + name);

        List<String> lore = new LinkedList<String>();
        lore.add(ChatColor.BLUE + "An Elytra that has");
        lore.add(ChatColor.BLUE + "been fused with armor");

        meta.setLore(lore);
        
        AttributeModifier armorModifier = new AttributeModifier(UUID.randomUUID(), "generic.armor", armor, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        AttributeModifier toughnessModifier = new AttributeModifier(UUID.randomUUID(), "generic.armor_toughness", toughness, Operation.ADD_NUMBER, EquipmentSlot.CHEST);
        ((Damageable) meta).setDamage(-(health + 432));
        
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR, armorModifier);
        meta.addAttributeModifier(Attribute.GENERIC_ARMOR_TOUGHNESS, toughnessModifier);
        
        return meta;
    }
    
}
