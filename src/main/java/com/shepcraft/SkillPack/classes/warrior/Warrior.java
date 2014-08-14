package com.shepcraft.SkillPack.classes.warrior;

import org.bukkit.ChatColor;

import com.shepcraft.SkillPack.classes.warrior.active.Strike;
import com.shepcraft.SkillPack.classes.warrior.passive.Rage;
import com.sucy.skill.api.ClassAttribute;
import com.sucy.skill.api.CustomClass;


public class Warrior extends CustomClass {

	public Warrior() {
		
		super("Warrior", null, ChatColor.RED + "Warrior", 15, 20);
		
		this.addSkills(Strike.NAME, Rage.NAME);
		setAttribute(ClassAttribute.HEALTH, 20, 1);
		setAttribute(ClassAttribute.MANA,80,1);
		
	}
	
	public Warrior(String name, String base, String prefix, int profess, int maxLevel) {
		super("Warrior", null, ChatColor.RED + "Warrior", 15, 20);
	}


}
