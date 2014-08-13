package com.shepcraft.SkillPack.classes.warrior.active;

import org.bukkit.Material;
import org.bukkit.entity.LivingEntity;
import org.bukkit.entity.Player;

import com.sucy.skill.*;
import com.sucy.skill.api.skill.ClassSkill;
import com.sucy.skill.api.skill.SkillAttribute;
import com.sucy.skill.api.skill.SkillType;
import com.sucy.skill.api.skill.TargetSkill;
import com.sucy.skill.api.util.effects.DOT;
import com.sucy.skill.api.util.effects.DOTSet;

public class Strike extends ClassSkill implements TargetSkill{
	
	public static final String NAME = "Strike";
	private static final String DAMAGE = "Damage";
	private static final String BLEED_DAMAGE = "Bleed Damage";
	
	public Strike() {
		super("Strike", SkillType.TARGET, Material.WOOD_SWORD, 5);
		
		description.add("Strikes your target,");
		description.add("causing damage, and ");
		description.add("has a chance to cause");
		description.add("them to bleed.");
		
		setAttribute(SkillAttribute.COOLDOWN, 15, -1);
		setAttribute(SkillAttribute.COST, 1, 0);
		setAttribute(SkillAttribute.LEVEL, 1, 2);
		setAttribute(SkillAttribute.MANA, 25, -1);
		setAttribute(DAMAGE, 10, .5);
		setAttribute(BLEED_DAMAGE, 2, 2);
	}

	public boolean cast(Player player, LivingEntity target, int level, boolean ally) {
		boolean worked = false;
		if (!ally) {
			int damage = (int) getAttribute(DAMAGE, level);
			target.damage(damage, player);
			DOTSet set = api.getDOTHelper().getDOTSet(event.getTarget())
			set.addEffect(NAME, new DOT(100, getAttribute(BLEED_DAMAGE, level) / 5, 20, true));
			worked = true;
			
		}
		return worked;
	}

}
