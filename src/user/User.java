package user;

public class User {
private String ID;
private String name;
private String password;
private String pwdHint;
private String role;

User() {
	// TODO 自动生成的构造函数存根
}
User(String ID,String name,String password,String pwdHint,String role){
	this.ID = ID;
	this.name = name;
	this.password = password;
	this.pwdHint = pwdHint;
	this.role = role;
}




public String getID() {
	return ID;
}
public void setID(String ID) {
	this.ID = ID;
}
public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
}
public String getPwdHint() {
	return pwdHint;
}
public void setPwdHint(String pwdHint) {
	this.pwdHint = pwdHint;
}
public String getRole() {
	return role;
}
public void setRole(String role) {
	this.role = role;
}






public boolean changePwd(String newPwd){
	setPassword(newPwd);
	
	return true;
}

public boolean findPwd(String hint){
	if(hint==this.pwdHint)	
	return true;
	else return false;
}


}
