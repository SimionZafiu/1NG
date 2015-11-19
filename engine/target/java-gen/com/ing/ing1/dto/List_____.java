
package com.ing.ing1.dto;

import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.apache.commons.lang.builder.HashCodeBuilder;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@Generated("org.jsonschema2pojo")
@JsonPropertyOrder({
    "id",
    "createDate",
    "productId",
    "productIdentification",
    "transactionType",
    "transactionSubType",
    "direction",
    "counterpartProductId",
    "counterpartProductIdentification",
    "description",
    "currency",
    "amount",
    "commission",
    "effectiveDate",
    "accountingDate",
    "transferId",
    "balanceAfterTransaction"
})
public class List_____ {

    @JsonProperty("id")
    private String id;
    @JsonProperty("createDate")
    private CreateDate___ createDate;
    @JsonProperty("productId")
    private String productId;
    @JsonProperty("productIdentification")
    private String productIdentification;
    @JsonProperty("transactionType")
    private TransactionType transactionType;
    @JsonProperty("transactionSubType")
    private TransactionSubType transactionSubType;
    @JsonProperty("direction")
    private Direction direction;
    @JsonProperty("counterpartProductId")
    private String counterpartProductId;
    @JsonProperty("counterpartProductIdentification")
    private String counterpartProductIdentification;
    @JsonProperty("description")
    private String description;
    @JsonProperty("currency")
    private Currency___ currency;
    @JsonProperty("amount")
    private Amount amount;
    @JsonProperty("commission")
    private Commission commission;
    @JsonProperty("effectiveDate")
    private EffectiveDate effectiveDate;
    @JsonProperty("accountingDate")
    private AccountingDate accountingDate;
    @JsonProperty("transferId")
    private String transferId;
    @JsonProperty("balanceAfterTransaction")
    private BalanceAfterTransaction balanceAfterTransaction;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The id
     */
    @JsonProperty("id")
    public String getId() {
        return id;
    }

    /**
     * 
     * @param id
     *     The id
     */
    @JsonProperty("id")
    public void setId(String id) {
        this.id = id;
    }

    /**
     * 
     * @return
     *     The createDate
     */
    @JsonProperty("createDate")
    public CreateDate___ getCreateDate() {
        return createDate;
    }

    /**
     * 
     * @param createDate
     *     The createDate
     */
    @JsonProperty("createDate")
    public void setCreateDate(CreateDate___ createDate) {
        this.createDate = createDate;
    }

    /**
     * 
     * @return
     *     The productId
     */
    @JsonProperty("productId")
    public String getProductId() {
        return productId;
    }

    /**
     * 
     * @param productId
     *     The productId
     */
    @JsonProperty("productId")
    public void setProductId(String productId) {
        this.productId = productId;
    }

    /**
     * 
     * @return
     *     The productIdentification
     */
    @JsonProperty("productIdentification")
    public String getProductIdentification() {
        return productIdentification;
    }

    /**
     * 
     * @param productIdentification
     *     The productIdentification
     */
    @JsonProperty("productIdentification")
    public void setProductIdentification(String productIdentification) {
        this.productIdentification = productIdentification;
    }

    /**
     * 
     * @return
     *     The transactionType
     */
    @JsonProperty("transactionType")
    public TransactionType getTransactionType() {
        return transactionType;
    }

    /**
     * 
     * @param transactionType
     *     The transactionType
     */
    @JsonProperty("transactionType")
    public void setTransactionType(TransactionType transactionType) {
        this.transactionType = transactionType;
    }

    /**
     * 
     * @return
     *     The transactionSubType
     */
    @JsonProperty("transactionSubType")
    public TransactionSubType getTransactionSubType() {
        return transactionSubType;
    }

    /**
     * 
     * @param transactionSubType
     *     The transactionSubType
     */
    @JsonProperty("transactionSubType")
    public void setTransactionSubType(TransactionSubType transactionSubType) {
        this.transactionSubType = transactionSubType;
    }

    /**
     * 
     * @return
     *     The direction
     */
    @JsonProperty("direction")
    public Direction getDirection() {
        return direction;
    }

    /**
     * 
     * @param direction
     *     The direction
     */
    @JsonProperty("direction")
    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    /**
     * 
     * @return
     *     The counterpartProductId
     */
    @JsonProperty("counterpartProductId")
    public String getCounterpartProductId() {
        return counterpartProductId;
    }

    /**
     * 
     * @param counterpartProductId
     *     The counterpartProductId
     */
    @JsonProperty("counterpartProductId")
    public void setCounterpartProductId(String counterpartProductId) {
        this.counterpartProductId = counterpartProductId;
    }

