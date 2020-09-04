package com.petscape.server.models

import com.fasterxml.jackson.annotation.JsonIgnore
import com.petscape.server.models.DropTag.*

enum class Drop(
    val item: String,
    val file: String,
    @JsonIgnore val tags: List<DropTag> = emptyList()
) {
    abyssalBludgeon(
        "Abyssal Bludgeon",
        "abyssal_bludgeon.png"
    ),
    abyssalDagger(
        "Abyssal Dagger",
        "abyssal_dagger.png"
    ),
    abyssalHead(
        "Abyssal Head",
        "abyssal_head.png"
    ),
    abyssalOrphan(
        "Abyssal Orphan",
        "abyssal_orphan.png",
        listOf(PET)
    ),
    abyssalWhip(
        "Abyssal Whip",
        "abyssal_whip.png"
    ),
    alchemicalHydraHeads(
        "Alchemical Hydra Heads",
        "alchemical_hydra_heads.png",
        listOf(HEAD)
    ),
    arcaneSigil(
        "Arcane Sigil",
        "arcane_sigil.png"
    ),
    archersRing(
        "Archers Ring",
        "archers_ring.png"
    ),
    armadylChainskirt(
        "Armadyl Chainskirt",
        "armadyl_chainskirt.png"
    ),
    armadylChestplate(
        "Armadyl Chestplate",
        "armadyl_chestplate.png"
    ),
    armadylCrossbow(
        "Armadyl Crossbow",
        "armadyl_crossbow.png"
    ),
    armadylHelmet(
        "Armadyl Helmet",
        "armadyl_helmet.png"
    ),
    armadylHilt(
        "Armadyl Hilt",
        "armadyl_hilt.png"
    ),
    bandosBoots(
        "Bandos Boots",
        "bandos_boots.png"
    ),
    bandosChestplate(
        "Bandos Chestplate",
        "bandos_chestplate.png"
    ),
    bandosHilt(
        "Bandos Hilt",
        "bandos_hilt.png"
    ),
    bandosTassets(
        "Bandos Tassets",
        "bandos_tassets.png"
    ),
    berserkerRing(
        "Berserker Ring",
        "berserker_ring.png"
    ),
    blackTourmalineCore(
        "Black Tourmaline Core",
        "black_tourmaline_core.png"
    ),
    brimstoneRing(
        "Brimstone Ring",
        "brimstone_ring.png"
    ),
    callistoCub(
        "Callisto Cub",
        "callisto_cub.png",
        listOf(PET)
    ),
    chaosElementalJr(
        "Chaos Elemental Jr.",
        "chaos_elemental_jr.png",
        listOf(PET)
    ),
    dagannothPrimeJr(
        "Dagannoth Prime Jr.",
        "dagannoth_prime_jr.png",
        listOf(PET)
    ),
    dagannothRexJr(
        "Dagannoth Rex Jr.",
        "dagannoth_rex_jr.png",
        listOf(PET)
    ),
    dagannothSupremeJr(
        "Dagannoth Supreme Jr.",
        "dagannoth_supreme_jr.png",
        listOf(PET)
    ),
    draconicVisage(
        "Draconic Visage",
        "draconic_visage.png"
    ),
    dragon2hSword(
        "Dragon 2h Sword",
        "dragon_2h_sword.png"
    ),
    dragonAxe(
        "Dragon Axe",
        "dragon_axe.png"
    ),
    dragonboneNecklace(
        "Dragonbone Necklace",
        "dragonbone_necklace.png"
    ),
    dragonChainbody(
        "Dragon Chainbody",
        "dragon_chainbody.png"
    ),
    dragonPickaxe(
        "Dragon Pickaxe",
        "dragon_pickaxe.png"
    ),
    eliteClueScroll(
        "Clue Scroll (Elite)",
        "clue_scroll_elite.png",
        listOf(CLUE)
    ),
    elysianSigil(
        "Elysian Sigil",
        "elysian_sigil.png"
    ),
    eternalCrystal(
        "Eternal Crystal",
        "eternal_crystal.png"
    ),
    generalGraardorJr(
        "General Graardor Jr.",
        "general_graardor_jr.png",
        listOf(PET)
    ),
    graniteGloves(
        "Granite Gloves",
        "granite_gloves.png"
    ),
    graniteHammer(
        "Granite Hammer",
        "granite_hammer.png"
    ),
    graniteRing(
        "Granite Ring",
        "granite_ring.png"
    ),
    hellpuppy(
        "Hellpuppy",
        "hellpuppy.png",
        listOf(PET)
    ),
    holyElixir(
        "Holy Elixir",
        "holy_elixir.png"
    ),
    hydraLeather(
        "Hydra Leather",
        "hydra_leather.png"
    ),
    hydrasClaw(
        "Hydra's Claw",
        "hydras_claw.png"
    ),
    hydraTail(
        "Hydra Tail",
        "hydra_tail.png"
    ),
    ikkleHydra(
        "Ikkle Hydra",
        "ikkle_hydra.png",
        listOf(PET)
    ),
    jarOfChemicals(
        "Jar of Chemicals",
        "jar_of_chemicals.png",
        listOf(JAR)
    ),
    jarOfDecay(
        "Jar of Decay",
        "jar_of_decay.png",
        listOf(JAR)
    ),
    jarOfDirt(
        "Jar of Dirt",
        "jar_of_dirt.png",
        listOf(JAR)
    ),
    jarOfEyes(
        "Jar of Eyes",
        "jar_of_eyes.png",
        listOf(JAR)
    ),
    jarOfMiasma(
        "Jar of Miasma",
        "jar_of_miasma.png",
        listOf(JAR)
    ),
    jarOfSand(
        "Jar of Sand",
        "jar_of_sand.png",
        listOf(JAR)
    ),
    jarOfSouls(
        "Jar of Souls",
        "jar_of_souls.png",
        listOf(JAR)
    ),
    jarOfStone(
        "Jar of Stone",
        "jar_of_stone.png",
        listOf(JAR)
    ),
    jarOfSwamp(
        "Jar of Swamp",
        "jar_of_swamp.png",
        listOf(JAR)
    ),
    kalphitePrincess(
        "Kalphite Princess",
        "kalphite_princess.png",
        listOf(PET)
    ),
    kbdHeads(
        "KBD Heads",
        "kbd_heads.png",
        listOf(HEAD)
    ),
    kqHead(
        "KQ Head",
        "kq_head.png",
        listOf(HEAD)
    ),
    krakenTentacle(
        "Kraken Tentacle",
        "kraken_tentacle.png"
    ),
    kreeArraJr(
        "Kree'Arra Jr.",
        "kree_arra_jr.png",
        listOf(PET)
    ),
    krilTsutsarothJr(
        "Kril Tsutsaroth Jr.",
        "kril_tsutsaroth_jr.png",
        listOf(PET)
    ),
    magicFang(
        "Magic Fang",
        "magic_fang.png"
    ),
    maledictionShard3(
        "Malediction Shard 3",
        "malediction_shard_3.png"
    ),
    mudBattlestaff(
        "Mud Battlestaff",
        "mud_battlestaff.png"
    ),
    noon(
        "Noon",
        "noon.png",
        listOf(PET)
    ),
    occultNecklace(
        "Occult Necklace",
        "occult_necklace.png"
    ),
    odiumShard3(
        "Odium Shard 3",
        "odium_shard_3.png"
    ),
    pegasianCrystal(
        "Pegasian Crystal",
        "pegasian_crystal.png"
    ),
    petDarkCore(
        "Pet Dark Core",
        "pet_dark_core.png",
        listOf(PET)
    ),
    petKraken(
        "Pet Kraken",
        "pet_kraken.png",
        listOf(PET)
    ),
    petSmokeDevil(
        "Pet Smoke Devil",
        "pet_smoke_devil.png",
        listOf(PET)
    ),
    petSnakeling(
        "Pet snakeling",
        "pet_snakeling.png",
        listOf(PET)
    ),
    primordialCrystal(
        "Primordial Crystal",
        "primordial_crystal.png"
    ),
    princeBlackDragon(
        "Prince Black Dragon",
        "prince_black_dragon.png",
        listOf(PET)
    ),
    ringOfTheGods(
        "Ring of the Gods",
        "ring_of_the_gods.png"
    ),
    sarachnisCudgel(
        "Sarachnis Cudgel",
        "sarachnis_cudgel.png"
    ),
    saradominHilt(
        "Saradomin Hilt",
        "saradomin_hilt.png"
    ),
    saradominsLight(
        "Saradomin's Light",
        "saradomins_light.png"
    ),
    saradominSword(
        "Saradomin Sword",
        "saradomin_sword.png"
    ),
    scorpiasOffspring(
        "Scorpia's Offspring",
        "scorpias_offspring.png",
        listOf(PET)
    ),
    serpentineVisage(
        "Serpentine Visage",
        "serpentine_visage.png"
    ),
    smokeBattlestaff(
        "Smoke Battlestaff",
        "smoke_battlestaff.png"
    ),
    sraracha(
        "Sraracha",
        "sraracha.png",
        listOf(PET)
    ),
    seerCull(
        "Seercull",
        "seercull.png"
    ),
    seersRing(
        "Seers Ring",
        "seers_ring.png"
    ),
    smoulderingStone(
        "Smouldering Stone",
        "smouldering_stone.png"
    ),
    spectralSigil(
        "Spectral Sigil",
        "spectral_sigil.png"
    ),
    spiritShield(
        "Spirit Shield",
        "spirit_shield.png"
    ),
    staffOfTheDead(
        "Staff of the Dead",
        "staff_of_the_dead.png"
    ),
    steamBattlestaff(
        "Steam Battlestaff",
        "steam_battlestaff.png"
    ),
    tanzaniteFang(
        "Tanzanite Fang",
        "tanzanite_fang.png"
    ),
    treasonousRing(
        "Treasonous Ring",
        "treasonous_ring.png"
    ),
    tridentOfTheSeas(
        "Trident of the Seas",
        "trident_of_the_seas.png"
    ),
    tyrannicalRing(
        "Tyrannical Ring",
        "tyrannical_ring.png"
    ),
    uncutOnyx(
        "Uncut Onyx",
        "uncut_onyx.png"
    ),
    venenatisSpiderling(
        "Venenatis Spiderling",
        "venenatis_spiderling.png",
        listOf(PET)
    ),
    vetionJr(
        "Vet'ion Jr.",
        "vetion_jr.png",
        listOf(PET)
    ),
    vorki(
        "Vorki",
        "vorki.png",
        listOf(PET)
    ),
    warriorring(
        "Warrior Ring",
        "warrior_ring.png"
    ),
    zamorakHilt(
        "Zamorak Hilt",
        "zamorak_hilt.png"
    ),
    zamorakianSpear(
        "Zamorakian Spear",
        "zamorakian_spear.png"
    ),
    zilyanaJr(
        "Zilyana Jr.",
        "zilyana_jr.png",
        listOf(PET)
    )
}