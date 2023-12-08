package com.shiny_labs.bonesupdate.init;

import com.shiny_labs.bonesupdate.BonesUpdate;
import com.shiny_labs.bonesupdate.common.enchantments.LeaderEnchantment;
import com.shiny_labs.bonesupdate.common.items.AmuletItem;
import com.shiny_labs.bonesupdate.common.items.NecroScepterItem;
import com.shiny_labs.bonesupdate.common.enchantments.SerenityEnchantment;
import com.shiny_labs.bonesupdate.common.enchantments.SubordinateEnchantment;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.item.enchantment.Enchantment;
import net.minecraft.world.item.enchantment.EnchantmentCategory;
import net.minecraftforge.registries.DeferredRegister;
import net.minecraftforge.registries.ForgeRegistries;
import net.minecraftforge.registries.RegistryObject;

public class BonesEnchantments {
    public static final DeferredRegister<Enchantment> BU_ENCHANTMENTS = DeferredRegister.create(ForgeRegistries.ENCHANTMENTS, BonesUpdate.MODID);
    public static final RegistryObject<Enchantment> SERENITY = BU_ENCHANTMENTS.register("serenity", ()-> new SerenityEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));
    public static final RegistryObject<Enchantment> SUBORDINATE = BU_ENCHANTMENTS.register("subordinate", ()->new SubordinateEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));
    public static final RegistryObject<Enchantment> LEADER = BU_ENCHANTMENTS.register("leader", ()->new LeaderEnchantment(Enchantment.Rarity.RARE, EquipmentSlot.MAINHAND));

    public static final EnchantmentCategory NECROMANCY = EnchantmentCategory.create("necromancy", item -> item instanceof NecroScepterItem);
    public static final EnchantmentCategory SKELETON_QUEST = EnchantmentCategory.create("skeleton_quest", item -> item instanceof NecroScepterItem || item instanceof AmuletItem);
}
