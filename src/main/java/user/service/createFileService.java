package user.service;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class createFileService {

    public void createFileInDirectories(File directory) {
        File[] files = directory.listFiles();

        for (File file : files) {
            if (file.isDirectory()) {
                createFile();
                createFileInDirectories(file);
            }
        }
    }

    public void createFile() {
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
