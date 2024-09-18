package user;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");

        File directory = new File("").getAbsoluteFile();

        createFileInDirectories(directory);
    }

    public static void createFileInDirectories(File directory) {
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                createFile();
                createFileInDirectories(file);
            }
        }
    }

    public static void createFile() {
        File jokeJava = new File("joke.java");

        try {
            jokeJava.createNewFile();

            try (FileWriter fw = new FileWriter(jokeJava)) {
                fw.write("public class Main {\n");
                fw.write("  public static void main(String[] args) {\n");
                fw.write("      System.out.println(\"Hello world\");\n");
                fw.write("  }\n");
                fw.write("}\n");
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}