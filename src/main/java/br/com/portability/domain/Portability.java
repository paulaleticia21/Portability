package br.com.portability.domain;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "portabilidades")
public class Portability {

    @Id
    public String portabilityId;
    public String clientId;
    public String customerId;
    public String portedNumber;
    public String requestDate;
    public String effectiveDate;
    public PortabilityStatus status;
}
