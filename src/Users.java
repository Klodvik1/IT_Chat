public class Users {
    String roleChat;
    String[] replicas;
    String[] triggerReplicas;

    Users (String[] str1, String[] str2){
        roleChat = str1[0];
        replicas = new String[str1.length - 1];
        for (int i = 1; i < str1.length; i++){
            replicas[i-1] = str1[i];
        }
        if (str2[0].length()<2) {
            triggerReplicas = new String[str2.length];
            for (int i = 0; i < str2.length; i++){
                triggerReplicas[i] = str2[i];
            }
        }
    }
}
