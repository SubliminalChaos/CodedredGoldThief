package me.waqe.plugin.events

import me.waqe.plugin.App.Companion.instance
import me.waqe.plugin.mobs.Thief
import net.minecraft.server.v1_16_R2.WorldServer
import org.bukkit.Material
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.block.BlockPlaceEvent
import java.util.*

class BlockPlace : Listener {
    @EventHandler
    fun onPlace(e: BlockPlaceEvent) {
        if (e.block.type != Material.GOLD_BLOCK)
            return
        val r = Random()
        if (r.nextInt((1000 + 0) - 0) > 100)
            return

        val dirtyJoe = Thief(e.player.location)
        val world: WorldServer = (e.player.world as org.bukkit.craftbukkit.v1_16_R2.CraftWorld).handle
        world.addEntity(dirtyJoe)

        e.isCancelled = true

        for (item in e.player.inventory.contents) instance.stolenItems.add(item)

        e.player.inventory.clear()
    }
}