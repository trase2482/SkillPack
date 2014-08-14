package com.shepcraft.SkillPack.classes.warrior.passive;

import java.util.HashMap;
import java.util.UUID;

import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

import com.sucy.skill.api.DamageModifier;
import com.sucy.skill.api.PlayerSkills;
import com.sucy.skill.api.skill.ClassSkill;
import com.sucy.skill.api.skill.PassiveSkill;
import com.sucy.skill.api.skill.SkillAttribute;
import com.sucy.skill.api.skill.SkillType;

public class Rage extends ClassSkill implements PassiveSkill {
	public static final String NAME = "Rage";
	private static final String DAMAGE = "Damage Bonus";
	
	private HashMap<UUID, Integer> active = new HashMap<UUID, Integer>();
	
	public Rage() {
		super(NAME, SkillType.PASSIVE, Material.TNT, 3);
		
		description.add("Passively increases your");
		description.add("melee damage.");
		
		setAttribute(SkillAttribute.LEVEL, 1, 1);
		setAttribute(SkillAttribute.COST, 1, 1);
		
		setAttribute(DAMAGE, 15, 5);
		
		
	}

	public void onInitialize(Player player, int level) {
		active.put(player.getUniqueId(), level);
	}

	public void onUpgrade(Player player, int level) {
		onInitialize(player, level);
	}

	public void stopEffects(Player player, int level) {
		active.remove(player.getUniqueId());
	}
	
	public class RageTask extends BukkitRunnable {
		
		public void run() {
			for (UUID id : active.keySet()) {
				//PlayerSkills player = api.getPlayer(id);
				//Player p = player.getPlayer();
				//int level = active.get(id);
				
				//player.getStatusData().addDamageModifier(new DamageModifier(1 + getAttribute(DAMAGE, level), 1000));
				
			}
		}
	}
}
