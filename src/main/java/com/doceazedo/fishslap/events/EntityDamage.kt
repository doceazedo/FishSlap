package com.doceazedo.fishslap.events

import com.doceazedo.fishslap.FishSlap
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.event.EventHandler
import org.bukkit.event.Listener
import org.bukkit.event.entity.EntityDamageByEntityEvent
import org.bukkit.util.Vector

val distanceX = FishSlap.instance!!.config.getDouble("distance")
val fishes = arrayOf(
    Material.TROPICAL_FISH,
    Material.PUFFERFISH,
    Material.SALMON,
    Material.COD,
    Material.COOKED_SALMON,
    Material.COOKED_COD
)

object EntityDamage: Listener {
    @EventHandler
    public fun onEntityDamageByEntity(e: EntityDamageByEntityEvent) {
        val victim = e.entity
        val attacker = e.damager
        if (
            victim !is Player ||
            attacker !is Player ||
            !victim.hasPermission("fishslap.canbeslapped") ||
            !attacker.hasPermission("fishslap.canslap")
        ) return
        if (!fishes.contains(attacker.inventory.itemInMainHand.type)) return;
        val knockback: Vector = attacker.location.direction.multiply(distanceX).setY(victim.location.y * 2)
        victim.velocity = knockback
    }
}