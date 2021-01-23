public class Main {
    public static void main(String[] args) {

        Lab lab = new Lab();
        Computer pc1 = lab.logOut();
        Computer pc2 = lab.logOut();
        lab.logIn(pc1);
        lab.logIn(pc2);

    }
}

