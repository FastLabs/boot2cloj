(require '[clojure.set :as s])
(def collector #{"srcSysAccountId"
                 "partyId"
                 "cntrPartySrcSysName"
                 "cntrPartyAmiCode"
                 "paragonLegalOrganizationId"
                 "partnerId"
                 "contractSrcSysName"
                 "bookingPartyAmiCode"
                 "lowestLevelUbr"
                 "productCode"
                 "depositAccountClassification"
                 "tradeDate"
                 "startDate"
                 "maturityDate"
                 "localGaapValuation"
                 "investmentProduct1SweepAmount"
                 "investmentProduct1InterestAmount"
                 "investmentProduct1ShortName"
                 "investmentProduct2SweepAmount"
                 "investmentProduct2InterestAmount"
                 "investmentProduct2ShortName"
                 "investmentProduct3SweepAmount"
                 "investmentProduct3InterestAmount"
                 "investmentProduct3ShortName"
                 "valuationCurrencyId"
                 "significantEarlyMaturityPenaltyFlag"
                 "governmentGuaranteeCountryCode"
                 "internetFlag"
                 "noticePeriod"
                 "lastActivityDate"
                 "tradingBookIndicator"
                 "escrowFlag"
                 "localGaapAccruedInterest"
                 "interestRate"
                 "interestType"
                 "periodFrequencyTime"
                 "srcUbrProxyCode"
                 "nextInterestPaymentDate"
                 "cntrPartyLegalName"})

(def db-internet-loan #{"srcSysAccountId"
                        "contractSrcSysName"
                        "tradeDate"
                        "startDate"
                        "maturityDate"
                        "currentNotionalAmount"
                        "valuationCurrencyId"
                        "productCode"
                        "srcUbrProxyCode"
                        "bookingPartyAmiCode"
                        "counterpartyId"
                        "counterpartyIdType"
                        "cobDate"})


(def db-internet-deposit #{"srcSysAccountId"
                           "contractSrcSysName"
                           "tradeDate"
                           "startDate"
                           "maturityDate"
                           "localGaapValuation"
                           "valuationCurrencyId"
                           "productCode"
                           "srcUbrProxyCode"
                           "bookingPartyAmiCode"
                           "partyId"
                           "cntrPartySrcSysName"})

(ss/intersection db-internet-loan db-internet-deposit)
(s/difference db-internet-loan db-internet-deposit)

(ss/intersection collector db-internet-loan)

(ss/intersection collector db-internet-deposit db-internet-loan)

(def wire-position-party-file #{
                                ["partyId"                    [:String]]
                                ["cntrPartySrcSysName"        [:String]]
                                ["cntrPartyAmiCode"           [:String]]
                                ["paragonLegalOrganizationId" [:String]]
                                ["partnerId"                  [:String]]
                                ["cntrPartyLegalName"         [:String]] })


(def wire-position-contract-file #{
                                   [ "srcSysAccountId"	[:String]]
                                   ["contractSrcSysName" [:String]]
                                   ["bookingPartyAmiCode" [:String]]
                                   ["lowestLevelUbr" [:String]]
                                   ["productCode" [:String]]
                                   ["depositAccountClassification" [:String]]
                                   ["investmentProduct1SweepAmount" [:String]]
                                   ["investmentProduct1InterestAmount"[:String]]
                                   ["investmentProduct1ShortName"[:String]]
                                   ["investmentProduct2SweepAmount"[:String]]
                                   ["investmentProduct2InterestAmount"[:String]]
                                   ["investmentProduct2ShortName"[:String]]
                                   ["investmentProduct3SweepAmount"[:String]]
                                   ["investmentProduct3InterestAmount"[:String]]
                                   ["investmentProduct3ShortName"[:String]]
                                   ["governmentGuaranteeCountryCode"[:String]]
                                   ["tradingBookIndicator"]})

