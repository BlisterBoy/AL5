package com.mklr.ruzzle.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.*;

import com.mklr.ruzzle.engine.Board;
import com.mklr.ruzzle.engine.Marble;
import com.mklr.ruzzle.solver.SolutionWord;
import com.mklr.ruzzle.solver.SolveByMarbleGrid;
import com.mklr.ruzzle.solver.Solver;

public class TestDictionnary {
    public static void main(String[] args) {
/*
        RuzzleDictionary d = new RuzzleDictionary();
        Thread t = new Thread(d);
        t.start();
        while (t.isAlive());
        System.out.println("DONE in " + ((new Date().getTime()) - beg) + "s.");
  */

        /*
        ArrayList<Integer[]> t = new ArrayList<Integer[]>();
        Integer[] a = {3,4};
        t.add(a);
        Integer[] b = {3,4};

        System.out.println("A : " + a[0] + " " + a[1]);
        System.out.println("B : " + b[0] + " " + b[1]);
        System.out.println("equals : " + a.equals(b));

        for (Integer[] gg : t) {
            if (Arrays.equals(a, b)) {
                System.out.println("a = b");
            } else {
                System.out.println("a != b");
            }
        }
*/

        /*
        Board b = new Board();
        b.init();
        */

        /*
        ArrayList<SolutionWord> al = new ArrayList<SolutionWord>();
        al.add(new SolutionWord("abcdefgh", 10));
        al.add(new SolutionWord("xyz", 100));
        al.add(new SolutionWord("jklazemlazeml", 23));
        al.add(new SolutionWord("xyqsd", 50));
        SolutionWord.changeSortType(Solver.SORT_BY_SCORE);
        Collections.sort(al, new SolutionWord());

        System.out.println(al);
        */
        
        RuzzleDictionary d = new RuzzleDictionary("French", "dict/French.dict");
        //RuzzleDictionary d = new RuzzleDictionary("enEN", "/usr/share/dict/words");
        d.init();

        Board b = new Board("French", d);
        b.init();

        System.out.println("====== BOARD ======");
        System.out.println(b);
        System.out.println("====== BOARD ======");

        System.out.println("\n\n");


        System.out.println(d.getLetterSet());
       /*
        Random r = new Random();
        for (int i = 0; i < 10000000; i++) {
            int random = r.nextInt(10000);
            double next = ((double)random)/100.0;
            try {
                new Marble(d.getLetterSet().getLetterByPercentage(next));
            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("Failed with value " + next);
                break;
            }
        }
         */
        /*
        System.out.println("====== SOLVER ======");
        SolveByMarbleGrid solver = new SolveByMarbleGrid(d, b);
        long beg = new Date().getTime();
        solver.solve(Solver.SORT_BY_WORD_LENGTH);
        long end = new Date().getTime();
        System.out.println(solver.getWordsList());
        System.out.println("====== SOLVER ======");

        System.out.println("\n\nAlg done in " + ((double)(end-beg)/(1000.0)) + "s.");
        System.out.println(solver.getWordsList().size() + " words found...");
           */


    }
}
