package com.example.dbtest.review;


import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

@Entity
@Table(name = "tbl_rms_rvw_chklist_rrc")
public class ReviewChecklist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RRC_Chklistid", length = 8)
	private int chkListId;
	
	@OneToOne(cascade = {CascadeType.DETACH, CascadeType.MERGE,
			CascadeType.PERSIST, CascadeType.REFRESH})
	@JoinColumn(name = "RRC_Rvwtypeid")
	private ReviewType rvwType;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "RRC_Category")
	private Category category = Category.main;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "RRC_Chklisttype", nullable = false)
	private ChkListType chkListType;
	
	@Column(name = "RRC_Reference", nullable = false, length = 50)
	private String reference = "n/a";
	  
	@Column(name = "RRC_Description", length = 2000, nullable = false)
	private String description = "";
	
	@Column(name = "RRC_Tip", length = 1000)
	private String tip;
	
	@Column(name = "RRC_Chklistpos", nullable = false, length = 4)
	private int chkListPos;
	
	@OneToOne
	@JoinColumn(name = "RRC_Resulttypeid")
	private ResultType resultType;
	
	@OneToOne
	@JoinColumn(name = "RRC_Updatedby")
	private Employee employee;
	
	@Temporal(TemporalType.DATE)
	@Column(name = "RRC_Updatedon")
	private Date updatedOn;

	public ReviewChecklist() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ReviewChecklist(int chlListId, ReviewType rvwType, String description, String tip, int chkListPos,
			Date updatedOn) {
		super();
		this.chkListId = chlListId;
		this.rvwType = rvwType;
		this.description = description;
		this.tip = tip;
		this.chkListPos = chkListPos;
		this.updatedOn = updatedOn;
	}

	public int getChkListId() {
		return chkListId;
	}

	public void setChkListId(int chkListId) {
		this.chkListId = chkListId;
	}

	public ReviewType getRvwType() {
		return rvwType;
	}

	public void setRvwType(ReviewType rvwType) {
		this.rvwType = rvwType;
	}
	
	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

	public ChkListType getChkListType() {
		return chkListType;
	}

	public void setChkListType(ChkListType chkListType) {
		this.chkListType = chkListType;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getTip() {
		return tip;
	}

	public void setTip(String tip) {
		this.tip = tip;
	}

	public int getChkListPos() {
		return chkListPos;
	}

	public void setChkListPos(int chkListPos) {
		this.chkListPos = chkListPos;
	}

	public ResultType getResultType() {
		return resultType;
	}

	public void setResultType(ResultType resultType) {
		this.resultType = resultType;
	}

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	public Date getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(Date updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "ReviewChecklist [chkListId=" + chkListId + ", rvwType=" + rvwType + ", reference=" + reference
				+ ", description=" + description + ", tip=" + tip + ", chkListPos=" + chkListPos + ", resultType="
				+ resultType + ", employee=" + employee + ", updatedOn=" + updatedOn + "]";
	}
	
}
