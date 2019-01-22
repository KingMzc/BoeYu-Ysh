package com.BoeYu.pojo;

public class TbAdmin {
    private Long id;

    private String username;

    private String password;

    private String salt;

    private String fullname;

    private String eMail;

    private String sex;

    private String birthday;

    private String address;

    private String phone;

    private Long roleId;
    
    private String roleName;

    private String Token;

    private String CodeImg;

    private String Flag;
    private String idcardz;
    private String idcardf;
    private String wxid;
    private String sfzhm;

    public String getSfzhm() {
        return sfzhm;
    }

    public void setSfzhm(String sfzhm) {
        this.sfzhm = sfzhm;
    }

    public String getIdcardz() {
        return idcardz;
    }

    public void setIdcardz(String idcardz) {
        this.idcardz = idcardz;
    }

    public String getIdcardf() {
        return idcardf;
    }

    public void setIdcardf(String idcardf) {
        this.idcardf = idcardf;
    }

    public String getWxid() {
        return wxid;
    }

    public void setWxid(String wxid) {
        this.wxid = wxid;
    }

    public String getToken() {
        return Token;
    }

    public void setToken(String token) {
        Token = token;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    public String getFullname() {
        return fullname;
    }

    public void setFullname(String fullname) {
        this.fullname = fullname == null ? null : fullname.trim();
    }

    public String geteMail() {
        return eMail;
    }

    public void seteMail(String eMail) {
        this.eMail = eMail == null ? null : eMail.trim();
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }
    
    public String getBirthday() {
		return birthday;
	}

	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}

	public String getRoleName() {
		return roleName;
	}

	public void setRoleName(String roleName) {
		this.roleName = roleName;
	}

	public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public Long getRoleId() {
        return roleId;
    }

    public void setRoleId(Long roleId) {
        this.roleId = roleId;
    }

    public String getCodeImg() {
        return CodeImg;
    }

    public void setCodeImg(String codeImg) {
        CodeImg = codeImg;
    }

    public String getFlag() {
        return Flag;
    }

    public void setFlag(String flag) {
        Flag = flag;
    }

    @Override
	public String toString() {
		return "TbAdmin [id=" + id + ", username=" + username + ", password=" + password + ", salt=" + salt
				+ ", fullname=" + fullname + ", eMail=" + eMail + ", sex=" + sex + ", birthday=" + birthday
				+ ", address=" + address + ", phone=" + phone + ", roleId=" + roleId + ", roleName=" + roleName + "]";
	}
    
}