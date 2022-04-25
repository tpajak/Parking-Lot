# Parking-Lot

## Description

Parking lots are an urban necessity. They provide places for you to leave your car without having to worry about it being stolen or towed. Modern car parking systems are automated and are capable of self-management. In this project, you will create a similar system, but in a simplified form.

Let's start by writing a program that can place your car in a parking lot and free the lot when the car leaves. This will be the "skeleton" of our functional parking lot, and we'll add on to it in the following steps. At busy times, the parking lot may run out of vacant spaces. The program will provide us with aggregated information about the current state of the lot.

## Description

At this stage, our minimalistic parking lot has two parking spots. Let's assume that the first spot is occupied and the second one is free.

The parking lot should allow the user to park the car. This is implemented using the `park` command. After the user has entered this command, the registration number and the color of the car should be specified. For example, `park KA-01-HH-1234 Blue`. The registration number should not contain spaces. The color can be written in either uppercase and lowercase letters.

As the first spot is already taken, the program should allocate the second spot and print: `Blue car parked in spot 2.` The color should match what the user inputs.

To pick up the car, the user should print the command `leave` and then the number of the parking spot, for example, `leave 1`. If there is no car in the given spot, the program should print an error: `There is no car in spot 1.` Otherwise, it should notify the user that the spot is now available: `Spot 1 is free.`

### Examples

The symbol `> `represents the user input. Note that it isn't part of the input.

Example 1:

```
> park KA-01-HH-1234 BlueBlue car parked in spot 2.
```

Example 2:

```
> leave 1Spot 1 is free.
```

Example 3:

```
> leave 2There is no car in spot 2.
```

 
