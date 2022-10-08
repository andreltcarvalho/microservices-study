
package com.andre.api.entity;

import java.util.LinkedHashMap;
import java.util.Map;
import javax.annotation.processing.Generated;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyDescription;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;


/**
 * User
 * <p>
 * An User
 * 
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "id",
    "name",
    "cpf"
})
@Generated("jsonschema2pojo")
public class User {

    /**
     * The unique identifier for an user
     * (Required)
     * 
     */
    @JsonProperty("id")
    @JsonPropertyDescription("The unique identifier for an user")
    private Integer id;
    /**
     * Name of the user
     * (Required)
     * 
     */
    @JsonProperty("name")
    @JsonPropertyDescription("Name of the user")
    private String name;
    /**
     * CPF of the user
     * 
     */
    @JsonProperty("cpf")
    @JsonPropertyDescription("CPF of the user")
    private String cpf;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new LinkedHashMap<String, Object>();

    /**
     * The unique identifier for an user
     * (Required)
     * 
     */
    @JsonProperty("id")
    public Integer getId() {
        return id;
    }

    /**
     * The unique identifier for an user
     * (Required)
     * 
     */
    @JsonProperty("id")
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * Name of the user
     * (Required)
     * 
     */
    @JsonProperty("name")
    public String getName() {
        return name;
    }

    /**
     * Name of the user
     * (Required)
     * 
     */
    @JsonProperty("name")
    public void setName(String name) {
        this.name = name;
    }

    /**
     * CPF of the user
     * 
     */
    @JsonProperty("cpf")
    public String getCpf() {
        return cpf;
    }

    /**
     * CPF of the user
     * 
     */
    @JsonProperty("cpf")
    public void setCpf(String cpf) {
        this.cpf = cpf;
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
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(User.class.getName()).append('@').append(Integer.toHexString(System.identityHashCode(this))).append('[');
        sb.append("id");
        sb.append('=');
        sb.append(((this.id == null)?"<null>":this.id));
        sb.append(',');
        sb.append("name");
        sb.append('=');
        sb.append(((this.name == null)?"<null>":this.name));
        sb.append(',');
        sb.append("cpf");
        sb.append('=');
        sb.append(((this.cpf == null)?"<null>":this.cpf));
        sb.append(',');
        sb.append("additionalProperties");
        sb.append('=');
        sb.append(((this.additionalProperties == null)?"<null>":this.additionalProperties));
        sb.append(',');
        if (sb.charAt((sb.length()- 1)) == ',') {
            sb.setCharAt((sb.length()- 1), ']');
        } else {
            sb.append(']');
        }
        return sb.toString();
    }

    @Override
    public int hashCode() {
        int result = 1;
        result = ((result* 31)+((this.name == null)? 0 :this.name.hashCode()));
        result = ((result* 31)+((this.cpf == null)? 0 :this.cpf.hashCode()));
        result = ((result* 31)+((this.id == null)? 0 :this.id.hashCode()));
        result = ((result* 31)+((this.additionalProperties == null)? 0 :this.additionalProperties.hashCode()));
        return result;
    }

    @Override
    public boolean equals(Object other) {
        if (other == this) {
            return true;
        }
        if ((other instanceof User) == false) {
            return false;
        }
        User rhs = ((User) other);
        return (((((this.name == rhs.name)||((this.name!= null)&&this.name.equals(rhs.name)))&&((this.cpf == rhs.cpf)||((this.cpf!= null)&&this.cpf.equals(rhs.cpf))))&&((this.id == rhs.id)||((this.id!= null)&&this.id.equals(rhs.id))))&&((this.additionalProperties == rhs.additionalProperties)||((this.additionalProperties!= null)&&this.additionalProperties.equals(rhs.additionalProperties))));
    }

}
