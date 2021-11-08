package com.revature.sadat.daos;

import java.util.List;

import com.revature.sadat.models.AppUser;
import com.revature.sadat.models.Employee;

public interface AppUserDAO {
	public boolean insertAppUser(AppUser user);
	public AppUser selectByID(Integer id);
	public boolean updateAppUser(AppUser user);
	public boolean removeAppUser(Integer id);
	public List<AppUser> allAppUsers();

}
