
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
    "identificationInBank",
    "id",
    "href",
    "referenceCreateDate",
    "subjectType",
    "name",
    "roleType"
})
public class List {

    @JsonProperty("identificationInBank")
    private String identificationInBank;
    @JsonProperty("id")
    private String id;
    @JsonProperty("href")
    private String href;
    @JsonProperty("referenceCreateDate")
    private ReferenceCreateDate referenceCreateDate;
    @JsonProperty("subjectType")
    private SubjectType subjectType;
    @JsonProperty("name")
    private String name;
    @JsonProperty("roleType")
    private RoleType roleType;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

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
     *     The href
     */
    @JsonProperty("href")
    public String getHref() {
        return href;
    }

    /**
     * 
     * @param href
     *     The href
     */
    @JsonProperty("href")
    public void setHref(String href) {
        this.href = href;
    }

    /**
     * 
     * @return
     *     The referenceCreateDate
     */
    @JsonProperty("referenceCreateDate")
    public ReferenceCreateDate getReferenceCreateDate() {
        return referenceCreateDate;
    }

    /**
     * 
     * @param referenceCreateDate
     *     The referenceCreateDate
     */
    @JsonProperty("referenceCreateDate")
    public void setReferenceCreateDate(ReferenceCreateDate referenceCreateDate) {
        this.referenceCreateDate = referenceCreateDate;
    }

    /**
     * 
     * @return
     *     The subjectType
     */
    @JsonProperty("subjectType")
    public SubjectType getSubjectType() {
        return subjectType;
    }

    /**
     * 
     * @param subjectType
     *     The subjectType
     */
    @JsonProperty("subjectType")
    public void setSubjectType(SubjectType subjectType) {
        this.subjectType = subjectType;
    }

    /**
     * 
     * @return
     *     The name
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * 
     * @param name
     *     The name
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * 
     * @return
     *     The roleType
     */
    @JsonProperty("roleType")
    public RoleType getRoleType() {
        return roleType;
    }

    /**
     * 
     * @param roleType
     *     The roleType
     */
    @JsonProperty("roleType")
    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
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
        return new HashCodeBuilder().append(identificationInBank).append(id).append(href).append(referenceCreateDate).append(subjectType).append(name).append(roleType).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof List) == false) {
            return false;
        }
        List rhs = ((List) other);
        return new EqualsBuilder().append(identificationInBank, rhs.identificationInBank).append(id, rhs.id).append(href, rhs.href).append(referenceCreateDate, rhs.referenceCreateDate).append(subjectType, rhs.subjectType).append(name, rhs.name).append(roleType, rhs.roleType).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
