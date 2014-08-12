package com.shepcraft.SkillPack.classes.warrior.active;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.sucy.skill.*;
import com.sucy.skill.api.skill.ClassSkill;
import com.sucy.skill.api.skill.SkillAttribute;
import com.sucy.skill.api.skill.SkillType;
import com.sucy.skill.api.skill.TargetSkill;

public class Strike extends ClassSkill implements TargetSkill{
	
	public static final String NAME = "Strike";
	private static final String DAMAGE = "Damage";
	
	public Strike() {
		super("Strike", SkillType.TARGET, Material.WOOD_SWORD, 5);
		
		description.add("Strikes your target,");
		description.add("causing damage, and ");
		description.add("has a chance to cause");
		description.add("them to bleed.");
		
		setAttribute(SkillAttribute.COOLDOWN, 10, -1);
		setAttribute(SkillAttribute.COST, 1, 0);
		setAttribute(SkillAttribute.LEVEL, 1, 2);
		setAttribute(SkillAttribute.MANA, 10, 0);
		setAttribute(DAMAGE, 10, 1);
	}

	public boolean cast(Player player, LivingEntity target, int level, boolean ally) {
		if (!ally) {
			int damage = (int) getAttribute(DAMAGE, level);
			target.damage(damage);
		}
		return false;
	}

}
