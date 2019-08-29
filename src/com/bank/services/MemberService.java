package com.bank.services;


import java.util.List;

import com.bank.domains.*;


public interface MemberService {
	
    public void join(CustomerBean param);
    public void register(EmployeeBean param);
    public List<CustomerBean> findAllCustomers();
    public List<EmployeeBean> findAllAdmins();
    public List<MemberBean> findByName(String name); // ��, ��� ����޼ҵ�
    public MemberBean findById(String id); // ��, ��� ����޼ҵ�
    public boolean login(MemberBean param); // ��, ��� ����޼ҵ�
    public int countCustomers(); // ����
    public int countAdmins(); // ������
    public boolean existId(String id);
    public void updatePass(MemberBean param);
    public boolean deleteMember(MemberBean param);
    
}