(def wire-position-other #{
                           ["localGaapValuation" [:String]]
                           ["valuationCurrencyId"]
                           ["significantEarlyMaturityPenaltyFlag" [:String]]
                           ["internetFlag" [:String]]
                           ["lastActivityDate"[:String]]
                           ["noticePeriod" [:String]]
                           ["escrowFlag" [:String]]
                           ["localGaapAccruedInterest"[:String]]
                           ["interestRate"[:String]]
                           ["interestType"[:String]]
                           ["periodFrequencyTime"[:String]]
                           ["nextInterestPaymentDate" [:String]]
                           ["srcUbrProxyCode" [:String]]
                           ["tradeDate" [:String]]
                           ["startDate" [:String]]
                           ["maturityDate" [:String]]
                           ["cobDate" [:String]]
                           ["source"  [:SourceSystem "SourceSystem.UNKNOWN"]]
                           ["positionType" [:PositionType "null"]]
                           ["rejectedPosition" [:boolean "false"]]})

(def wire-position-ls2 #{ ["sourceSystem" [:String]]
                          ["alternativeAccountId" [:String]]
                          ["accountEntityBook" [:String]]
                          ["localTypeCode" [:String]]
                          ["localSubTypeCode" [:String]]
                          ["ammortizationIndicator" [:String]]
                          ["nextCapitalPaymentDate" [:String]]
                          ["capitalPaymentFrecuency" [:String]]
                          ["accruedInterestAmount" [:String]]
                          ["accruedInterestCurrency" [:String]]
                          ["newInterestResetDate" [:String]]
                          ["currentNotionalAmount" [:String]]
                          ["daysPastDue" [:String]]
                          ["loanDefaultType" [:String]]
                          ["bookName" [:String]]
                          ["regulatoryReportTreatme" [:String]]
                          ["counterpartyId" [:String]]
                          ["counterpartyIdType" [:String]]
                          ["facilityId" [:String]]
                          ["facilitySourceId" [:String]]})

