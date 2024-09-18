package user;

import user.service.createFileService;

import java.io.File;

public class Main {
    public static void main(String[] args) {
        createFileService fileService = new createFileService();

        File directory = new File("").getAbsoluteFile();

        fileService.createFileInDirectories(directory);
    }
}