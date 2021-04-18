package me.waqe.plugin.events

import me.waqe.plugin.App.Companion.instance
import org.bukkit.Material
import org.bukkit.entity.Villager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDeathEvent
import org.bukkit.inventory.ItemStack

class EntityDeath : Listener {

    // random drops
    private var goldsack: Array<ItemStack> = arrayOf<ItemStack>(
        ItemStack(Material.GOLD_NUGGET, 16),
        ItemStack(Material.GOLD_BLOCK, 2),
        ItemStack(Material.DIAMOND, 32),
        ItemStack(Material.IRON_INGOT, 16),
        ItemStack(Material.ENDER_PEARL, 12),
    )


    @EventHandler
    fun onDeath(e: EntityDeathEvent) {
        // give last random item then drop stolen inventory
        if (e.entity !is Villager) return
        if (e.entity.customName == null) return
        if (!e.entity.customName!!.contains("Thief")) return

        for (item in instance.stolenItems) {
            if (item != null)
                e.entity.world.dropItemNaturally(e.entity.location, item as ItemStack)
        }
    }
}