package cn.com.project.course.domain;

public class Course {
    private Integer id;

    private String kname;

    private Integer aId;

    private String keshi;

    private String content;
    private String account;
    
    public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getKname() {
        return kname;
    }

    public void setKname(String kname) {
        this.kname = kname == null ? null : kname.trim();
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

    public String getKeshi() {
        return keshi;
    }

    public void setKeshi(String keshi) {
        this.keshi = keshi == null ? null : keshi.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }
}