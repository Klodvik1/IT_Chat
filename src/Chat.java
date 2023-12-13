import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

public class Chat {
    Person[] us;
    //int trigger = 0;
    public void Enable() throws IOException{
        gettingOrderUsers();
        for (int i=0; i < us.length; i++){
            Type(i);
        }
    }

    private void gettingOrderUsers() throws IOException {
        Users[] user = gettingReplicas();
        String[] words = readFile("Users.txt");
        us = new Person[words.length];
        for(int i = 0; i < words.length; i++){
            us[i] = new Person(words[i], user);
        }
    }

    private Users[] gettingReplicas() throws IOException {
        String[] words = readFile("Users_words.txt");
        Users[] user = new Users[words.length];
        for(int i =0; i < words.length; i++){
            String[] str = Pattern.compile(":").split(words[i]);
            user[i] = new Users(Pattern.compile(";").split(str[0]),str[1]);
        }
        return user;
    }

    private String[] readFile(String filePath)throws IOException {
        List<String> str = new ArrayList<>();
        String[] content = null;
        try {
            BufferedReader in = new BufferedReader(new FileReader(filePath));
            String line;
            while ((line = in.readLine()) != null)
                str.add(line);
            in.close();
            content = new String[str.size()];
            str.toArray(content);
        } catch (IOException e) {
        }
        return content;
    }

    private void Type (int i){
        System.out.println(us[i].nickname + ":" + us[i].role.replicas[0]);
        if (i>0){
            if (us[i].trigger) {
                if (us[i].role.roleChat.equals("Team Lead")){
                    for (int j = 1; j < i; j++){
                        if ((!us[j].trigger) & (!us[i].role.roleChat.equals("Senior"))){
                            System.out.println(us[i].nickname + ":" + us[i].role.triggerReplicas[0] + " " + us[j].nickname + "!");
                        }
                    }
                } else {
                    System.out.println(us[i].nickname + ":" + us[i].role.triggerReplicas[0]);
                    if (us[i].role.roleChat.equals("Senior")){
                        for (int j=i; j < us.length; j++){
                            us[j].addTrigger("Middle");
                        }
                    }
                }
            } else {
                System.out.println(us[i].nickname + ":" + us[i].role.replicas[1]);
                for(int j = i; (j < us.length) & (!us[i].role.roleChat.equals("Team Lead")); j++){
                    us[j].addTrigger("Team Lead");
                    us[j].addTrigger("Senior");
                }
            }
        } else {
            us[i].trigger = true;
        }
    }
}
