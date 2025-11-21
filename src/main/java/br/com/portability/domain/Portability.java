package br.com.portability.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "portabilidades")
public class Portability {

    @Id
    public  String portabilityId;
    public String clientId;
    public String customerId;
    public String portedNumber;
    public String requestDate;
    public String effectiveDate;
    public PortabilityStatus status;

    public String getPortabilityId() {
        return portabilityId;
    }

    public void setPortabilityId(String portabilityId) {
        this.portabilityId = portabilityId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getCustomerId() {
        return customerId;
    }

    public void setCustomerId(String customerId) {
        this.customerId = customerId;
    }

    public String getPortedNumber() {
        return portedNumber;
    }

    public void setPortedNumber(String portedNumber) {
        this.portedNumber = portedNumber;
    }

    public String getRequestDate() {
        return requestDate;
    }

    public void setRequestDate(String requestDate) {
        this.requestDate = requestDate;
    }

    public String getEffectiveDate() {
        return effectiveDate;
    }

    public void setEffectiveDate(String effectiveDate) {
        this.effectiveDate = effectiveDate;
    }

    public PortabilityStatus getStatus() {
        return status;
    }

    public void setStatus(PortabilityStatus status) {
        this.status = status;
    }
}

