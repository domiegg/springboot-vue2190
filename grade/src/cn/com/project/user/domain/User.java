package cn.com.project.user.domain;

import org.springframework.web.multipart.MultipartFile;

public class User {
    private Integer id;

    private String account;

    private String password;

    private String age;

    private String role;

    private String address;

    private String tel;

    private String chexing;

    private String jsnumber;

    private String idk;

    private String state;

    private byte[] photo;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getAccount() {
        return account;
    }

    public void setAccount(String account) {
        this.account = account == null ? null : account.trim();
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age == null ? null : age.trim();
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role == null ? null : role.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel == null ? null : tel.trim();
    }

    public String getChexing() {
        return chexing;
    }

    public void setChexing(String chexing) {
        this.chexing = chexing == null ? null : chexing.trim();
    }

    public String getJsnumber() {
        return jsnumber;
    }

    public void setJsnumber(String jsnumber) {
        this.jsnumber = jsnumber == null ? null : jsnumber.trim();
    }

    public String getIdk() {
        return idk;
    }

    public void setIdk(String idk) {
        this.idk = idk == null ? null : idk.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

	public byte[] getPhoto() {
		return photo;
	}

	public void setPhoto(byte[] photo) {
		this.photo = photo;
	}

}