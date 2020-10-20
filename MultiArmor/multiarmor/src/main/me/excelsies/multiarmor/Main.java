package me.excelsies.multiarmor;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.SmithingRecipe;
import org.bukkit.inventory.RecipeChoice;
import org.bukkit.inventory.ShapedRecipe;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.inventory.ItemStack;
import org.bukkit.plugin.java.JavaPlugin;



public class Main extends JavaPlugin
{
    @Override
    public void onEnable(){
        Bukkit.addRecipe(LeatherElytra());
        Bukkit.addRecipe(ChainElytra());
        Bukkit.addRecipe(GoldElytra());
        Bukkit.addRecipe(IronElytra());
        Bukkit.addRecipe(DiamondElytra());
        Bukkit.addRecipe(NetheriteElytra());
        Bukkit.addRecipe(NautilusRecipe());

        getServer().getPluginManager().registerEvents(new OnSmithingListener(), this);

        getLogger().info(ChatColor.GREEN + "[MultiArmor]: Plugin is enabled!");
    }

    @Override
    public void onDisable(){
        getLogger().info(ChatColor.RED + "[MultiArmor]: Plugin is disabled!");
    }

    

    public SmithingRecipe LeatherElytra(){
        
        ItemStack result = new ItemStack(Material.ELYTRA);
        
        RecipeChoice base = new RecipeChoice.MaterialChoice(Material.LEATHER_CHESTPLATE);
        RecipeChoice addition = new RecipeChoice.MaterialChoice(Material.ELYTRA);

        NamespacedKey key = new NamespacedKey(this, "Leather_Armored_Elytra");

        SmithingRecipe recipe = new SmithingRecipe(key, result, base, addition);
        
        
        return recipe;
    }

    public SmithingRecipe ChainElytra(){
        
        ItemStack result = new ItemStack(Material.ELYTRA);
        
        RecipeChoice base = new RecipeChoice.MaterialChoice(Material.CHAINMAIL_CHESTPLATE);
        RecipeChoice addition = new RecipeChoice.MaterialChoice(Material.ELYTRA);
        
        NamespacedKey key = new NamespacedKey(this, "Chainmail_Armored_Elytra");

        SmithingRecipe recipe = new SmithingRecipe(key, result, base, addition);

        return recipe;
    }

    public SmithingRecipe IronElytra(){
        
        ItemStack result = new ItemStack(Material.ELYTRA);
        
        RecipeChoice base = new RecipeChoice.MaterialChoice(Material.IRON_CHESTPLATE);
        RecipeChoice addition = new RecipeChoice.MaterialChoice(Material.ELYTRA);
        
        NamespacedKey key = new NamespacedKey(this, "Iron_Armored_Elytra");

        SmithingRecipe recipe = new SmithingRecipe(key, result, base, addition);

        return recipe;
    }

    
    public SmithingRecipe GoldElytra(){
        
        ItemStack result = new ItemStack(Material.ELYTRA);
        
        RecipeChoice base = new RecipeChoice.MaterialChoice(Material.GOLDEN_CHESTPLATE);
        RecipeChoice addition = new RecipeChoice.MaterialChoice(Material.ELYTRA);
        
        NamespacedKey key = new NamespacedKey(this, "Gold_Armored_Elytra");

        SmithingRecipe recipe = new SmithingRecipe(key, result, base, addition);

        return recipe;
    }

    public SmithingRecipe DiamondElytra(){
        
        ItemStack result = new ItemStack(Material.ELYTRA);
        
        RecipeChoice base = new RecipeChoice.MaterialChoice(Material.DIAMOND_CHESTPLATE);
        RecipeChoice addition = new RecipeChoice.MaterialChoice(Material.ELYTRA);
        
        NamespacedKey key = new NamespacedKey(this, "Diamond_Armored_Elytra");

        SmithingRecipe recipe = new SmithingRecipe(key, result, base, addition);

        return recipe;
    }

    public SmithingRecipe NetheriteElytra(){
        
        ItemStack result = new ItemStack(Material.ELYTRA);
        RecipeChoice base = new RecipeChoice.MaterialChoice(Material.NETHERITE_CHESTPLATE);
        RecipeChoice addition = new RecipeChoice.MaterialChoice(Material.ELYTRA);
        
        NamespacedKey key = new NamespacedKey(this, "Netherite_Armored_Elytra");

        SmithingRecipe recipe = new SmithingRecipe(key, result, base, addition);

        return recipe;
    } 

    public ShapedRecipe NautilusRecipe(){
        ItemStack result = new ItemStack(Material.NAUTILUS_SHELL);

        NamespacedKey key = new NamespacedKey(this, "Nautilus_Shell");
        ShapedRecipe recipe = new ShapedRecipe(key, result);
        recipe.shape("RBG" , "B B" , "GBR");
        recipe.setIngredient('B', Material.BONE_MEAL);
        recipe.setIngredient('R', Material.BLAZE_POWDER);
        recipe.setIngredient('G', Material.GUNPOWDER);

        return recipe;
    }
/*
    public ShapelessRecipe DiamondShapelessElytra(){
        
        ItemStack result = new ItemStack(Material.ELYTRA);
        
        result.setItemMeta(createArmorMeta(result, "Diamond Elytra", 3, 0, 528)); 

        NamespacedKey key = new NamespacedKey(this, "Diamond_Armored_Elytra");

        ShapelessRecipe recipe = new ShapelessRecipe(key, result);

        recipe.addIngredient(Material.ELYTRA);
        recipe.addIngredient(Material.DIAMOND_CHESTPLATE);

        return recipe;
    } //*/
}
