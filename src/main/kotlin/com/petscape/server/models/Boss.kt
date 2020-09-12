package com.petscape.server.models

import com.petscape.server.models.BossTag.*
import com.petscape.server.models.Drop.*

@Suppress("unused")
class BossModel(boss: Boss) {
    val displayName = boss.displayName
    val file = boss.file
}

enum class Boss(
    val displayName: String,
    val file: String,
    val slayerLevel: Int? = null,
    val drops: List<Pair<Drop, Int>>,
    val tags: List<BossTag> = emptyList()
) {

    //TODO how to deal with gauntlet and its weird drop rates
    //TODO chaos Fanatic/chaos Archaeologist?
    //TODO Giant Mole
    //TODO skotizo?
    //TODO raids 1/2
    //TODO Wintertodt - tagged as minigame
    
    AbyssalSire(
        displayName = "Abyssal Sire",
        file = "abyssal_sire.png",
        slayerLevel = 85,
        drops = listOf(
            Pair(AbyssalBludgeon, 206),
            Pair(AbyssalDagger, 492),
            Pair(AbyssalHead, 1280),
            Pair(AbyssalWhip, 1066),
            Pair(EliteClueScroll, 180),
            Pair(JarOfMiasma, 984),
            Pair(AbyssalOrphan, 2560)
        ),
        tags = listOf(SLAYER, SOLO)
    ),
    AlchemicalHydra(
        displayName = "Alchemical Hydra",
        file = "alchemical_hydra.png",
        slayerLevel = 95,
        drops = listOf(
            Pair(AlchemicalHydraHeads, 256),
            Pair(BrimstoneRing, 180),
            Pair(HydraLeather, 512),
            Pair(HydraTail, 512),
            Pair(HydrasClaw, 1000),
            Pair(EliteClueScroll, 256),
            Pair(JarOfChemicals, 2000),
            Pair(IkkleHydra, 3000)
        ),
        tags = listOf(SLAYER, SOLO)
    ),
    Callisto(
        displayName = "Callisto",
        file = "callisto.png",
        drops = listOf(
            Pair(TyrannicalRing, 512),
            Pair(Dragon2hSword, 256),
            Pair(DragonPickaxe, 171),
            Pair(EliteClueScroll, 100),
            Pair(CallistoCub, 2000)
        ),
        tags = listOf(WILDERNESS)
    ),
    Cerberus(
        displayName = "Cerberus",
        file = "cerberus.png",
        slayerLevel = 91,
        drops = listOf(
            Pair(PrimordialCrystal, 512),
            Pair(PegasianCrystal, 512),
            Pair(EternalCrystal, 512),
            Pair(SmoulderingStone, 512),
            Pair(EliteClueScroll, 100),
            Pair(JarOfSouls, 2000),
            Pair(Hellpuppy, 3000)
        ),
        tags = listOf(SLAYER, SOLO)
    ),
    ChaosElemental(
        displayName = "Chaos Elemental",
        file = "chaos_elemental.png",
        drops = listOf(
            Pair(Dragon2hSword, 128),
            Pair(DragonPickaxe, 128),
            Pair(EliteClueScroll, 200),
            Pair(ChaosElementalJr, 300)
        ),
        tags = listOf(WILDERNESS)
    ),
    CommanderZilyana(
        displayName = "Commander Zilyana",
        file = "zilyana.png",
        drops = listOf(
            Pair(SaradominHilt, 508),
            Pair(SaradominSword, 127),
            Pair(ArmadylCrossbow, 508),
            Pair(SaradominsLight, 254),
            Pair(ZilyanaJr, 5000),
            Pair(EliteClueScroll, 250)
        )
    ),
    CorporealBeast(
        displayName = "Corporeal Beast",
        file = "corporeal_beast.png",
        drops = listOf(
            Pair(EliteClueScroll, 200),
            Pair(ArcaneSigil, 1365),
            Pair(ElysianSigil, 4095),
            Pair(HolyElixir, 170),
            Pair(PetDarkCore, 5000),
            Pair(SpectralSigil, 1365),
            Pair(SpiritShield, 64)
        ),
        tags = listOf(GROUP)
    ),
    DagannothPrime(
        displayName = "Dagannoth Prime",
        file = "dagannoth_prime.png",
        drops = listOf(
            Pair(SeersRing, 128),
            Pair(MudBattlestaff, 128),
            Pair(DragonAxe, 128),
            Pair(EliteClueScroll, 750),
            Pair(DagannothPrimeJr, 5000)
        )
    ),
    DagannothRex(
        displayName = "Dagannoth Rex",
        file = "dagannoth_rex.png",
        drops = listOf(
            Pair(WarriorRing, 128),
            Pair(BerserkerRing, 128),
            Pair(DragonAxe, 128),
            Pair(EliteClueScroll, 750),
            Pair(DagannothRexJr, 5000)
        )
    ),
    DagannothSupreme(
        displayName = "Dagannoth Supreme",
        file = "dagannoth_supreme.png",
        drops = listOf(
            Pair(SeerCull, 128),
            Pair(ArchersRing, 128),
            Pair(DragonAxe, 128),
            Pair(EliteClueScroll, 750),
            Pair(DagannothSupremeJr, 5000)
        )
    ),
    GeneralGraardor(
        displayName = "General Graardor",
        file = "graardor.png",
        drops = listOf(
            Pair(BandosHilt, 508),
            Pair(BandosBoots, 384),
            Pair(BandosChestplate, 384),
            Pair(BandosTassets, 384),
            Pair(GeneralGraardorJr, 5000),
            Pair(EliteClueScroll, 250)
        )
    ),
    GrotesqueGuardians(
        displayName = "Grotesque Guardians",
        file = "grotesque_guardians.png",
        slayerLevel = 75,
        drops = listOf(
            Pair(GraniteGloves, 500),
            Pair(GraniteRing, 500),
            Pair(BlackTourmalineCore, 1000),
            Pair(GraniteHammer, 750),
            Pair(EliteClueScroll, 230),
            Pair(JarOfStone, 5000),
            Pair(Noon, 3000)
        ),
        tags = listOf(SLAYER, SOLO)
    ),
    KalphiteQueen(
        displayName = "Kalphite Queen",
        file = "kalphite_queen.png",
        drops = listOf(
            Pair(DragonChainbody, 128),
            Pair(Dragon2hSword, 256),
            Pair(KqHead, 128),
            Pair(KalphitePrincess, 3000),
            Pair(EliteClueScroll, 100),
            Pair(JarOfSand, 2000)
        )
    ),
    KingBlackDragon(
        displayName = "King Black Dragon",
        file = "king_black_dragon.png",
        drops = listOf(
            Pair(DragonPickaxe, 1500),
            Pair(KbdHeads, 128),
            Pair(EliteClueScroll, 450),
            Pair(PrinceBlackDragon, 3000),
            Pair(DraconicVisage, 5000)
        )
    ),
    Kraken(
        displayName = "Kraken",
        file = "kraken.png",
        slayerLevel = 87,
        drops = listOf(
            Pair(KrakenTentacle, 300),
            Pair(TridentOfTheSeas, 512),
            Pair(EliteClueScroll, 500),
            Pair(JarOfDirt, 1000),
            Pair(PetKraken, 3000)
        ),
        tags = listOf(SLAYER, SOLO)
    ),
    KreeArra(
        displayName = "Kree'Arra",
        file = "kreearra.png",
        drops = listOf(
            Pair(ArmadylHilt, 508),
            Pair(ArmadylHelmet, 508),
            Pair(ArmadylChestplate, 384),
            Pair(ArmadylChainskirt, 384),
            Pair(KreeArraJr, 5000),
            Pair(EliteClueScroll, 250)
        )
    ),
    KrilTsutsaroth(
        displayName = "Kril Tsutsaroth",
        file = "kril_tsutsaroth.png",
        drops = listOf(
            Pair(StaffOfTheDead, 508),
            Pair(ZamorakHilt, 508),
            Pair(SteamBattlestaff, 128),
            Pair(ZamorakianSpear, 128),
            Pair(KrilTsutsarothJr, 5000),
            Pair(EliteClueScroll, 250)
        )
    ),
    Nightmare(
        displayName = "The Nightmare",
        file = "nightmare.png",
        drops = listOf(
            Pair(NightmareStaff, 400),
            Pair(InquisitorsGreatHelm, 600),
            Pair(InquisitorsHauberk, 600),
            Pair(InquisitorsPlateskirt, 600),
            Pair(InquisitorsMace, 1200),
            Pair(EldritchOrb, 1800),
            Pair(HarmonisedOrb, 1800),
            Pair(VolatileOrb, 1800),
            Pair(EliteClueScroll, 200),
            Pair(JarOfDreams, 2000),
            Pair(LittleNightmare, 4000)
        ),
        tags = listOf(GROUP)
    ),
    Sarachnis(
        displayName = "Sarachnis",
        file = "sarachnis.png",
        drops = listOf(
            Pair(JarOfEyes, 2000),
            Pair(SarachnisCudgel, 384),
            Pair(Sraracha, 3000),
            Pair(EliteClueScroll, 60)
        )
    ),
    Scorpia(
        displayName = "Scorpia",
        file = "scorpia.png",
        drops = listOf(
            Pair(MaledictionShard3, 256),
            Pair(OdiumShard3, 256),
            Pair(ScorpiasOffspring, 2000)
        ),
        tags = listOf(WILDERNESS)
    ),
    ThermonuclearSmokeDevil(
        displayName = "Thermonuclear Smoke Devil",
        file = "thermonuclear_smoke_devil.png",
        slayerLevel = 93,
        drops = listOf(
            Pair(SmokeBattlestaff, 512),
            Pair(OccultNecklace, 350),
            Pair(DragonChainbody, 2000),
            Pair(EliteClueScroll, 500),
            Pair(PetSmokeDevil, 3000)
        ),
        tags = listOf(SLAYER, SOLO)
    ),
    Venenatis(
        displayName = "Venenatis",
        file = "venenatis.png",
        drops = listOf(
            Pair(TreasonousRing, 512),
            Pair(Dragon2hSword, 256),
            Pair(DragonPickaxe, 171),
            Pair(VenenatisSpiderling, 2000),
            Pair(EliteClueScroll, 100)
        ),
        tags = listOf(WILDERNESS)
    ),
    Vetion(
        displayName = "Vet'ion",
        file = "vetion.png",
        drops = listOf(
            Pair(RingOfTheGods, 512),
            Pair(Dragon2hSword, 256),
            Pair(DragonPickaxe, 171),
            Pair(EliteClueScroll, 100),
            Pair(VetionJr, 2000)
        ),
        tags = listOf(WILDERNESS)
    ),
    Vorkath(
        displayName = "Vorkath",
        file = "vorkath.png",
        drops = listOf(
            Pair(DragonboneNecklace, 1000),
            Pair(EliteClueScroll, 65),
            Pair(JarOfDecay, 3000),
            Pair(Vorki, 3000)
        ),
        tags = listOf(SOLO)
    ),
    Zulrah(
        displayName = "Zulrah",
        file = "zulrah.png",
        drops = listOf(
            Pair(UncutOnyx, 512),
            Pair(TanzaniteFang, 512),
            Pair(MagicFang, 512),
            Pair(SerpentineVisage, 512),
            Pair(EliteClueScroll, 75),
            Pair(JarOfSwamp, 3000),
            Pair(PetSnakeling, 4000)
        ),
        tags = listOf(SOLO)
    );

    fun toModel(): BossModel = BossModel(this)
}