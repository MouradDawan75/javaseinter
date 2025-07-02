package fr.dawan.javaintermediare.designspatterns.creation.prototype;

import java.util.ArrayList;
import java.util.List;

public class Question implements Cloneable{

    private String texte;
    private List<Reponse> reponses = new ArrayList<>();

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public List<Reponse> getReponses() {
        return reponses;
    }

    public void setReponses(List<Reponse> reponses) {
        this.reponses = reponses;
    }

    public Question(String texte) {
        this.texte = texte;
    }

    public Question() {
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        /*
        On doit gérer les attributs complèxes de la classe
         */
        Question copie = (Question) super.clone(); //clonage des attributs standards (int, string,bool......)

        //Reponse est un attribut complèxe
        copie.reponses = new ArrayList<>();
        for(Reponse r : reponses){
            copie.reponses.add((Reponse)r.clone());
        }

        return copie;
    }

    //Solution sans l'interface cloneable
    public Question copy(){
        Question qst = new Question();
        qst.setTexte(this.getTexte());

        qst.reponses = new ArrayList<>();

        for(Reponse r : reponses){
            Reponse rep = new Reponse();
            rep.setText(r.getText());
            rep.setCorrect(rep.isCorrect());
            qst.reponses.add(rep);
        }

        return qst;
    }
}
