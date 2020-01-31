package com.example.a26498;

public class UserClass {
    private int moneyTotalMoth;
    private int moneyTotalDay;
    private int moneyHave;

    public UserClass(){
    }

    public UserClass(int moneyTotalDay,int moneyTotalMoth,int moneyHave){
        this.setMoneyHave(moneyHave);
        this.setMoneyTotalDay(moneyTotalDay);
        this.setMoneyTotalMoth(moneyTotalMoth);
    }
    /*get() and set()*/
    public int getMoneyTotalMoth() {
        return moneyTotalMoth;
    }

    public void setMoneyTotalMoth(int moneyTotalMoth) {
        this.moneyTotalMoth = moneyTotalMoth;
    }

    public int getMoneyTotalDay() {
        return moneyTotalDay;
    }

    public void setMoneyTotalDay(int moneyTotalDay) {
        this.moneyTotalDay = moneyTotalDay;
    }

    public int getMoneyHave() {
        return moneyHave;
    }

    public void setMoneyHave(int moneyHave) {
        this.moneyHave = moneyHave;
    }

    /*normal methods*/

}
