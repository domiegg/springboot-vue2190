package cn.com.project.course.domain;

public class Grade {
    private Integer id;

    private Integer cId;

    private Integer dId;

    private String xueqi;

    private String fenshu;

    private String content;
    private String account;
    private String kname;

    private Integer aId;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getcId() {
        return cId;
    }

    public void setcId(Integer cId) {
        this.cId = cId;
    }

    public Integer getdId() {
        return dId;
    }

    public void setdId(Integer dId) {
        this.dId = dId;
    }

    public String getXueqi() {
        return xueqi;
    }

    public void setXueqi(String xueqi) {
        this.xueqi = xueqi == null ? null : xueqi.trim();
    }

    public String getFenshu() {
        return fenshu;
    }

    public void setFenshu(String fenshu) {
        this.fenshu = fenshu == null ? null : fenshu.trim();
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content == null ? null : content.trim();
    }

    public Integer getaId() {
        return aId;
    }

    public void setaId(Integer aId) {
        this.aId = aId;
    }

	public String getAccount() {
		return account;
	}

	public void setAccount(String account) {
		this.account = account;
	}

	public String getKname() {
		return kname;
	}

	public void setKname(String kname) {
		this.kname = kname;
	}
    
}