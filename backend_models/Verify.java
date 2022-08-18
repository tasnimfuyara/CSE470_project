/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package backend_models;

/**
 *
 * @author student
 */
public class Verify {

    private String path;

    public boolean imageTest(String input) {
        //get path
        //show captcha
        //get user input
        // correct return true
        // wrong return false

        int num = Integer.parseInt(input);

        String s = "Images/" + num + ".png";
        if (path.equals(s)) {
            return true;
        } else {
            return false;
        }
    }

    public String getVerifImgStr() {
        double a = Math.random() * 7;
        int d = (int) a;
        while (d == 0) {
            a = Math.random() * 7;
            d = (int) a;
        }
        this.path = "Images/" + d + ".png";
        return this.path;
    }
}
