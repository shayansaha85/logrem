import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;

// > java -jar logrem.jar -path=/path/of/log/folders -maxSizeLimit=3 -logFileExtension=log,out

public class LogFileRemover {

    public static boolean isPresent(String[] extension, String filename) {
        boolean isPresent = false;
        int length = extension.length;
        int count = 0;
        String fileExtension = filename.split("\\.")[filename.split("\\.").length-1];
        for(int i=0; i<length; i++) {
            if(fileExtension.equalsIgnoreCase(extension[i])) {
                count++;
            }
        }
        if(count != 0) {
            isPresent = true;
        }
        return isPresent;
    }

    public static ArrayList<String> findLogs(String folderPath, String[] extensions) {
        ArrayList<String> filesWithDefinedExtensions = new ArrayList<>();
        String filename = "";
        File folder = new File(folderPath);
        File[] listOfFiles = folder.listFiles();

        for (int i = 0; i < listOfFiles.length; i++) {
            if (listOfFiles[i].isFile()) {
               filename = listOfFiles[i].getName();
               if(isPresent(extensions, filename)) {
                   filesWithDefinedExtensions.add(filename);
               }
            }
        }
        return filesWithDefinedExtensions;
    }

    public static String getSizeOfFile(String filepath) throws IOException {
        String sizeOfFile = "";
        File file = new File(filepath);
        Path path = Paths.get(filepath);
        long bytes = Files.size(path);
        sizeOfFile = String.format("%d", bytes / 1024);
        return sizeOfFile;
    }

    public static void deleteFile(String filepath) {
        File file = new File(filepath);
        file.delete();
    }
    public static void main(String[] args) throws IOException {
        ArrayList<String> files;
        ArrayList<String> pathsWithFilenames = new ArrayList<>();
        try {
            String path_flag = args[0];
            String maxSizeLimit_flag = args[1];
            String logFileExtension_flag = args[2];

            if (args[0].split("=")[0].equalsIgnoreCase("-path") && args[0].split("=")[0].equalsIgnoreCase("-maxSizeLimit") && args[0].split("=")[0].equalsIgnoreCase("-logFileExtension")) {
                String path = path_flag.split("=")[1];
                String maxSize = maxSizeLimit_flag.split("=")[1];
                String[] extensions = logFileExtension_flag.split("=")[1].split(",");
                System.out.println();
                System.out.println("Searching files with below extensions:");
                System.out.println("=============================================================================================================================");
                for (int j = 0; j < extensions.length; j++) {
                    System.out.println((j + 1) + ". " + extensions[j]);
                }
                System.out.println();

                files = findLogs(path, extensions);
                for (int i = 0; i < files.size(); i++) {
                    pathsWithFilenames.add(path + "/" + files.get(i));
                }

                for (String p : pathsWithFilenames) {
                    if (Double.valueOf(getSizeOfFile(p)) >= Double.valueOf(maxSize)) {
                        System.out.println("=============================================================================================================================");
                        System.out.println("File location : " + p);
                        System.out.println("File size : " + getSizeOfFile(p));
                        System.out.println("The size is more than permissible limit i.e. " + maxSize + " KB");
                        deleteFile(p);
                        System.out.println("FILE DELETED");
                    } else {
                        System.out.println("=============================================================================================================================");
                        System.out.println("File location : " + p);
                        System.out.println("File size : " + getSizeOfFile(p));
                        System.out.println("The size is not more than permissible limit i.e. " + maxSize + " KB");
                        System.out.println("FILE NOT DELETED");

                    }
                }
            } else {
                System.out.println("=============================================================================================================================");
                System.out.println("RUN FAILED");
                System.out.println("=============================================================================================================================");
                System.out.println();
                System.out.println("Please read the guide below for running the tool");
                System.out.println();
                System.out.println("To run the jar file you should have three things");
                System.out.println("\t1)\tpath [ folder path of the log files ]");
                System.out.println("\t2)\tmaxSizeLimit [ file size limit in kilobytes ]");
                System.out.println("\t3)\tlogFileExtension [ extensions of the files you want to delete. extensions should be separated by comma (\",\") ]");
                System.out.println();
                System.out.println("Example: java -jar logrem.jar -path=/path/of/log/folders -maxSizeLimit=3 -logFileExtension=log,out");
                System.out.println("=============================================================================================================================");

            }
        }
        catch(Exception e) {
            System.out.println("=============================================================================================================================");
            System.out.println("RUN FAILED");
            System.out.println("=============================================================================================================================");
            System.out.println();
            System.out.println("Please read the guide below for running the tool");
            System.out.println();
            System.out.println("To run the jar file you should have three things");
            System.out.println("\t1)\tpath [ folder path of the log files ]");
            System.out.println("\t2)\tmaxSizeLimit [ file size limit in kilobytes ]");
            System.out.println("\t3)\tlogFileExtension [ extensions of the files you want to delete. extensions should be separated by comma (\",\") ]");
            System.out.println();
            System.out.println("Example: java -jar logrem.jar -path=/path/of/log/folders -maxSizeLimit=3 -logFileExtension=log,out");
            System.out.println("=============================================================================================================================");

        }


    }
}