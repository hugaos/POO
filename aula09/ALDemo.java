package aula09;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

import aula06.DateYMD;
import aula06.Pessoa;

public class ALDemo {
    public static void main(String[] args) {
        ArrayList<Integer> c1 = new ArrayList<>();
        for (int i = 10; i <= 100; i += 10)
            c1.add(i);
        System.out.println("Size: " + c1.size());
        for (int i = 0; i < c1.size(); i++)
            System.out.println("Elemento: " + c1.get(i));
        ArrayList<String> c2 = new ArrayList<>();
        c2.add("Vento");
        c2.add("Calor");
        c2.add("Frio");
        c2.add("Chuva");
        System.out.println(c2);
        Collections.sort(c2);
        System.out.println(c2);
        c2.remove("Frio");
        c2.remove(0);
        System.out.println(c2);

        Set<Pessoa> c3 = new HashSet<>();
        c3.add(new Pessoa("Hugo sousa", 8976543, new DateYMD(22, 06, 2004)));
        c3.add(new Pessoa("Ana vaz", 8976873, new DateYMD(2, 03, 2003)));
        c3.add(new Pessoa("Ricardo", 8786543, new DateYMD(8, 12, 2004)));
        c3.add(new Pessoa("João Guilherme", 8988943, new DateYMD(5, 9, 2004)));
        c3.add(new Pessoa("Catarina Susana", 8976234, new DateYMD(25, 04, 1984)));
        Iterator<Pessoa> i = c3.iterator();
        while (i.hasNext())
            System.out.println(i.next());

        Set<DateYMD> c4 = new TreeSet<>();
        c4.add(new DateYMD(2, 3, 2000));
        c4.add(new DateYMD(1, 2, 3));
        c4.add(new DateYMD(22, 11, 2004));
        c4.add(new DateYMD(15, 7, 1967));
        c4.add(new DateYMD(19, 2, 1968));
        Iterator<DateYMD> d = c4.iterator();
        while (d.hasNext())
            System.out.println(d.next());

    }
}