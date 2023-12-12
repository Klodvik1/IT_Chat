public class Users {
    String roleChat;
    String[] replicаs;

    Users (String[] str){
        roleChat = str[0];
        replicаs = new String[str.length - 1];
        for (int i = 1; i < str.length; i++){
            replicаs[i-1] = str[i];
        }
    }
}
