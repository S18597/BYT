public class Main {
    public static void main(String[] args) {
        ConcreteMediators mediators = new ConcreteMediators();
        CColleague1 cColleague1 = new CColleague1(mediators);
        CColleague2 cColleague2 = new CColleague2(mediators);
        CColleague3 cColleague3 = new CColleague3(mediators);

        mediators.addColleagueToList(cColleague1);
        mediators.addColleagueToList(cColleague2);
        mediators.addColleagueToList(cColleague3);

        cColleague1.send("CColleague1. Message1.");

        System.out.println();

        cColleague3.send("CColleague3. Message1.");
    }
}
