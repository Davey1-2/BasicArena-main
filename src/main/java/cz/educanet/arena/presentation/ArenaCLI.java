package cz.educanet.arena.presentation;

import cz.educanet.arena.data.GladiatorDatabase;
import cz.educanet.arena.logic.Arena;
import cz.educanet.arena.logic.Gladiator;

import java.util.Scanner;

public class ArenaCLI {

    private Arena logic;
    private Scanner sc;


    /**
     * Initialize all variables that are needed.
     */
    public void init() {
        logic = new Arena();
        sc = new Scanner(System.in);
    }

    public void renderLandingPage() {
        System.out.println("     /\\                         \n" +
                "    /  \\   _ __ ___ _ __   __ _ \n" +
                "   / /\\ \\ | '__/ _ \\ '_ \\ / _` |\n" +
                "  / ____ \\| | |  __/ | | | (_| |\n" +
                " /_/    \\_\\_|  \\___|_| |_|\\__,_|");
        System.out.println("---------------------------------");
    }

    public void renderGladiatorPicker() {
        Gladiator g = new Gladiator();
        Gladiator g2 = new Gladiator();


        System.out.println("Jak se jmenuje tvuj první gladiator?");
        g.setName(sc.nextLine());
        g.setDmgGlad(g.getDmgGlad());
        g.setHp(g.getHp());
        GladiatorDatabase.saveGladiator(g.getName()+".txt", g);


        System.out.println("Jak se jmenuje tvuj druhy gladiator?");
        g2.setName(sc.nextLine());
        g2.setDmgGlad(g2.getDmgGlad());
        g2.setHp(g2.getHp());
        GladiatorDatabase.saveGladiator(g2.getName()+".txt", g2);


        System.out.println("Pick your fighter #1 (enter the path of the saved file):");
        String gladiator1File = sc.nextLine();



        System.out.println("Pick your fighter #2 (enter the path of the saved file):");
        String gladiator2File = sc.nextLine();



        Gladiator gladiator1 = GladiatorDatabase.loadGladiator(gladiator1File);
        Gladiator gladiator2 = GladiatorDatabase.loadGladiator(gladiator2File);

        logic.setGladiator1(gladiator1);
        logic.setGladiator2(gladiator2);

    }

    /**
     * Fight until one gladiator dies, or surrenders.
     */
    public void renderEntireFight() {
        // TODO:
        // while(...) {logic.fight.... sout...}




        int round = 0;
        int[] fightingRound = {};


        while (logic.getWinner() == null){

            Gladiator pepa = logic.getGladiator1();
            Gladiator vojta = logic.getGladiator2();


            round++;
            System.out.println("------------------- " + round + ". kolo -----------------------");
            System.out.println(pepa.getName() + ": " + pepa.getHp() + "hp");
            System.out.println(vojta.getName() + ": " + vojta.getHp() +"hp");
            System.out.println();

            fightingRound = logic.fight();

            System.out.println(pepa.getName() + " zautocil na gladiatora " + vojta.getName());
            System.out.println(vojta.getName() + " ma " + vojta.getHp() + "hp");
            if (logic.getWinner() == pepa){
                System.out.println("tento zapas vyhral " + pepa.getName());
                System.exit(0);
            }

            System.out.println(vojta.getName() + " utoci zpet");
            System.out.println(pepa.getName() + " ma " + pepa.getHp() + "hp");

            if (logic.getWinner() == vojta){
                System.out.println("--------------------------------------");
                System.out.println("tento zapas vyhral " + vojta.getName());
                System.exit(0);
            }


        }
    }


}
