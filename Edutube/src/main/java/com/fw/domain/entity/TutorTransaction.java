package com.fw.domain.entity;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.GenericGenerator;

@Entity
@Table(name="tutor_transaction")
public class TutorTransaction {
	@Id
	@GenericGenerator(name = "eduetube", strategy = "increment")
	@GeneratedValue(generator = "eduetube")
	@Column(name="payment_id")
	private int payment_id;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name="tag_tutor_id")
	private Tag_Tutor tag_tutor;
	@Column(name="transaction_date")
	private Date transaction_date;
	@Column(name="transaction_amount")
	private String transaction_amount;
	@Transient
	private String startDate;
	@Transient
	private String endDate;
	public int getPayment_id() {
		return payment_id;
	}
	public void setPayment_id(int payment_id) {
		this.payment_id = payment_id;
	}
	public Tag_Tutor getTag_tutor() {
		return tag_tutor;
	}
	public void setTag_tutor(Tag_Tutor tag_tutor) {
		this.tag_tutor = tag_tutor;
	}
	public Date getTransaction_date() {
		return transaction_date;
	}
	public void setTransaction_date(Date transaction_date) {
		this.transaction_date = transaction_date;
	}
	public String getTransaction_amount() {
		return transaction_amount;
	}
	public void setTransaction_amount(String transaction_amount) {
		this.transaction_amount = transaction_amount;
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	

}
