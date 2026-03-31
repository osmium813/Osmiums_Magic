package com.Osmium.OsmiumsMagic.compat;

import com.Osmium.OsmiumsMagic.Main.Osmiumsmagic;
import com.Osmium.OsmiumsMagic.gui.reinforcementtable.ReinforcementTableScreen;
import com.Osmium.OsmiumsMagic.gui.synthesis_table.SynthesisTableScreen;
import com.Osmium.OsmiumsMagic.recipe.ReinforcementRecipe;
import com.Osmium.OsmiumsMagic.recipe.SynthesisRecipe;
import mezz.jei.api.IModPlugin;
import mezz.jei.api.JeiPlugin;
import mezz.jei.api.registration.IGuiHandlerRegistration;
import mezz.jei.api.registration.IRecipeCategoryRegistration;
import mezz.jei.api.registration.IRecipeRegistration;
import net.minecraft.client.Minecraft;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.RecipeManager;

import java.util.List;

@JeiPlugin
public class JEIOsmiumsmagicPlugin implements IModPlugin {
    @Override
    public ResourceLocation getPluginUid() {
        return new ResourceLocation(Osmiumsmagic.MOD_ID, "jei_plugin");
    }

    @Override
    public void registerCategories(IRecipeCategoryRegistration registration) {
        registration.addRecipeCategories(new ReinforcementCategory(registration.getJeiHelpers().getGuiHelper()));
        registration.addRecipeCategories(new SynthesisCategory(registration.getJeiHelpers().getGuiHelper()));
    }

    @Override
    public void registerRecipes(IRecipeRegistration registration) {
        RecipeManager recipeManager = Minecraft.getInstance().level.getRecipeManager();

        List<ReinforcementRecipe> reinforcementRecipes = recipeManager.getAllRecipesFor(ReinforcementRecipe.Type.INSTANCE);
        List<SynthesisRecipe> synthesisRecipes = recipeManager.getAllRecipesFor(SynthesisRecipe.Type.INSTANCE);
        registration.addRecipes(ReinforcementCategory.REINFORCEMENT_RECIPE_TYPE, reinforcementRecipes);
        registration.addRecipes(SynthesisCategory.SYNTHESIS_RECIPE_TYPE, synthesisRecipes);
    }

    @Override
    public void registerGuiHandlers(IGuiHandlerRegistration registration) {
        registration.addRecipeClickArea(ReinforcementTableScreen.class, 93, 42, 20, 30,
                ReinforcementCategory.REINFORCEMENT_RECIPE_TYPE);
        registration.addRecipeClickArea(SynthesisTableScreen.class, 93, 35, 20, 30,
                SynthesisCategory.SYNTHESIS_RECIPE_TYPE);
    }


}
