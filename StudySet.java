import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class StudySet {
    private HashMap<String, Term> terms; 
    private int termCount = 0;
    private String ssName;


    /*
     * Constructor for StudySet that prompts
     * User for terms/definitions until User is
     * content
     * @param: StudySet Name
     * @return: None
     */
    public StudySet(String n, boolean user){
        this.ssName = n;
        Scanner scanSS = new Scanner(System.in);
        terms = new HashMap<>();

        while(true){
            System.out.println("Enter Term/Question Name: ");
            String name = scanSS.nextLine();
            System.out.println("Enter Definition/Answer: ");
            String answer = scanSS.nextLine();
            Term t = new Term(name, answer);
            terms.put(name, t);

            System.out.println("Added! Add more terms? Y/N ");
            termCount++;
            if(scanSS.nextLine().equals("Y")){
                continue;
            }else{
                break;
            }

        }
    }

    public StudySet(String n){
        this.ssName = n;
        terms = new HashMap<>();
    }

    public Term addTerm(String n, String a){
        Term t = new Term(n,a);
        terms.put(n, t);
        termCount++;
        return t;
    }

    public Term removeTerm(String n){
        return terms.remove(n);
    }

    public Term getTerm(String n){
        return terms.get(n);
    }

    public int getTermCount(){
        return this.termCount;
    }

    public String getName(){
        return this.ssName;
    }

    public void display(){
        System.out.println("\nSet: " + getName()+"\n");
        int i = 1;
        for(Map.Entry<String, Term> entry : terms.entrySet()){
            System.out.println((i) + ": " + entry.getValue().toString());
            i++;
        }
    }
}
