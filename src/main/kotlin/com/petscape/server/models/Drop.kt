package com.petscape.server.models

import com.petscape.server.models.DropTag.*

@Suppress("unused")
class DropModel(drop: Drop) {
    val item = drop.item
    val file = drop.file
}

enum class Drop(
    val item: String,
    val file: String,
    val tags: List<DropTag> = emptyList()
) {
    AbyssalBludgeon(
        "Abyssal Bludgeon",
        "abyssal_bludgeon.png"
    ),
    AbyssalDagger(
        "Abyssal Dagger",
        "abyssal_dagger.png"
    ),
    AbyssalHead(
        "Abyssal Head",
        "abyssal_head.png"
    ),
    AbyssalOrphan(
        "Abyssal Orphan",
        "abyssal_orphan.png",
        listOf(PET)
    ),
    AbyssalWhip(
        "Abyssal Whip",
        "abyssal_whip.png"
    ),
    AlchemicalHydraHeads(
        "Alchemical Hydra Heads",
        "alchemical_hydra_heads.png",
        listOf(HEAD)
    ),
    ArcaneSigil(
        "Arcane Sigil",
        "arcane_sigil.png"
    ),
    ArchersRing(
        "Archers Ring",
        "archers_ring.png"
    ),
    ArmadylChainskirt(
        "Armadyl Chainskirt",
        "armadyl_chainskirt.png"
    ),
    ArmadylChestplate(
        "Armadyl Chestplate",
        "armadyl_chestplate.png"
    ),
    ArmadylCrossbow(
        "Armadyl Crossbow",
        "armadyl_crossbow.png"
    ),
    ArmadylHelmet(
        "Armadyl Helmet",
        "armadyl_helmet.png"
    ),
    ArmadylHilt(
        "Armadyl Hilt",
        "armadyl_hilt.png"
    ),
    BandosBoots(
        "Bandos Boots",
        "bandos_boots.png"
    ),
    BandosChestplate(
        "Bandos Chestplate",
        "bandos_chestplate.png"
    ),
    BandosHilt(
        "Bandos Hilt",
        "bandos_hilt.png"
    ),
    BandosTassets(
        "Bandos Tassets",
        "bandos_tassets.png"
    ),
    BerserkerRing(
        "Berserker Ring",
        "berserker_ring.png"
    ),
    BlackTourmalineCore(
        "Black Tourmaline Core",
        "black_tourmaline_core.png"
    ),
    BrimstoneRing(
        "Brimstone Ring",
        "brimstone_ring.png"
    ),
    CallistoCub(
        "Callisto Cub",
        "callisto_cub.png",
        listOf(PET)
    ),
    ChaosElementalJr(
        "Chaos Elemental Jr.",
        "chaos_elemental_jr.png",
        listOf(PET)
    ),
    DagannothPrimeJr(
        "Dagannoth Prime Jr.",
        "dagannoth_prime_jr.png",
        listOf(PET)
    ),
    DagannothRexJr(
        "Dagannoth Rex Jr.",
        "dagannoth_rex_jr.png",
        listOf(PET)
    ),
    DagannothSupremeJr(
        "Dagannoth Supreme Jr.",
        "dagannoth_supreme_jr.png",
        listOf(PET)
    ),
    DraconicVisage(
        "Draconic Visage",
        "draconic_visage.png"
    ),
    Dragon2hSword(
        "Dragon 2h Sword",
        "dragon_2h_sword.png"
    ),
    DragonAxe(
        "Dragon Axe",
        "dragon_axe.png"
    ),
    DragonboneNecklace(
        "Dragonbone Necklace",
        "dragonbone_necklace.png"
    ),
    DragonChainbody(
        "Dragon Chainbody",
        "dragon_chainbody.png"
    ),
    DragonPickaxe(
        "Dragon Pickaxe",
        "dragon_pickaxe.png"
    ),
    EldritchOrb(
        "Eldritch Orb",
        "eldritch_orb.png"
    ),
    EliteClueScroll(
        "Clue Scroll (Elite)",
        "clue_scroll_elite.png",
        listOf(CLUE)
    ),
    ElysianSigil(
        "Elysian Sigil",
        "elysian_sigil.png"
    ),
    EternalCrystal(
        "Eternal Crystal",
        "eternal_crystal.png"
    ),
    GeneralGraardorJr(
        "General Graardor Jr.",
        "general_graardor_jr.png",
        listOf(PET)
    ),
    GraniteGloves(
        "Granite Gloves",
        "granite_gloves.png"
    ),
    GraniteHammer(
        "Granite Hammer",
        "granite_hammer.png"
    ),
    GraniteRing(
        "Granite Ring",
        "granite_ring.png"
    ),
    HarmonisedOrb(
        "Harmonised Orb",
        "harmonised_orb.png"
    ),
    Hellpuppy(
        "Hellpuppy",
        "hellpuppy.png",
        listOf(PET)
    ),
    HolyElixir(
        "Holy Elixir",
        "holy_elixir.png"
    ),
    HydraLeather(
        "Hydra Leather",
        "hydra_leather.png"
    ),
    HydrasClaw(
        "Hydra's Claw",
        "hydras_claw.png"
    ),
    HydraTail(
        "Hydra Tail",
        "hydra_tail.png"
    ),
    IkkleHydra(
        "Ikkle Hydra",
        "ikkle_hydra.png",
        listOf(PET)
    ),
    InquisitorsGreatHelm(
        "Inquisitor's Great Helm",
        "inquisitors_great_helm.png"
    ),
    InquisitorsHauberk(
        "Inquisitor's Hauberk",
        "inquisitors_hauberk.png"
    ),
    InquisitorsPlateskirt(
        "Inquisitor's Plateskirt",
        "inquisitors_plateskirt.png"
    ),
    InquisitorsMace(
        "Inquisitor's Mace",
        "inquisitors_mace.png"
    ),
    JarOfChemicals(
        "Jar of Chemicals",
        "jar_of_chemicals.png",
        listOf(JAR)
    ),
    JarOfDecay(
        "Jar of Decay",
        "jar_of_decay.png",
        listOf(JAR)
    ),
    JarOfDirt(
        "Jar of Dirt",
        "jar_of_dirt.png",
        listOf(JAR)
    ),
    JarOfDreams(
        "Jar of Dreams",
        "jar_of_dreams.png",
        listOf(JAR)
    ),
    JarOfEyes(
        "Jar of Eyes",
        "jar_of_eyes.png",
        listOf(JAR)
    ),
    JarOfMiasma(
        "Jar of Miasma",
        "jar_of_miasma.png",
        listOf(JAR)
    ),
    JarOfSand(
        "Jar of Sand",
        "jar_of_sand.png",
        listOf(JAR)
    ),
    JarOfSouls(
        "Jar of Souls",
        "jar_of_souls.png",
        listOf(JAR)
    ),
    JarOfStone(
        "Jar of Stone",
        "jar_of_stone.png",
        listOf(JAR)
    ),
    JarOfSwamp(
        "Jar of Swamp",
        "jar_of_swamp.png",
        listOf(JAR)
    ),
    KalphitePrincess(
        "Kalphite Princess",
        "kalphite_princess.png",
        listOf(PET)
    ),
    KbdHeads(
        "KBD Heads",
        "kbd_heads.png",
        listOf(HEAD)
    ),
    KqHead(
        "KQ Head",
        "kq_head.png",
        listOf(HEAD)
    ),
    KrakenTentacle(
        "Kraken Tentacle",
        "kraken_tentacle.png"
    ),
    KreeArraJr(
        "Kree'Arra Jr.",
        "kree_arra_jr.png",
        listOf(PET)
    ),
    KrilTsutsarothJr(
        "Kril Tsutsaroth Jr.",
        "kril_tsutsaroth_jr.png",
        listOf(PET)
    ),
    LittleNightmare(
        "Little Nightmare",
        "little_nightmare.png",
        listOf(PET)
    ),
    MagicFang(
        "Magic Fang",
        "magic_fang.png"
    ),
    MaledictionShard3(
        "Malediction Shard 3",
        "malediction_shard_3.png"
    ),
    MudBattlestaff(
        "Mud Battlestaff",
        "mud_battlestaff.png"
    ),
    NightmareStaff(
        "Nightmare Staff",
        "nightmare_staff.png"
    ),
    Noon(
        "Noon",
        "noon.png",
        listOf(PET)
    ),
    OccultNecklace(
        "Occult Necklace",
        "occult_necklace.png"
    ),
    OdiumShard3(
        "Odium Shard 3",
        "odium_shard_3.png"
    ),
    PegasianCrystal(
        "Pegasian Crystal",
        "pegasian_crystal.png"
    ),
    PetDarkCore(
        "Pet Dark Core",
        "pet_dark_core.png",
        listOf(PET)
    ),
    PetKraken(
        "Pet Kraken",
        "pet_kraken.png",
        listOf(PET)
    ),
    PetSmokeDevil(
        "Pet Smoke Devil",
        "pet_smoke_devil.png",
        listOf(PET)
    ),
    PetSnakeling(
        "Pet snakeling",
        "pet_snakeling.png",
        listOf(PET)
    ),
    PrimordialCrystal(
        "Primordial Crystal",
        "primordial_crystal.png"
    ),
    PrinceBlackDragon(
        "Prince Black Dragon",
        "prince_black_dragon.png",
        listOf(PET)
    ),
    RingOfTheGods(
        "Ring of the Gods",
        "ring_of_the_gods.png"
    ),
    SarachnisCudgel(
        "Sarachnis Cudgel",
        "sarachnis_cudgel.png"
    ),
    SaradominHilt(
        "Saradomin Hilt",
        "saradomin_hilt.png"
    ),
    SaradominsLight(
        "Saradomin's Light",
        "saradomins_light.png"
    ),
    SaradominSword(
        "Saradomin Sword",
        "saradomin_sword.png"
    ),
    ScorpiasOffspring(
        "Scorpia's Offspring",
        "scorpias_offspring.png",
        listOf(PET)
    ),
    SerpentineVisage(
        "Serpentine Visage",
        "serpentine_visage.png"
    ),
    SmokeBattlestaff(
        "Smoke Battlestaff",
        "smoke_battlestaff.png"
    ),
    Sraracha(
        "Sraracha",
        "sraracha.png",
        listOf(PET)
    ),
    SeerCull(
        "Seercull",
        "seercull.png"
    ),
    SeersRing(
        "Seers Ring",
        "seers_ring.png"
    ),
    SmoulderingStone(
        "Smouldering Stone",
        "smouldering_stone.png"
    ),
    SpectralSigil(
        "Spectral Sigil",
        "spectral_sigil.png"
    ),
    SpiritShield(
        "Spirit Shield",
        "spirit_shield.png"
    ),
    StaffOfTheDead(
        "Staff of the Dead",
        "staff_of_the_dead.png"
    ),
    SteamBattlestaff(
        "Steam Battlestaff",
        "steam_battlestaff.png"
    ),
    TanzaniteFang(
        "Tanzanite Fang",
        "tanzanite_fang.png"
    ),
    TreasonousRing(
        "Treasonous Ring",
        "treasonous_ring.png"
    ),
    TridentOfTheSeas(
        "Trident of the Seas",
        "trident_of_the_seas.png"
    ),
    TyrannicalRing(
        "Tyrannical Ring",
        "tyrannical_ring.png"
    ),
    UncutOnyx(
        "Uncut Onyx",
        "uncut_onyx.png"
    ),
    VenenatisSpiderling(
        "Venenatis Spiderling",
        "venenatis_spiderling.png",
        listOf(PET)
    ),
    VetionJr(
        "Vet'ion Jr.",
        "vetion_jr.png",
        listOf(PET)
    ),
    VolatileOrb(
        "Volatile Orb",
        "volatile_orb.png"
    ),
    Vorki(
        "Vorki",
        "vorki.png",
        listOf(PET)
    ),
    WarriorRing(
        "Warrior Ring",
        "warrior_ring.png"
    ),
    ZamorakHilt(
        "Zamorak Hilt",
        "zamorak_hilt.png"
    ),
    ZamorakianSpear(
        "Zamorakian Spear",
        "zamorakian_spear.png"
    ),
    ZilyanaJr(
        "Zilyana Jr.",
        "zilyana_jr.png",
        listOf(PET)
    );

    fun toModel(): DropModel = DropModel(this)
}