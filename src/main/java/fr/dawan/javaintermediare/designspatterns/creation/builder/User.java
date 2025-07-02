package fr.dawan.javaintermediare.designspatterns.creation.builder;


public class User {

    private String firstName; // required
    private String lastName; //required
    private int age; //optional
    private String email; //optional
    private String password; //optional

    //Option1: la classe gère sa propre instanciation
    // définir plusieurs constrcuteurs
    //User(firstName,lastName)
    //UserfirstName,lastName)


//    public User(String firstName, String larstName, int age, String email, String password) {
//        this.firstName = firstName;
//        this.larstName = larstName;
//        this.age = age;
//        this.email = email;
//        this.password = password;
//    }

    //Option2: utiliser le pattern builder: déléguer l'instanciation à une autre classe
    /*
    1- Vérrouiller l'accès au constructeur par défaut
    2- Définir une classe interne static qui va initialiser tous les de l'objet (1 méthode par attribut)
    3- La pattern possède une méthode build qui renvoie l'objet instancié
     */

    private User(){

    }

    public static UserBuilder builder(String firstName, String lastName){
        return new UserBuilder(firstName, lastName);
    }

    public static class UserBuilder{
        private User user;

        public UserBuilder(String firstName, String lastName){
            user = new User();
            user.firstName = firstName;
            user.lastName = lastName;
        }

        public UserBuilder withAge(int age){
            user.age = age;
            return this;
        }

        public UserBuilder withEmail(String email){
            user.email = email;
            return this;
        }

        public UserBuilder withPassword(String password){
            user.password = password;
            return this;
        }

        public User build(){
            return user;
        }
    }
}
