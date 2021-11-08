package com.revature.sadat.daos;

import java.util.List;

import com.revature.sadat.models.Login;

public interface LoginDAO {
	public boolean insertLogin(Login lg);
	public Login selectByUsername(String username, String password);
	public Login selectByLoginID(Integer id);
	public boolean updateLogin(Login lg);
	public boolean removeLogin(Integer id);
	public List<Login> allLogins();

}
