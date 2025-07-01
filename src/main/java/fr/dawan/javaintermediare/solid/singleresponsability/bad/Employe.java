package fr.dawan.javaintermediare.solid.singleresponsability.bad;

/*
Single Of Responsability: une classe ne doit gerer qu'une et unique tâche
 */
public class Employe {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employe(String name, int id) {
        this.name = name;
        this.id = id;
    }

    public Employe() {
    }

    public void save(Employe e){
        //save en BD
    }

    public boolean isPromotionDue(){
        //logic
        return true;
    }
}
/*
Constat: cette classe gère plusieurs tâches -> violation du Single Of Responsability
Le code au sein d'une classe ne doit avoir qu'une seule et unique responsabilité, qu'un seul type de tâche à effectuer
Si vous constatez que 2 têches différentes sont effectuées dans une classe, posez vous la question de savoir si vous
devez scinder la classe en 2.

Ce principe s'appliques aux: packages, classes et méthodes

Intérêts:
- Organisation du code
- Faible couplage
- Debug: code facile à maintenir
 */
