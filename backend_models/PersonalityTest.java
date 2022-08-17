/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend_models;

import java.io.*;
import java.util.*;


public class PersonalityTest {

    private String question,
            answer1,
            answer2;

    public String getQuestion(int i) throws IOException {
        Scanner sc = new Scanner(new File("PTQuestions.txt"));
        String questionString = "";
        int a = 0;
        while(sc.hasNext() && a != i ) {
            questionString = sc.nextLine();
            a++;
        }
        sc.close();
        
        question = questionString.substring(0, questionString.indexOf("?"));
        answer1 = questionString.substring(questionString.indexOf("?") + 1, questionString.indexOf("@"));
        answer2 = questionString.substring(questionString.indexOf("@") + 1, questionString.indexOf("!"));

        return question;

    }

    public String getAnswer1() {
        return answer1;
    }

    public String getAnswer2() {
        return answer2;
    }

}
