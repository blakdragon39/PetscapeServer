# Endpoints
**Bold** parameters are required

## GET /bingo/all
List all existing bingo games

#### Returns
```
[
    {
        "id": mongo ObjectId,
        "name": String
    },
    ...
]
```


## POST /bingo/new_game
Create a new bingo game that randomly generates cards.

#### Parameters
**name** (String)
- Title of the bingo game
  
**type** (`bosses`, `items`, `combined`)  
- `bosses`: Each square is a boss. Squares can have duplicates, since there aren't enough bosses for a full 25 squares.
- `items`: Each square is an item. Squares will not have duplicates.
- `combined`: Each square is a unique item/boss combination .

**free_space** (Boolean)  
- `true` if the middle square is to be a free space, otherwise `false`.

**cards_match** (Boolean)
- `true` if all players should play on a matching card. `false` if each player should get their own randomly generated card. 

#### Returns
- `Bingo Game` object


## POST /bingo/new_custom_game
Create a new bingo game with custom defined squares. All players will play off of the same matching card.

#### Parameters
**name** (String)
- Title of the bingo game

**json body**
- JSON body with a list of 25 squares that can include bosses, items, or custom tasks  

```
[
    {
        "boss": "Boss Name - optional",
        "item": "Item Name - optional",
        "task": "Custom task description - optional"
    },
    ....    
]
```

#### Returns
- `Bingo Game` object

    
## POST /bingo/add_card
Add a card for a user to a bingo game. Card will either be the parent card for the game, or a randomly generated card, depending on the game type.

#### Parameters
**id** (`mongo ObjectId`)

**username** (String)
- Name of the user to add a card for. Each user can only have one card per game.

#### Returns
- `Bingo Card` object


## POST /bingo/complete_square
Marks a square as complete on a game card.

#### Parameters
**game_id** (`mongo ObjectId`)  
**card_id** (`mongo ObjectId`)  
**square_id** (`mongo ObjectId`)

#### Returns
- `Bingo Card` object


## POST /bingo/update_notes
Update notes on a card.

#### Parameters
**game_id** (`mongo ObjectId`)  
**card_id** (`mongo ObjectId`)  
**notes** (String)

#### Returns
- `Bingo Card` object


## GET /bingo/winners
Get the winning cards from a game of bingo (one or more lines finished)

#### Parameters
**game_id** (`mongo ObjectId`)

#### Returns
```
[
    {Bingo Card},
    ...
]
```


## GET /bingo/get_card

#### Parameters
**game_id** (`mongo ObjectId`)  
**username** (String)

#### Returns
- `Bingo Card` object


## GET /bingo/get_card_image

#### Parameters
**game_id** (`mongo ObjectId`)  
**username** (String)

#### Returns
- `image/png`


# Models

## Bingo Game
```
{
    "id": {mongo ObjectId},
    "name": String,
    "type": { BOSSES, ITEMS, COMBINED, OTHER },
    "freeSpace": Boolean,
    "parentCard": [
        {Bingo Square},
        ...
    ],
    "cards": [
        {Bingo Card},
        ...
    ]
}
```

## Bingo Card
```
{
    "id": {mongo ObjectId},
    "username": String,
    "notes": String,
    "squares": [
        {Bingo Square},
        ...
    ]
}
```

## Bingo Square
```
{
    "id": {mongo ObjectId},
    "completed": Boolean,
    "task": String,
    "boss": Boss,
    "item": Drop
}
```

## Boss
```
{
    "name": String,
    "file": String,
    "wilderness": Boolean,
    "slayer_level": Int
}
```

## Drop
```
{
    "item": String,
    "file": String,
    "drop_rate": String
}
```