package com.doceazedo.fishslap

import com.doceazedo.fishslap.events.EntityDamage
import org.bukkit.Bukkit
import org.bukkit.plugin.java.JavaPlugin

class FishSlap : JavaPlugin() {
    companion object {
        var instance: FishSlap? = null
    }

    override fun onEnable() {
        instance = this
        instance?.saveDefaultConfig()
        Bukkit.getPluginManager().registerEvents(EntityDamage, this)
    }

    override fun onDisable() {
        // Plugin shutdown logic
    }
}