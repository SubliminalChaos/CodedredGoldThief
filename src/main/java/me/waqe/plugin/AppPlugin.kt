package me.waqe.plugin

import me.waqe.plugin.events.BlockPlace
import me.waqe.plugin.events.EntityDamage
import me.waqe.plugin.events.EntityDeath
import org.bukkit.command.Command
import org.bukkit.command.CommandSender
import org.bukkit.entity.Player
import org.bukkit.event.Listener
import org.bukkit.plugin.java.JavaPlugin

class App : JavaPlugin(), Listener {
    companion object {
        lateinit var instance: App
    }

    var stolenItems: ArrayList<Any> = ArrayList<Any>()

    override fun onEnable() {
        instance = this

        //this.reloadConfig()
        //this.saveDefaultConfig()

        this.server.pluginManager.registerEvents(EntityDamage(), this)
        this.server.pluginManager.registerEvents(EntityDeath(), this)
        this.server.pluginManager.registerEvents(BlockPlace(), this)
    }

    override fun onDisable() {

    }

}
