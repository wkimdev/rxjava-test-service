package kr.co.doublechain.rx.service.sending.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import org.davidmoten.rx.jdbc.annotations.Column;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;

/**
 * TransferHistoryVO
 * created by basquiat
 *
 */
@JsonDeserialize(as = TransferHistoryDTO.class)
@JsonPropertyOrder({"txId", "userUuId", "coinType", "transferAmt", "receivedAddress", "sendDttm"})
public interface TransferHistory {

	/**
	 * txid
	 */
	@JsonProperty("txId")
	@Column("txid")
	String txId();

	/**
	 * userUuId
	 */
	@JsonProperty("userUuId")
	@Column("user_uuid")
	String userUuId();
	
	/**
	 * coin type
	 */
	@JsonProperty("coinType")
	@Column("coin_type")
	String coinType();
	
	/**
	 * transfer value
	 */
	@JsonProperty("transferAmt")
	@Column("transfer_amt")
	BigDecimal transferAmt();
	
	/**
	 * received address
	 */
	@JsonProperty("receivedAddress")
	@Column("received_address")
	String receivedAddress();
	
	/**
	 * sent dttm
	 */
	@JsonProperty("sendDttm")
	@Column("send_dttm")
	Timestamp sendDttm();
	
	
	
}
