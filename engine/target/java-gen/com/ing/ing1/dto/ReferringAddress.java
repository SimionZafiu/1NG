
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
    "bankId",
    "addressType",
    "preferred",
    "street",
    "city",
    "zip",
    "county",
    "nation"
})
public class ReferringAddress {

    @JsonProperty("id")
    private String id;
    @JsonProperty("createDate")
    private CreateDate createDate;
    @JsonProperty("bankId")
    private String bankId;
    @JsonProperty("addressType")
    private AddressType addressType;
    @JsonProperty("preferred")
    private Boolean preferred;
    @JsonProperty("street")
    private String street;
    @JsonProperty("city")
    private String city;
    @JsonProperty("zip")
    private String zip;
    @JsonProperty("county")
    private String county;
    @JsonProperty("nation")
    private Nation nation;
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
    public CreateDate getCreateDate() {
        return createDate;
    }

    /**
     * 
     * @param createDate
     *     The createDate
     */
    @JsonProperty("createDate")
    public void setCreateDate(CreateDate createDate) {
        this.createDate = createDate;
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
     *     The addressType
     */
    @JsonProperty("addressType")
    public AddressType getAddressType() {
        return addressType;
    }

    /**
     * 
     * @param addressType
     *     The addressType
     */
    @JsonProperty("addressType")
    public void setAddressType(AddressType addressType) {
        this.addressType = addressType;
    }

    /**
     * 
     * @return
     *     The preferred
     */
    @JsonProperty("preferred")
    public Boolean getPreferred() {
        return preferred;
    }

    /**
     * 
     * @param preferred
     *     The preferred
     */
    @JsonProperty("preferred")
    public void setPreferred(Boolean preferred) {
        this.preferred = preferred;
    }

    /**
     * 
     * @return
     *     The street
     */
    @JsonProperty("street")
    public String getStreet() {
        return street;
    }

    /**
     * 
     * @param street
     *     The street
     */
    @JsonProperty("street")
    public void setStreet(String street) {
        this.street = street;
    }

    /**
     * 
     * @return
     *     The city
     */
    @JsonProperty("city")
    public String getCity() {
        return city;
    }

    /**
     * 
     * @param city
     *     The city
     */
    @JsonProperty("city")
    public void setCity(String city) {
        this.city = city;
    }

    /**
     * 
     * @return
     *     The zip
     */
    @JsonProperty("zip")
    public String getZip() {
        return zip;
    }

    /**
     * 
     * @param zip
     *     The zip
     */
    @JsonProperty("zip")
    public void setZip(String zip) {
        this.zip = zip;
    }

    /**
     * 
     * @return
     *     The county
     */
    @JsonProperty("county")
    public String getCounty() {
        return county;
    }

    /**
     * 
     * @param county
     *     The county
     */
    @JsonProperty("county")
    public void setCounty(String county) {
        this.county = county;
    }

    /**
     * 
     * @return
     *     The nation
     */
    @JsonProperty("nation")
    public Nation getNation() {
        return nation;
    }

    /**
     * 
     * @param nation
     *     The nation
     */
    @JsonProperty("nation")
    public void setNation(Nation nation) {
        this.nation = nation;
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
        return new HashCodeBuilder().append(id).append(createDate).append(bankId).append(addressType).append(preferred).append(street).append(city).append(zip).append(county).append(nation).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ReferringAddress) == false) {
            return false;
        }
        ReferringAddress rhs = ((ReferringAddress) other);
        return new EqualsBuilder().append(id, rhs.id).append(createDate, rhs.createDate).append(bankId, rhs.bankId).append(addressType, rhs.addressType).append(preferred, rhs.preferred).append(street, rhs.street).append(city, rhs.city).append(zip, rhs.zip).append(county, rhs.county).append(nation, rhs.nation).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
