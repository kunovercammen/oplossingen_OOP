package SETenMAP_opdracht1;

import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;

public class SetEnMap {

    public static void main(String[] args) {
        String [] letters1 = {"p", "e", "a", "b", "a"};
        String [] letters2 = {"p", "f", "a", "b", "a","x","a","f"};
        List <String> l1 = new ArrayList<>(Arrays.asList(letters1));
        List <String> l2 = new ArrayList<>(Arrays.asList(letters2));
        System.out.println("rij1:"+"\n"+l1);
        System.out.println("rij2:"+"\n"+l2);

        System.out.println("gemeenschappelijke letters in rij letters1 en letters2, dubbels toegelaten");
        l1.retainAll(l2);
        System.out.println(l1);

        System.out.println("gemeenschappelijke letters in rij letters1 en letters2, dubbels niet toegelaten");
        // TO DO Tip maak gebruik van Set en de retainAll methode
        Set<String> s1 = new HashSet<String>(l1);
        Set<String> s2 = new HashSet<String>(l2);
        s1.retainAll(s2);
        System.out.println(s1);


        System.out.println("gemeenschappelijke letters in rij letters1 en letters2, dubbels niet toegelaten, alfabetisch geordend");
        // TO DO Tip idem als vorige opdracht maar gebruik juist type van Set
        Set<String> s3 = new TreeSet<String>(l1);
        Set<String> s4 = new TreeSet<String>(l2);
        s3.retainAll(s4);
        System.out.println(s3);


        System.out.println("Aantal voorkomens van elke letter in rij letters2,alfabetisch geordend");
        // TO DO Tip gebruik map waarbij een letter een key is en een teller de value
        Map <String,Integer> map = new TreeMap<>();
        for (String s: letters2) {
            int aantal = 1;
            if(map.containsKey(s)) {
                aantal = map.get(s) + 1;
            }
            map.put(s,aantal);
        }

        // De volgende code overloopt de set van entries uit de treemap,
        // haalt uit de entry de key en de value en print deze geformateerd f
        Set <Map.Entry<String, Integer>> set = map.entrySet();
        for (Map.Entry<String,Integer> entry:set){
            String output = String.format("%2s: %2d", entry.getKey(),entry.getValue());
            System.out.println(output);
        }

        System.out.println("Alfabetische opsomming van letters in rij letters2 die 1, 2, 3 en 4 keer voorkomen");
        Map <Integer,Set<String>> map2 = new TreeMap<>();
        for (int i =1; i < 5;i++){
            map2.put(i,new TreeSet<>() );
        }
        // TO DO Tip hierboven hebben we een multimap gemaakt met als key een getal van 1 tot 4
        // en als value een treeset van letters die 1, 2, 3 of 4 keren voorkomen
        // de 4 entries van map2 zijn al aangemaakt maar de values zijn nog leeg
        for (Map.Entry<String,Integer> entry:set){
            // wij overlopen de set van entries van de map uit de vorige opdracht
            int aantal = entry.getValue();
            if(map2.containsKey(aantal)) {
                map2.get(aantal).add(entry.getKey());
            }
            // TO DO pas de inhoud van map2 aan
        }
        // hier wordt de inhoud van map2 getonnd op de console
        Set <Map.Entry<Integer,Set<String>>> set2 = map2.entrySet();
        for (Map.Entry<Integer,Set<String>> entry:set2){
            String output = String.format("%2s: %-20s", entry.getKey(),entry.getValue());
            System.out.println(output);
        }
    }
}
/**
 CONSOLE OUTPUT:
 rij1:
 [p, e, a, b, a]
 rij2:
 [p, f, a, b, a, x, a, f]
 gemeenschappelijke letters in rij letters1 en letters2, dubbels toegelaten
 [p, a, b, a]
 gemeenschappelijke letters in rij letters1 en letters2, dubbels niet toegelaten
 [p, a, b]
 gemeenschappelijke letters in rij letters1 en letters2, dubbels niet toegelaten, alfabetisch geordend
 [a, b, p]
 Aantal voorkomens van elke letter in rij letters2,alfabetisch geordend
 a:  3
 b:  1
 f:  2
 p:  1
 x:  1
 Alfabetische opsomming van letters in rij letters2 die 1, 2, 3 en 4 keer voorkomen
 1: [b, p, x]
 2: [f]
 3: [a]
 4: []

 **/
