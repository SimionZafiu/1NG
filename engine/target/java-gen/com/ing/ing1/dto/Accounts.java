
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
    "service",
    "description",
    "serviceImplemented",
    "entryPointList"
})
public class Accounts {

    @JsonProperty("service")
    private String service;
    @JsonProperty("description")
    private String description;
    @JsonProperty("serviceImplemented")
    private String serviceImplemented;
    @JsonProperty("entryPointList")
    private EntryPointList entryPointList;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * @return
     *     The service
     */
    @JsonProperty("service")
    public String getService() {
        return service;
    }

    /**
     * 
     * @param service
     *     The service
     */
    @JsonProperty("service")
    public void setService(String service) {
        this.service = service;
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
     *     The serviceImplemented
     */
    @JsonProperty("serviceImplemented")
    public String getServiceImplemented() {
        return serviceImplemented;
    }

    /**
     * 
     * @param serviceImplemented
     *     The serviceImplemented
     */
    @JsonProperty("serviceImplemented")
    public void setServiceImplemented(String serviceImplemented) {
        this.serviceImplemented = serviceImplemented;
    }

    /**
     * 
     * @return
     *     The entryPointList
     */
    @JsonProperty("entryPointList")
    public EntryPointList getEntryPointList() {
        return entryPointList;
    }

    /**
     * 
     * @param entryPointList
     *     The entryPointList
     */
    @JsonProperty("entryPointList")
    public void setEntryPointList(EntryPointList entryPointList) {
        this.entryPointList = entryPointList;
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
        return new HashCodeBuilder().append(service).append(description).append(serviceImplemented).append(entryPointList).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof Accounts) == false) {
            return false;
        }
        Accounts rhs = ((Accounts) other);
        return new EqualsBuilder().append(service, rhs.service).append(description, rhs.description).append(serviceImplemented, rhs.serviceImplemented).append(entryPointList, rhs.entryPointList).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
