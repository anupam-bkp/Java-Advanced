package com.example.dbtest.jpa01;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "tbl_rms_resulttypes_rrt")
public class ResultType {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RRT_Resultid", length = 8)
	private int resultId;
	
	@Column(name = "RRT_Resultoptions", nullable = false, length = 100)
	private String resultOptions;
	
	@Column(name = "RRT_Resultdefault", nullable = false, length = 4)
	private int resultDefault;
	
	@Column(name = "RRT_Resultpass", nullable = false, length = 4)
	private int resultPass;

	public ResultType() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ResultType(String resultOptions, int resultDefault, int resultPass) {
		super();
		this.resultOptions = resultOptions;
		this.resultDefault = resultDefault;
		this.resultPass = resultPass;
	}

	public int getResultId() {
		return resultId;
	}

	public void setResultId(int resultId) {
		this.resultId = resultId;
	}

	public String getResultOptions() {
		return resultOptions;
	}

	public void setResultOptions(String resultOptions) {
		this.resultOptions = resultOptions;
	}

	public int getResultDefault() {
		return resultDefault;
	}

	public void setResultDefault(int resultDefault) {
		this.resultDefault = resultDefault;
	}

	public int getResultPass() {
		return resultPass;
	}

	public void setResultPass(int resultPass) {
		this.resultPass = resultPass;
	}

	@Override
	public String toString() {
		return "ResultType [resultId=" + resultId + ", resultOptions=" + resultOptions + ", resultDefault="
				+ resultDefault + ", resultPass=" + resultPass + "]";
	}
}
