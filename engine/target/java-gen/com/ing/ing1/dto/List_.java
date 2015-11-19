
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
    "entryPoint",
    "description",
    "implemented"
})
public class List_ {

    @JsonProperty("entryPoint")
    private String entryPoint;
    @JsonProperty("description")
    private String description;
    @JsonProperty("implemented")
    private String implemented;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The entryPoint
     */
    @JsonProperty("entryPoint")
    public String getEntryPoint() {
        return entryPoint;
    }

    /**
     * 
     * @param entryPoint
     *     The entryPoint
     */
    @JsonProperty("entryPoint")
    public void setEntryPoint(String entryPoint) {
        this.entryPoint = entryPoint;
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
     *     The implemented
     */
    @JsonProperty("implemented")
    public String getImplemented() {
        return implemented;
    }

    /**
     * 
     * @param implemented
     *     The implemented
     */
    @JsonProperty("implemented")
    public void setImplemented(String implemented) {
        this.implemented = implemented;
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
        return new HashCodeBuilder().append(entryPoint).append(description).append(implemented).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof List_) == false) {
            return false;
        }
        List_ rhs = ((List_) other);
        return new EqualsBuilder().append(entryPoint, rhs.entryPoint).append(description, rhs.description).append(implemented, rhs.implemented).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
