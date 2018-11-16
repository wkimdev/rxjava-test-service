package kr.co.doublechain.rx.service.sending.domain;

import java.math.BigDecimal;
import java.sql.Timestamp;

import lombok.Data;

/**
 * TransferHistoryDTO
 * created by basquiat
 *
 */
@Data
public class TransferHistoryDTO implements TransferHistory {

	/**
	 * txid
	 */
	private String txId;

	/**
	 * userUuId
	 */
	private String userUuId;
	
	/**
	 * coin type
	 */
	private String coinType;
	
	/**
	 * transfer value
	 */
	private BigDecimal transferAmt;
	
	/**
	 * received address
	 */
	private String receivedAddress;
	
	/**
	 * sent dttm
	 */
	private Timestamp sendDttm;

	@Override
	public String txId() {
		return this.txId;
	}

	@Override
	public String userUuId() {
		return this.userUuId;
	}

	@Override
	public String coinType() {
		return this.coinType;
	}

	@Override
	public BigDecimal transferAmt() {
		return this.transferAmt;
	}

	@Override
	public String receivedAddress() {
		return this.receivedAddress;
	}

	@Override
	public Timestamp sendDttm() {
		return this.sendDttm;
	}
	
}
