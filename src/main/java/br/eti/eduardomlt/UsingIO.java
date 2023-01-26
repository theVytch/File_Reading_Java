package br.eti.eduardomlt;

import java.io.*;

public class UsingIO {

    private static final String MY_FILE = "D:" + File.separator + "file-using-io.txt";

    public UsingIO() {
        try {
            writeFile();
        }catch (IOException ex){
            ex.printStackTrace();
        }
        readFile();
    }

    private void writeFile() throws IOException{
        final File file = new File(MY_FILE);

        boolean fileCreated = false;

        if(!file.exists()){
            fileCreated = file.createNewFile();
        }

        if(fileCreated || file.exists()){
            final OutputStream output = new FileOutputStream(file);

            final var content = "Ola mundo IO";

            output.write(content.getBytes("UTF-8"));
            output.close();

            System.out.println("Dados gravados no arquivo");
        }
    }

    private void readFile() {
        try(final InputStream input = new FileInputStream(MY_FILE)) {
            int content;
            while ((content = input.read()) != -1) {
                System.out.print((char) content);
            }
        }catch (IOException ex){
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new UsingIO();
    }
}
