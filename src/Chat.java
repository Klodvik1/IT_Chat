import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class Chat {
    Person[] us;
    //int trigger = 0;
    public void Enable() throws IOException{
        gettingOrderUsers();
        for (int i=0; i < us.length; i++){
            //System.out.println(us[i].role.replicas[1]);
            //Type(i);
        }
    }

    private void gettingOrderUsers() throws IOException {
        Users[] user = gettingReplicas();
        String[] words = readFile("Users.txt").split("\n");
        us = new Person[words.length];
        for(int i = 0; i < words.length; i++){
            us[i] = new Person(words[i], user);
        }
    }

    private Users[] gettingReplicas() throws IOException {
        String[] words = readFile("Users_words.txt").split("\n");
        Users[] user = new Users[words.length];
        for(int i =0; i < words.length; i++){
            String[] str = words[i].split(":");
            user[i] = new Users(str[0].split(";"),str[1].split(";"));
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

    private void Type (int i){
       // System.out.println(us[i].nickname + ":" + us[i].role.replicas[0]);
        if ((i>0) & (us[i].role.replicas.length > 1)){
            if (us[i].trigger) {
                if (us[i].role.roleChat.equals("Team Lead")){
                    for (int j = 1; j < i; j++){
                        if ((!us[j].trigger) & (!us[i].role.roleChat.equals("Senior"))){
                            System.out.println(us[i].nickname + ":" + us[i].role.triggerReplicas[0] + us[j].nickname + "!");
                        }
                    }
                } else {
                    System.out.println(us[i].nickname + ":" + us[i].role.triggerReplicas[0]);
                }
            } else {
                System.out.println(us[i].nickname + ":" + us[i].role.replicas[1]);
                for(int j = i; (j < us.length) & (!us[i].role.roleChat.equals("Team Lead")); j++){
                    us[j].addTrigger("Team Lead");
                    us[j].addTrigger("Senior");
                }
            }
        } else if ((us[i].trigger) & (us[i].role.triggerReplicas.length > 0)){
            System.out.println(us[i].nickname + ":" + us[i].role.triggerReplicas[0]);
            for (int j=0; j < us.length; j++){
                us[j].addTrigger("Middle");
            }
        }
    }
}
