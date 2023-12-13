import java.util.regex.Pattern;

public class Person {
    String nickname;
    Users role;
    boolean trigger = false;


    Person(String words, Users[] user){
        String[] str = Pattern.compile(" ").split(words);

        if (str.length > 2){
            str[1] += " " + str[2];
        }
        nickname = str[0];
        for (int i = 0; i < user.length; i++){
            if (user[i].roleChat.equals(str[1])){
                role = user[i];
            }
        }
    }

    public void addTrigger (String search){
        if (search.equals(role.roleChat)){
            trigger = true;
        }
    }
}
