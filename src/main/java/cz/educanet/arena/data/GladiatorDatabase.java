package cz.educanet.arena.data;

import cz.educanet.arena.logic.Gladiator;

import java.io.*;

/**
 * Utils class that saves and loads gladiators.
 */
public class GladiatorDatabase {

    /**
     * @param filename path to the gladiator file.
     * @return loaded Gladiator
     */
    public static Gladiator loadGladiator(String filename) {
        Gladiator gladiator = new Gladiator();

        try {

            BufferedReader br = new BufferedReader(new FileReader(filename));
            gladiator.setName(br.readLine().split(">")[1]);
            gladiator.setHp(Integer.parseInt(br.readLine().split(">")[1]));


            br.close();

        }  catch (IOException e) {
            e.printStackTrace();
        }

        return gladiator;
    }
    /**
     * Saves the gladiator.
     * @param filename path to save too.
     * @param gladiator Gladiator to save.
     */
    public static void saveGladiator(String filename, Gladiator gladiator) {

        try {
            BufferedWriter bw = new BufferedWriter(new FileWriter(filename));
            bw.write("jmeno gladiatora >" + gladiator.getName() );
            bw.newLine();
            bw.write("zivoty gladiatora >" + gladiator.getHp() );
            bw.newLine();
            bw.write("damage > random every round ");
            bw.newLine();

            bw.close();


        } catch (IOException e) {
            e.printStackTrace();
        }

    }


}
