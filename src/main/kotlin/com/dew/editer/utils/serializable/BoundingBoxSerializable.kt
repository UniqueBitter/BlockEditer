package top.maplex.DewCore.utils.serializable

import kotlinx.serialization.KSerializer
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.descriptors.buildClassSerialDescriptor
import kotlinx.serialization.descriptors.element
import kotlinx.serialization.encoding.*
import org.bukkit.util.BoundingBox

object BoundingBoxSerializable : KSerializer<BoundingBox> {

    override val descriptor: SerialDescriptor = buildClassSerialDescriptor("org.bukkit.util.BoundingBox") {
        element<Double>("minX")
        element<Double>("minY")
        element<Double>("minZ")
        element<Double>("maxX")
        element<Double>("maxY")
        element<Double>("maxZ")
    }

    override fun deserialize(decoder: Decoder): BoundingBox = decoder.decodeStructure(descriptor) {
        var minX = 0.0
        var minY = 0.0
        var minZ = 0.0
        var maxX = 0.0
        var maxY = 0.0
        var maxZ = 0.0
        while (true) {
            when (val index = decodeElementIndex(descriptor)) {
                0 -> minX = decodeDoubleElement(descriptor, 0)
                1 -> minY = decodeDoubleElement(descriptor, 1)
                2 -> minZ = decodeDoubleElement(descriptor, 2)
                3 -> maxX = decodeDoubleElement(descriptor, 3)
                4 -> maxY = decodeDoubleElement(descriptor, 4)
                5 -> maxZ = decodeDoubleElement(descriptor, 5)
                CompositeDecoder.DECODE_DONE -> break
                else -> error("Unexpected index: $index")
            }
        }
        BoundingBox(minX, minY, minZ, maxX, maxY, maxZ)
    }

    override fun serialize(encoder: Encoder, value: BoundingBox) {
//        encoder.encodeString("${value.minX}::${value.minY}::${value.minZ}::${value.maxX}::${value.maxY}::${value.maxZ}")
        return encoder.encodeStructure(descriptor) {
            encodeDoubleElement(descriptor, 0, value.minX)
            encodeDoubleElement(descriptor, 1, value.minY)
            encodeDoubleElement(descriptor, 2, value.minZ)
            encodeDoubleElement(descriptor, 3, value.maxX)
            encodeDoubleElement(descriptor, 4, value.maxY)
            encodeDoubleElement(descriptor, 5, value.maxZ)
        }
    }

}