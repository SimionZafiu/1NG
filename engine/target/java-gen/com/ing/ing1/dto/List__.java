
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
    "type",
    "subType",
    "description",
    "featureList"
})
public class List__ {

    @JsonProperty("id")
    private String id;
    @JsonProperty("createDate")
    private CreateDate__ createDate;
    @JsonProperty("type")
    private Type_ type;
    @JsonProperty("subType")
    private SubType_ subType;
    @JsonProperty("description")
    private String description;
    @JsonProperty("featureList")
    private FeatureList featureList;
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
    public CreateDate__ getCreateDate() {
        return createDate;
    }

    /**
     * 
     * @param createDate
     *     The createDate
     */
    @JsonProperty("createDate")
    public void setCreateDate(CreateDate__ createDate) {
        this.createDate = createDate;
    }

    /**
     * 
     * @return
     *     The type
     */
    @JsonProperty("type")
    public Type_ getType() {
        return type;
    }

    /**
     * 
     * @param type
     *     The type
     */
    @JsonProperty("type")
    public void setType(Type_ type) {
        this.type = type;
    }

    /**
     * 
     * @return
     *     The subType
     */
    @JsonProperty("subType")
    public SubType_ getSubType() {
        return subType;
    }

    /**
     * 
     * @param subType
     *     The subType
     */
    @JsonProperty("subType")
    public void setSubType(SubType_ subType) {
        this.subType = subType;
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
     *     The featureList
     */
    @JsonProperty("featureList")
    public FeatureList getFeatureList() {
        return featureList;
    }

    /**
     * 
     * @param featureList
     *     The featureList
     */
    @JsonProperty("featureList")
    public void setFeatureList(FeatureList featureList) {
        this.featureList = featureList;
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
        return new HashCodeBuilder().append(id).append(createDate).append(type).append(subType).append(description).append(featureList).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof List__) == false) {
            return false;
        }
        List__ rhs = ((List__) other);
        return new EqualsBuilder().append(id, rhs.id).append(createDate, rhs.createDate).append(type, rhs.type).append(subType, rhs.subType).append(description, rhs.description).append(featureList, rhs.featureList).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
