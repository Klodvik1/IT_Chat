public class Person {
    String nickname;
    Users role;
    boolean trigger = false;


    Person(String words, Users[] user){
        String[] str = words.split(" ");
        if (str.length > 2){
            str[1] += " " + str[2];
        }
        nickname = str[0];
//        str[1]= str[1].replaceAll(".$", "");
        System.out.println(str[1]);
        for (int i = 0; i < user.length; i++){
            if (user[i].roleChat.equals(str[1])){
                role = user[i];
                System.out.println(str.length);
            }
        }
    }

    public void addTrigger (String search){
        if (search.equals(role.roleChat)){
            trigger = true;
        }
    }
}
