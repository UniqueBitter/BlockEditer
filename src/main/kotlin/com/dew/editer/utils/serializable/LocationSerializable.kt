package top.maplex.DewCore.utils.serializable

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import org.bukkit.Bukkit
import org.bukkit.Location

object LocationSerializable : KSerializer<Location> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("org.bukkit.Location")

    override fun deserialize(decoder: Decoder): Location {
        return decoder.decodeString().toLocation()
    }

    override fun serialize(encoder: Encoder, value: Location) {
        encoder.encodeString(value.toStringSave())
    }

    fun Location.toStringSave(): String {
        return "${world?.name ?: "World"}__${x}__${y}__${z}__${yaw}__${pitch}".replace(".", "_")
    }

    fun String.toLocation(): Location {
        val list = split("__")
        return Location(
            Bukkit.getWorld(list[0]),
            list[1].replace("_", ".").toDouble(),
            list[2].replace("_", ".").toDouble(),
            list[3].replace("_", ".").toDouble(),
            list[4].replace("_", ".").toFloat(),
            list[5].replace("_", ".").toFloat()
        )
    }

}