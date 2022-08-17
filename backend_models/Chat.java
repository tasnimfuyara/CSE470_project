
package backend_models;

import java.io.*;

public class Chat {

    Account clientAccount, otherUser;
    String[] chatHistoryArr;
    int chatIndex = -1;
    String chatLog;

    //Probably a List for chat history that is returned as a string array
    public Chat(Account clientAccount, Account otherUser) throws IOException {
        this.clientAccount = clientAccount;
        this.otherUser = otherUser;
        //search for clientAccount&otherUser or otherUser&&clientAccount
        TextFile f = new TextFile("chatLog.txt");
        chatLog = f.fileContent;
        //System.out.println(chatLog);
        chatHistoryArr = chatLog.split("aaskopplooe");//each ^%@&¡¿¿e is the end of a chat
        //      int i = 0;

        for (int i = 0; i < chatHistoryArr.length; i++) {
            //System.out.print(chatHistoryArr[i]);
            if (chatHistoryArr[i].indexOf(this.clientAccount.getUsername().toLowerCase() + "&&" + this.otherUser.getUsername().toLowerCase() + " aaskopploo") == 0
                    || chatHistoryArr[i].indexOf(this.clientAccount.getUsername().toLowerCase() + "&&" + this.otherUser.getUsername().toLowerCase() + " aaskopploo") == 1) {
                chatIndex = i;
                break;
            }

            if (chatHistoryArr[i].indexOf(this.otherUser.getUsername().toLowerCase() + "&&" + this.clientAccount.getUsername().toLowerCase() + " aaskopploo") == 0
                    || chatHistoryArr[i].indexOf(this.otherUser.getUsername().toLowerCase() + "&&" + this.clientAccount.getUsername().toLowerCase() + " aaskopploo") == 1) {
                chatIndex = i;
                break;
            }
        }

        if (chatIndex == -1) {
            chatLog += this.clientAccount.getUsername() + "&&" + this.otherUser.getUsername() + " aaskopploo aaskopplooe";
            chatHistoryArr = f.fileContent.split("aaskopplooe");
            chatIndex = chatHistoryArr.length - 1;
            chatHistoryArr[chatIndex] = this.clientAccount.getUsername() + "&&" + this.otherUser.getUsername() + " aaskopploo ";
            FileWriter fw = new FileWriter("chatLog.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.print(chatLog);
            pw.close();
            fw.close();
        }
    }

    public String[] getChatHistory() {

        //split it at the string ^$@&¡¿¿
        //String ^$@&¡¿¿~ represents the end of chatHistory
        //System.out.println(chatHistoryArr[chatIndex]);
        String df = chatHistoryArr[chatIndex];
        //System.out.println("Chat History: " + df);
        String[] chatHistorybtnUsers = df.split("aaskopploo");
        //System.out.println(chatHistorybtnUsers[0]);
        if (chatHistorybtnUsers.length >= 2) {

            String[] returnArray = new String[chatHistorybtnUsers.length - 2]; //everything but first adn last 
            for (int i = 1; i < chatHistorybtnUsers.length - 1; i++) {
                returnArray[i - 1] = chatHistorybtnUsers[i];
            }
            return returnArray;
        } else {
            String[] a = {"This is the beginning of your chat! Say Hi!"};
            return a;
        }

    }

    public void sendChat(String message) {
        FileWriter fw;
        try {
            String theMessage = clientAccount.getUsername() + ":" + message;
            //  chatHistory.add(theMessage);
            String temp = chatHistoryArr[chatIndex];
            //System.out.println("Temp = " + temp);
            chatHistoryArr[chatIndex] += theMessage + " aaskopploo ";
            chatLog = chatLog.replace(temp, chatHistoryArr[chatIndex]);
            fw = new FileWriter("chatLog.txt");
            PrintWriter pw = new PrintWriter(fw);
            pw.print(chatLog);
            chatHistoryArr = chatLog.split("aaskopplooe");
            pw.close();
            fw.close();
        } catch (IOException ex) {
            throw new RuntimeException(ex);
        }

    }

}
