package com.dew.editer

import org.bukkit.Material
import org.bukkit.entity.Player
import taboolib.common.platform.command.*
import taboolib.expansion.createHelper

@CommandHeader("setblkcokin", permission = "panling.admin")
object Setblockin {
    @CommandBody(permission = "panling.admin")
    val main = mainCommand {
        createHelper()
    }
    @CommandBody(permission = "panling.admin")
    val green = subCommand {
        execute<Player> {
            sender, context, argument ->
            sender.world.getBlockAt(63,30,-40).setType(Material.GREEN_WOOL)
            sender.world.getBlockAt(63,31,-49).setType(Material.GREEN_WOOL)
            sender.world.getBlockAt(63,30,-58).setType(Material.GREEN_WOOL)
        }
    }

    @CommandBody(permission = "panling.admin")
    val white = subCommand {
        execute<Player> {
                sender, context, argument ->
            sender.world.getBlockAt(63,30,-40).setType(Material.WHITE_WOOL)
            sender.world.getBlockAt(63,31,-49).setType(Material.WHITE_WOOL)
            sender.world.getBlockAt(63,30,-58).setType(Material.WHITE_WOOL)
        }
    }

    @CommandBody(permission = "panling.admin")
    val red = subCommand {
        execute<Player> {
                sender, context, argument ->
            sender.world.getBlockAt(63,30,-40).setType(Material.RED_WOOL)
            sender.world.getBlockAt(63,31,-49).setType(Material.RED_WOOL)
            sender.world.getBlockAt(63,30,-58).setType(Material.RED_WOOL)
        }
    }
}