import java.util.ArrayList;
import java.util.Scanner;

public class main{
    public static ArrayList<StudySet> preDefs = new ArrayList<>();
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        createPreDefs();
        StudySet curr;

        System.out.println("Welcome! Would you like to create your own Study Set? Y/N ");
        
        if(scan.next().equals("Y")){
            System.out.println("StudySet Name: ");
            scan.nextLine();
            curr = new StudySet(scan.nextLine(), true);
            preDefs.add(curr);
            curr.display();
        }else{
            System.out.println("Choose StudySet from Below: ");
            for(StudySet ss: preDefs){
                System.out.print(ss.getName() + "  ");
            }
            scan.nextLine();
            scan.nextLine();

        }

        scan.close();
    }


    private static void createPreDefs(){
        StudySet CST = new StudySet("CS Theory");
        preDefs.add(CST);
        CST.addTerm("Automata", "abstract machines");
        CST.addTerm("Alphabet", "Nonempty finite set");
        CST.addTerm("Σ*", "Set of all strings");
        StudySet DM = new StudySet("Discrete Math");
        preDefs.add(DM);
        DM.addTerm("Set", "A well-defined collection of distinct objects");
        DM.addTerm("Truth Table", "A mathematical table used to show the truth values of a logical expression");
        DM.addTerm("Functions", "A rule that assigns to every element of A exactly one element of B");
        StudySet LA = new StudySet("Linear Algebra");
        preDefs.add(LA);
        LA.addTerm("Vector", "A mathematical object that can be abstractly defined as an element of a vector space");
        LA.addTerm("Orthogonality", "Describes vectors that are perpendicular to each other, analogous to a 90-degree angle in geometry");
        
    }
}