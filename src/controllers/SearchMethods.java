package controllers;
import models.Person;
public class SearchMethods {
    public boolean isSortedByAge(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            if (persons[i].getAge() > persons[i + 1].getAge()) {
                return false;
            }
        }
        return true;
    }

    public boolean isSortedByName(Person[] persons) {
        for (int i = 0; i < persons.length - 1; i++) {
            if (persons[i].getName().compareTo(persons[i + 1].getName()) > 0) {
                return false;
            }
        }
        return true;
    }

    public Person binarySearchByAge (Person [] persons , int age){
        int inicio = 0;
        int fin = persons.length - 1;
        
        while (inicio <= fin){
            int medio = inicio + (fin - inicio) / 2 ;

            if (persons[medio].getAge() == age){
                return persons[medio];
            }
            if (persons[medio].getAge() < age ) {
                inicio = medio + 1;
            } else{
                fin = medio - 1;
            }
        }
        return null;
    }

    public Person binarySearchByName (Person [] persons, String name){
        int inicio = 0 ;
        int fin = persons.length - 1;

        while (inicio <= fin) {
            int  medio = inicio + (fin - inicio) / 2;
            int comparacion = persons[medio].getName().compareToIgnoreCase(name);
            if (comparacion == 0 ){
                return persons[medio];
            }
            if (comparacion < 0){
                inicio = medio + 1 ;
            } else {
                fin = medio - 1 ;
            }
        }
        return null;
    }
}
