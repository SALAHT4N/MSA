package com.software.mas.model.templates;

public class LoginStatus {
    /*
    * @param correct :
    * represent the status of the login action is it Correct or not.
    * @param lvl :
    * represent the user level for the one have pressed the login button.
    * 0 -> Customer. 1 -> User.
    * */

    public LoginStatus(){
        correct=false;
        lvl=-1;
    }


    private boolean correct;
    private int lvl;

    public boolean isCorrect() {
        return correct;
    }

    public void setCorrect(boolean correct) {
        this.correct = correct;
    }

    public int getLvl() {
        return lvl;
    }

    public void setLvl(int lvl) {
        this.lvl = lvl;
    }
}
