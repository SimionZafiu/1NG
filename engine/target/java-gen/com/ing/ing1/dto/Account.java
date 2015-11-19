
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
    "flagExternal",
    "type",
    "subType",
    "productIdentification",
    "customerDescription",
    "bankId",
    "status",
    "closingDate",
    "referringAddress",
    "currency",
    "owners",
    "identificationInBank",
    "id",
    "createDate",
    "availableBalance",
    "accountingBalance",
    "iban"
})
public class Account {

    @JsonProperty("flagExternal")
    private Boolean flagExternal;
    @JsonProperty("type")
    private Type type;
    @JsonProperty("subType")
    private SubType subType;
    @JsonProperty("productIdentification")
    private String productIdentification;
    @JsonProperty("customerDescription")
    private String customerDescription;
    @JsonProperty("bankId")
    private String bankId;
    @JsonProperty("status")
    private Status status;
    @JsonProperty("closingDate")
    private ClosingDate closingDate;
    @JsonProperty("referringAddress")
    private ReferringAddress referringAddress;
    @JsonProperty("currency")
    private Currency currency;
    @JsonProperty("owners")
    private Owners owners;
    @JsonProperty("identificationInBank")
    private String identificationInBank;
    @JsonProperty("id")
    private String id;
    @JsonProperty("createDate")
    private CreateDate_ createDate;
    @JsonProperty("availableBalance")
    private AvailableBalance availableBalance;
    @JsonProperty("accountingBalance")
    private AccountingBalance accountingBalance;
    @JsonProperty("iban")
    private String iban;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The flagExternal
     */
    @JsonProperty("flagExternal")
    public Boolean getFlagExternal() {
        return flagExternal;
    }

    /**
     * 
     * @param flagExternal
     *     The flagExternal
     */
    @JsonProperty("flagExternal")
    public void setFlagExternal(Boolean flagExternal) {
        this.flagExternal = flagExternal;
    }

    /**
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public Type getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(Type type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The subType
     */
    @JsonProperty("subType")
    public SubType getSubType() {
        return subType;
    }

    /**
     * 
     * @param subType
     *     The subType
     */
    @JsonProperty("subType")
    public void setSubType(SubType subType) {
        this.subType = subType;
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
     *     The customerDescription
     */
    @JsonProperty("customerDescription")
    public String getCustomerDescription() {
        return customerDescription;
    }

    /**
     * 
     * @param customerDescription
     *     The customerDescription
     */
    @JsonProperty("customerDescription")
    public void setCustomerDescription(String customerDescription) {
        this.customerDescription = customerDescription;
    }

    /**
     * 
     * @return
     *     The bankId
     */
    @JsonProperty("bankId")
    public String getBankId() {
        return bankId;
    }

    /**
     * 
     * @param bankId
     *     The bankId
     */
    @JsonProperty("bankId")
    public void setBankId(String bankId) {
        this.bankId = bankId;
    }

    /**
     * 
     * @return
     *     The status
     */
    @JsonProperty("status")
    public Status getStatus() {
        return status;
    }

    /**
     * 
     * @param status
     *     The status
     */
    @JsonProperty("status")
    public void setStatus(Status status) {
        this.status = status;
    }

    /**
     * 
     * @return
     *     The closingDate
     */
    @JsonProperty("closingDate")
    public ClosingDate getClosingDate() {
        return closingDate;
    }

    /**
     * 
     * @param closingDate
     *     The closingDate
     */
    @JsonProperty("closingDate")
    public void setClosingDate(ClosingDate closingDate) {
        this.closingDate = closingDate;
    }

    /**
     * 
     * @return
     *     The referringAddress
     */
    @JsonProperty("referringAddress")
    public ReferringAddress getReferringAddress() {
        return referringAddress;
    }

    /**
     * 
     * @param referringAddress
     *     The referringAddress
     */
    @JsonProperty("referringAddress")
    public void setReferringAddress(ReferringAddress referringAddress) {
        this.referringAddress = referringAddress;
    }

    /**
     * 
     * @return
     *     The currency
     */
    @JsonProperty("currency")
    public Currency getCurrency() {
        return currency;
    }

    /**
     * 
     * @param currency
     *     The currency
     */
    @JsonProperty("currency")
    public void setCurrency(Currency currency) {
        this.currency = currency;
    }

    /**
     * 
     * @return
     *     The owners
     */
    @JsonProperty("owners")
    public Owners getOwners() {
        return owners;
    }

    /**
     * 
     * @param owners
     *     The owners
     */
    @JsonProperty("owners")
    public void setOwners(Owners owners) {
        this.owners = owners;
    }

    /**
     * 
     * @return
     *     The identificationInBank
     */
    @JsonProperty("identificationInBank")
    public String getIdentificationInBank() {
        return identificationInBank;
    }

    /**
     * 
     * @param identificationInBank
     *     The identificationInBank
     */
    @JsonProperty("identificationInBank")
    public void setIdentificationInBank(String identificationInBank) {
        this.identificationInBank = identificationInBank;
    }

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
    public CreateDate_ getCreateDate() {
        return createDate;
    }

    /**
     * 
     * @param createDate
     *     The createDate
     */
    @JsonProperty("createDate")
    public void setCreateDate(CreateDate_ createDate) {
        this.createDate = createDate;
    }

    /**
     * 
     * @return
     *     The availableBalance
     */
    @JsonProperty("availableBalance")
    public AvailableBalance getAvailableBalance() {
        return availableBalance;
    }

    /**
     * 
     * @param availableBalance
     *     The availableBalance
     */
    @JsonProperty("availableBalance")
    public void setAvailableBalance(AvailableBalance availableBalance) {
        this.availableBalance = availableBalance;
    }

    /**
     * 
     * @return
     *     The accountingBalance
     */
    @JsonProperty("accountingBalance")
    public AccountingBalance getAccountingBalance() {
        return accountingBalance;
    }

    /**
     * 
     * @param accountingBalance
     *     The accountingBalance
     */
    @JsonProperty("accountingBalance")
    public void setAccountingBalance(AccountingBalance accountingBalance) {
        this.accountingBalance = accountingBalance;
    }

    /**
     * 
     * @return
     *     The iban
     */
    @JsonProperty("iban")
    public String getIban() {
        return iban;
    }

    /**
     * 
     * @param iban
     *     The iban
     */
    @JsonProperty("iban")
    public void setIban(String iban) {
        this.iban = iban;
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
        return new HashCodeBuilder().append(flagExternal).append(type).append(subType).append(productIdentification).append(customerDescription).append(bankId).append(status).append(closingDate).append(referringAddress).append(currency).append(owners).append(identificationInBank).append(id).append(createDate).append(availableBalance).append(accountingBalance).append(iban).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Account) == false) {
            return false;
        }
        Account rhs = ((Account) other);
        return new EqualsBuilder().append(flagExternal, rhs.flagExternal).append(type, rhs.type).append(subType, rhs.subType).append(productIdentification, rhs.productIdentification).append(customerDescription, rhs.customerDescription).append(bankId, rhs.bankId).append(status, rhs.status).append(closingDate, rhs.closingDate).append(referringAddress, rhs.referringAddress).append(currency, rhs.currency).append(owners, rhs.owners).append(identificationInBank, rhs.identificationInBank).append(id, rhs.id).append(createDate, rhs.createDate).append(availableBalance, rhs.availableBalance).append(accountingBalance, rhs.accountingBalance).append(iban, rhs.iban).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
