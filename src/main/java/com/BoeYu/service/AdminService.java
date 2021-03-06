package com.BoeYu.service;


import java.util.List;

import com.BoeYu.pojo.*;
import com.BoeYu.util.ResultUtil;

public interface AdminService {
	//登陆
	public TbAdmin login(String username, String password);
	
	//获取所有角色
	public ResultUtil selRoles(Integer page, Integer limit);

	ResultUtil dictionaryList(Integer page, Integer limit);
	
	//获取所有角色
	public List<TbRoles> selRoles();
	
	//获取所有管理员
	 ResultUtil selAdmins(Integer page,Integer limit);
	//获取城市合伙人
	ResultUtil selpAdmins(Integer page,Integer limit,AdminSearch search);

	
	//获取角色菜单
	public List<Menu> selMenus(TbAdmin admin);
	
	//获取指定角色权限树
	public List<TbMenus> selXtreeData(TbAdmin admin);
	//获取指定角色权限树
	public List<TbMenus> selXtreeData1(TbAdmin admin);
	
	//更新角色信息
	public void updRole(TbRoles role,String m);
	
	//删除指定角色
	public void delRole(Long roleId);

	//批量删除指定角色
	public void delRoles(String rolesId);
	
	//根据角色名查询角色
	public TbRoles selRoleByRoleName(String roleName);

	//添加新角色
	public void insRole(TbRoles role, String m);

	//删除指定管理员
	public void delAdminById(Long id);

	//批量删除指定管理员
	public void delAdmins(String adminStr);

	//管理员用户名唯一性校验
	public TbAdmin selAdminByUserName(String username);

	//新增管理员
	public void insAdmin(TbAdmin admin);

	//根据id得到管理员
	public TbAdmin selAdminById(Long id);

	//根据email得到管理员
	public TbAdmin selAdminByEmail(String eMail,String username);

	//更新管理员信息
	public void updAdmin(TbAdmin admin);

	public void updAdmin1(TbAdmin admin);

	public List<TbMenus> selMenusByParentId();

	public TbMenus selMenuById(Long menuId);

	public void insMenu(TbMenus menus);

	public void updMenu(TbMenus menus);

	public TbMenus selMenuByTitle(String title);

	public TbMenus selMenusById(Long menuId);

	public void delMenuById(Long menuId);

	public List<TbMenus> selMenusById1(Long menuId);

	public void updMenuSortingById(TbMenus menus);

	public List<TbMenus> checkTitleSameLevel(TbMenus menus);

	public TbRoles getRole(TbRoles role);

	void updateToken(TbAdmin admin);

	int checkphone(String phone);

	int addPartnerAdmin(TbAdmin admin);

	int addAccount(Account account);

	Account selectAccount(String id);

	int selectToken(String token);

	TbAdmin selAdminByToken(String token);

	int updateDictionary(String val,Long id);

	String selDictionaryval(String nkey);

}
