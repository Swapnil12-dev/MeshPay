/**
 * Represents a payment processed by MeshPay.
 *
 * Every payment reaching the backend is recorded as a
 * transaction for auditing and tracking purposes.
 *
 * Responsibilities:
 * - Stores sender and receiver details.
 * - Stores payment amount.
 * - Stores transaction execution status.
 *
 * Note:
 * Transactions are immutable records and should never be modified
 * after creation.
 */

package com.mesh.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table(name = "transactions")
public class Transaction {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(nullable = false)
	private String senderVpa;

	@Column(nullable = false)
	private String receiverVpa;

	@Column(nullable = false, precision = 19, scale = 2)
	private BigDecimal amount;

	@Column(unique = true, nullable = false)
	private String packetHash;

	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Status status;

	public enum Status {
		SETTLED,
		REJECTED
	}

	// Constructors
	public Transaction() {
		super();
	}

	public Transaction(Long id, String senderVpa, String receiverVpa, BigDecimal amount, String packetHash, Status status) {
		super();
		this.id = id;
		this.senderVpa = senderVpa;
		this.receiverVpa = receiverVpa;
		this.amount = amount;
		this.packetHash = packetHash;
		this.status = status;
	}

	// Getters and Setters
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getSenderVpa() {
		return senderVpa;
	}

	public void setSenderVpa(String senderVpa) {
		this.senderVpa = senderVpa;
	}

	public String getReceiverVpa() {
		return receiverVpa;
	}

	public void setReceiverVpa(String receiverVpa) {
		this.receiverVpa = receiverVpa;
	}

	public BigDecimal getAmount() {
		return amount;
	}

	public void setAmount(BigDecimal amount) {
		this.amount = amount;
	}

	public String getPacketHash() {
		return packetHash;
	}

	public void setPacketHash(String packetHash) {
		this.packetHash = packetHash;
	}

	public Status getStatus() {
		return status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "Transaction [id=" + id + ", senderVpa=" + senderVpa + ", receiverVpa=" + receiverVpa + ", amount="
				+ amount + ", packetHash=" + packetHash + ", status=" + status + "]";
	}
}