package com.Osmium.OsmiumsMagic.curios;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMultimap;
import com.google.common.collect.Multimap;
import io.redspace.ironsspellbooks.item.curios.CurioBaseItem;
import net.minecraft.world.entity.ai.attributes.Attribute;
import net.minecraft.world.entity.ai.attributes.AttributeModifier;
import net.minecraft.world.item.ItemStack;
import top.theillusivec4.curios.api.SlotContext;

import java.util.Map;
import java.util.UUID;

public class TripleAttributeCurio extends CurioBaseItem {

    private final Multimap<Attribute, AttributeModifier> attributeMap;

    public TripleAttributeCurio(Properties properties, Attribute attribute1, AttributeModifier attributeModifier1, Attribute attribute2, AttributeModifier attributeModifier2, Attribute attribute3, AttributeModifier attributeModifier3) {
        super(properties);

        this.attributeMap = HashMultimap.create();
        attributeMap.put(attribute1, attributeModifier1);
        attributeMap.put(attribute2, attributeModifier2);
        attributeMap.put(attribute3, attributeModifier3);
    }

    @Override
    public Multimap<Attribute, AttributeModifier> getAttributeModifiers(SlotContext slotContext, UUID uuid, ItemStack stack) {
        ImmutableMultimap.Builder<Attribute, AttributeModifier> builder = ImmutableMultimap.builder();

        for (Map.Entry<Attribute, AttributeModifier> entry : attributeMap.entries()) {
            Attribute attr = entry.getKey();
            AttributeModifier mod = entry.getValue();

            builder.put(attr, new AttributeModifier(
                    uuid,
                    mod.getName(),
                    mod.getAmount(),
                    mod.getOperation()
            ));
        }

        return builder.build();
    }
}
