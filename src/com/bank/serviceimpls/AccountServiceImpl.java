package com.bank.serviceimpls;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import com.bank.domains.AccountBean;
import com.bank.services.AccountService;
public class AccountServiceImpl implements AccountService{
	private List<AccountBean> accounts;
	
	public AccountServiceImpl() {
		accounts = new ArrayList<>();
	}
	
    @Override
    public void createAccount(String money) {
        AccountBean a = new AccountBean();
        a.setMoney(money);
        a.setRegDate(findDate());
        a.setAccountNum(createAccountNum());
        System.out.println(a.toString());
        accounts.add(a);
    }
    
    @Override
    public String createAccountNum() {
    	Random ran = new Random();
    	String acc = String.format("%04d-%04d", ran.nextInt(9999)+1,ran.nextInt(9999)+1);//04는 비워진 자리 0으로, 4자리로 정수
        return acc;
    }

    public List<AccountBean> findAll() {
        return accounts;
    }
    @Override
    public AccountBean findByAccountNum(String accountNum) {
    	AccountBean ac = new AccountBean();
    	for(AccountBean a: accounts) {
    		if(accountNum.equals(a.getAccountNum())) {
    			ac = a;
    		}
    	}
        return ac;
    }
    @Override
    public int countAccounts() {
        return accounts.size();
    }
    @Override
    public boolean existAccountNum(String accountNum) {
    	boolean flag = false;
    	for(AccountBean ac : accounts) {
    		if(accountNum.equals(ac.getAccountNum())) {
    			flag = true;
    		}
    	}
        return flag;
    }
    @Override
    public String findDate() {
    	SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd hh : mm");
    	String date =  sdf.format(new Date());
        return date;
    }
    @Override
    public void depositMoney(AccountBean param) {
    	int idx = 0, val1 = 0, val2 = 0;
        if(existAccountNum(param.getAccountNum())) {
        	for(AccountBean ac : accounts) {
        		if(param.getAccountNum().equals(ac.getAccountNum())) {
        			idx = accounts.indexOf(ac);
        			val1 =Integer.parseInt(param.getMoney());
        			val2 = Integer.parseInt(ac.getMoney());
        			ac.setMoney(String.valueOf(val1+val2));
        			ac.setRegDate(findDate());
        			accounts.add(idx,ac);
        			break;
        		}
        	}
        }
    }
    @Override
    public void withdrawMoney(AccountBean param) {
    	int idx = 0, val1 = 0, val2 = 0;
        if(existAccountNum(param.getAccountNum())) {
        	for(AccountBean ac : accounts) {
        		if(param.getAccountNum().equals(ac.getAccountNum())) {
        			idx = accounts.indexOf(ac);
        			val1 =Integer.parseInt(param.getMoney());
        			val2 = Integer.parseInt(ac.getMoney());
        			ac.setMoney(String.valueOf(val1-val2));
        			ac.setRegDate(findDate());
        			accounts.add(idx,ac);
        			break;
        		}
        	}
        }
    }

    @Override
    public void deleteAccountNum(String accountNum) {
    	accounts.remove(findByAccountNum(accountNum));
    	}  
    }
    