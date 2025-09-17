package src.main.model;
public class Term {
    private String name;
    private String answer;

    public Term(String t, String a){
        this.name = t;
        this.answer = a;
    }

    public String getName(){
        return this.name;
    }

    public String getAnswer(){
        return this.answer;
    }

    public String toString(){
        return this.name + "\n" + this.answer + "\n"; 
    }
}
