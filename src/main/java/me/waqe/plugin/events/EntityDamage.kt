package me.waqe.plugin.events

import org.bukkit.Material
import org.bukkit.entity.Villager
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageEvent
import org.bukkit.inventory.ItemStack
import java.util.*

class EntityDamage : Listener {

    // random drops
    private var goldsack: Array<ItemStack> = arrayOf<ItemStack>(
        ItemStack(Material.GOLD_NUGGET, 16),
        ItemStack(Material.GOLD_BLOCK, 2),
        ItemStack(Material.GOLDEN_AXE, 1),
        ItemStack(Material.IRON_INGOT, 16),
        ItemStack(Material.ENDER_PEARL, 2),
    )


    @EventHandler
    fun onDamage(e: EntityDamageEvent) {
        if (e.entity !is Villager) return
        if (e.entity.customName == null) return
        if (!e.entity.customName!!.contains("Thief")) return
        val r = Random(0)
        e.entity.world.dropItemNaturally(e.entity.location,
            goldsack[r.nextInt(goldsack.size + 0) - 0])

    }
}