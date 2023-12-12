import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Chat {
    public void Enable() throws IOException{
        Us[] us = gettingOrderUsers();
    }

    private Us[] gettingOrderUsers() throws IOException {
        Users[] user = gettingReplicas();
        String[] words = readFile("Users.txt").split("\n");
        Us[] us = new Us[words.length];
        for(int i = 0; i < words.length; i++){
            us[i] = new Us(words[i], user);
        }
        return us;
    }

    private Users[] gettingReplicas() throws IOException {
        String[] words = readFile("Users_words.txt").split("\n");
        Users[] user = new Users[words.length];
        for(int i =0; i < words.length; i++){
            String[] str = words[i].split(";");
            user[i] = new Users(str);
        }
        return user;
    }

    private String readFile(String filePath)throws IOException {
        StringBuffer fileData = new StringBuffer();
        BufferedReader reader = new BufferedReader(
                new FileReader(filePath));
        char[] buf = new char[1024];
        int numRead=0;
        while((numRead=reader.read(buf)) != -1){
            String readData = String.valueOf(buf, 0, numRead);
            fileData.append(readData);
        }
        reader.close();
        return fileData.toString();
    }
}
