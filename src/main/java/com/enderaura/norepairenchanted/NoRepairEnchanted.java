package com.enderaura.norepairenchanted;

import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.plugin.java.JavaPlugin;

public final class NoRepairEnchanted extends JavaPlugin implements Listener{

    @Override
    public void onEnable() {
        getServer().getPluginManager().registerEvents(this, this);

    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }

    @EventHandler
    public void onClick(InventoryClickEvent e) {
        // We now know they've clicked an Inventory.

        if ((e.getInventory().getType() == InventoryType.ANVIL && e.getSlot() != 2) || (e.getInventory().getType() == InventoryType.ANVIL && e.getSlot() != 0))
            return;
        // Now we know they clicked the output slot of a crafting table or anvil.

        if (e.getInventory().getType() == InventoryType.ANVIL && e.getInventory().getItem(1) != null && e.getInventory().getItem(1).getType() == Material.ENCHANTED_BOOK)
            return;
        // We now know that they're not enchanting an item.

        if (e.getCurrentItem() == null || e.getCurrentItem().getEnchantments().isEmpty())
            return;
        // We now know that they clicked an enchanted item without putting an enchant onto it. Cancel the event.

        e.setCancelled(true);
    }
}
