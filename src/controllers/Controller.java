package controllers;
import java.util.ArrayList;
import java.util.List;


import models.Person;
import views.View;


public class Controller {
    private View view;
    private SortingMethods sortingMethods;
    private SearchMethods searchMethods;
    private List<Person> persons;


    public Controller(View view, SortingMethods sortingMethods, SearchMethods searchMethods) {
        this.view = view;
        this.sortingMethods = sortingMethods;
        this.searchMethods = searchMethods;
        this.persons = new ArrayList<>();
    }

    public void start (){
        boolean r = true;
        while(r){
            int opcion = view.showMenu();
            if (opcion == 1){
                inputPersons();
            } else if (opcion == 2){
                addPersons();
            } else if (opcion == 3){
                sortPersons();
            } else if (opcion == 4){
                searchPerson ();
            } else if (opcion == 5){
                view.displayPersons(persons.toArray(new Person [0]));
            } else if (opcion == 0){
                r = false;
            } else {
                System.out.println("Opcion invalida.");
            }
        }
    }

    public void inputPersons (){
        System.out.println(" ¿Cuantas personas va a ingregar? ");
        int c = view.getScanner().nextInt();
        for ( int i = 0 ; i < c ; i++){
            persons.add(view.inputPerson());
        } 
    }

    public void addPersons (){
        persons.add(view.inputPerson());
    }

    public void sortPersons(){
        if(persons.isEmpty()){
            System.out.println("No hay personas suficientes para ordenar.");
            return;
        }
    }

    public void searchPerson() {
        int searchCriterion = view.selectSearchCriterion();  
    
        Person persona = null;  
        
        if (searchCriterion == 1) {  
            String name = view.inputName();
            persona = searchMethods.binarySearchByName(persons.toArray(new Person[0]), name);
        } else if (searchCriterion == 2) {  
            int age = view.inputAge();
            persona = searchMethods.binarySearchByAge(persons.toArray(new Person[0]), age);
        } else {
            System.out.println("Opcion invalida.");
        }
        
        view.displaySearchResult(persona); 
    }
    
}
