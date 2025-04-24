package views;
import models.Person;
import java.util.Scanner;

public class View {

    Scanner scanner = new Scanner(System.in);

    public int showMenu () {
        System.out.println("----- MENU-----");
        System.out.println("Seleccione una opcion: ");
        System.out.println("1.- Ingrese las personas: ");
        System.out.println("2.- Agregar una persona: ");
        System.out.println("3.- Ordenar las personas: ");
        System.out.println("4.- Buscar una personas: ");
        System.out.println("5.- Salir. ");
        
        return scanner.nextInt();
    }

    public Person inputPerson (){
        scanner.nextLine();
        System.out.println(" Ingrese el nombre: ");
        String name = scanner.nextLine();
        System.out.println("Ingrese la edad: ");
        int age = scanner.nextInt();
        return new Person (name, age);
    }

    public int selectSortingMethod (){
        System.out.println("Seleccione el metodo de ordenamiento deseado: ");
        System.out.println("1.- Burbuja: ");
        System.out.println("2.- Sleccion: ");
        System.out.println("3.- Insercion por edad: ");
        System.out.println("4.- Insercion por nombre");
        return scanner.nextInt();
    }

    public int selectSearchCriterion(){
        System.out.println("-- Buscar por: --");
        System.out.println("1.- Nombre: ");
        System.out.println("2.- Edad: ");
        return scanner.nextInt();
    }

    public void displayPersons(Person[] persons ){
        for (Person person : persons){
            System.out.println(person);
        }
    }

    public void displaySearchResult(Person person){
        if (person != null){
            System.out.println(" Persona encontrada " + person);
        } else {
            System.out.println("Persona no encontrada. ");
        }
    }

    public int inputAge(){
        System.out.println("Ingrese la edad a buscar: ");
        return scanner.nextInt();
    }

    public String inputName(){
        scanner.nextLine();
        System.out.println("Ingrese el nombre a buscar: ");
        return scanner.nextLine();
    }
    public Scanner getScanner(){
        return scanner;
    }
}
