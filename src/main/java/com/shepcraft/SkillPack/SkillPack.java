package com.shepcraft.SkillPack;

import com.shepcraft.SkillPack.classes.warrior.Warrior;
import com.shepcraft.SkillPack.classes.warrior.active.Strike;
import com.sucy.skill.SkillAPI;
import com.sucy.skill.api.SkillPlugin;

import org.bukkit.plugin.java.JavaPlugin;

public final class SkillPack extends JavaPlugin implements SkillPlugin {
	

	@Override
	public void onEnable() {
		// Performed when the plugin is enabled
		getLogger().info("Custom skillpack enabled!");
	}

	@Override
	public void onDisable() {
		// Performed when the plugin is disabled
		getLogger().info("Custom skillpack disabled!");
	}

	public void registerClasses(SkillAPI api) {
		api.addClasses(new Warrior());

	}

	public void registerSkills(SkillAPI api) {

		api.addSkills(

		// Warrior
				new Strike()

		// TODO: Add more skills!
		);

	}
}
