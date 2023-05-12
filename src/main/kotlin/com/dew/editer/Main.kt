package com.dew.editer

import com.dew.editer.utils.toConsole
import taboolib.common.platform.Plugin
import taboolib.module.chat.colored


object Main : Plugin() {
    override fun onEnable() {
        toConsole("&ablockediter加载完毕".colored())
    }


}