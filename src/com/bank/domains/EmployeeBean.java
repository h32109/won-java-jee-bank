package com.bank.domains;
public class EmployeeBean extends MemberBean{
    
    private static final long serialVersionUID = 1L;
    private String sabun;
    public String getSabun() {
        return sabun;
    }
    public void setSabun(String sabun) {
        this.sabun = sabun;
    }
    @Override
    public String toString() {
        return "ȸ������ [id=" + getId()
                + ", pw=" + getPw()
                + ", name=" + getName()
                + ", ssn=" + getSsn()
                + ", sabun=" + sabun + "]";
    }
}