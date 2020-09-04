package com.petscape.server.models

import com.petscape.server.models.BossTag.*
import com.petscape.server.models.Drop.*

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
    
    abyssalSire(
        displayName = "Abyssal Sire",
        file = "abyssal_sire.png",
        slayerLevel = 85,
        drops = listOf(
            Pair(abyssalBludgeon, 206),
            Pair(abyssalDagger, 492),
            Pair(abyssalHead, 1280),
            Pair(abyssalWhip, 1066),
            Pair(eliteClueScroll, 180),
            Pair(jarOfMiasma, 984),
            Pair(abyssalOrphan, 2560)
        ),
        tags = listOf(SLAYER, SOLO)
    ),
    alchemicalHydra(
        displayName = "Alchemical Hydra",
        file = "alchemical_hydra.png",
        slayerLevel = 95,
        drops = listOf(
            Pair(alchemicalHydraHeads, 256),
            Pair(brimstoneRing, 180),
            Pair(hydraLeather, 512),
            Pair(hydraTail, 512),
            Pair(hydrasClaw, 1000),
            Pair(eliteClueScroll, 256),
            Pair(jarOfChemicals, 2000),
            Pair(ikkleHydra, 3000)
        ),
        tags = listOf(SLAYER, SOLO)
    ),
    callisto(
        displayName = "Callisto",
        file = "callisto.png",
        drops = listOf(
            Pair(tyrannicalRing, 512),
            Pair(dragon2hSword, 256),
            Pair(dragonPickaxe, 171),
            Pair(eliteClueScroll, 100),
            Pair(callistoCub, 2000)
        ),
        tags = listOf(WILDERNESS)
    ),
    cerberus(
        displayName = "Cerberus",
        file = "cerberus.png",
        slayerLevel = 91,
        drops = listOf(
            Pair(primordialCrystal, 512),
            Pair(pegasianCrystal, 512),
            Pair(eternalCrystal, 512),
            Pair(smoulderingStone, 512),
            Pair(eliteClueScroll, 100),
            Pair(jarOfSouls, 2000),
            Pair(hellpuppy, 3000)
        ),
        tags = listOf(SLAYER, SOLO)
    ),
    chaosElemental(
        displayName = "Chaos Elemental",
        file = "chaos_elemental.png",
        drops = listOf(
            Pair(dragon2hSword, 128),
            Pair(dragonPickaxe, 128),
            Pair(eliteClueScroll, 200),
            Pair(chaosElementalJr, 300)
        ),
        tags = listOf(WILDERNESS)
    ),
    commanderZilyana(
        displayName = "Commander Zilyana",
        file = "zilyana.png",
        drops = listOf(
            Pair(saradominHilt, 508),
            Pair(saradominSword, 127),
            Pair(armadylCrossbow, 508),
            Pair(saradominsLight, 254),
            Pair(zilyanaJr, 5000),
            Pair(eliteClueScroll, 250)
        )
    ),
    corporealBeast(
        displayName = "Corporeal Beast",
        file = "corporeal_beast.png",
        drops = listOf(
            Pair(eliteClueScroll, 200),
            Pair(arcaneSigil, 1365),
            Pair(elysianSigil, 4095),
            Pair(holyElixir, 170),
            Pair(petDarkCore, 5000),
            Pair(spectralSigil, 1365),
            Pair(spiritShield, 64)
        ),
        tags = listOf(GROUP)
    ),
    dagannothPrime(
        displayName = "Dagannoth Prime",
        file = "dagannoth_prime.png",
        drops = listOf(
            Pair(seersRing, 128),
            Pair(mudBattlestaff, 128),
            Pair(dragonAxe, 128),
            Pair(eliteClueScroll, 750),
            Pair(dagannothPrimeJr, 5000)
        )
    ),
    dagannothRex(
        displayName = "Dagannoth Rex",
        file = "dagannoth_rex.png",
        drops = listOf(
            Pair(warriorring, 128),
            Pair(berserkerRing, 128),
            Pair(dragonAxe, 128),
            Pair(eliteClueScroll, 750),
            Pair(dagannothRexJr, 5000)
        )
    ),
    dagannothSupreme(
        displayName = "Dagannoth Supreme",
        file = "dagannoth_supreme.png",
        drops = listOf(
            Pair(seerCull, 128),
            Pair(archersRing, 128),
            Pair(dragonAxe, 128),
            Pair(eliteClueScroll, 750),
            Pair(dagannothSupremeJr, 5000)
        )
    ),
    generalGraardor(
        displayName = "General Graardor",
        file = "graardor.png",
        drops = listOf(
            Pair(bandosHilt, 508),
            Pair(bandosBoots, 384),
            Pair(bandosChestplate, 384),
            Pair(bandosTassets, 384),
            Pair(generalGraardorJr, 5000),
            Pair(eliteClueScroll, 250)
        )
    ),
    grotesqueGuardians(
        displayName = "Grotesque Guardians",
        file = "grotesque_guardians.png",
        slayerLevel = 75,
        drops = listOf(
            Pair(graniteGloves, 500),
            Pair(graniteRing, 500),
            Pair(blackTourmalineCore, 1000),
            Pair(graniteHammer, 750),
            Pair(eliteClueScroll, 230),
            Pair(jarOfStone, 5000),
            Pair(noon, 3000)
        ),
        tags = listOf(SLAYER, SOLO)
    ),
    kalphiteQueen(
        displayName = "Kalphite Queen",
        file = "kalphite_queen.png",
        drops = listOf(
            Pair(dragonChainbody, 128),
            Pair(dragon2hSword, 256),
            Pair(kqHead, 128),
            Pair(kalphitePrincess, 3000),
            Pair(eliteClueScroll, 100),
            Pair(jarOfSand, 2000)
        )
    ),
    kingBlackDragon(
        displayName = "King Black Dragon",
        file = "king_black_dragon.png",
        drops = listOf(
            Pair(dragonPickaxe, 1500),
            Pair(kbdHeads, 128),
            Pair(eliteClueScroll, 450),
            Pair(princeBlackDragon, 3000),
            Pair(draconicVisage, 5000)
        )
    ),
    kraken(
        displayName = "Kraken",
        file = "kraken.png",
        slayerLevel = 87,
        drops = listOf(
            Pair(krakenTentacle, 300),
            Pair(tridentOfTheSeas, 512),
            Pair(eliteClueScroll, 500),
            Pair(jarOfDirt, 1000),
            Pair(petKraken, 3000)
        ),
        tags = listOf(SLAYER, SOLO)
    ),
    kreeArra(
        displayName = "Kree'Arra",
        file = "kreearra.png",
        drops = listOf(
            Pair(armadylHilt, 508),
            Pair(armadylHelmet, 508),
            Pair(armadylChestplate, 384),
            Pair(armadylChainskirt, 384),
            Pair(kreeArraJr, 5000),
            Pair(eliteClueScroll, 250)
        )
    ),
    krilTsutsaroth(
        displayName = "Kril Tsutsaroth",
        file = "kril_tsutsaroth.png",
        drops = listOf(
            Pair(staffOfTheDead, 508),
            Pair(zamorakHilt, 508),
            Pair(steamBattlestaff, 128),
            Pair(zamorakianSpear, 128),
            Pair(krilTsutsarothJr, 5000),
            Pair(eliteClueScroll, 250)
        )
    ),
    nightmare(
        displayName = "The Nightmare",
        file = "nightmare.png",
        drops = listOf(
            Pair(nightmareStaff, 400),
            Pair(inquisitorsGreatHelm, 600),
            Pair(inquisitorsHauberk, 600),
            Pair(inquisitorsPlateskirt, 600),
            Pair(inquisitorsMace, 1200),
            Pair(eldritchOrb, 1800),
            Pair(harmonisedOrb, 1800),
            Pair(volatileOrb, 1800),
            Pair(eliteClueScroll, 200),
            Pair(jarOfDreams, 2000),
            Pair(littleNightmare, 4000)
        ),
        tags = listOf(GROUP)
    ),
    sarachnis(
        displayName = "Sarachnis",
        file = "sarachnis.png",
        drops = listOf(
            Pair(jarOfEyes, 2000),
            Pair(sarachnisCudgel, 384),
            Pair(sraracha, 3000),
            Pair(eliteClueScroll, 60)
        )
    ),
    scorpia(
        displayName = "Scoripia",
        file = "scorpia.png",
        drops = listOf(
            Pair(maledictionShard3, 256),
            Pair(odiumShard3, 256),
            Pair(scorpiasOffspring, 2000)
        ),
        tags = listOf(WILDERNESS)
    ),
    thermonuclearSmokeDevil(
        displayName = "Thermonuclear Smoke Devil",
        file = "thermonuclear_smoke_devil.png",
        slayerLevel = 93,
        drops = listOf(
            Pair(smokeBattlestaff, 512),
            Pair(occultNecklace, 350),
            Pair(dragonChainbody, 2000),
            Pair(eliteClueScroll, 500),
            Pair(petSmokeDevil, 3000)
        ),
        tags = listOf(SLAYER, SOLO)
    ),
    venenatis(
        displayName = "Venenatis",
        file = "venenatis.png",
        drops = listOf(
            Pair(treasonousRing, 512),
            Pair(dragon2hSword, 256),
            Pair(dragonPickaxe, 171),
            Pair(venenatisSpiderling, 2000),
            Pair(eliteClueScroll, 100)
        ),
        tags = listOf(WILDERNESS)
    ),
    vetion(
        displayName = "Vet'ion",
        file = "vetion.png",
        drops = listOf(
            Pair(ringOfTheGods, 512),
            Pair(dragon2hSword, 256),
            Pair(dragonPickaxe, 171),
            Pair(eliteClueScroll, 100),
            Pair(vetionJr, 2000)
        ),
        tags = listOf(WILDERNESS)
    ),
    vorkath(
        displayName = "Vorkath",
        file = "vorkath.png",
        drops = listOf(
            Pair(dragonboneNecklace, 1000),
            Pair(eliteClueScroll, 65),
            Pair(jarOfDecay, 3000),
            Pair(vorki, 3000)
        ),
        tags = listOf(SOLO)
    ),
    zulrah(
        displayName = "Zulrah",
        file = "zulrah.png",
        drops = listOf(
            Pair(uncutOnyx, 512),
            Pair(tanzaniteFang, 512),
            Pair(magicFang, 512),
            Pair(serpentineVisage, 512),
            Pair(eliteClueScroll, 75),
            Pair(jarOfSwamp, 3000),
            Pair(petSnakeling, 4000)
        ),
        tags = listOf(SOLO)
    );

    fun toModel(): BossModel = BossModel(this)
}