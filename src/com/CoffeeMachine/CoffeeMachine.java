package com.CoffeeMachine;

import java.util.Scanner;



public class CoffeeMachine {
    static int water = 400;
    static int milk = 540;
    static int beans = 120;
    static int cups = 9;
    static int money = 550;
    static Scanner scanner = new Scanner(System.in);


    //potrebne suroviny
    final static int espressoWater = 250;
    final static int espressoBeans = 16;
    final static int espressoPrice = 4;
    final static int latteWater  = 350;
    final static int latteMilk = 75;
    final static int latteBeans = 20;
    final static int lattePrice = 7;
    final static int cappuWater = 200 ;
    final static int cappuBeans = 12;
    final static int cappuMilk = 100;
    final static int cappuPrice = 6;


    public static void main(String[] args) {

        String action = "";
do {
    System.out.println("Write action (buy, fill, take, remaining, exit): ");
    action = scanner.next();
    chooseAction(action);


} while (!action.equals("exit"));


    }

    private static void chooseAction(String action) {
switch (action){
    case "buy":
        buy();
        break;
    case "fill":
        fill();
        break;
    case "take":
        take();
        break;
    case "remaining":
        remaining();
        break;
    default:
        System.out.println("neplatna volba");
}

    }

    private static void remaining() {
        System.out.println("The coffee machine has:");
        System.out.println(water + " of water");
        System.out.println(milk + " of milk");
        System.out.println(beans + " of coffe beans");
        System.out.println(cups + " of disposable cups");
        System.out.println("$"+ money + " of money");
    }

    private static void take() {
        System.out.println("I gave you $" + money);
        money = 0;
    }

    private static void fill() {
        System.out.println("Write how many ml of water do you want to add: ");
        water += scanner.nextInt();
        System.out.println("Write how many ml of milk do you want to add: ");
        milk += scanner.nextInt();
        System.out.println("Write how many grams of coffee beans do you want to add:");
        beans += scanner.nextInt();
        System.out.println("Write how many disposable cups of coffee do you want to add: ");
        cups += scanner.nextInt();

    }

    private static void buy() {




        System.out.println("What do you want to buy? 1 - espresso, 2 - latte, 3 - cappuccino, back - to main menu: ");
       String volba = scanner.next();
       if(checkState(volba)){
        switch (volba){
            case "1":
                water -= espressoWater;
                beans -= espressoBeans;
                cups -= 1;
                money += espressoPrice;
                System.out.println("I have enough resources, making you a coffee!");
                break;
            case "2":
                water -= latteWater;
                beans -= latteBeans;
                milk -= latteMilk;
                cups -= 1;
                money += lattePrice;
                System.out.println("I have enough resources, making you a coffee!");
                break;
            case "3":
                water -= cappuWater;
                beans -= cappuBeans;
                milk -= cappuMilk;
                cups -= 1;
                money += cappuPrice;
                System.out.println("I have enough resources, making you a coffee!");
                break;
            case "back":
                System.out.println("return to main");
                break;
            default:
                System.out.println("spatna volba");
                break;

            }
        }
    }

    private static boolean checkState(String volba) {
        boolean navrat = true;
        int wat = 0;
        int mlk = 0;
        int bns = 0;



        switch (volba){
            case "1":
                wat = espressoWater;
                bns = espressoBeans;
                break;
            case "2":
                wat = latteWater;
                mlk = latteMilk;
                bns = latteBeans;
                break;
            case "3":
                wat = cappuWater;
                mlk = cappuMilk;
                bns = cappuBeans;
                break;
            default:
                return false;

        }

        if((water - wat) < 0 ){
            System.out.println("Sorry, not enough water!");
            navrat = false;
        }
        if ((cups - 1) < 0){
            System.out.println("Sorry, not enough cups!");
            navrat = false;
        }
        if ((beans - bns) < 0){
            System.out.println("Sorry, not enough beans");
            navrat = false;
        }
        if((milk - mlk) < 0){
            System.out.println("Sorry, not enough milk!");
            navrat = false;
        }
        return navrat;
    }
}
