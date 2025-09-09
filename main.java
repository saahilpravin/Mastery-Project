import java.util.ArrayList;
import java.util.Scanner;

public class main{
    public static ArrayList<StudySet> preDefs = new ArrayList<>();
    public static void main(String args[]) {
        Scanner scan = new Scanner(System.in);
        createPreDefs();
        StudySet curr;

        System.out.println("Welcome! Would you like to create your own Study Set? Y/N ");
        
        if(scan.nextLine().equals("Y")){
            System.out.println("StudySet Name: ");
            curr = new StudySet(scan.nextLine(), true);
            preDefs.add(curr);
            curr.display();
        }else{
            System.out.println("Choose StudySet Number from Below: ");
            int i=1;
            for(StudySet ss: preDefs){
                System.out.print(i+". " + ss.getName() + "  ");
                i++;
            }
            System.out.println();
            i = scan.nextInt();
            curr = preDefs.get(i-1);
            curr.display();
        }
        while(true){
            System.out.println("What would you like to do? Study/Edit/New/Exit ");
            String action = scan.next();
            if(action.equals("Edit")){
                curr.display();
                System.out.println("What would you like to edit? Add/Remove ");
                String edit = scan.next();
                if(edit.equals("Add")){
                    System.out.println("Enter Term/Question Name: ");
                    scan.nextLine();
                    String name = scan.nextLine();
                    System.out.println("Enter Definition/Answer: ");
                    String answer = scan.nextLine();
                    curr.addTerm(name, answer);
                    System.out.println("Term Added!");
                }else{
                    System.out.println("Enter Term/Question Name: ");
                    scan.nextLine();
                    String name = scan.nextLine();
                    curr.removeTerm(name);
                    System.out.println("Term Removed!");
                }
                curr.display();
            }else if(action.equals("Study")){
                System.out.println("In Progress");
            }else if(action.equals("Exit")){
                break;
            }else if(action.equals("New")){
                System.out.println("Would you like to create your own Study Set? Y/N ");
                if(scan.next().equals("Y")){
                    System.out.println("StudySet Name: ");
                    scan.nextLine();
                    curr = new StudySet(scan.nextLine(), true);
                    preDefs.add(curr);
                    curr.display();
                }else{
                    System.out.println("Choose StudySet Number from Below: ");
                    int i=1;
                    for(StudySet ss: preDefs){
                        System.out.print(i+". " + ss.getName() + "  ");
                        i++;
                    }
                    System.out.println();
                    i = scan.nextInt();
                    curr = preDefs.get(i-1);
                    curr.display();
                }
            }
        }   
        scan.close();
    }


    private static void createPreDefs(){
        StudySet CST = new StudySet("CS Theory");
        preDefs.add(CST);
        CST.addTerm("Automata", "abstract machines");
        CST.addTerm("Alphabet", "Nonempty finite set");
        CST.addTerm("Sigma*", "Set of all strings");
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