(defn field-names [meta-set]
  (set (map #(first % ) meta-set)))


;;(def all-positions (ss/join (field-names wire-position-party-file) ))

(def canonical-position [
                         ["positionBalanceId"       [:String]]
                         ["snapshotId"              [:String]]
                         ["snapshotVersion"         [:Integer]]
                         ["sourceId"                [:String]]
                         ["accountReference"        [:String]]
                         ["productId"               [:String]]
                         ["valuationCurrencyId"     [:String]]
                         ["bookId"                  [:String]]
                         ["counterpartyPartyId"     [:String]]
                         ["instrumentId"            [:String]]
                         ["tradeDate"               [:Date]]
                         ["lastActivityDate"        [:Date]]
                         ["localGaapValuationAmt"   [:Double]]
                         ["localGaapAccInterestA"   [:Double]]
                         ["maturityDate"            [:Date]]
                         ["signifEarlyMaturPenal"   [:String]]
                         ["escrowFlag"              [:String]]
                         ["internetFlag"            [:String]]
                         ["noticePeriod"            [:Double]]
                         ["interestRate"            [:Double]]
                         ["interestType"            [:String]]
                         ["startDate"               [:Date]]
                         ["periodFrequencyType"     [:String]]
                         ["nextInterestPaymentDate" [:Date]]
                         ["nextCapitalPaymentDate"  [:Date]]
                         ["capitalPaymentFrequen"   [:Double]]
                         ["nextInterestResetDate"   [:Date]]
                         ["pastDueDays"             [:Integer]]
                         ["loanDefaultType"         [:String]]
                         ["facilityId"              [:String]]])

package com.db.treasury.tch.data.transformer;

import java.util.Calendar;
import java.util.Date;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.db.tch.classification.ExternalDomains.PositionType;
import com.db.tch.classification.ExternalDomains.SourceSystem;
import com.db.treasury.tch.common.util.DateTimeUtil;
import com.db.treasury.tch.common.util.NumberUtil;
import com.db.treasury.tch.data.service.ReferenceDataService;
import com.db.treasury.tch.domain.Currency;

/**
 * Transforms XOM into domain model and vice-versa
 * @author liusbetty
 *
 */

@Component
public class PositionTransformer {

	private String datePattern;

	@Autowired
	private DateTimeUtil dateTimeUtil;

	@Autowired
	private ReferenceDataService referenceService;

	/**
	 * Converts the given XOM Position into a Domain Position to be consumed by the Persistence layer
	 * @param xom position
	 * @return domain position
	 */
	public com.db.treasury.tch.domain.Position convertToDomain(com.db.tch.classification.Position x_pos, String sourceType, Integer snapshotVersion){
		this.datePattern = "dd/MM/yyyy";

		if (SourceSystem.DBI.toString().equals(sourceType) && x_pos.getPositionType() != null && PositionType.LOAN.equals(x_pos.getPositionType())) {
			this.datePattern = "ddMMyyyy";
		}

		com.db.treasury.tch.domain.Position d_pos = new com.db.treasury.tch.domain.Position();

		//Common conversion for different source systems
		d_pos.setPositionBalanceId(this.generateUUID());
		d_pos.setSnapshotVersion(snapshotVersion);
		d_pos.setAccountReference(x_pos.getSrcSysAccountId());

		if (referenceService != null && x_pos.getValuationCurrencyId() != null) {
			Currency currency = referenceService.getCurrencyByCode(x_pos.getValuationCurrencyId());
			if (currency != null) {
				d_pos.setValuationCurrencyId(currency.getId());
			}
		}

		//TODO To refactor in the future to set the Instrument related
		d_pos.setInstrumentId(null);

		Date temp = dateTimeUtil.parseDate(x_pos.getTradeDate(), this.datePattern);
		if (temp != null) {
			d_pos.setTradeDate(new java.sql.Date(temp.getTime()));
		}

		temp = dateTimeUtil.parseDate(x_pos.getMaturityDate(), this.datePattern);
		if (temp != null) {
			d_pos.setMaturityDate(new java.sql.Date(temp.getTime()));
		}

		d_pos.setInterestRate(NumberUtil.parseDouble(x_pos.getInterestRate()));
		d_pos.setInterestType(x_pos.getInterestType());

		temp = dateTimeUtil.parseDate(x_pos.getStartDate(), this.datePattern);
		if (temp != null) {
			d_pos.setStartDate(new java.sql.Date(temp.getTime()));
		}

		d_pos.setPeriodFrequencyType(x_pos.getPeriodFrequencyTime());

		temp = dateTimeUtil.parseDate(x_pos.getNextInterestPaymentDate(), this.datePattern);
		if(temp != null){
			d_pos.setNextInterestPaymentDate(new java.sql.Date(temp.getTime()));
		}

		d_pos.setBookId(x_pos.getBookName());

		if (SourceSystem.COL.toString().equals(sourceType)) {
			this.convertToDomainCollector(x_pos, d_pos);
		}
		else if (SourceSystem.LS2.toString().equals(sourceType)) {
			this.convertToDomainLS2(x_pos, d_pos);
		}
		else if (SourceSystem.DBI.toString().equals(sourceType)) {
			this.convertToDomainDbInternet(x_pos, d_pos);
		}

		return d_pos;
	}

	private void convertToDomainCollector(com.db.tch.classification.Position x_pos, com.db.treasury.tch.domain.Position d_pos){
		d_pos.setCounterpartyPartyId(x_pos.getPartyId());

		d_pos.setProductId(x_pos.getDepositAccountClassification());

		d_pos.setLocalGaapAccInterestAmt(NumberUtil.parseDouble(x_pos.getLocalGaapAccruedInterest()));
		d_pos.setLocalGaapValuationAmt(NumberUtil.parseDouble(x_pos.getLocalGaapValuation()));

		Date temp = dateTimeUtil.parseDate(x_pos.getLastActivityDate(), this.datePattern);
		if (temp != null) {
			d_pos.setLastActivityDate(new java.sql.Date(temp.getTime()));
		}

		d_pos.setSignifEarlyMaturPenalFlag(x_pos.getSignificantEarlyMaturityPenaltyFlag());
		d_pos.setEscrowFlag(x_pos.getEscrowFlag());
		d_pos.setInternetFlag(x_pos.getInternetFlag());
		d_pos.setNoticePeriod(NumberUtil.parseDouble(x_pos.getNoticePeriod()));
		d_pos.setNextCapitalPaymentDate(null);
		d_pos.setCapitalPaymentFrequency(null);
		d_pos.setNextInterestResetDate(null);
		d_pos.setPastDueDays(null);
		d_pos.setLoanDefaultType(null);
		d_pos.setFacilityId(null);
	}

	private void convertToDomainLS2(com.db.tch.classification.Position x_pos, com.db.treasury.tch.domain.Position d_pos){
		d_pos.setCounterpartyPartyId(x_pos.getCounterpartyId());
		d_pos.setProductId(x_pos.getLocalTypeCode());
		d_pos.setLastActivityDate(null);
		d_pos.setSignifEarlyMaturPenalFlag(null);
		d_pos.setEscrowFlag(null);
		d_pos.setInternetFlag(null);
		d_pos.setNoticePeriod(null);

		Date temp = dateTimeUtil.parseDate(x_pos.getNextCapitalPaymentDate(), this.datePattern);
		if (temp != null) {
			d_pos.setNextCapitalPaymentDate(new java.sql.Date(temp.getTime()));
		}

		d_pos.setLocalGaapAccInterestAmt(NumberUtil.parseDouble(x_pos.getAccruedInterestAmount()));
		d_pos.setLocalGaapValuationAmt(NumberUtil.parseDouble(x_pos.getCurrentNotionalAmount()));

		d_pos.setCapitalPaymentFrequency(NumberUtil.parseDouble(x_pos.getCapitalPaymentFrecuency()));

		temp = dateTimeUtil.parseDate(x_pos.getNewInterestResetDate(), this.datePattern);
		if (temp != null) {
			d_pos.setNextInterestResetDate(new java.sql.Date(temp.getTime()));
		}

		d_pos.setPastDueDays(NumberUtil.parseInteger(x_pos.getDaysPastDue()));
		d_pos.setLoanDefaultType(x_pos.getLoanDefaultType());
		d_pos.setFacilityId(x_pos.getFacilityId());
	}

	private void convertToDomainDbInternet(com.db.tch.classification.Position x_pos, com.db.treasury.tch.domain.Position d_pos){
		d_pos.setProductId(x_pos.getProductCode());
		if (PositionType.DEPOSIT.equals(x_pos.getPositionType())) {
			d_pos.setCounterpartyPartyId(x_pos.getPartyId());
			d_pos.setLocalGaapValuationAmt(NumberUtil.parseDouble(x_pos.getLocalGaapValuation()));
		}
		else if (PositionType.LOAN.equals(x_pos.getPositionType())) {
			d_pos.setCounterpartyPartyId(x_pos.getCounterpartyId());
			d_pos.setLocalGaapValuationAmt(NumberUtil.parseDouble(x_pos.getCurrentNotionalAmount()));
		}
	}

	public java.sql.Date convertCobDateToDomain(Object cobDateInMessage) {
		java.sql.Date cobDate = new java.sql.Date(Calendar.getInstance().getTimeInMillis());
		if (cobDateInMessage != null) {
			Date temp = dateTimeUtil.parseDate((String)cobDateInMessage, "dd/MM/yyyy");
			if (temp != null) {
				cobDate = new java.sql.Date(temp.getTime());
			}
		}
		return cobDate;
	}

	private String generateUUID(){

		return UUID.randomUUID().toString();
	}

	public void setDateTimeUtil(DateTimeUtil dateTimeUtil) {
		this.dateTimeUtil = dateTimeUtil;
	}
}






