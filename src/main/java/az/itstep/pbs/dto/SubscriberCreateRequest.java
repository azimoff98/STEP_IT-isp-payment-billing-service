package az.itstep.pbs.dto;

import lombok.Data;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;


@Data
public class SubscriberCreateRequest implements BaseDto{

    @NotNull(message = "Name cannot be null")
    @NotBlank(message = "Name cannot be blank")
    private String name;
    @NotNull(message = "Surname cannot be null")
    @NotBlank(message = "Surname cannot be blank")
    private String surname;
    @NotNull(message = "Passport Number cannot be null")
    @NotBlank(message = "Passport Number cannot be blank")
    private String passportNumber;
    @NotNull(message = "Fin Code Number cannot be null")
    @NotBlank(message = "Fin Code Number cannot be blank")
    private String finCode;
    @NotNull(message = "Phone number Number cannot be null")
    @NotBlank(message = "Phone number Number cannot be blank")
    private String phoneNumber;
    private String address;
}
