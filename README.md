# Axis & Allies Battle Simulator
![image](https://github.com/user-attachments/assets/39610ff5-4250-4de4-9ad2-b046bed253df)

This program allows you to simulate battles for the game "Axis & Allies 1914" one round at a time. Land battles are currently supported. In the future, I plan to add support
for sea battles and amphibious battles.

## Using the Simulator
For the calculation of bonuses and hits, the red panel contains the attacking army, and the blue panel contains the defending army. Click the "Add Units" button to open a window with pictures of the units. Make sure the checkbox at the top of the add units panel has the correct army selected, then click the unit you want to add to the army. If you add a unit by mistake, you can click on its picture in the main area to delete it, or you can click the clear button to wipe both army panels. When the armies are set up, click the
fight button, which will create a new window with statistics related to the round of combat.

If you wish to continue the combat, you may choose casualties to remove from each army, add any reinforcements that arrived, and click the "Fight" button again to simulate the
next round of combat.

## Interpreting Results
![image](https://github.com/user-attachments/assets/a8d88264-8437-44b4-b328-704783662825)

The first section of the stats window tells you the unit composition of both armies. This is helpful if you have a large battle where hand counting would be tedious. It can also be helpful for making decisions on which casualties to remove.

The second section displays how many hits each army scored in this simulation of the battle, as well as how many hits each army was expected to score according to the expected
value calculation of the unit dice. This helps you see both the expected performance of your unit composition as well as the variation in results that exists in this game.

The third section displays the casualties, which does not necessarily equal the number of hits the other army scored. If the attacking army has tanks, then each tank would block a shot, reducing that army's casualties by the number of attacking tanks.
