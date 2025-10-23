Turn-Based RPG System
Overview

This project implements a turn-based RPG battle system in Java. It allows the creation of character classes, weapons, attacks, effects, and passive abilities. Battles occur between groups of characters until one group is defeated.

Features
Character Classes

Warrior

Base Attributes: Strength 15, Agility 8, Intelligence 5

Health: 120, Mana: 50

Passive Ability: "Thick Skin" – reduces incoming damage by 20%

Allowed Weapons: Swords, Axes

Archer

Base Attributes: Strength 8, Agility 15, Intelligence 7

Health: 90, Mana: 80

Passive Ability: "Dodge" – 25% chance to avoid an attack

Allowed Weapons: Bows, Daggers

Mage

Base Attributes: Strength 5, Agility 7, Intelligence 18

Health: 70, Mana: 150

Passive Ability: "Mana Regeneration" – restores 10 mana per turn

Allowed Weapons: Staves, Daggers

Weapons & Special Attacks

Longsword: "Deep Cut" – chance to cause bleeding over 3 turns

Elven Bow: "Rain of Arrows" – area attack hitting all enemies

Arcane Staff: "Fireball" – applies burning effect for 2 turns

War Axe: "Crushing Blow" – 25% chance to stun the enemy

Shadow Dagger: "Sneak Attack" – triple damage if the enemy is unaware

Effects like bleeding, burning, or stun are processed at the beginning of each character’s turn.

Battle System

Battles are turn-based between two GenericGroups.

Each character acts if alive and processes effects first.

A group loses when all its members have 0 or less health.

Supports single-target and area-of-effect attacks.

Passive abilities are applied automatically (e.g., damage reduction, dodge, mana regeneration).

How to Run

Clone the repository.

Compile all Java files:

javac Classes/*.java Weapons/*.java Attacks/*.java Effects/*.java Groups/*.java Battle/*.java BattleTest.java


Run the test:

java BattleTest


The test will simulate a battle between a hero group and enemy group, showing attacks, effects, passive abilities, and the winner.

Project Structure
Classes/        -> Character classes (Warrior, Archer, Mage, GenericClass)
Weapons/        -> Weapons (Longsword, ArcaneStaff, ElvenBow, WarAxe, ShadowDagger)
Attacks/        -> Attack strategies for weapons
Effects/        -> Status effects (Bleeding, Burning, Stun)
Groups/         -> Group of characters
Battle/         -> Turn-based battle controller
BattleTest.java -> Main test file for simulation

Notes

All attributes, effects, and attacks are configurable.

You can add new weapons, attacks, effects, and character classes easily.

Designed to demonstrate OOP concepts, design patterns, and turn-based battle mechanics in Java.
