// CSE 143 AW with Esteban
// Homework 3
// Chingpo Lin
// 1/20/2018
// A AssassinManager class that plays a game of Assassin, a person may be
// killed by the person before him in the list, and the first person may be
// killed by the last people. client can print the information in killRing
// and graveYard, and we can know if any of the list contains a given name
// if there is just one person left, gameover and that person is the winner
// and the client can pass a parameter to kill a given name.

import java.util.*;

public class AssassinManager {

   private AssassinNode killRing;
   private AssassinNode graveYard;
   
   // pre: throw IllegalArgumentException if there is no name in the list
   // post: construct the killRing with the order of names in list, and also
   // add the person before him become the killer(the first people's killer is
   // the last person)
   public AssassinManager(List<String> names) {
      if (names.size() == 0) {
         throw new IllegalArgumentException();
      }
      killRing = new AssassinNode(names.get(0));
      AssassinNode temp = killRing;
      for (int i = 1; i< names.size(); i++) {
         temp.next = new AssassinNode(names.get(i));
         temp = temp.next;
      }
      temp = killRing;
      while (temp.next != null) {
         temp.next.killer = temp.name;
         temp = temp.next;
      }
      killRing.killer = temp.name;
      graveYard = null;
   }
   
   // prints the name of who is stalking who in the order in killRing
   public void printKillRing() {
      AssassinNode temp = killRing;
      while (temp.next != null) {
         System.out.println("    " + temp.next.killer + " is stalking " + temp.next.name);
         temp = temp.next;
      }
      System.out.println("    " + killRing.killer + " is stalking " + killRing.name);
   }
   
   // prints the name who was killed in graveYard, and the most recent
   // victim will show at first.
   public void printGraveyard() {
      AssassinNode temp = graveYard;
      while (temp != null && temp.next != graveYard) {
         System.out.println("    " + temp.name + " was killed by " + temp.killer);
         temp = temp.next;
      }
   }
   
   // ignore case and finds out if killRing contains a given name.
   public boolean killRingContains(String name) {
      AssassinNode temp = killRing;
      return checkContains(name, temp);
   }
   
   // ignore case and finds out if graveyard contains a given name.
   public boolean graveyardContains(String name) {
      AssassinNode temp = graveYard;
      return checkContains(name, temp);
   }
   
   // this avoids redundency in contains method.
   private boolean checkContains(String name, AssassinNode temp) {
      while ((temp != null) && (!temp.name.equalsIgnoreCase(name))) {
         temp = temp.next;
      }
      return temp != null;
   }
   
   // return true(gameover), if there is just one person left.
   public boolean gameOver() {
      return (killRing != null) && (killRing.next == null);
   }
   
   // return the only person left in killRing, returns null when
   // more people left in it.
   public String winner() {
      if (gameOver()) {
         return killRing.name;
      }
      return null;
   }
   
   // pre: throws IllegalArgumentException if there is more than one people
   // in the killRing or the name is not in the killRing
   // post: remove the people who is killed from killRing to graveYard, and
   // let the graveYard's killer be the one who kill him, and remove the 
   // victim from killRing, and change the killer that may be influenced.
   public void kill(String name) {
      if (gameOver()) {
         throw new IllegalStateException();
      }else if (!killRingContains(name)) {
         throw new IllegalArgumentException();
      }
      AssassinNode temp = killRing;
      if (temp.name.equalsIgnoreCase(name)) {
         killRing.next.killer = killRing.killer;
         killRing = killRing.next;
         temp.next = graveYard;
         graveYard = temp;
      }else {
         while (!temp.next.name.equalsIgnoreCase(name)) {
            temp = temp.next;
         }
         if (temp.next.next != null) {
            temp.next.next.killer = temp.name;
         }else {
            killRing.killer = temp.name;
         }
         AssassinNode temp2 = temp.next;
         temp.next = temp.next.next;
         temp2.next = graveYard;
         graveYard = temp2;
      }
   }
}