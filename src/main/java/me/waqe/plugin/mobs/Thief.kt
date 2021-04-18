package me.waqe.plugin.mobs

import net.minecraft.server.v1_16_R2.*  // build.gradle mavenLocal() compileOnly("___")
import org.bukkit.ChatColor
import org.bukkit.Location
import org.bukkit.craftbukkit.v1_16_R2.CraftWorld

class Thief(loc: Location) :
    EntityVillager(EntityTypes.VILLAGER, (loc.world as CraftWorld?)!!.handle) {
    init {
        setPosition(loc.x, loc.y, loc.z)
        this.customName = ChatComponentText("${ChatColor.GOLD}${ChatColor.BOLD}Thief")
        this.customNameVisible = true
        this.health = 100f

        goalSelector.a(
            0, PathfinderGoalAvoidTarget(
                this,
                EntityPlayer::class.java, 15f, 1.0, 1.0
            )
        )
        goalSelector.a(
            1, PathfinderGoalPanic(this, 2.0)
        )
        goalSelector.a(2, PathfinderGoalRandomStrollLand(this, 0.6))
        goalSelector.a(3, PathfinderGoalRandomLookaround(this))
    }
}

