package Proyecto_Ficheros_Texto;

import java.io.*;

public class OpenFile {

    public static BufferedReader r (String file_path) throws IOException {
        return new BufferedReader( new FileReader( new File(file_path)));
    }

    public static BufferedWriter w (String file_path) throws IOException {
        return new BufferedWriter( new FileWriter( new File(file_path)));
    }

    public static BufferedWriter a (String file_path) throws IOException {
        return new BufferedWriter( new FileWriter( new File(file_path), true));
    }
}