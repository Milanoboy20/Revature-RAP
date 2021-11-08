package com.revature.sadat.daos;

import java.util.List;

import com.revature.sadat.models.SystemAdmin;


public interface SystemAdminDAO {
	public boolean insertAdmin(SystemAdmin adm);
	public SystemAdmin selectByID(Integer id);
	public boolean updateAdmin(SystemAdmin adm);
	public boolean removeAdmin(Integer id);
	public List<SystemAdmin> allAdmins();

}
