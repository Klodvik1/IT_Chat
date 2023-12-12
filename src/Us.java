public class Us {
    String nickname;
    Users role;

    Us (String str, Users[] user){
        String[] str2 = str.split(" ");
        nickname = str2[0];
        if (str2.length > 2){
            str2[1] = str2[1] + ' ' + str2[2];
        }

        for (int i = 0; i < user.length; i++){
            if (user[i].roleChat.equals(str2[1])){
                role = user[i];
            }
        }
    }
}
