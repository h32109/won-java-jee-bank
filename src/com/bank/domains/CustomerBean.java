package com.bank.domains;
public class CustomerBean extends MemberBean{
    private static final long serialVersionUID = 1L;
    private String credit;
    public String getCredit() {
        return credit;
    }
    public void setCredit(String credit) {
        this.credit = credit;
    }
    @Override
    public String toString() {
        return String.format("%s,%s,%s,%s,%s", getId(),getPw(),getName(),getSsn(),credit);
    }
}