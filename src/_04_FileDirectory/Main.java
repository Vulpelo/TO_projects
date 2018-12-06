package _04_FileDirectory;

public class Main {
    public static void main(String[] args) {
        folderTest();
    }

    private static void folderTest() {
        // Creating hierarchy
        Check_Folder gf = new Check_Folder("root");

        Check_Folder f1 = new Check_Folder("Folder1");
        Check_Folder f2 = new Check_Folder("Folder2");
        Check_Folder f3 = new Check_Folder("Folder3");

        Check_Folder f11 = new Check_Folder("Folder1_1");
        Check_Folder f22 = new Check_Folder("Folder2_2");
        Check_Folder f33 = new Check_Folder("Folder2_2");

        Plik p1 = new Plik("Plik1");
        Plik p2 = new Plik("Plik2");
        Plik p3 = new Plik("Plik3");

        f1.add(f11);
        f1.add(p1);

        f2.add(f22);
        f2.add(p2);

        f3.add(f33);
        f3.add(p3);

        gf.add(f1);
        gf.add(f2);
        gf.add(f3);


        // commends
        System.out.println("");
        gf.tree(1);

        System.out.println("");
        gf.ls();
    }
}
