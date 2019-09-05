package com.bank.serviceimpls;
import java.util.ArrayList;
import java.util.List;

import com.bank.DAOImpls.MemberDAOImpl;
import com.bank.daos.MemberDAO;
import com.bank.domains.CustomerBean;
import com.bank.domains.EmployeeBean;
import com.bank.domains.MemberBean;
import com.bank.services.MemberService;

public class MemberServiceImpl implements MemberService {
private MemberDAO dao;
	
	
	public MemberServiceImpl() {
		dao = new MemberDAOImpl();
	}
	
    @Override
    public void join(CustomerBean param) {
        dao.insertCustomer(param);
    }
 
    @Override
    public void register(EmployeeBean param) {
    }
    
    @Override
    public CustomerBean login(MemberBean param) {
    	CustomerBean customer = new CustomerBean();
    	customer.setId(param.getId());
    	customer.setPw(param.getPw());
    	CustomerBean target = dao.login(customer);
        return target;
    }
}
   /* @Override
   public List<CustomerBean>findAllCustomers() {
        return null;
    }
    
    @Override
   public List<EmployeeBean> findAllAdmins() {
    	List<EmployeeBean> emps = new ArrayList<>();
    /emps = this.employees; 
        return emps;
    }
    
    @Override
    public List<MemberBean> findByName(String name) {
    	MemberBean m = new MemberBean();
    	List<MemberBean> ms = new ArrayList<>();
    	int count =0, count1 =0;
      	for(CustomerBean c : customers) {
    		if(name.equals(c.getName())) {
    			ms.add(m);
    			count++;
    		}
    	}
    	for(EmployeeBean e : employees) {
    		if(name.equals(e.getName())) {
    			ms.add(e);
    			count++;
    			break;
    		}
    	}
    	for(CustomerBean c : customers) {
    		if(name.equals(c.getName())) {
    			ms.add(m);
    			count1++;
    			if(count == count1) {
    		        return ms;
    			}
    		}
    	}
    	for(EmployeeBean e : employees) {
    		if(name.equals(e.getName())) {
    			ms.add(e);
    			break;
    		}
    	}
        return ms;
    }
    @Override
    public MemberBean findById(String id) {
    	MemberBean m = new MemberBean();
    	for(CustomerBean c : customers) {
    		if(id.equals(c.getId())) {
    			m = c;
    			break;
    		}
    	}
    	for(EmployeeBean c : employees) {
    		if(id.equals(c.getId())) {
    			m = c;
    			break;
    		}
    	}
        return m;
    }

    
    @Override
    public int countCustomers() {
        return customers.size();
    }
    
    @Override
    public int countAdmins() {
        return employees.size();
    }
    
    @Override
    public boolean existId(String id) {
    	MemberBean m = findById(id);
        return employees.contains(m)||customers.contains(m);
    }
    
    @Override
    public void updatePass(MemberBean param) {
    	String id = param.getId();
    	String oldP = param.getPw().split(",")[0];
        String newP = param.getPw().split(",")[1];
        MemberBean m = findById(id);
        if(m.getPw().equals(oldP)) {
        int idx = (employees.contains(m)) ? employees.indexOf(m) : customers.indexOf(m);
        if(employees.contains(m)) {
        	employees.get(idx).setPw(newP);
        }else {
        	customers.get(idx).setPw(newP);
        }
        	
        }
    }
    @Override
    public boolean deleteMember(MemberBean param) {
    	boolean flag = false;
    	MemberBean m = findById(param.getId());
        flag = (employees.contains(m)) ? employees.remove(m) : customers.remove(m);
    	return flag;
    }*/