    /**
     * 
     * @return
     *     The counterpartProductIdentification
     */
    @JsonProperty("counterpartProductIdentification")
    public String getCounterpartProductIdentification() {
        return counterpartProductIdentification;
    }

    /**
     * 
     * @param counterpartProductIdentification
     *     The counterpartProductIdentification
     */
    @JsonProperty("counterpartProductIdentification")
    public void setCounterpartProductIdentification(String counterpartProductIdentification) {
        this.counterpartProductIdentification = counterpartProductIdentification;
    }

    /**
     * 
     * @return
     *     The description
     */
    @JsonProperty("description")
    public String getDescription() {
        return description;
    }

    /**
     * 
     * @param description
     *     The description
     */
    @JsonProperty("description")
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * 
     * @return
     *     The currency
     */
    @JsonProperty("currency")
    public Currency___ getCurrency() {
        return currency;
    }

    /**
     * 
     * @param currency
     *     The currency
     */
    @JsonProperty("currency")
    public void setCurrency(Currency___ currency) {
        this.currency = currency;
    }

    /**
     * 
     * @return
     *     The amount
     */
    @JsonProperty("amount")
    public Amount getAmount() {
        return amount;
    }

    /**
     * 
     * @param amount
     *     The amount
     */
    @JsonProperty("amount")
    public void setAmount(Amount amount) {
        this.amount = amount;
    }

    /**
     * 
     * @return
     *     The commission
     */
    @JsonProperty("commission")
    public Commission getCommission() {
        return commission;
    }

    /**
     * 
     * @param commission
     *     The commission
     */
    @JsonProperty("commission")
    public void setCommission(Commission commission) {
        this.commission = commission;
    }

    /**
     * 
     * @return
     *     The effectiveDate
     */
    @JsonProperty("effectiveDate")
    public EffectiveDate getEffectiveDate() {
        return effectiveDate;
    }

    /**
     * 
     * @param effectiveDate
     *     The effectiveDate
     */
    @JsonProperty("effectiveDate")
    public void setEffectiveDate(EffectiveDate effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    /**
     * 
     * @return
     *     The accountingDate
     */
    @JsonProperty("accountingDate")
    public AccountingDate getAccountingDate() {
        return accountingDate;
    }

    /**
     * 
     * @param accountingDate
     *     The accountingDate
     */
    @JsonProperty("accountingDate")
    public void setAccountingDate(AccountingDate accountingDate) {
        this.accountingDate = accountingDate;
    }

    /**
     * 
     * @return
     *     The transferId
     */
    @JsonProperty("transferId")
    public String getTransferId() {
        return transferId;
    }

    /**
     * 
     * @param transferId
     *     The transferId
     */
    @JsonProperty("transferId")
    public void setTransferId(String transferId) {
        this.transferId = transferId;
    }

    /**
     * 
     * @return
     *     The balanceAfterTransaction
     */
    @JsonProperty("balanceAfterTransaction")
    public BalanceAfterTransaction getBalanceAfterTransaction() {
        return balanceAfterTransaction;
    }

    /**
     * 
     * @param balanceAfterTransaction
     *     The balanceAfterTransaction
     */
    @JsonProperty("balanceAfterTransaction")
    public void setBalanceAfterTransaction(BalanceAfterTransaction balanceAfterTransaction) {
        this.balanceAfterTransaction = balanceAfterTransaction;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    @Override
    public int hashCode() {
        return new HashCodeBuilder().append(id).append(createDate).append(productId).append(productIdentification).append(transactionType).append(transactionSubType).append(direction).append(counterpartProductId).append(counterpartProductIdentification).append(description).append(currency).append(amount).append(commission).append(effectiveDate).append(accountingDate).append(transferId).append(balanceAfterTransaction).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof List_____) == false) {
            return false;
        }
        List_____ rhs = ((List_____) other);
        return new EqualsBuilder().append(id, rhs.id).append(createDate, rhs.createDate).append(productId, rhs.productId).append(productIdentification, rhs.productIdentification).append(transactionType, rhs.transactionType).append(transactionSubType, rhs.transactionSubType).append(direction, rhs.direction).append(counterpartProductId, rhs.counterpartProductId).append(counterpartProductIdentification, rhs.counterpartProductIdentification).append(description, rhs.description).append(currency, rhs.currency).append(amount, rhs.amount).append(commission, rhs.commission).append(effectiveDate, rhs.effectiveDate).append(accountingDate, rhs.accountingDate).append(transferId, rhs.transferId).append(balanceAfterTransaction, rhs.balanceAfterTransaction).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
