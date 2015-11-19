
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
    "name",
    "description",
    "bankRef",
    "version",
    "serverDate",
    "defaultLang",
    "localCountry",
    "timeZone",
    "infos"
})
public class ServerStatus {

    @JsonProperty("id")
    private String id;
    @JsonProperty("name")
    private String name;
    @JsonProperty("description")
    private String description;
    @JsonProperty("bankRef")
    private BankRef bankRef;
    @JsonProperty("version")
    private String version;
    @JsonProperty("serverDate")
    private ServerDate serverDate;
    @JsonProperty("defaultLang")
    private String defaultLang;
    @JsonProperty("localCountry")
    private String localCountry;
    @JsonProperty("timeZone")
    private String timeZone;
    @JsonProperty("infos")
    private Infos infos;
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
     *     The bankRef
     */
    @JsonProperty("bankRef")
    public BankRef getBankRef() {
        return bankRef;
    }

    /**
     * 
     * @param bankRef
     *     The bankRef
     */
    @JsonProperty("bankRef")
    public void setBankRef(BankRef bankRef) {
        this.bankRef = bankRef;
    }

    /**
     * 
     * @return
     *     The version
     */
    @JsonProperty("version")
    public String getVersion() {
        return version;
    }

    /**
     * 
     * @param version
     *     The version
     */
    @JsonProperty("version")
    public void setVersion(String version) {
        this.version = version;
    }

    /**
     * 
     * @return
     *     The serverDate
     */
    @JsonProperty("serverDate")
    public ServerDate getServerDate() {
        return serverDate;
    }

    /**
     * 
     * @param serverDate
     *     The serverDate
     */
    @JsonProperty("serverDate")
    public void setServerDate(ServerDate serverDate) {
        this.serverDate = serverDate;
    }

    /**
     * 
     * @return
     *     The defaultLang
     */
    @JsonProperty("defaultLang")
    public String getDefaultLang() {
        return defaultLang;
    }

    /**
     * 
     * @param defaultLang
     *     The defaultLang
     */
    @JsonProperty("defaultLang")
    public void setDefaultLang(String defaultLang) {
        this.defaultLang = defaultLang;
    }

    /**
     * 
     * @return
     *     The localCountry
     */
    @JsonProperty("localCountry")
    public String getLocalCountry() {
        return localCountry;
    }

    /**
     * 
     * @param localCountry
     *     The localCountry
     */
    @JsonProperty("localCountry")
    public void setLocalCountry(String localCountry) {
        this.localCountry = localCountry;
    }

    /**
     * 
     * @return
     *     The timeZone
     */
    @JsonProperty("timeZone")
    public String getTimeZone() {
        return timeZone;
    }

    /**
     * 
     * @param timeZone
     *     The timeZone
     */
    @JsonProperty("timeZone")
    public void setTimeZone(String timeZone) {
        this.timeZone = timeZone;
    }

    /**
     * 
     * @return
     *     The infos
     */
    @JsonProperty("infos")
    public Infos getInfos() {
        return infos;
    }

    /**
     * 
     * @param infos
     *     The infos
     */
    @JsonProperty("infos")
    public void setInfos(Infos infos) {
        this.infos = infos;
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
        return new HashCodeBuilder().append(id).append(name).append(description).append(bankRef).append(version).append(serverDate).append(defaultLang).append(localCountry).append(timeZone).append(infos).append(additionalProperties).toHashCode();
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof ServerStatus) == false) {
            return false;
        }
        ServerStatus rhs = ((ServerStatus) other);
        return new EqualsBuilder().append(id, rhs.id).append(name, rhs.name).append(description, rhs.description).append(bankRef, rhs.bankRef).append(version, rhs.version).append(serverDate, rhs.serverDate).append(defaultLang, rhs.defaultLang).append(localCountry, rhs.localCountry).append(timeZone, rhs.timeZone).append(infos, rhs.infos).append(additionalProperties, rhs.additionalProperties).isEquals();
    }

}
