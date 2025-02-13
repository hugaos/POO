package aula01;

public class entmas {
    public static void name(String[] args) {
        String s1 = "Aveiro";
        String s2 = "aveiro";
        System.out.println(s1.equals(s2) ? "Iguais" : " Diferentes");
        System.out.println(s1.equalsIgnoreCase(s2) ? "Iguais" : " Diferentes ");
        System.out.println(s1.compareTo(s2));
    }
}
